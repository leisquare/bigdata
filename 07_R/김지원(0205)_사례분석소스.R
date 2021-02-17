################################################################
# # #       빅데이터 분석 결과 시각화 사례 연구 소스       # # # 
################################################################
#1. koweps_hpc10_2015_beta5.sav 로드하여 변수명 결정
getwd() #디렉토리위치확인
setwd("e:/big/src/07_R") #디렉토리위치변경

###1. ‘한국복지패널데이터’(SPSS, koweps_hpc10_2015_beta5.sav)를 로드한 후 필요한 데이터 변수만을 
#select하여 변수명을 변경하시오. 단 필요한 필드로 성별은 gender, 태어난 연도는 birth, 혼인상태는 marriage, 종교는
#religion, 월평균임금은 income, 직업코드는 code_job, 지역코드는 code_region로 필드명을 변경한다.

library(foreign)
library(dplyr)
library(readxl)

# (1)로드
install.packages("foreign") #read.spss() 함수 사용 목적
library(foreign)
raw_welfare<-read.spss(file='inData/inData/Koweps/Koweps_hpc10_2015_beta1.sav',
                       to.data.frame=T)
welfare<-raw_welfare
View(welfare)

# (2)필드명을 변경했다
install.packages("dplyr")
library(dplyr)

welfare<-rename(raw_welfare,gender=h10_g3,birth=h10_g4,marriage=h10_g10,religion=h10_g11,
                    income=p1002_8aq1,code_job=h10_eco9,code_region=h10_reg7)



# (3) 필요 필드만 select

welfare<-welfare %>% 
  select(gender, birth,marriage,religion,income,code_job,code_region)

View(welfare)

colSums(is.na(welfare))


table(welfare$gender,useNA='ifany')


###2. 1번 문제의 결과인 data.frame변수를 이용하여 성별에 따른 월급 차이가 있는지를 분석하시오. 

#(1)gender 필드 변수의 이상치가 있는지 확인하고 이상치 값 처리를 한다(1점).
table(welfare$gender,useNA='ifany')

welfare$gender
welfare$gender<-ifelse((welfare$gender!=1 & welfare$gender!=2),NA,welfare$gender)

# ② gender 필드 변수의 결측치를 확인한다(1점).
table(is.na(welfare$gender))

#③ gender의 값이 1은 male로 2는 female로 변경하고 gender의 타입을 factor로 변경한다(1점).
class(welfare$gender)
welfare$gender <- ifelse(welfare$gender==1, 'male', 'female')
welfare$gender<-factor(welfare$gender)

welfare$gender<-as.factor(welfare$gender)

welfare$gender

#factor 순서 바꾸려면 아래의 둘 중 하나
welfare$gender<-factor(welfare$gender,levels=c('male','female'))

#④ 성별 비율을 도표로 나타내고 그래프로 시각화한다(2점).
welfare %>%
  group_by(gender) %>% 
  summarise(ratio=n()/nrow(welfare)*100) #성별 비율

library(ggplot2)
ggplot(data=welfare,aes(x=gender,y=income))+
  geom_violin(na.rm=T)+
  geom_point(position='jitter',col='yellow',alpha=0.7,na.rm=T)+
  geom_boxplot(aes(fill=gender),notch=T,width=0.4,na.rm=T)


welfare %>% 
  group_by(gender) %>% 
  summarise(ratio=n()/nrow(welfare)*100) %>% 
  ggplot(aes(x=gender,y=ratio))+
  geom_col(aes(rill=gender))+
  labs(title='남녀성비')+
  scale_x_discrete(limits=c('female','male'),labels=c('female','male'))

#범례의 텍스트 순서도 바꾼다
theme(legend.position='none',
      legend.background=element_rect(fill='lightgray'),
      legend.title=element_text(face=3,color='red'))  #face 3=이탤릭
###########################



gender.ratio<-welfare %>% 
  group_by(gender) %>% 
  summarise(ratio=n()/nrow(welfare)*100)
gender.ratio
pie(gender.ratio$ratio,
    labels=paste(gender.ratio$gender,
                 round(gender.ratio$ratio,1),
                 '%'),clockwise = T)      

ggplot(gender.ratio,aes(x="",y=ratio,fill=gender))+
  geom_bar(stat="identity")+
  coord_polar("y")

     
