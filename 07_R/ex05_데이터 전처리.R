
####################################
#5 데이터 전처리
####################################

# 1.파일 ㅇ비출력
# 1.1 시스템 인코딩 조회
Sys.getlocale()

# 1.2 write.table ; 데이터를 파일에 저장 
iris
class(iris) #정보를 파일에 쓰는 경우는 텍스트파일이 아니라면 거의 데이터프레임이다.
write.table(iris,file='outData/iris.csv',sep=',')
write.table(iris,file='outData/iris2.csv',sep=',',row.names=FALSE)
head(iris)
InsectSprays
str(InsectSprays)
write.table(InsectSprays,file='outData/insect.csv',sep=',')

# 1.3 read.table; 파일을 읽어 데이터프레임 형태로 저장
irisData<-read.table('outData/iris.csv', sep=',',header = TRUE, encoding='utf-8')
#숫자는 numeric으로 문자는 cha로 들어옴 
irisData<-read.table('outData/iris.csv', sep=',',header = TRUE, encoding='utf-8',stringsAsFactors=TRUE)
#위처럼 쓰면 cha도 factor로 들어오지만, 보통 그렇게 쓰지아니함
head(irisData)
tail(irisData)
str(irisData)

irisData$Species <- as.factor(irisData$Species)
irisData$Species <- factor(irisData$Species, levels=c("setosa","versicolor","virginica" ))
levels(iris$Species)

iris$Species
str(iris$Species)
nrow(iris)
summary(iris)

#1.4 write.csv
write.csv(iris,file = 'outData/iris2.csv')
write.csv(iris,file = 'outData/iris1.csv',quote=FALSE)
#

#1.5 read.csv
newData <- read.csv('outData/iris1.csv', header = TRUE , stringsAsFactors=T)
str(newData)
head(newData)
summary(newData)

#1.6 cat ; 분석 결과 등을 저장할 때
irisSummary <- summary(newData)
class(irisSummary)
irisSummary[1]

nrow(irisSummary )

cat('iris 요약: ','\n',file='outData/irisSummary.txt')
for(i in 1:nrow(irisSummary)){
  cat(irisSummary[i,],'\n',file='outData/irisSummary.txt',append=T)
}

cat('iris 요약: ','\n',irisSummary,file='outData/irisSummary.txt',append=TRUE,Encoding='utf-8')

# 2. apply계열의 함수

# 2.1 apply:
# iris 데이터의 열별 평균, 행별 평균(합계, 분산, 표준편차, 최소값, 최대값)
  #apply(대상 자료, 1또는2,함수)1은 행별 함수 수행, 2는 열별 함수 수행
head(iris[1:4,])
apply(iris[,1:4],2,mean) #행별평균
apply(iris[,-5],2,mean) #열별평균
#setosa종과 versicolor종과 virginica종을 분류하고 각가긩 열별 평균 구하기

iris
apply(subset(iris, subset=(iris$Species == 'setosa'),select=-5),2,mean)
apply(subset(iris, subset=(iris$Species == 'virginica'),select=-5),2,mean)

apply(iris[,1:4],2,FUN=mean) #열별 평균
apply(iris[,1:4],2,FUN=sd) #열별 표준편차
apply(iris[,1:4],2,FUN=sum) #열별 합계
apply(iris[,1:4],2,FUN=median) #열별 중앙값
apply(iris[,1:4],2,FUN=min) #열별 최소값
apply(iris[,1:4],2,FUN=max) #열별 최대값

name<-c('김','홍','박','이','윤')
kor<-c(90,50,70,60,100)
eng<-c(100,40,50,60,70)
mat<-c(90,91,50,64,80)
student<- data.frame(name,kor,eng,mat)
student

#학생별 평균, 과목별 평균

apply(student[,-1],1,FUN=mean)
apply(student[,-1],2,FUN=mean)

# 2.2 lapply: list apply(결과도 list)
x<-list(a=1:10,beta=exp(-3:3),logic=c(T,F,T,F))
x
lapply(x,mean)
lapply(x,quantile)
lapply(x,quantile,1:3/4)


exp(-3:3) #e의 -3승부터 e의 3승까지 출력되는 지수함수
# 2.3 sapply: lapply와 유사하나 결과가 행렬이나 벡터로 반환
sapply(x,mean)
sapply(x,quantile)
sapply(x,quantile,1:3/4)

fivenum(0:100)
i39<-sapply(c(3:9),seq)
i39
sapply(i39,fivenum)
lapply(i39,fivenum) #결과는 같은데 lapply와 sapply의 모양 차이를 볼 것.

# 문 iris 데이터를 lapply와 sapply를 이용하여 sepal,Length~petal.Width까지의 평균을 구하여라.

