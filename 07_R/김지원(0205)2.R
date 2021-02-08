
######################################################
#혼자서 해보기1 : mpg 데이터를 이용해 분석 문제를 해결해 보세요.
######################################################
#Q1. 자동차 배기량에 따라 고속도로 연비가 다른지 알아보려고 합니다. 
#displ(배기량)이 4 이하인 자동차와 5 이상인 자동차 중 어떤 자동차의 hwy(고속도로 연비)가 평균적으로 더 높은지 알아보세요.
mpg<-as.data.frame(ggplot2::mpg)
library(dplyr)
library(doBy)

#(1)dplyr 패키지 이용
#mpg_rank<-ifelse(mpg$displ<=4,"a",ifelse(mpg$displ<5,"b","c"))


mpg %>%
  mutate(mpg_rank=ifelse(mpg$displ<=4,"displ<=4",ifelse(mpg$displ<5,"displ<5","displ>=5"))) %>% 
  filter(mpg_rank=="displ<=4"|mpg_rank=="displ>=5")%>% 
  group_by(mpg_rank) %>% 
  summarise(tot_mean1=mean(hwy))

#####(2) apply계열 함수 이용: tapply,by,summaryBy,aggregate
df <- mpg[(mpg$displ<=4 | mpg$displ>= 5),]
df$group <- ifelse(df$displ<=4, "displ<=4하", ifelse(df$displ>=5, "displ>=5", NA))
tapply(df$hwy, df$group, mean)

# Q2. 자동차 제조 회사에 따라 도시 연비가 다른지 알아보려고 합니다.
#"audi"와 "toyota" 중 어느 manufacturer(자동차 제조 회사)의 cty(도시 연비)가
#평균적으로 더 높은지 알아보세요.

#(1)dplyr 패키지 이용

mpg %>% 
  filter(manufacturer=='audi'|manufacturer=='toyota') %>% 
  group_by(manufacturer) %>% 
  summarise(cty_mean1=mean(cty))

### (2) apply계열 함수 이용: tapply,by,summaryBy,aggregate

auditoyota<-subset(mpg,manufacturer==c('audi','toyota'))
tapply(auditoyota$cty,auditoyota$manufacturer,mean,simplify=F)

# Q3. "chevrolet", "ford", "honda" 자동차의 고속도로 연비 평균을 알아보려고 합니다.
#이 회사들의 자동차를 추출한 뒤 hwy 전체 평균을 구해보세요.
#(1)dplyr 패키지 이용
mpg %>% 
  filter(manufacturer=='chevrolet'|manufacturer=='ford'|manufacturer=='honda') %>% 
  summarise(hwytotalmean=mean(hwy))

### (2) apply계열 함수 이용: tapply,by,summaryBy,aggregate

cfh<-subset(mpg,manufacturer==c('chevrolet','ford','honda'))
tapply(cfh$hwy,cfh$manufacturer,mean)

######################################################
#혼자서 해보기 2 . mpg 데이터를 이용해서 분석 문제를 해결해보세요.
######################################################
#Q1. mpg 데이터는 11개 변수로 구성되어 있습니다. 이 중 일부만 추출해서 분석에 활용하려고 합니다. 
#mpg 데이터에서 class(자동차 종류), cty(도시 연비) 변수를 추출해 새로운 데이터를 만드세요. 
#새로 만든 데이터의 일부를 출력해서 두 변수로만 구성되어 있는지 확인하세요.
#(1)dplyr 패키지 이용
newdata<-mpg %>% select(class,cty)
head(newdata)

### (2) apply계열 함수 이용: tapply,by,summaryBy,aggregate

classcty<-subset(mpg,select=c(8,11))
classcty

#Q2. 자동차 종류에 따라 도시 연비가 다른지 알아보려고 합니다. 
#앞에서 추출한 데이터를 이용해서 class(자동차 종류)가 "suv"인 자동차와 
#"compact"인 자동차 중 어떤 자동차의 cty(도시 연비)가 더 높은지 알아보세요.
#(1)dplyr 패키지 이용
newdata %>% 
  filter(class=='suv'|class=='compact')%>%
  group_by(class) %>%
  summarise(cty_mean_newdata=mean(cty)) %>%
  arrange(-cty_mean_newdata)
