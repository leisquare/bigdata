
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