irisList <- as.list(iris[,1:4])
irisList
lapply(irisList,mean)
sapply(irisList,mean)

# 2.4 vapply : sapply : FUN의 모든 값이 특별 value타입과 호환되는지 확인
vapply(irisList, mean, numeric(1))
vapply(i39,fivenum, FUN.VALUE=c(numeric(1),numeric(1),numeric(1),numeric(1),numeric(1)))

cities<-c('Seoul','Busan','New York','Tokyo')
nchar(cities[1])
sapply(cities,nchar)
lapply(cities,nchar)
vapply(cities,nchar,FUN.VALUE=numeric(1))

# 2.5 mapply:apply같으나 여러개의 인자를 함수에 전달
rep(c(1,2,3),each=3,times=2)
x<-c(1,2,3,4)
mean(x)

rep(c(1,2,3),2)
mapply(rep,x=1:4,times=4:1) #rep(1,times=4) rep(2,times=3) .......

#직업별 수입
job<-c(3,3,5,2,2,3,5,3,4,4,6,3)
income<-c(4879,6509,4183,0,3894,0,3611,6454,4975,8780,0,4362)
cust<-data.frame(job,income)
cust

income.avg<-c(900,0,3500,3600,3700,3800,3900,4000)
income.avg
names(income.avg)<-0:7
income.avg

zero2mean <-function(job,income){
  #return(ifelse(income==0, income.avg[as.character(j0b)],income))
  if(income==0){
    return (income.avg[as.character(job)])
  }else{
    return (income)
  }
}


cust$income2<-mapply(zero2mean,cust$job,cust$income)
cust

#for문으로 돌리지 않고.


#3. 데이터 그룹화 함수 적용
# 3.1 tapply : 그룹화 처리를 위한 apply 
tapply (iris$Sepal.Length,iris$Species,mean)
tapply(iris$Sepal.Length,iris$Species,sd)

boxplot(iris$Sepal.Length~iris$Species)

str(cust)
cust$job<-factor(cust$job,levels=0:7)
tapply(cust$income2,cust$job,FUN=mean)
tapply(cust$income2,cust$job,FUN=mean,default=-1)

datasets::InsectSprays
head(InsectSprays)
str(InsectSprays)

# 스프레이의 종류에 따른 살충 효과 점검.
tapply (InsectSprays$count,InsectSprays$spray,mean)
tapply (InsectSprays$count,InsectSprays$spray,sd)

boxplot(InsectSprays$count~InsectSprays$spray)

tapply(iris$Sepal.Length,iris$Species,sd)


su(InsectSprays$count,InsectSprays$spray,FUN=c(mean,sd)) #단점
# tapply(iris[,1:2],iris[,5],mean)

#3.2 by; 그룹화 처리를 위한 apply(함수를 2개 이상 가능)
by(iris[,1:2],iris[,5],sum)
by(iris[,1:4],iris$Species,summary)

# cust의 직업별 평균을 income과 imcpme2를 한번에
by(cust[,c('income','income2')],cust[,'job'],summary)

#su## 3.3 도비 패키지
install.packages("doBy")
library("doBy")
summaryBy(Sepal.Length+Sepal.Width~Species,iris) #함수명은 default:mean
summaryBy(Sepal.Length+Sepal.Width+Petal.Length+Petal.Width~Species,iris,FUN=sd)
summaryBy(Sepal.Length+Sepal.Width+Petal.Length+Petal.Width~Species,iris,FUN=c(mean,sd))

#문.emp.csv파일의 데이터를 받아 부서별 급여, 상여금을 비교하시오.

emp<- read.csv(file.choose(),header=T)
emp
str(emp$deptno)

emp$deptno<-as.factor(emp$deptno)
emp$deptno<-factor(emp$deptno,levels=seq(10,40,10))
names(emp)

summaryBy(sal+comm~deptno,emp,na.rm=T)

# (2) orderBy: 정렬
orderBy(~Sepal.Length,data=iris) #오름차순 정렬.
orderBy(~-Sepal.Length,data=iris) #내림차순 정렬렬
orderBy(~Species+Sepal.Length,data=iris) #Species 순 내림차순
orderBy(~Species-Sepal.Length,data=iris)
# 종별, sepal.length 오름차순으로 정렬한 데이터를 Sepal.Length, Sepal.Width, Spedcies
orderBy(~Species+Sepal.Length, data=iris)[,c(1,2,5)]

# 문, emp데이터에서 월급이 적은 순으로 ename, sal을 추출
orderBy(~sal+ename,data=emp)
orderBy(~sal, data=emp)[,c('ename','sal')]


