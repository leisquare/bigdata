
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
plot(cars,type='b',main='b타입') #추세선
plot(cars,type='s',main='s타입') #추세선
plot(cars,type='n',main='n타입') #추세선
plot(cars,type='o',main='d타입') #추세선

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
#3: 그래프의 제목이나 부제목 캡션, 축이름 등 부가 요소를 추가하는 함수.

#ggplot2
#ggplot(data,aes(x=,y=))+
#geom함수()+어떤 그래프를 그릴지
#labs(제목, x축,y축에 라벨)+
#scale함수()+
#theme() + 
#coord_cartesian() #lab~coordcartesian까지는 순서 바꿀 수 있다.


ggplot(data=mtcars,aes(x=wt,y=mpg))+
  geom_point(aes(size=mpg,color=cyl))+
  labs(title="fuel consumption(miles per gallon)",
       x="weight(1,000lbs)",
       y="Fuel consumption (miles per gallon)",
       subtitle="(차량무게와 연비와의 관계)",
       caption="source:mpg datasets")


ggplot(data=iris,aes(x=Petal.Length,y=Petal.width))+
  geom_point(aes(color=Species))+
  labs(title="fuel consumption(miles per gallon)",
       x="Petal.Length",
       y="Petal.width",
       subtitle="(차량무게와 연비와의 관계)",
       caption="source:mpg datasets")

# 4.1 산점도, 적합도, text...
#x축 iris$Petal.Length, y축 iris$Petal.width의 산점도
#점의 색은 종에 따라 다르게 그리시오,
library(ggplot2)
ggplot(data=iris,aes(x=Petal.Length,y=Petal.Width))+
  geom_point(aes(color=Species))


ggplot(data=iris,aes(x=Petal.Length,y=Petal.Width))+
  geom_point(aes(color=Species))+
  scale_color_manual(values = c('black','red','orange'))+
  labs(title="iris데이터의 산점도",
       subtitle="aaa",
       x="꽃잎 길이",y="꽃잎 너비")+
  coord_cartesian(ylim=c(0,2.5))+
  geom_smooth()


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
rm(list=ls())
dim(mtcars)
str(mtcars)
mtcars$cyl<-factor(mtcars$cyl,levels=c(4,6,8),
                   labels=c('4 cylinders',
                            '6 cylinders',
                            '8 cylinders'))

head(mtcars)

ggplot(data=mtcars,aes(x=mpg))+
  geom_histogram()

ggplot(data=mtcars,aes(x=mpg))+
  geom_histogram()+
  facet_grid(cyl~.)+#3개의 패널에 그리는 함수
  labs(title='cyl에 따른 연비 히스토그램',
       x='연비',y='횟수수')

mtcars$cyl

#히스토그램은 연속형 자료형으로 만든 도수분포표.
#연속형 자료에서 구간별 갯수를 세어 만든다. 
#(즉 원래부터 요인(factor)을 쓰는 범주형의 도수분포표에서는 불가능함 그건 막대그래프임)
#1
ggplot(data=mtcars,aes(x=cyl))+
  geom_histogram() #cyl데이터는 연속형이 아니라서 에러가 발생함.
#2 막대그래프
ggplot(data=mtcars,aes(x=cyl))+
  geom_bar()

#ggplot2::mpg 데이터에서 displ 도수분포표 출력(class에 따라 그래프의 색상을 달리 표현함)
str(mpg$displ)
ggplot(mpg,aes(x=displ))+
  geom_histogram(aes(x=displ))
  
ggplot(mpg,aes(x=displ))+
  geom_histogram(aes(fill=class))+
  theme(axis.text.x=element_text(color = 'red',size=15),
        axis.line=element_line(color='black',size = 2),
        axis.text.y=element_blank(),
        panel.background=element_rect(fill='lightblue',
                                      size = 1.5,
                                      color="black",
                                      linetype = 'dotted'),
  plot.background=element_rect(fill='lightgreen'))



ggplot(mpg,aes(x=displ))+
  geom_histogram(fill='red',binwidth=0.1) #데이터값과 관계없는 상수값에 색 입힐때

ggplot(mpg,aes(x=displ))+
  geom_histogram(aes(fill='red'),binwidth=0.1)+ #클래스에 따라 다른 색으로 채우고싶을때 #binwidth 막대 하나하나의 가로넓이
  labs(title="histogra with Auto Bining",
       subtitle="(Engine Displacement across Vehicle classes)")+
  theme(legend.position = "bottom")
  

