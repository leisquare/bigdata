###########################################################
# # # 5-1장.dplyr 패키지를 이용한 전처리 # # # #
###########################################################

# 1.외부파일 read/write
# 1.1 엑셀파일 읽어오기 - readx1 패키지 이용
library(readxl)
require(readxl)
install.packages("readxl")
library(readxl)
getwd()
###############################
exam<-read_excel("inData/exam.xlsx")
exam<-read_excel("E:\\kim_jiwon\\src\\07_R\\inData\\exam.xlsx")
class(exam)
exam<-as.data.frame(exam)
head(exam)
nrow(exam)
exam[21,]<-data.frame(id=1,class=1,math=90,english=90,science=99)
tail(exam)
exam$tot<-exam$math+exam$english+exam$science # 파생변수 추가
exam$grade<-ifelse(exam$tot>mean(exam$tot),'상','하') #파생변수
exam$grade
apply(exam[,3:6],2,mean)


###############################
#데이터 파일에 컬럼명이 없는 경우(데이터만 들어있는 경우)
data<-read_excel("inData/data_ex.xls") #이렇게 들이면 첫 줄이 헤더가 되어버린다
data<-read_excel("inData/data_ex.xls",col_names = F)
data
colnames(data)<-c('id','gender','age','area')
data

#1.2 데이터 쓰기(파일로 쓰기, vs 변수만 쓰기)
write.csv(exam,"outData/exam.csv",row.names = TRUE) #파일 write
save(exam,file='outData/exam.rda') #exam변수를 파일로 저장. 
rm(list=ls(all.names=T)) #모든 변수 삭제제
exam
load('outData/exam.rda') #환경창에도 뜬다.
exam

# 2. 데이터 파악하기
mpg<-ggplot2::mpg

# head()앞부분 tail()
# dim() 차원 str()구조 summary()
head(mpg)
tail(mpg)
edit(mpg) #에디트 창
View(mpg) #뷰 창
dim(mpg) #차원
summary(mpg) #최소값, 1사분위수, 중위수, 3사분위수, 최대값

#변수명 바꾸기(cty->city, hwy->highway)
install.packages("dplyr")
library(dplyr)
mpg<-rename(mpg,city=cty)
mpg<-rename(mpg,highway=hwy)
colnames(mpg)

# 파생변수(계산식으로)
mpg$total=(mpg$city+mpg$highway)/2
head(mpg,3)
# 파생변수(조건식으로)
mean(mpg$total)
mpg$test<-ifelse(mpg$total>=mean(mpg$total),"pass","fail")
table(mpg$test)

install.packages("ggplot2")
library(ggplot2)

boxplot(mpg$total) # 박스플롯
hist(mpg$total) #(2) 히스토그램
install.packages("vioplot")
library(vioplot)
vioplot(mpg$total,col='red') #(3) 바이올린플롯
par(mfrow=c(1,3)) #시각화 그래프를 1행 3열로 출력하기 위함
par(mfrow=c(1,1))

?qplot
qplot(mpg$test,color=mpg$test)
hist(mpg$total)


#(혼자 분석하기)
midwest<-as.data.frame(ggplot2::midwest)
  #데이터 파악하기, 파생변수 만들기
#문1 ggplot2의 midwest 데이터를 데이터 프레임 형태로 불러와서 데이터의 특성을 파악하세요.
head(midwest)
tail(midwest)
dim(midwest)
summary(midwest)
#문 2 poptotal(전체 인구)을 total로, popasian(아시아 인구)을 asian으로 변수명을 수정하세요.
midwest<-rename(midwest,total=poptotal)
midwest<-rename(midwest,asian=popasian)
colnames(midwest)
#문 3 total, asian 변수를 이용해 '전체 인구 대비 아시아 인구 백분율' 파생변수를 만들고, 히스토그램을 만들어 도시들이 어떻게 분포하는지 살펴보세요. 
midwest$ratioasian<-(midwest$asian/midwest$total)*100
midwest[,c('total','asian','ratioasian')]
#문 4 아시아 인구 백분율 전체 평균을 구하고, 평균을 초과하면 "large", 그 외에는 "small"을 부여하는 파생변수를 만들어 보세요.
mean(midwest$ratioasian)
midwest$over<-ifelse(midwest$ratioasian>=mean(midwest$ratioasian),"large","small")

