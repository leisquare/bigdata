#예제


#[문제1] 1부터 10사이의 벡터를 만들어서 v1 이라는 변수에 저장한다.
v1<-c(1,2,3,4,5,6,7,8,9,10)
v2<-2*v1
max_v<-max(v2)
min_v<-min(v2)
avg_v<-mean(v2)
sum_v<-sum(v2)
v3<-v2[-5]
v1
v2
v3
max_v
min_v
avg_v
sum_v

#[문제2] 10 에서 38사이의 숫자 중에서 2씩 증가한 값으로 벡터를 생성하고 3행 5열의 매트릭스를 만들어 m1 에 저장한다.(행 우선 저장)
v<-seq(10,38,2)
m1<-matrix(v,ncol=5,byrow=T)
m1
m2<-m1+100
m_max_v<-max(m1)
m_min_v<-min(m1)
row_max<-apply(m1[,1:5],1,FUN=max)
col_max<-apply(m1[,1:5],2,FUN=max)

m1
m2
m_max_v
m_min_v
row_max
col_max

# [문제3] seq() 또는 rep() 함수를 이용하여 다음 결과가 나오도록 명령을 작성한다.

sq1<-seq(1,9,2)
rp1<-rep(1,5)
rp2<-rep(1:3,times=3)
rp3<-rep(1:4,each=2)

# [문제4] 1부터 10 까지 출력하는데 3씩 증가 되는 형태로(1 4 7 10)저장되는 벡터를 정의하여 v3 변수에 저장한다

v3<- seq(1,10,3)

# [문제5 ] 1부터 100으로 구성되는 7개의 중복되지 않는 데이터를 추출하여 count 라는 백터를 만든다. 
count<- c(sample(1:100, size = 7))
  #week.korname 이라는 이름으로 “일요일”, “월요일”,…”토요일” 값으로 벡터를 만든다. 
week.korname<-c('일요일','월요일','화요일','수요일','목요일','금요일','토요일')
  #다음 형식으로 구성되는 벡터를 생성하여 출력한다.
  #추출된 값이 – 21, 40, 11, 55, 70, 90, 30 이라면 다음과 같이 출력한다.
  #일요일 : 21   월요일 : 40   화요일 : 11 ……………..   토요일 : 30
cat(paste(week.korname,count,sep=' : '))
  #값이 가장 큰 요일의 명칭을 출력한다.
week.korname[order(-count)[1]]
  #값이 가장 작은 요일의 명칭을 출력한다.
week.korname[order(count)[1]]
  #50보다 큰 값에 해당하는 요일의 명칭을 출력한다.
week.korname[count>50]

# [문제6]  다음과 같이 값이 구성되는 매트릭스를 정의하여 m1 에 저장한다.

n1<-c(1,2,3)
n2<-c(4,5,6)
n3<-c(7,8,9)

m1<-matrix(c(n1,n2,n3),ncol=3)
m1

# [문제7] 다음과 같이 값이 구성되는 매트릭스를 정의하여 m2 에 저장한다.
m2<-matrix(seq(1,9),ncol=3,byrow=T)
m2

# [문제8]  m2 를 가지고 다음과 같이 값이 구성되는 매트릭스를 정의하여 m3 에 저장하고 출력한다.
m3<-matrix(m2,ncol=3,byrow=F,
    dimnames = list(c('row1','row2','row3'),
                c('col1','col2','col3')))

# [문제9] 다음과 같이 구성 되는 2행 3열 매트릭스 alpha를 생성한 후에
alpha<-matrix(c('a','b','c','d','e','f'),ncol=3)
alpha2<-rbind(alpha,c('x','y','z'))
alpha3<-cbind(alpha,c('s','p'))

# [문제10] 다음과 같이 값이 구성되는 배열을 정의하여 a 라는 변수에 저장한다.
vector1<-matrix(seq(1,6),ncol=3)
vector2<-matrix(seq(7,12),ncol=3)
vector3<-matrix(seq(13,18),ncol=3)
vector4<-matrix(seq(19,24),ncol=3)

a<-array(c(vector1,vector2,vector3,vector4),dim=c(2,3,4))
  # (1) 2행3열4층의 데이터를 출력한다.
a[2,3,4]
  # (2) 각 층마다 2행의 데이터를 출력한다
a[2,,]
  # (3) 각 층마다 1열의 데이터를 출력한다.
a[,1,]
  # (4) 3층의 모든 데이터를 출력한다.
a[,,3]
  # (5) a라는 배열을 구성하는 모든 데이터에 +100을 연산하여 출력한다.
a+100
  # (6) 4층의 모든 데이터들에 100을 곱한 결과를 출력한다.