# 문2 월급이 적은 순 5명만 직원 이름과 sal을 호출
head(orderBy(~sal+ename,data=emp))


# (3) sampleBy
sampleBy(~Species,data=iris,frac=0.1) #그룹별 20퍼센트씩 샘플링하는 방법. 비복원추출
sampleBy(~Species,data=iris,frac=0.1, replace = T) #복원추출

sampleBy(~Species,data=iris,frac=0.1, systematic = T) #계층적 추출

#벡터 샘플링
idx<-sample(1:150,10)
idx
iris[idx,] #전체에서 10개 뽑기

# 4. formula ~+
## lm() 선형회귀식 도출 함수(독립변수, 종속변수 명명식, 순서식)
x<-c(1,2,3,4,5) #공부량(독립변수)
y<-c(28,41,59,81,99) #점수(종속변수)-회귀분석; lm()함수 이용
y1<-c('F','F','F','p','p') #당락여부(종속변수) - 로지스틱회귀 : glm()

fit<-lm(y~x)
fit
plot(x,y,col='blue')
lines(x,x*18.2+7,col='red')
abline(fit,lty='dashed')

#독립변수가 2개
x1<-c(1,2,3,4,5) #공부시간
x2<-c(10,20,3,4,5) #기출문제 푼 갯수
y1<-c('50','70','63','85','99') #종속변수

fit<-lm(y~x1+x2) #x1과 x2의 상관관계가 없다고 전제.
fit

#cars
cars
?cars #속도에 따른 제동거리의 관계를 회귀식으로 도출

plot(cars)

fit<-lm(cars$dist~cars$speed)
fit<-lm(dist~speed,data=cars) #결과는 위와같다
fit
lines(cars$speed,cars$speed*3.932-17.579)
abline(fit,lty='dotted')

# 5. 데이터 분리
# 5.1 split
iris.species<-split(iris,iris$Species) #list형태
iris.species['virginica']

iris.sepal<-split(iris,iris$Sepal.Length>5)
iris.sepal
iris.sepal['FALSE']
head(iris.sepal$'FALSE')
#5.2 subset
#문. setosa 중 Sepal.Length,Petal.Length열 출력

subset(iris,subset=(iris$Species=='setosa'),select =c(Sepal.Length,Petal.Length,Petal.Width))
subset(iris,subset=(iris$Species=='setosa'),select =c(1,3))
#문. setosa 중 Sepal.Length,Sepal.Width,Petal.Length,Petal.Width 열 출력

subset(iris,subset=(iris$Species=='setosa'),select =c(-Species))
subset(iris,subset=(iris$Species=='setosa'),select =c(1:4))
subset(iris,subset=(iris$Species=='setosa'),select =c(-5))

#문. setosa 중 Sepal.Length가 4 이상인 데이터.
subset(iris,subset=(iris$Species=='setosa'&Sepal.Length>=5),select =c(-5))


# 6. 데이터 합치기
# 컬럼 합치기 cbind()
# 행 합치기 rbind()
# 병합하기 merge()

# 6.1 cbind
student.a<-data.frame(name=c('yi','kim'),score=c(100,90))
student.a
student.b<-data.frame(id=c(100,101),gender=c('여','남'))
student.b
(student<-cbind(student.a,student.b))

# 6.2 rbind
student.a<-data.frame(name=c('yi','kim'),score=c(100,90))
student.b<-data.frame(name=c('yun','an'),score=c(100,80))
(student<-rbind(student.a,student.b))

# 6.3 merge
student.a<-data.frame(name=c('yun','kim'),kor=c(100,90))
student.b<-data.frame(name=c('yi','kim'),eng=c(88,72),mat=c(68,75))
(student<-merge(student.a,student.b,all=T))

# 7. 데이터 정렬
# sort() 정렬된 데이터 반환 / order()정렬된 데이터의 index 반환

data<-c(10,30,100,1,3)
sort(data) #오름차순 정렬
sort(data,decreasing = TRUE) #내림차순 정렬
sort(iris$Sepal.Length) 

data<-c(10,30,100,1,3)
names(data)<-c('1번째','2번째','3번째','4번째','5번째')
data
sort(data)
order(data) #정렬된 데이터의 색인을 출력
data[order(data)] #sort(data)와 같다.

#iris 데이터를 Sepal.Length를 기준으로 내림차순 정렬
sort(iris$Sepal.Length)
order(iris$Sepal.Length)
order(Sepal)

iris[order(iris$Sepal.Length,decreasing=T),]

#iris 데이터를 Sepal.Length(내림차순),Sepal.width(오름차순)
order(-iris$Sepal.Length,iris$Sepal.Width)
iris[order(-iris$Sepal.Length,iris$Sepal.Width),c(1,2,5)]