ggplot(mpg,aes(x=displ))+
  geom_histogram(aes(fill=class),
                     bins=5,color='black'
                     )
#빈의 갯수(지정하지않으면 기본 30). 수를 지정할때는 binwidth를 지적하지않는다(bins가 무시된다)
#빈의 갯수는 상수라서 aes값 밖에 써야한다.

?theme
?geom_histogram
?element_rect

#4.3 상자도표(boxplot)
ggplot(iris,aes(y=Sepal.Length))+
  geom_boxplot()

#종별 Sepal.Length의 차이가 있는지를 보고 싶을 때
tapply(iris$Sepal.Length,iris$Species,mean) #도표표현
ggplot(iris,aes(y=Sepal.Length,x=Species))+ #시각화 표현
  geom_boxplot(aes(fill=Species),col='dimgray')+
  scale_fill_manual(values=c('#FF0000','yellow','green'))


library(RColorBrewer)
display.brewer.all()
pal<-brewer.pal(8,'Set2')
ggplot(iris,aes(y=Sepal.Length,x=Species))+ #시각화 표현
  geom_boxplot(aes(fill=Species),col='dimgray')+
  scale_fill_manual(values=pal)

install.packages("gapminder")
library(gapminder)
table(gapminder$country)
dim(gapminder)

#대륙별 gdp 차이가 있는지
table(gapminder$continent)
ggplot(gapminder,aes(x=continent,y=gdpPercap))+
  geom_boxplot()+
  coord_cartesian(ylim=c(0,30000))
  
#교수의 직급별(조교수,부교수,정교수) 연봉의 상의한지
install.packages("car")
library(car)
Salaries
dim(Salaries)
colnames(Salaries)

ggplot(Salaries,aes(x=rank,y=salary))+
  geom_boxplot(aes(col=rank),fill='lightyellow',notch=T)+
#notch=T: 중위수에 대해서 95% 신뢰구간 표현. 신뢰구간이 겹치는지 파악
  geom_point(position='jitter',col='brown',alpha=0.2,pch=3)+
  #position='jitter'=산점도를 분산해서
  geom_rug(col='dimgray',sides='l')
#관측값의 밀도상태 표현
#데이터가 많은 곳은 빽빽하게, 적은 곳은 하얗게
#mtcars데이터 cyl개수에 따른 연비 mpg의 95%중위수 신뢰구간을 표현하는 상자도표를 시각화 하시오.
head(mtcars)
?mtcars

str(mtcars$cyl)

ggplot(data=mtcars,aes(x=cyl,y=mpg,fill=cyl))+
  geom_boxplot(notch=T)+
  geom_point(position='jitter',col='brown',alpha=0.8,pch=1)


#4.4 바이올린 도표: boxplot과 밀도도표를 합침

singer<-lattice::singer
head(singer)
View(singer)
str(singer)

ggplot(data=singer,aes(x=voice.part,y=height))+
  geom_boxplot()

ggplot(data=singer,aes(x=voice.part,y=height))+
  geom_violin(fill='honeydew2')+
  geom_boxplot(width=0.3,fill='green')

# 4.5 밀도 도표
head(mtcars,1)
#실린더 수(cyl)에 다른 연비(mpg의 밀도도표)
ggplot(data=mtcars, aes(x=mpg,fill=cyl))+
  geom_density()+
  labs(title='밀도도표',
       x='miles per gallon')+
  theme(legend.position = c(0.8,0.8))

#4.6 추세선(시계열데이터의 흐름표현)
economics
colnames(economics)
#tlrks(data)에 따른 실업률(unemploy)
ggplot(data=economics,aes(x=date,y=unemploy))+
  geom_line()+
  geom_smooth(method='lm') #적합도선

#4.7 막대도표(geom_bar함수, geom_col 함수)
#도수분포표, 막대도표, 히스토그램 모두
  #히스토그램: 연속형 자료를 계급으로 나누어 게급별 도수를 나타냄.
  #막대도표: 범주형 자료의 빈도를 나타냄
          #geom_bar(),geom_col()함수