#⑤ income의 최소값, 1분위수, 중위수, 3분위수, 최대값, 결측치 등을 탐색하고, 
#boxplot과 월급의 빈도그래프를 시각화한다(2점).
summary(welfare$income)
table(is.na(welfare$income))
#히스토그램으로 income의 분포를 본다.
qplot(welfare$income)
qplot(welfare$income,xlim=c(0,1000))


ggplot(welfare, aes(y=income))+
  geom_histogram(na.rm=T)+ #연속적 자료 income을 계급으로 나누어 계급별 도수분포표 나타냄
  coord_cartesian(xlim=c(0,1000))

ggplot(welfare, aes(y=income))  +
  geom_boxplot(na.rm=T)

ggplot(data = welfare, aes(x = income))+
  geom_bar(na.rm=T)

#⑥ income이 0인 데이터는 이상치로 정하고, 이상치를 결측 처리한다(1점).
boxplot(welfare$income)
bp<-boxplot(welfare$income)$stat
bp
table(welfare$income<=bp[1],usaNA="ifany") #하위 이상치 벗어난 값
table(welfare$income>bp[5],exclude=NULL) #상위이상치 벗어난 값이 5%이상이어서 상위이상치는 이상치처리 안함.


welfare$income<-ifelse(welfare$income<=bp[1],NA,welfare$income)
welfare$income

table(welfare$income==bp[1],usaNA="ifany")

tapply(welfare$income,welfare$gender,FUN=mean,na.rm=T)

summaryBy(income~gender,data=welfare,FUN=c(mean,sd),na.rm=T)
# summaryBy(income~birth,data=welfare,FUN=c(mean,sd),na.rm=T) 이런결과가 나올수도있어서 이렇게 바로 쓰지 않음

aggregate(welfare$income,by=list(welfare$gender),mean,na.rm=T)
aggregate(welfare$income,by=list(welfare$gender),sd,na.rm=T)

#na.omit함수를 써서 아래 방법을 쓸 수도. 결측치없애거나 하는건 이걸 더 많이 씀. 
temp<-welfare[,c('income','gender','birth')]
temp<-na.omit(temp)
summary(temp)
summaryBy(income~gender,temp,FUN=c(mean,sd))
summaryBy(income~birth,temp,FUN=c(mean,sd))
#summaryBy(income~birth,data=temp,FUN=c(mean,sd),na.rm=T) 이제 이것이 잘 작동한다.

welfare %>% 
  filter(!is.na(income)&!is.na(gender)) %>% 
  group_by(gender) %>% 
  summarise(mean=mean(income),
            sd=sd(income))

ggplot(data=welfare,aes(x=gender,y=income))+
  geom_point(position='jitter',col='yellow',alpha=0.1)+
  geom_violin()+
  geom_boxplot(aes(col=gender),fill='lightyellow',notch=T,width=0.3)+
  geom_rug(col='dimgray')+
  labs(title='하위 이상치 처리 후 성별에 따른 수입 분석')+
  coord_cartesian(ylim=c(0,1000))


#⑦ 결측치를 제외한 데이터를 이용하여 성별에 따른 월급차이가 있는지를 분석한다(2점).


welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(gender) %>% 
  summarise(income.mean = mean(income),
            income.sd = sd(income)) %>% 
  ggplot(aes(x=gender, y=income.mean)) +
  geom_bar(stat = 'identity') +
  labs(title="성비에 따른 평균 수입")


#p-value가 0.05보다 작은경우 귀무가설(두 그룹의 평균이 같다)를 기각=두 그룹의 평균이 다르다.
#등분산성도 성립되지 않는다.



###3. 1번 문제의 결과인 data.frame변수를 이용하여 나이와 월급의 관계를 분석하여
#몇 살 때 월급을 가장 많이 받는지 시각화하시오.
#① birth, income 필드 변수의 이상치와 결측치를 확인한다(2점).
table(is.na(welfare$birth))
table(is.na(welfare$income))

boxplot(welfare$birth)$stats
#income 이상치
mean(welfare$income,na.rm=T)+3*sd(welfare$income,na.rm=T)
mean(welfare$income,na.rm=T)-3*sd(welfare$income,na.rm=T)
#birth 이상치
mean(welfare$birth,na.rm=T)+3*sd(welfare$birth,na.rm=T)
mean(welfare$birth,na.rm=T)-3*sd(welfare$birth,na.rm=T)