100*a[,,4]
  # (7) 각층의 1행, 2열과3열만 출력한다.
a[1,-1,]
  # (8) 2층의 2행 데이터들의 값을 100을 더한 값으로 변경한다.
a[2,,2]<-a[2,,2]+100
  # (9) 1층의 모든 데이터들의 값에 2를 뺀 값으로 변경한다.
a[,,1]<-a[,,1]-2
  # (10) a 배열의 모든 데이터 값들을 10을 곱한 값으로 변경한다.
a<-a*10
  # (11) a 변수를 삭제한다.
rm(a)

# [문제11] 다음과 같이 값이 구성되는 데이터프레임을 정의하여 df1 에 저장한다.
df1<-data.frame(seq(1,5),seq(2,10,2))
names(df1) <-c("x","y")
df1

# [문제12] 다음과 같이 값이 구성되는 데이터프레임을 정의하여 df2 에 저장한다.
df2<-data.frame(seq(1,5),c('a','b','c','d','e'),seq(6,10))
names(df2) <-c("col1","col2","col3")
df2

# [문제13] c() 함수로 먼저 벡터를 생성한 다음 data.frame()사용해서 
  #다음과 같이 구성되는 데이터 프레임 df3를만들어 출력해 본다.(제품명이 팩터형이 되지 않게 한다.)

name<-c('사과','딸기','수박')
price<-c(1800,1500,3000)
amount<-c(24,38,13)
df3<-data.frame(name,price,amount)
names(df3) <-c("제품명","가격","판매량")
df3

# [문제14] 앞에서 만든 데이터 프레임을 이용해서 과일 가격 평균, 판매량 평균을 구하여 출력한다.
mean(df3[,2])
mean(df3[,3])


# [문제15] 다음 세 벡터를 이용하여 데이터프레임 df4를 생성하고,
  #name 변수는 문자, gender 변수는 팩터, math 변수는 숫자 데이터의 유형이라는 것을 확인하시오.

name <- c('Potter', 'Elsa', 'Gates', 'Wendy', 'Ben')
gender <- factor(c('M', 'F', 'M', 'F', 'M'))
math <- c(85, 76, 99, 88, 40)
df4<-data.frame(name,gender,math)
str(df4)

# [문제16] 다음과 같이 값이 구성되는 리스트를 정의하여 L1 에 저장한다.
L1 <- list(name='scott',sal=3000)
L1
result1<-L1$sal*2
result1

# [문제17] 다음과 같이 값이 구성되는 리스트를 정의하여 L2 에 저장한다.

L2<-list("scott",c(100,200,300))

# [문제18] 다음 리스트에서 A를 "Alpha"로 대체한다.
li<-list(c(3,5,7), c('A', 'B', 'C'))
li[[2]]
li[[2]]<-c('Alpha', 'B', 'C')


# [문제19] 다음 리스트에서 첫 번째 원소(alpha)의 각 값에 10을 더하여 출력한다.
a<-list(alpha=0:4, beta=sqrt(1:5), gamma=log(1:5))
a$alpha <-  a$alpha+10
a

# [문제20] 다음 리스트는 math, writing, reading의 중간고사 및 기말고사 점수이다. 
  #전체 평균을 계산하여 출력한다.
a<- list(math=list(95, 90), writing=list(90, 85), reading=list(85, 80))
unlist(a)
mean(unlist(a))

# [문제21] iris 데이터에서 다음 기본 정보를 조회한다(기본정보조회)
#타입, 구조, 차원, 변수이름, 기본통계량(평균, 표준편차, 사분위수)
#타입
class(iris)
#구조
str(iris)
#차원
dim(iris)
#변수명
ls(iris)

#기본통계량
summary(iris)

# [문제22] iris 데이터를 정렬한다
  #Petal.Length를 기준으로 내림차순으로 정렬하세요
iris[order(-iris$Petal.Length),]
  #Sepal.Width 를 내림차순 정렬하세요
iris[order(-iris$Sepal.Width),]

# [문제 23] iris 데이터의 종별 데이터 개수 출력한다
table(iris$Species)

#[문제 24] 종별 Sepal.Length의 합을 출력한다.
tapply(iris$Sepal.Length, iris$Species, sum)

# [문제 25] Sepal.Length, Sepal.Width, Petal.Length, Petal.Width의 평균을 출력
# Apply, lappy, sapply이용
# 종별 Sepal.Length의 평균 출력
irisList <- as.list(iris[,1:4])
irisList
lapply(irisList, mean)
sapply(irisList, mean)

## [문제 26] 꽃받침의 길이(Sepal.Length)가 가장 긴 꽃의 종은 무엇인가요?

iris[which.max(iris$Sepal.Length),][5]