boxplot(midwest$asian)
boxplot(midwest$total)


boxplot(midwest$ratioasian)
mean(midwest$ratioasian)
midwest$group<-ifelse(midwest$ratioasian>=mean(midwest$ratioasian),"large","small")
head(midwest[,c('total','asian','ratioasian','group')])
dim(midwest)


#문 5 •	문제5. "large"와 "small"에 해당하는 지역이 얼마나 되는지, 빈도표와 빈도 막대 그래프를 만들어 확인.
qplot(midwest$over,color=midwest$over)

table(midwest$group)
nrow(midwest)


# 3. 파악한 데이터를 dplyr패키지를 이용하여 전처리 및 분석하기. 
# 3.1 조건에 맞는 데이터 추출하기 : filter()
# %>%의 단축키=ctrl+shift+m
exam<-read.csv("inData/exam.csv",header=T)

exam%>%       #dplyr패키치는 %>% 기호를 이용해 함수들을 나열하는 방식 코딩. %>% 는 윗줄 끝에 둘 것 
  filter(class==1)
# class가 1이거나 2이거나 3인 데이터 추출
exam %>% 
  filter(class==1|class==2|class==3)
exam %>% 
  filter(class %in% c(1,2,3))

#class가 1이고 영어성적이 80이상인 데이터 추출
exam1<- exam %>% 
  filter(class==1&english>=80)
exam1

#3.2 필요한 변수 추출하기:select()
exam %>% 
  select(class,english,math) #추출하고자 하는 변수만 selece 함수 안에.
exam %>% 
  select(-math)
#class가 1과 2의 행 중에서 국어, 영어, 수학 데이터만 출력
exam %>% 
  filter(class%in%c(1,2)) %>% 
  select(english,math)
#class가 1,2,3행에서 영, 수 데이터만 앞 5개 추출
exam %>% 
  filter(class %in%c(1,2,3)) %>% 
  select(english,math) %>% 
  head #앞 6개
# 3.3 정렬하기: arrange()
exam %>% arrange(math) # 오름차순 정렬 
exam %>% arrange(desc(math)) #내림차순 정렬
exam %>% arrange(-math) #내림차순 정렬
exam %>% arrange(class,desc(math)) #클래스 오름차순, 클래스가 같으면 math 내림차순

#id가 1부터 10인 학생의 영어, 수학성적을 영어성적 기준으로 오름차순정렬하고 top6만
exam %>% 
  filter(id%in%c(1:10)) %>% 
  select(english,math) %>%
  arrange(english) %>% 
  head
#파생변수 추가: mutate           
exam %>% 
  mutate(total=math+english+science,
         avg=(math+english+science)/3)%>% 
                                           head
head(exam)
#추가한 파생변수를 dplyr코드에 바로 활용
exam %>% 
  mutate(total=math+english+science,
         avg=(math+english+science)/3)%>% 
  select(-id) %>% 
  arrange(desc(total)) %>% 
  head(3)
  
#3.5 요약하기 :summarise()
  #summarise 안에 들어갈 수 있는 요약함수들 : mean, sd, sum, min,mas,median,n
exam %>% 
  summarise(mean_math=mean(math))
exam %>% 
  summarise(mean_math=mean(math),
            mean_eng=mean(english),
            sd_math=sd(math),
            sd_eng=sd(english))
  

#3.6 집단별로 요약하기 group_by()+summarise()
exam %>% 
  group_by(class,) %>% 
  summarise(mean_math=mean(math),
            n=n(),
            max_eng=max(english)) %>% 
  arrange(mean_math)

#클래스별 수학, 영어, 과학의 평균
exam %>% 
  group_by(class,) %>% 
  summarise(mean_math=mean(math),
            mean_eng=mean(english),
            mean_sci=mean(science))
library(doBy)
summaryBy(math+english+science~class,exam)

#mpg 회사별로 "suv 자동차의 도시 및 고속도로 통합 연비 평균을 구해
#정렬하고 1~5위까지 출력하기
mpg<-as.data.frame(ggplot2::mpg)

head(mpg,3)

mpg %>% 
  filter(class=='suv') %>% 
  group_by(manufacturer) %>% 
  mutate(totalavg=(cty+hwy)/2)%>%
  summarise(tot_mean=mean(totalavg))
  arrange(-totalavg)%>%
  head(5)