(b<-boxplot(welfare$birth)$stat)
table(welfare$birth<b[1]|welfare$birth>b[5]) #이상치없음

#② birth변수를 이용하여 (2015년 기준으로) 나이를 계산하고 이 값을 age 필드로 추가한다(2점).
welfare$age<-2015-welfare$birth+1
boxplot(welfare$age)$stat #분포 보기기

qplot(welfare$age,binwidth=0.9)
ggplot(data=welfare,aes(age))+
  geom_bar()
ggplot(data=welfare,aes(age))+
  geom_histogram(binwidth=0.9)

# 3.3 x축을 나이와 y축을 나이별 평균 월급의 변화 시각화
age_income <- welfare %>% 
  filter(!is.na(welfare$income)) %>% 
  group_by(age) %>% 
  summarise(income.mean = mean(income),
            income.sd = mean(income)) 


ggplot(age_income,aes(x=age,y=income.mean))+
  geom_col()

ggplot(age_income,aes(x=age,y=income.mean))+
  geom_bar(stat="identity")+
  geom_line()


#④ # 3.4 나이에 따른 월급의 차이가 있는지 분석
# 통계적으로 분석하기 p값에 따라 (3개이상 집단의 평균의 차이를 비교하는데 사용)
result<-aov(income~age,data=welfare)
summary(result)

fit<-lm(income~age,data=welfare)
anova(fit)


#f-value가 0.05보다 작은 경우: 귀무가설기각
#f-value가 0.05보다 큰 경우: 귀무가설기각할수없음



##3.5 월급 가장 많이 받는 나이대

ggplot(age_income, aes(x=age, y=income.mean)) +
  geom_line() +
  coord_cartesian(xlim = c(30,60))
#xlim(c(30,60))
orderBy(~-income.mean, data=age_income)[1:5,]

age_income %>% 
  arrange(-income.mean) %>% # 월급을 가장 많이 받는 나이:53
  head(5)


#4. 연령대에 따른 월급 차이- 어떤 연령대의 월급이 가장 많은지
#파생변수 agegrade를 필드로 추가.
welfare$agegrade<-ifelse(welfare$age<=30,'young',
                         ifelse(welfare$age<=60,'middle','old'))

#② agegrade 의 분포를 도표와 그래프로 시각화한다(3점).

ggplot(data = welfare, aes(x = agegrade))+
  geom_bar(aes(fill=agegrade))+
  scale_x_discrete(limits=c('young','middle','old')) #순서바꾸기


#③ 연령대 별 월급의 boxplot을 시각화한다(2점).

boxplot(income~agegrade,data=welfare,col=c('red','green','blue'))

ggplot(welfare,aes(x=agegrade,y=income,fill=agegrade))+
  geom_boxplot(notch=T)+
  scale_fill_manual(values=topo.colors(3))+
  coord_cartesian(ylim=c(0,2000))


# ④ 실제로 연령대에 따른 월급 차이가 있는지 분석 도표
agegrade_income <- welfare %>% 
  group_by(agegrade) %>% 
  summarise(income.mean = mean(income, na.rm=T),
            income.sd= sd(income, na.rm=T))
agegrade_income
summaryBy(income~agegrade, welfare, FUN=c(mean, sd), na.rm=T)

# 4.5 연령대에 따른 월급 차이가 있는지 분석 시각화
ggplot(welfare,aes(x=agegrade,y=income))+
  geom_point(position='jitter',col='orange',alpha=0.2)+
  geom_boxplot(aes(fill=agegrade),notch=T)+
  scale_x_discrete(limits=c('young','middle','old'))+
  scale_fill_discrete(limits=c('young','middle','old'))+
  geom_rug(col='dimgray')+
  coord_cartesian(ylim=c(0,500))


# 4.6 연령대에 따른 월급 차이가 통계적으로 유의미한지 분석
temp<-welfare %>% filter(!is.na(income))
result<-aov(income~agegrade,data=temp)
summary(result)


#5. 1번 문제의 결과인 data.frame변수를 이용하여 성별에 따른 월급의 차이는 
#연령대 별로 다른지 분석하시오. 
#채점기준 ① 성별, 연령대, 월급 데이터의 결측치를 확인한다(3점).
table(is.na(welfare$gender))
table(is.na(welfare$agegrade))
table(is.na(welfare$income))

