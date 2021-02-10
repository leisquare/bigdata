
##############################################################
#8장. 데이터 시각화
##############################################################
#시각화: 

#R의 그래픽 시스템
#(1) base graphics system - 전통적인 함수 이용. 정교한 그래프 이용시 노력 필요.
    # 그래프 종류별 함수가 각기 달라 정교한 그래프 이용시 노력 필요.

#(2) grid graghics system-base graphics system 한계 극복을 위해 탄생한 패키지(ggplot2)
#유연한 그래프 환경 제공

library(ggplot2)
ggplot(data=mtcars,aes(x=wt,y=mpg)) #그래프의 초기화
ggplot(data=mtcars,aes(x=wt,y=mpg))+geom_point()+labs(title='그래프 첫 예제')+
  geom_smooth()

#1.2 그래프 함수
#고수준 그래프 함수: plot, barplot,boxplot,hist,pie....
#그래프함수를 호출할때마다 그래프영역에 새로운 그래프를 그림.
#저수준 그래프 함수: lines,abline(회귀 라인), point,text...
#새로운 그래프를 생성하지 않음. 이미 그려진 그래프 위에 점, 라인, 글씨...

#(1) par(): 그래프를 조정하거나 특성을 지정.
#par() 함수의 리턴값은 실행 전의 특성을 리턴한다.
?cars #차속도와 제동거리
plot(cars)
abline(cars)


oldPar<-par(bty='L')
oldPar
plot(cars)
?par

plot(iris)
par(oldPar) #oldPar설정으로 복귀
plot(cars) #고수준 그래프 함수
#fit<-lm(cars$dist~cars$speed)
fit<-lm(dist~speed,data=cars)
fit
abline(fit,col="red")#저수준 그래프 함수

#par 함수의 다른 파라미터 사용 예
x<-1:100
y1<-rnorm(100) #평균이 0이고 표준편차가 1인 수 100개 추출
y2<-rnorm(100)+100 #평균이 100이고 표준편차가 1인 수 100개 추출

oldPar<-par(mar=c(5,5,5,5)) #그래프 여백(하,좌,상, 우우)

plot(x,y1,pch=1,,type='s',col='turquoise',
     ylim=c(-8,2),yaxt='n',bty='n',ylab="")
#pch=0은 네모, 1은 원, 2는 세모, 3은 십자 등...
#type:p: 점 l: 선 b: 점선동시, o:점선겹치면서동시, j:히스토그램, s:계단, n:좌표찍지않음
#col:1:black, 2:red, 3:green,4;blue,5:cyan,6:purple,7:yellow,8:gray
#ylin,xlim; y눈금, x눈금 조정
#yaxt: y축 눈금없애기
#bty:그래프 박스 타입(o,l,7,u,c,n...)
#ylab;y축 라벨
axis(side=2,at=c(-2,0,2))
#side: 1하 2좌 3위 4우
#at:위치
mtext('red line(y1)',side=2,line=2,at=0,col=2)
#다시 하려면 고수준 함수부터 차례로 다시 실행할 것
par(new=TRUE) #고수준 함수라도 기존 그래프 영역에 덧그리는 함수
plot(x,y2,pch=1, type='b', col='blue',ylim=c(98,108),yaxt='n',bty='n',ylab="")
axis(side=4,at=c(98,100,102))
mtext('blue line(y1)',side=4,line=2,at=100,col='blue')

par(oldPar)

colors()

#고수준 그래프 함수
#2.1 plot: type에 따라 여러 유형의 그래프를 그림. 산점도 그래프



plot(cars,main="speed and Stopping Distance of cars",
     xlab="speed(mph)",ylab="stopping distances(ft)",las=1)
#las:축눈금 라벨방향, 0:축과 평행, 1:가로, 2:수직 3:세로
#2행3열로 그래프 영역 분리
oldPar<-par(mfrow=c(2,3))
plot(cars,type='p',main='p타입')
plot(cars,type='l',main='l타입') #추세선
plot(cars,type='b',main='l타입') #추세선
plot(cars,type='s',main='l타입') #추세선
plot(cars,type='n',main='l타입') #추세선
plot(cars,type='o',main='l타입') #추세선

#2.2 barplot : 막대그래프
VAdeaths
par(mfrow=c(1,1))
barplot(VADeaths,main="버지니아주 사망율",
        font=2,border="red",legend=rownames(VADeaths),
        angle=c(10,30,50,70,90),
        density=80,col=cm.colors(5))
        #lenend: 오른쪽 상단 범례
        #angle= 막대그래프에 칠할 빗금의 각도
        #막대그래프 안에 칠할 선 수
barplot(VADeaths,main="버지니아주 사망율",font=2,
        border="red",legend=rownames(VADeaths),
        angle=c(10,30,50,70,90),
        density=50, col=rainbow(5),beside=T)

#2.3 boxplot 4분위스 그래프
InsectSprays
boxplot(InsectSprays$count)
boxplot(count~spray,data=InsectSprays,col="tomato4")
tapply(InsectSprays$count,InsectSprays$spray,median)
colors()