#mpg 데이터셋에서 제조회사별로 도수분포표(빈도표)를 나타내자.
str(mpg)
ggplot(data=mpg,aes(x=manufacturer))+geom_histogram() #안됨
ggplot(data=mpg,aes(x=manufacturer))+
  geom_bar(stat='count')+ #stat = "count" 빈도를 시각화
  theme()

str(mpg$class)
ggplot(data=mpg,aes(x=manufacturer,fill=class))+
  geom_bar()+
  theme(legend.position = "top",
        axis.text.x=element_text(angle=45,vjust = 0.5))+
  scale_fill_manual(values=topo.colors(7))+ #at 16pages
  labs(title="제조사별 class빈도표")

#다이아몬드 품질별 데이터
head(diamonds)
str(diamonds)
dim(diamonds)
table(diamonds$cut)
#다이아몬드 품질(컷)별 변도수 시각화
ggplot(diamonds,aes(x=cut,fill=cut,col=cut))+
  geom_bar(stat="count")+
  scale_fill_manual(values=topo.colors(5))
      

ggplot(diamonds,aes(x=cut,fill=cut,col=cut))+
  geom_bar(stat="count")+
  scale_color_manual(values=rainbow(5))

#다이아몬드 품질별 색상갯수
table(diamonds$cut,diamonds$color)
table(diamonds$color)


library(dplyr)
diamonds %>% 
  group_by(cut,color) %>% 
  summarise(n=n()) %>% 
  ggplot(aes(x=cut,fill=color,y=n))+
  geom_bar(stat='identity')

?geom_bar

#따로그리기
diamonds %>% 
  group_by(cut,color) %>% 
  summarise(n=n()) %>% 
  ggplot(aes(x=cut,fill=color,y=n))+
  geom_bar(stat='identity',position='dodge');
      
diamonds %>% 
  group_by(cut,color) %>% 
  summarise(n=n()) %>% 
  ggplot(aes(x=cut,fill=color,y=n))+
  geom_col(position='dodge')

#다이아몬드의 품질cut별 table별 빈도수 시각화

diamonds %>% 
  group_by(cut,table) %>% 
  summarise(n=n()) %>% 
  ggplot(aes(x=table,y=n,fill=cut))+
  geom_bar(stat='identity')+
  facet_wrap(~cut)+
  coord_cartesian(ylim=c(0,3000),xlim=c(50,80))

#다이아몬드 품질별 table의 종류 갯수
diamonds %>% 
  group_by(cut,table) %>% 
  summarise(n=n()) %>% 
  group_by(cut) %>% 
  summarise(n=n()) %>% 
  ggplot(aes(x=cut,y=n,fill=cut))+
  #geom_bar(stat='identity')+
  geom_col()

diamonds %>% 
  group_by(cut) %>% 
  summarise(n=n_distinct(table)) %>%  #cut을 table종류수로
  ggplot(aes(x=cut,y=n,fill=cut))+
  #geom_bar(stat='identity')
  geom_col()


#4.8 그래프를 파일로 저장
#(1)
jpeg('iris.jpg')#iris.jpg 그림파일 생성
boxplot(iris$Sepal.Length)
dev.off()
getwd()

png('iris2.png',width=300,height=150)
ggplot(iris,aes(x=Sepal.Length,y=Sepal.Width))+
  geom_point()+
  facet_wrap(~Species)
dev.off



#(2) ggplot2그래프에서만 저장할 수 있는 방법

ggplot(iris,aes(x=Petal.Width,y=Petal.Length,col=Species))+
  geom_point(aes(size=Petal.Width),pch=3,alpha=0.5)

ggsave("outData/iris.jpg")


#(3) 화면을 분할하여 그래프 여러개 출력
oldPar<-par(mfrow=c(2,3)) #이건 기본그래프에서만 사용가능
ggplot(iris,aes(x=Petal.Width,y=Petal.Length))+
  geom_point()


install.packages("gridExtra")
library(gridExtra)
g1<-ggplot(iris,aes(x=Petal.Width,y=Petal.Length))+
  geom_point()
g1
g2<-ggplot(iris,aes(x=Petal.Width,y=Petal.Length,col=Species))+
  geom_point(aes(size=Petal.Width),pch=3,alpha=0.5)
g2
grid.arrange(g1,g2,ncol=2)


#5. 산점도 행렬
plot(iris[-5])
pairs(iris[-5],panel=panel.smooth) #panel=panel.smooth 는 추세선 추가