#채점기준 ② 연령대별, 성별 월급의 평균과 표준편차, 빈도를 출력한다(3점).
library(doBy)
summaryBy(income~agegrade,data=welfare,FUN=c(mean,sd),na.rm=T)
summaryBy(gender~agegrade,data=welfare,FUN=c(mean,sd),na.rm=T)

gender_agegrade_income<-welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(agegrade,gender) %>% 
  summarise(income.mean=mean(income),
            income.sd=sd(income),
            n=n())
gender_agegrade_income


#채점기준 ③ 성별에 따른 월급의 차이가 연령대별로 다른지 시각화 한다(4점).

ggplot(gender_agegrade_income,
       aes(x=gender, y=income.mean,fill=gender))+
  geom_bar(stat='identity',position='dodge')


ggplot(gender_agegrade_income, 
       aes(x=gender, y=income.mean)) +
  geom_col(aes(fill=gender))+
  facet_wrap(~agegrade) +
  theme(legend.position = "none")

###6.1번 문제의 결과인 data.frame변수를 이용하여 나이에 따른 월급 변화를 성별을 분리하여 시각화 하시오.
#① 나이와 성별로 group_by하여 월급평균, 월급표준편차, 월급중앙값, 최소값과 최대값, 빈도 산출(5점).
gender_age_income<-welfare %>% 
  filter(!is.na(welfare$income)) %>% 
  group_by(age,gender) %>% 
  summarise(income.mean=mean(income),
            income.sd=sd(income),
            income.median=median(income),
            income.min=min(income),
            income.max=max(income),
            n=n())
gender_age_income

#② 나이에 따른 월급평균의 추이를 아래와 같은 그래프를 시각화하고, 그래프를 파일로도 출력(5점).
ggplot(gender_age_income,aes(x=age,y=income.mean,col=gender))+
  geom_line()

### 7. 직업별 월급 차이 분석. 어떤 직업이 월급이 가장 높은지 상위 10개 직업군 시각화.
#7.1 직업별 월급평균, 표준편차, 빈도를 평균월급순으로 정렬출렬. 직업별 월급 추이 분석.
table(welfare$code_job)
job_list<-read_excel("inData/inData/koweps/koweps_Codebook.xlsx",
                     col_names=T, sheet=2)
View(job_list)

welfare<-left_join(welfare,job_list,id='code_job')

job_income<-welfare %>% 
  filter(!is.na(welfare$income)) %>% 
  group_by(job) %>% 
  summarise(income.mean=mean(income),
            income.sd=sd(income),
            n=n()) %>% 
  arrange(-income.mean) %>% 
  head(10) 
job_income

ggplot(job_income,aes(x=job, y=income.mean, fill=job))+
  geom_bar(stat='identity')


#7.2 직업별 월급차이를 분석, 상위 소득 10개 직업군을 도표로 출력.
#그래프로 시각화하고 시각화한 그래프는 ggsave함수를 이용해 top10.png라는 그림파일로 저장



ggplot(data=job_income,aes(x=income.mean,y=reorder(job,income.mean)))+
  geom_col()+
  labs(title='상위소득 10개 직업군',x='직업',y='평균소득')

ggsave("outData/top10.png")

###8  성별에 따라 어떤 직업이 가장 많을지 분석. 
#8.1 여성 최빈 직업 상위 10를 추출한다(5점).

job_female<-welfare %>% 
  filter(!is.na(welfare$job)&gender=='female') %>% 
  group_by(job) %>% 
  summarise(cnt=n()) %>%
  arrange(desc(cnt)) %>% 
  head(10)

job_female

#ggplot(data=job_female,aes(y=reorder(job,cnt),x=cnt))+
#  geom_col()

#8.2 남성 최빈 직업 상위 10을 추출한다(5점).
job_male<-welfare %>% 
  filter(!is.na(welfare$job)&gender=='male') %>% 
  group_by(job) %>% 
  summarise(n=n()) %>%
  arrange(-n) %>% 
  head(10)

job_male