### (2) apply계열 함수 이용: tapply,by,summaryBy,aggregate
classcty2<-subset(classcty,class==c("suv","compact"))
summaryBy(cty~class,classcty2)

#Q3. "audi"에서 생산한 자동차 중에 어떤 자동차 모델의 hwy(고속도로 연비)가 높은지 
#알아보려고 합니다. "audi"에서 생산한 자동차 중 hwy가 1~5위에 해당하는 
#자동차의 데이터를 출력하세요.
#(1)dplyr 패키지 이용
mpg %>% 
  filter(manufacturer=='audi')%>%
  arrange(-hwy) %>% 
  head(5)

### (2) apply계열 함수 이용: tapply,by,summaryBy,aggregate
df<-mpg[mpg$manufacturer=='audi',]
head(orderBy(~-hwy,df),5)
head(df[order(df$hwy,decreasing=T),],5)


######################################################
#혼자서 해보기 3 . mpg 데이터를 이용해서 분석 문제를 해결해보세요.
######################################################
#mpg 데이터는 연비 변수는 hwy(고속도로 연비), cty(도시 연비) 두 종류로 분리되어 있습니다.
#두 변수를 각각 활용하는 대신 하나의 통합 연비 변수를 만들어 분석하려고 합니다

#Q1. mpg 데이터 복사본을 만들고, cty와 hwy를 더한 '합산 연비 변수'를 추가하세요.
#(1)
mpg %>%
  mutate(합산연비변수 = cty+hwy) %>%
  head
mpg
#(2)
mpgdup<-mpg
mpgdup$합산연비변수<-mpgdup$cty+mpgdup$hwy
mpgdup

#Q2. 앞에서 만든 '합산 연비 변수'를 2로 나눠 '평균 연비 변수'를 추가세요
#(1)
mpg %>%
  mutate(합산연비변수 = cty+hwy,
    평균연비변수=(합산연비변수/2)) %>%
  head
#(2)
mpgdup$평균연비변수<-(mpgdup$합산연비변수)/2
mpgdup
#Q3. '평균 연비 변수'가 가장 높은 자동차 3종의 데이터를 출력하세요.
#(1)
mpg %>%
  mutate(합산연비변수 = cty+hwy,
    평균연비변수=(합산연비변수/2)) %>%
  arrange(-평균연비변수) %>% 
  head(3)

#(2)
head(orderBy(~-평균연비변수,data=mpgdup),3)



#Q4. 1~3번 문제를 해결할 수 있는 하나로 연결된 dplyr 구문을 만들어 출력. 
#데이터는 복사본 대신 mpg 원본을 이용하세요

mpg %>% 
  mutate(합산연비변수=cty+hwy,
               평균연비변수=합산연비변수/2)%>% 
  arrange(-평균연비변수 )%>% 
  head(3)


######################################################
#혼자서 해보기 4 . mpg 데이터를 이용해서 분석 문제를 해결해보세요.
######################################################

# Q1. mpg 데이터의 class는 "suv", "compact" 등 자동차를 특징에 따라 일곱 종류로 분류한 변수입니다.
#어떤 차종의 연비가 높은지 비교해보려고 합니다. class별 cty 평균을 구해보세요.
#(1)dplyr 패키지 이용
mpg %>% 
  group_by(class) %>%
  summarise(cty_mean=mean(cty))

### (2) apply계열 함수 이용: tapply,by,summaryBy,aggregate
tapply(mpg$cty,mpg$class,mean)
by(mpg$cty,mpg$class,mean)
summaryBy(cty~class,mpg)
aggregate(mpg$cty,by=list(mpg$class),mean)

  
#Q2. Q1의 결과는 class 값 알파벳 순으로 정렬되어 있습니다.
#어떤 차종의 도시 연비가 높은지 알아보기 쉽도록 cty 평균이 높은 순으로 정렬해 출력하세요
#(1)dplyr 패키지 이용
mpg %>% 
  group_by(class) %>%
  summarise(cty_mean=mean(cty)) %>%
  arrange(-cty_mean)

### (2) apply계열 함수 이용: tapply,by,summaryBy,aggregate
sort(tapply(mpg$cty, mpg$class, mean), decreasing = TRUE)

