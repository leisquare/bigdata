##############################################################
#10장. t-test분석 vs anova분석
##############################################################
#두그룹간 평균의 차이가 통계적으로 유의한지 검증: T-test분석
#세그룹 이상간의 평균 차이를 통계적으로 유의한지 검증: anova(분산분석)

#1. 두 그룹간의 평균의 차이가 유의한지 분석
ToothGrowth
table(ToothGrowth$supp)
#(1) 도표로 차이의 유의성을 표현(tapply, by, summaryBy, aggregate)
#(2) 그래프로 시각화된 유의성 표현(바이올린도표, 산점도, 상자도표)
#(3) 통게적으로 유의한지 검증

#기니피그 치아성장에 비타민 종류가 유의미하게 영향을 미치는지 확인
#(1) 우선 공부하는 과정에서 데이터가 부족하므로 데이터의 수를 부풀림
#실제로는 이렇게 하면 안됨!


ToothGrowth<-rbind(ToothGrowth,ToothGrowth)
nrow(ToothGrowth)
table(is.na(ToothGrowth))
colSums(is.na(ToothGrowth))

#(1)
library(doBy)
summaryBy(len~supp,data=ToothGrowth,FUN=c(mean,sd))
library(dplyr)
ToothGrowth %>% 
  group_by(supp) %>% 
  summarise(len.mean = mean(len),
            len.sd = sd(len))
#(2)
ToothGrowth %>% 
  filter(!is.na(supp)&!is.na(len)) %>% 
  group_by(supp) %>% 
  summarise(len.mean=mean(len)) %>% 
  ggplot(aes(x=supp,y=len.mean)) +
  geom_col(aes(fill=supp),width=0.7)

ggplot(data=ToothGrowth,aes(x=supp,y=len))+
  geom_violin()+
  geom_point(position='jitter',col='yellow',alpha=0.7)+
  geom_boxplot(aes(fill=supp),notch=T,width=0.4)

#(3) 통계적인 분석
#일원표본 t-test

table(ToothGrowth$supp,useNA='ifany')#결측치 빈도까지 출력
table(ToothGrowth$supp,exclude=NULL) #결측치 빈도까지 출력
a<-ToothGrowth[ToothGrowth$supp=='OJ','len']
b<-ToothGrowth[ToothGrowth$supp=='VC','len']
t.test(a-b)
t.test(a,b)

ToothGrowth

#이원표본 t.test(등분산성테스트->T테스트 분석)
var.test(len~supp,data=ToothGrowth)
#p-value가 0.05보다 작은경우 귀무가설(두 그룹의 평균이 같다)를 기각=두 그룹의 평균이 다르다.
#등분산성도 성립되지 않는다.
#p-value가 0.05보다 큰경우 귀무가설을 기각하지 못한다=두 그룹의 평균이 거의 비슷하다.
#등분산성도 성립된다.
t.test(len~supp,data=ToothGrowth,var.equal=F)
#var.equal=F:두그룹의 등분산성이 성립되지 않는 경우
#var.equal=T:두그룹의 등분산성이 성립되는 경우

#p-value가 0.05보다 작은 경우: 귀무가설기각
#p-value가 0.05보다 큰 경우: 귀무가설기각할수없음


#### 예제: datasets:sleep:extra(수면량),group(수면제 종류)
sleep<-rbind(sleep,sleep) #4번 실행해서 데이터 뻥튀기.
nrow(sleep)
head(sleep)
str(sleep)
table(sleep$group,useNA='ifany')

#(1) 도표로 평균의 차이 나타내기
library(doBy)
summaryBy(extra~group, data=sleep, FUN=c(mean, sd))


sleep %>% 
  group_by(group) %>% 
  summarise(mean = mean(extra),
            sd = sd(extra))

#(2) 평균의 차이를 시각화하기

sleep %>% 
  filter(!is.na(extra)&!is.na(group)) %>% 
  group_by(group) %>% 
  summarise(extra.mean=mean(extra)) %>% 
  ggplot(aes(x=group,y=extra.mean)) +
  geom_col(aes(fill=group),width=0.7)

library(ggplot2)
result <- summaryBy(extra~group, data=sleep, FUN=c(mean, sd))
ggplot(result, aes(x=group, y=extra.mean)) +
  geom_col(aes(fill=group), width=0.7)

ggplot(data=sleep,aes(x=group,y=extra))+
  geom_violin()+
  geom_point(position='jitter',col='yellow',alpha=0.7)+
  geom_boxplot(aes(fill=group),notch=T,width=0.4)

#(3) 통계적으로 유의미한 차이를 분석하기
var.test(extra~group,data=sleep) # p-value가 0.05보다 큼
t.test(extra~group,data=sleep,var.equal=T) 
#p-value가 0.05보다 작아 두 그룹사이 평균이 같다는 귀무가설을 기각한다.

# 2. 3개 이상의 집단간 평균의 차이를 비교할때는 분산분석
#(1) aov()
#iris 데이터셋에서 종에 따라 Sepal.Length의 평균이 다른지

ggplot(iris,aes(x=Species,y=Sepal.Length))+
  geom_boxplot(aes(fill=Species),notch=T)

result<-aov(Sepal.Length~Species,data=iris) # species이 범주형
summary(result)

#f-value가 0.05보다 작은 경우: 귀무가설기각
#f-value가 0.05보다 큰 경우: 귀무가설기각할수없음


#(2) anova()
#ggplot::mpg데이터셋에서 cyl에 따라 mpg의 평균이 다른지
rm(list=ls())
str(mtcars$cyl)
table(mpg$cyl,useNA="ifany") #cyl의 가지수와 결측치 확인

#cyl에 따른 그룹이 4개 그룹이고 cyl변수가 연속형 변수이므로
fit<-lm(mpg~cyl,data=mtcars)
anova(fit)
#f-value가 0.05보다 작은 경우: 귀무가설기각
#f-value가 0.05보다 큰 경우: 귀무가설기각할수없음


###예제: Datasets::orange; 오렌지나무의 종류, 연령, 둘레
#오렌지나무의 연령에 따른 둘레의 평균이 상이한지 분석하시오..
fit<-lm(circumference~age, data=Orange)
anova(fit)