#9.종교 유무에 따른 이혼률을 분석하시오. 
#9.1 종교 데이터인 religion 필드의 이상치 및 결측치를 확인(1점).
table(welfare$religion, useNA = "ifany")
table(welfare$religion, exclude = NULL)
table(is.na(welfare$religion))
#9.2 religion 필드가 1이면 “종교-유”, 2이면 “종교-무”로 데이터를 변경한다(2점).
welfare$religion <- ifelse(welfare$religion==1, '종교-유','종교-무')
#9.3 종교 유무의 빈도를 시각화한다(1점).
ggplot(welfare, aes(x=religion,fill=religion)) +
  geom_bar()+
  theme(legend.position ="none")
#9.4 혼인 상태 데이터인 marriage 필드가 1이면 “기혼”, 3이면 “이혼”으로, 그 외는 NA로 값을 같은
#marriage_group 파생변수를 추가한다(2점).
welfare <- welfare %>%
  mutate(marriage_group = ifelse(marriage ==1, "기혼",
                           ifelse(marriage ==3, "이혼",NA )))

#9.5 종교 유무에 따른 이혼률을 분석한다(2점).
var.test(marriage_group~religion,data=welfare)

marriage_group<-welfare %>% 
  group_by(marriage_group,religion) %>% 
  summarise(ratio=n()/nrow(welfare)*100)
marriage_group

temp<-welfare %>% 
  filter(!is.na(marriage_group)&!is.na(religion))
View(temp)
#도표..
table(temp$religion,temp$marriage_group)
#시각화
religion_marriage<-welfare %>% 
  filter(!is.na(marriage_group)) %>% 
  group_by(religion,marriage_group) %>% 
  summarise(n=n()) %>%
  mutate(tot_group=sum(n)) %>% 
  mutate(pct=round(n/tot_group*100,1))
religion_marriage            

var.test(data=temp,marriage~religion)
t.test(data=temp,marriage~religion,var.equal=F) 
#0.045로 종교유무에 따라 결혼 상태가 다소 다를 수 있다.


#9.6 분석한 결과를 도표와 그래프로 시각화한다(2점).
ggplot(data=religion_marriage,aes(x=religion,y=n,fill=marriage_group))+
  geom_col(position='dodge')


#이혼상태만 보자.
welfare %>% 
  filter(marriage_group=='이혼') %>% 
  group_by(religion) %>%
  summarise(tot=n()) %>%
  mutate(pct=tot/sum(tot)*100) %>% 
  ggplot(aes(x=religion,y=pct))+
  geom_col()

#10. 지역별 연령대 비율을 분석하시오. 노년층이 많은 지역은 어디인지 출력하시오. 
#10.1 결측치를 확인한다(2점)
table(welfare$code_region,useNA='ifany')
table(!is.na(welfare$agegrade))
table(!is.na(welfare$code_region))

#10.2 region 파생변수를 지역명으로 추가한다(2점).
#1:서울 2:수도권(인천/경기) 3:부산/경남/울산 4:대구/경북 5:대전/충남 6:강원/충북 7:광주/전남/전북/제주도
region_list <- data.frame(code_region = c(1:7),
                          region=c('서울',
                                   '수도권(인천/경기)',
                                   '부산/경남/울산',
                                   '대구/경북',
                                   '대전/충남',
                                   '강원/충북',
                                   '광주/전남/전북/제주도'))
welfare <- left_join(welfare, region_list, by="code_region")

#10.3 지역별 연령대 비율을 분석한 도표 및 그래프를 시각화한다(3점).
region_agegrade<-welfare %>% 
  group_by(region, agegrade) %>% 
  summarise(n = n()) %>%   
  mutate(tot_group = sum(n)) %>% 
  mutate(pct = round(n/tot_group*100, 2)) 

ggplot(data=region_agegrade, aes(x=reorder(region, n), y=n, fill=agegrade)) + 
  geom_col(position = 'dodge') +
  theme(axis.text.x = element_text(angle = 45, vjust=0.7))

# 지역별 연령대 비율
ggplot(data=region_agegrade, aes(x=reorder(region, n), y=pct, fill=agegrade)) + 
  geom_col(position = 'dodge') +
  theme(axis.text.x = element_text(angle=45, vjust=0.5)) 


#10.4 노년층이 많은 지역이 어디인지 시각화한다(3점).
oldagegrade_region <- region_agegrade %>%
  filter(agegrade=='old') %>%
  arrange(desc(pct))
oldagegrade_region

ggplot(data=oldagegrade_region, 
       aes(x = pct, y=reorder(region, pct))) +geom_col()