#emp에서 월급 많은 순 ename, sal 추출
order(emp$ename,emp$sal)
emp[order(-emp$sal),c('ename','sal')] #-emp$sal도 내림차순 정렬임

#emp에서 월급 많은 5명 ename, sal 추출
head(emp[order(emp$sal,decreasing = TRUE),c('ename','sal')],5) #마지막에 ,5 붙이면 5개 나옴


#emp에서 월급 적은 5명 ename, sal 추출
tail(emp[order(emp$sal,decreasing = TRUE),c('ename','sal')],5)

# 8. 데이터 프레임 이름 생략하기
# 8.1 with, within절
iris.temp<- iris
iris.temp[c(1,3),1] #<-NA
head(iris.temp,3)

# 종별 중앙값
split(iris.temp$Sepal.Length,iris.temp$Species) #결과는 list
mps<-sapply(split(iris.temp$Sepal.Length,iris.temp$Species),median,na.rm=T)
mps
(mps<-tapply(iris.temp$Sepal.Length,iris.temp$Species,median,na.rm=T))
mps['setosa']
iris.temp$Sepal.Length2<-ifelse(is.na(iris.temp$Sepal.Length),mps[iris.temp$Species],iris.temp$Sepal.Length)
head(iris.temp[,c('Sepal.Length','Sepal.Length2')])
iris.temp$Sepal.Length2<-NULL
head(iris.temp)

(mps<-tapply(iris.temp$Sepal.Length,iris.temp$Species,median,na.rm=T))
iris.temp$Sepal.Length2<-ifelse(is.na(iris.temp$Sepal.Length),mps[iris.temp$Species],iris.temp$Sepal.Length)

#with절은 iris.temp 안의 Sepal.Length 결과값을 반환
#Within절은 Sepal.Length의 결측치가 대치된 데이터 프레임 셋이 반환
iris.temp<-with(iris.temp,{
  mps<-tapply(Sepal.Length,Species, median, na.rm=T)
  Sepal.Length<-ifelse(is.na(Sepal.Length),mps[Species],Sepal.Length)
})
iris.temp<-within(iris.temp,{
  mps<-tapply(Sepal.Length,Species, median, na.rm=T)
  Sepal.Length<-ifelse(is.na(Sepal.Length),mps[Species],Sepal.Length)
})
iris.with
head(iris.temp)



# 8.2 attach()함수, detach()함수

attach(iris) #이 부분 아래는 iris$를 생략해도 되는 구간
detach(iris)
summary(Species)
Sepal.Length
tapply(Petal.Length,Species,mean)
detach(iris)

# 9. 데이터 집계
# 9.1 table 
table(iris$Species)
emp = read.csv('inData/emp.csv',header=T)
table(emp$ename) #factor변수가 아니면 집게가 무의미

head(InsectSprays)
#InsectSprays 데이터셋에서 스프레이별 집계

table(InsectSprays$spray)
#emp 데이터셋에서 deptno를 집계
str(emp$deptno)
emp$deptno<-factor(emp$deptno,levels=seq(10,40,10))
table(emp$deptno)

#9.2 aggregate : 데이터를 하위 집합으로 분할하고 요약통계 계산
aggregate(iris[,1:4],by=list(iris[,5]),mean)

# 보험회사의 고객들이 보험금을 청구하는 데이터에서 고객별 입원일 조회
cust_id<-c(1005,1002,1003,1004,1005,1001,1005,1002,1003)
hos_day<-c(2,3,20,5,13,0,8,2,3,16)
length(cust_id)
length(hos_day)

data<-data.frame(cust_id,hos_day)
day_per_cust<-aggregate(data$hos_day,by=list(data$cust_id),sum)
day_per_cust

names(day_per_cust)<-c('cust_id','hos_day')
day_per_cust
day_per_cust[order(day_per_cust$hos_day),]

#아래가 다같은 결과
aggregate(data$hos_day,by=list(data$cust_id),sum)
#대상열이 하나만 가능
tapply(data$hos_day,data$dust_id,sum)
library(doBy)
#FUN을 두개 이상 사용 가능
summaryBy(hos_day~cust_id,data=data,FUN=c(sum,mean))

#10. 조건으로 색인찾기
subset(iris,iris$Species=='setosa') #조건으로 데이터 추출
which(iris$Species=='setosa') #조건으로 색인 추출
iris[which(iris$Species=='setosa'), ] #조건을 이용해서 데이터 출력

which.max(iris$Sepal.Length)
iris[which.max(iris$Sepal.Length), ] #sepal.Length가 제일 큰 row 출력력





