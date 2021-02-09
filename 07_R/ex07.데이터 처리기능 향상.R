
##############################################################
#7장. 데이터 처리기능 향상
##############################################################
#이 장의 내용: ①plyr 패키지(apply 계열), ②데이터 구조변경,(melt ,cast) ③데이터 테이블

iris(iris$Sepal.length>7.5&iris$Petal.Length>5,)

#1.plyr패키지 : 데이터 분할, 함수 적용 등을 사용하는 함수 포함.
#apply계 함수의 보강 가능.
install.packages("plyr")
library(plyr)
#xyply(.data,.group....) ex.adply,ddply
apply(iris[,1:4],2,mean) #mean(iris[,1]) 
apply(iris[,1:4],2,function(col){mean(col)})

sapply(iris[,1:4],function(col){mean(col)})
sapply(iris[,1:4],mean)
sapply(iris[,1:4],function(col){mean(round(col))})
sapply(iris[,1:4],mean(round)) #이건 안됨

x<-data.frame(v1=c(4,6,16),
              v2=c(16,81,196))
x

apply(x,2,function(col){mean(sqrt(col))})
#adply == apply(),sappl()... 비슷
adply(.data=iris[,1:4],.margins=2,function(dol){sum(col)})

#ddply == summaryBy(Sepal.Length+Sepal.Width~Species,iris,FUN=mean와 비슷 
ddply(.data=iris,.Species,function(group){
  data.frame(SL.mean=mean(group$Sepal.Length),
             SW.mean=mean(group$Sepal.Width)
})
  
#summarise, : 뒤에 나오는 변수들만 출력
#transform : 기존 iris 데이터와 뒤에 나오는 변수들을 같이 출력.
ddply(iris, .(Species),summarise,SLmean=mean(Sepal.Length), SWmean=mean(Sepal.Width))

  
head(iris)

dfx<-data.frame(group=c(rep('A',8),rep('B',15),rep('C',6)),
                gender=sample(c('M','F'),size =29,replace=TRUE),
                age=round(runif(29,min=18,max=54)))  
dfx

ddply(dfx,.(group,gender),summarise,mean=mean(age),sd=sd(age))
ddply(dfx,.(group,gender),summarise,mean=round(mean(age),2),sd=round(sd(age),2))
ddply(dfx,.(group,gender),transform,mean=round(mean(age),2),sd=round(sd(age),2))


library(doBy)
summaryBy(age~group+gender,dfx,FUN=c(mean,sd))

#2. 데이터 구조 변경(melt, cast 함수)
?airquality
View(airquality)
install.packages("reshape2")
library(reshape2)
airquality.melt<- melt(airquality,id=c('Month','Day').na.rm=TRUE)
View(airquality.melt)
airquality[airquality$Month==5&airquality$Day==5,]
subset(airquality,Month==5&Day==5)

#melt를 통해 바뀐 구조.
airquality.melt[airquality.melt$Month==5& airquali=ty.melt$Day==1,]
subset(airquality.melt, Month==5&Day==5)

#melt된 데이터를 원상복구: dcast vs acast
airquality.dc<-dcast(airquality.melt,Month+Day~variable) # month,day 변수로
head(airquality.dc)
airquality.ac<-acast(airquality.melt,Month+Day~variable)# month,day 행이름으로.
head(airquality.ac)
airquality.ac['5_1',]

# 3. 데이터 테이블: 짧고 유연하고 빠른 구문 사용을 위해 데이터 프레임에서 상속받음
flights_df<-read.csv("inData/flights14.csv")
head(flights_df)
flights_df

library(readxl)
exam<-read_excel("inData/exam.xlsx")
class(exam)

install.packages("data.table") #fread() : csv파일을데이터테이블로 받는 함수
library(data.table)
flight<-fread("inData/flights14.csv")
flight



#flights_df(데이터프레임),flights(데이터테이블)


head(iris$Sepal.Length,10)
iris[c(1:10),'Sepal.Length']
iris[c(1:10),'Sepal.Length', drop=FALSE]
# 3) virginica 종만 추출
levels(iris$Species)
virginica<-iris[iris$Species == 'virginica',]
virginica <- subset(iris,iris$Species =='virginica')
virginica
# 3) setosa 추출
setosa<- iris[iris$Species =='setosa',]
setosa


#flights_df 데이터프레임에 대해 작성 제출
#1. origin이 JFK이고 month가 5월인 모든 행을 resul에 얻는다
resul<- flights_df %>% 
  filter(origin=='JFK' & month==5)

resul<-flights_df[flights_df$origin=='JFK'& flights_df$month==5]
resul
#2. 처음 두 행을 resul에 얻는다
resul<-flights_df %>% 
  filter(origin=='JFK' & month==5) %>% 
  head(2)

resul<-head(resul,2)
resul

#3. origin으로 오름차순, desc로 내림차순으로 정렬하여 출력
flights_df %>% 
  arrange(origin)

flights_df %>% 
  arrange(desc(origin))





#4. arr_delay열만 출력
flights_df %>% 
  select(arr_delay)

flights_df['arr_delay']


#5. year열부터 dep_time열까지 출력

flights_df %>% 
  select(year:dep_time)

flights_df[,1:4]

#6. year열과 dep_time열 출력
flights_df %>% 
  select(year,dep_time);

flights_df[,c('year','dep_time')]

#7. arr_delay열과 dep_delay열을 출력하되 열이름을 delay_arr과 delay_dep로 변경
flights_df %>% 
  select(delay_arr=arr_delay,delay_dep=dep_delay) %>% 
  head(2)


flights_df[,c('arr_delay','dep_delay')]

#8. 지연시간(arr_delay, dep_delay모두 0미만인 비행이 몇 번인지 출력
flights_df %>% 
  filter(arr_delay<0 & dep_delay<0) %>% 
  select(flight);




#9. 6월에 출발 공항이 JFK인 모든 항공편의 도착지연 및 출발지연 시간의 평균을 계산
flights_df %>% 
  filter(origin=='JFK'&month==6) %>% 
  summarise(mean(arr_delay),
            mean(dep_delay))


#10. 9번의 결과에 title에 mean_arr, mean_dep로 출력
flights_df %>% 
  filter(origin=='JFK'&month==6) %>% 
  summarise(mean_arr=mean(arr_delay),
            mean_dep=mean(dep_delay))

###11. JFK 공항의 6월 운항 횟수
flights_df %>% 
  group_by(month)%>% 
  tally();

flights_df %>% 
  filter(month==6) %>%
  tally();

#12. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 출력
flights_df %>% 
  filter(month==6) %>% 
  select(arr_delay,dep_delay);

#13. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 제외한 모든 열 출력
flights_df %>% 
  filter(month==6) %>% 
  select(-arr_delay,-dep_delay);

#14. 출발 공항(origin)별 비행 수 출력 (JFK 81483 LGA 84433 EWR 87400)
flights_df %>% 
  group_by(origin)%>% 
  tally();


#15. 항공사코드(carrier)가 AA에 대해 출발공항별 비행횟수 계산
flights_df %>% 
  filter(carrier=='AA') %>%
  group_by(origin)%>% 
  tally();


#16. origin, dest별로 비행횟수 출력
flights_df %>% 
  group_by(origin,dest)%>% 
  tally();

#17. 항공사코드(carrier)가 AA에 대해 origin, dest별로 비행횟수 출력
flights_df %>% 
  filter(carrier=='AA') %>%
  group_by(origin,dest)%>% 
  tally();

#18. 항공사 코드가 AA에 대해, origin, dest, 월별 평균arr_delay, 평균 dep_delay 출력
flights_df %>% 
  filter(carrier=='AA') %>%
  group_by(month) %>%
  summarise(mean_arr=mean(arr_delay),
            mean_dep=mean(dep_delay));



#19. dep_delay>0가 참이거나 거짓, arr_delay>0가 참이거나 거짓인 각각의 비행횟수
flights_df %>% 
  filter(dep_delay>0) %>%
  tally();

flights_df %>% 
  filter(dep_delay<=0) %>%
  tally();

flights_df %>% 
  filter(arr_delay>0) %>%
  tally();


flights_df %>% 
  filter(arr_delay<=0) %>%
  tally();


#20. Origin==“JFK”에 대해 월별 최대 출발 지연 시간 출력(month로 정렬)
flights_df %>% 
  filter(origin=="JFK") %>%
  arrange(dep_delay) %>% 
  select(dep_delay)%>%
  head(1);







apply(iris[,-5],2,sum)





)