#Q3. 어떤 회사 자동차의 hwy(고속도로 연비)가 가장 높은지 알아보려고 합니다.
#hwy 평균이 가장 높은 회사 세 곳을 출력하세요.
#(1)dplyr 패키지 이용
mpg %>% 
  group_by(manufacturer) %>%
  summarise(hwy_mean=mean(hwy)) %>%
  arrange(-hwy_mean) %>% 
  head(3)

### (2) apply계열 함수 이용: tapply,by,summaryBy,aggregate
result <-aggregate(mpg$cty, by=list(mpg$class), mean)
result
class(result)
head(result[order(result$x, decreasing = T),] , 3)
result[order(result$x, decreasing = T),][1:3,]
head(result[order(result$x, decreasing = T),] , 3)
head(orderBy(~-x, result), 3)

#Q4. 어떤 회사에서 "compact"(경차) 차종을 가장 많이 생산하는지 알아보려고 합니다.
#각 회사별 "compact" 차종 수를 내림차순으로 정렬해 출력하세요.
#(1)dplyr 패키지 이용
mpg
mpg %>% 
  group_by(manufacturer) %>% 
  filter(class=='compact')%>%
  summarise(n=n()) %>%
  arrange(desc(n))

### (2) apply계열 함수 이용: tapply,by,summaryBy,aggregate
df<-mpg[mpg$class=='compact',]
df<=subset(mpg,mpg$class=='compact')

sort(table(df$manufacturer),decreasing=T)


######################################################
#혼자서 해보기 5 . mpg 데이터를 이용해서 분석 문제를 해결해보세요.
######################################################

#mpg 데이터를 이용해서 분석 문제를 해결해 보세요.
#mpg 데이터의 fl 변수는 자동차에 사용하는 연료(fuel)를 의미합니다. 아래는 자동차연료별 가격을 나타낸 표입니다

#Q1.mpg 데이터에 price_fl(연료 가격) 변수를 추가하세요.
colnames(mpg)
mpg$fl
head(mpg,2)
fuel<-data.frame(fl=c('c','d','e','p','r'),
                kind=c('cng','diesel','etanol E85','primium','reqular'),
                price_fl=c(2.35,2.38,2.11,2.76,2.22))
#Q2.mpg에 price_f1변수 추가

left_join(mpg,fuel,by='fl')


######################################################
#혼자서 해보기 6 . mpg 데이터를 이용해서 분석 문제를 해결해보세요.
######################################################
table(mpg$drv)
mpg <- as.data.frame(ggplot2::mpg) # mpg 데이터 불러오기
boxplot(mpg$cty)
mpg[c(10, 14, 58, 93), "drv"] <- "k" # drv 이상치 할당
mpg[c(29, 43, 129, 203), "cty"] <- c(3, 4, 39, 42) # cty 이상치 할당
boxplot(mpg$cty)

#drv에 이상치가 있는지 확인하세요. 이상치를 결측 처리한 다음이상치가 사라졌는지 확인하세요.
# 결측 처리 할 때는 %in% 기호를 활용하세요.

mpg$drv<-ifelse((mpg$drv!='4' & mpg$drv!='f'),NA,mpg$drv)
mpg$drv<-ifelse((mpg$drv %in% c('k')),NA,mpg$drv)
mpg$drv

#. 상자 그림을 이용해서 cty에 이상치가 있는지 확인하세요. 
#상자그림의 통계치를 이용해 정상 범위를 벗어난 값을 결측 처리한 후 다시 상자 그림을 만들어 이상치가 사라졌는지 확인하세요.
boxplot(mpg$cty)
result<-boxplot(mpg$cty)$stats
result
mpg$hwy<-ifelse(mpg$hwy>result[5]|mpg$hwy<result[1],NA,mpg$hwy)
boxplot(mpg$cty)

# 두 변수의 이상치를 결측처리 했으니 이제 분석할 차례입니다. 이상치를 제외한 다음 
#drv별로 cty 평균이 어떻게 다른지 알아보세요. 하나의 dplyr 구문으로 만들어야 합니다

mpg %>% 
  group_by(drv) %>% 
  summarise(cty_mean=mean(cty))



######################################################
#분석 도전
######################################################