#2.4 hist:히스토그램(도수분포표)
x<-c(1,1,2,2,2,3,4,4)
hist(x)
h<-hist(x,breaks=c(0,1,2,3,4))
#breaks=구간

h
text(h$mids,h$counts,h$counts,adj=c(0.5,-.2),col='red')
text(h$mids,h$counts,h$counts,adj=c(0,0),col='blue')
text(h$mids,h$counts,h$counts,adj=c(1,0),col='green')
text(h$mids,h$counts,h$counts,adj=c(0,1),col='yellow')
text(h$mids,h$counts,h$counts,adj=c(1,1),col='purple')
#adj 위치 재조정

islands #1만 평방마일을 초과하는 주요대륙 넓이 정보

class(islands)

is.vector(islands)
hist(sqrt(islands),breaks=c(2,30,70,100,140))
#2.5 pie
pie.sales<-c(0.1,0.3,0.20,0.15,0.1,0.15)
sum(pie.sales)
names(pie.sales)<-c("c","java","python","r","orcle","hadoop")
pie.sales
pie(pie.sales) #기본은 반시계방향
pie(pie.sales,clockwise=T,col=c('red','orange','yellow','green','blue','white'))
pie(pie.sales,clockwise=T,col=rainbow(6))

#2.6 mosaicplot
Titanic
class(Titanic)
mosaicplot(~Sex+Age+Survived,data=Titanic,color=T)

#3 저수준 그래프 함수
#3.1 points
plot(-4:4,-4:4,type='n')
points(1,2,col="red")

points(rnorm(100),rnorm(100),col="blue",pch=2)
rnorm(100) #평균이 0이고 표준편차가 1인 표준정규분포 데티어 100개 난수 생성

#3.2 lines
plot(cars,main="speed&dostance")
fit<-lm(dist~speed,cars)
fit #y=3.932,x=-17.579
lines(cars$speed,3.932*cars$speed-17.579,col='blue')

#3.3 abline:회귀식선
abline(fit,col="red",lty='dashed')
#lty: 라인의스타일

#3.4 text(x,y,출력할 텍스트, 그외 옵션들)
plot(1:5,1:5, type="n")
text(3,3,'A',adj=c(0,0),col='red')
text(2,4,expression(hat(beta)==(x^t*X)^{-1}*X^t*y),cex=2)

#4. ggplot 패키지 함수 
install.packages("ggplot2")
library(ggplot2)
#1: 그래프 초기화(데이터셋, 변수설정)-그 자체로는 그래프 표현 x
#2: 그래프의 결과물에 대응하는 geom 함수 
#3: 그래프의 제목이나 부제목 캡션, 축이름 등 부가 요소를 추가
ggplot(data=mtcars,aes(x=wt,y=mpg))+
  geom_point(aes(size=mpg,color=cyl))+
  labs(title="fuel consumption(miles per gallon)",
       x="weight(1,000lbs)",
       y="Fuel consumption (miles per gallon)",
       subtitle="(차량무게와 연비와의 관계)",
       caption="source:mpg datasets")

#x축 iris$Petal.Length, y축 iris$Petal.width의 산점도
#점의 색은 종에 따라 다르게 그리시오,


ggplot(data=iris,aes(x=Petal.Length,y=Petal.width))+
  geom_point(aes(color=Species))+
  labs(title="fuel consumption(miles per gallon)",
       x="Petal.Length",
       y="Petal.width",
       subtitle="(차량무게와 연비와의 관계)",
       caption="source:mpg datasets")

ggplot(data=iris,aes(x=Petal.Length,y=Petal.Width))+
  geom_point(aes(color=Species))


head(airquality)
#airquality$Ozone과 airquality$solar.R과의 관계를 표현하는 산점도.
#월별 점의 색을 달리 표현합니다.
ggplot(data=airquality,aes(x=Ozone,y=Solar.R))+
  geom_point(aes(color=Month))+
  labs(title="오존량과 태양복사량과의 관계계")+
  geom_smooth(method='lm')

ggplot(data=mtcars,aes(x=wt,y=mpg))+
  geom_point(pch=25,color='blue',bg='red',size=1,stroke=1)+
  #shape=par에서 pch와 같음
  #stroke= 선 두께
  #size=점크기
  geom_smooth(method="lm",color='red',size=2,linetype=2)+
  geom_text(label=rownames(mtcars),hjust=0,wjust=0, size=3,nudge_y=1)+
  labs(x='차량무게(1,000lbs)',
       y='연비',
       title='차량무게와 연비와의 관계',
       subtitle='(부제목)',
       caption='참조:datasets의 mtcars')


mtcars
?geom_point

#4.2 히스토그램
dim(mtcars)
str(mtcars)
mtcars$cyl<-factor(mtcars$cyl,levels=c(4,6,8),
                   labels=c('4 cylinders',
                            '6 cylinders',
                            '8 cylinders'))

head(mtcars)
ggplot(data=mtcars,aes(x=mpg))+
  geom_histogram()+
  facet_grid(cyl~.)+#3개의 패널에 그리는 함수
  labs(title='cyl에 따른 연비 히스토그램',
       x='연비',y='횟수수')

mtcars$cyl





colors()

