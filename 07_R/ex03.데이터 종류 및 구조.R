
##############################################################
#3장. 데이터 종류 및 구조
##############################################################


# 1. 데이터 종류 : 기본 데이터 타입(문자, 숫자, logical)=스칼라타입
        # 팩터, 벡터,리스트, 행렬, 배열, 데이터프레임, 날짜, 특별한 값(결측치)

# 2. 기본데이터타입: character, numeric, logical,
a<-"Hello"
a<-"Hello"
R

class(a)
cat(a) #print와 비슷. \n을 수행
cat('a값은 ',a)

b <- 10.1
b<- 10

strB<-as.character(b) # as."():
strB

c<-TRUE;
c
is.logical(c)

class(strB)
class(a)
class(b)
class(c)

str(a) #str() R의 내부 구조를 간결하게 표시
str(b)
str(c)


# 3. 특별한 값(Null, na;결축치, NaN, Inf

result<-0
add<-function(a,b){
  result<<-a*5+b ##전역변수화
  #return(result)
  return()
}
(temp<-add(1,2)) #일반변수 temp에 할당
(temp <-add(a=1,b=2)) #=는 주로 함수 안에서 준다.
(temp<-add,(b=10,5)) # 이렇게도 들어가진다. 남은 것은 남은 칸에 할당.
(temp<-add(1,3)) #  return()로 함수를 만들고 값을 입력했을 때 NULL로 나온다. Empty value
is.null(temp)

d<-c(2,3,NA,6,NaN,10/0) #c와 같은 것을 vector라고 한다. 동일자료형의 집합(combine?)
d
is.na(d)
is.na(d[3])

#NA(결측치)관련 함수
#is.na(d) # 결측치인지 아닌지
#complete.case(d) #결측치 여부 (true/false) is.na와 반대의 결과
#na.omit(d) 결측치 제외
#na.pass(d) NA여부 상관없이 처리.
is.na(d)
is.na(d[3])

?is.na
complete.cases(d)
na.omit(d);
na.pass(d)

mean(d) #평균결측치가 들어있으면 평균 계산이 안된다.
d<-c(2,3,4,5,NA)
mean(d, na.rm=TRUE)
boxplot(d)#돌출된 값이 어떤 형태로 있는지를 보여줌

# 4. 팩터(factor): 범주형데이터, 명명식, 순서식
gender1<- c('남','남','여')
gender1[3]
class(gender1)
gender1[4] <-'중성'
gender1 #넣으면 안되는 값이 넣어짐
gender<-factor(c('남','남','여'),levels=c('남','여'))
class(gender)
gender[3]
gender
str(gender)
gender[4]<-'중성'
gender

level<-factor(c('좋음','보통','보통'),levels =c('싫음','보통','좋음'),ordered=TRUE)
level
#아래와 같이 만들어도 내용물은 일단 똑같지만, 이것은 NA요소가 들어갈 수 있게 된다.
level <- ordered(c('좋음','보통','보통'),levels = c('싫음','보통','좋음'))
level

level[4]<- '몰라'
level



# 5. 구조형 변수와 복합형 변수; 변수 하나에 여러 값
  #(1) 구조형 변수: 동일 자료형. 
      #벡터, 행렬, 배열
  #(2) 복합형 변수: 서로다른 자료형을 가질 수 있음
      # ex)리스트, 데이터 프레임(csv)

# 6. 벡터 : 동일 자료형의 집합
data<- c(11,22,33,'test'); #이렇게 넣어놓으면 숫자+문자지만 문자형으로 들어간다.
data<- c(11,22,33,TRUE); #이것은 TRUE를 1로 해서 숫자로 들어간다.
str(data)
data<-c(TRUE,'test') #logical과 char과 섞이면 char화함.

data<-c(1,2,3) # 1인덱스부터 시작
data[4]<-40
data

#행과 열 조회
NROW(data) #항목 갯수1
length(data) #항목 갯수2

data<-c(1:4)
data 
#특정 값 조회
names(data)<-c('A열','B열','C열','D열')
data[1] #첫번째 값 반환
data['A열'] #A열 값 반환
data[c(1,2)] #첫번재, 두번째 값 반환
data[c(1:2)] #첫번째부터 두번째까지의 값 반환 
data[c('A열','B열')] #A열B열값 반환환
data[-2] #두번째를 제외하라는 뜻. 
data[data>2] #2보다 큰 값만 반환
data[c(TRUE,FALSE,FALSE,TRUE)] #1열 4열만 가져온다.
2 %in% data #data 안에 2가 포함되어있는가 여부

#Q1. 시험점수 변수를 만들고 출력하고 전체 평균을 구한 후 출력
  # 80,60,70,50,90,미응시
  # 
80,60,70,50,90,미응시
score<-c(80,60,70,50,90,NA);
print(paste("시험점수는 ",score))
cat(score)
na.omit(score)
(avg<-mean(score,na.rm=TRUE))
names(score)
names(score)<-c('kim','eun','pack','yi','azur','lim')
score
score[score>80]

class(score) #class 함수 이용시 벡터 요소 하나하나의 타입
is.vector(score)

# 6.1 character()
charArr <- character(5) # charArr length가 0인 벡터.
is.vector(charArr)
length(charArr)
charArr<-character (5) #length가 5인 벡터.그러나 6번 방에도 넣어진다...
charArr [6] <- '테스트'
charArr[7], "테스트"

char
# 6.2 numeric()
intArr<-numeric()
class(intArr)
is.vector(intArr)
intArr[1]<-1
intArr[3]<-3
intArr


# 6.3 logical()
logicArr <- logical(2) #length가 2인 logical 벡터
logicArrp[1]<-TRUE
logicArrp[2]<-FALSE
logicArrp[3]<-T
logicArr

# 6.4 seq()
?seq
seq(from=1,to=10)
a<-seq(from=1,to=10)
seq(from=1,to=10,by=2)
a<-seq(from=1,to=10,by=2)
a<-1:10
is.vector(a)

seq(10,-10,-2)
seq(0,1,0.1)
seq(1,9,by=pi)

# 6.5 rep()반복객체를 만드는 함수
rep(1:4,each=2) #12341234 rep(1:4,2)로 써도 된다.
rep(1:4,c(1,2,3,4))
rep(1:4,each=2,len=6)
rep(1:4,times=2)

# 6.6 벡터의 연산(사칙연산, 결합, 교집합, 합집합, 차집합)

a<-c(1,2,3)
b<-c(10,20,30)
a+b
a-b
a*b
a/b
a%%b #나머지 연산자
c(a,b) #벡터의 결합

a<-c(1,2,3)
b<-c("Hell","R")
c<-c(TRUE,FALSE)
(z<-c(a,b,c))

a<-append(a,c(4,5,6))
a
a[8]


#벡터의 집합연산 -합집합, 교집합, 차집합, 비교
a<-c(1,2,3,4,5,6)
b<-c(2,4,6,8,10,12)
union(a,b) #합집합
intersect(a,b) #교집합
setdiff(a,b) #차집합
setequal(a,b) #비교
setequal(a,c(intersect(a,b),setdiff(a,b)))

# 7. 리스트
student <- list(name='홍길동',age=25)
student
studentVector<-unlist(student)
studentVector
s<-c('홍길동',25)
names(s)<-c('name','age')
student<-as.list(s)  #as.list(): list형으로 형변환
student['name']
student$name
student[1] #$name[1]홍길동
student[[1]] #$[1]홍길동
student$age <- NULL #student의 age 제거

NROW(student) #열 수수
length(student) #행 수

# 8.행렬
colmatrix <- matrix(1:15,nrow=5,ncol=3)
colmatrix

colmatrix <- matrix(1:15,nrow=5,ncol=3,byrow=FALSE)
colmatrix
rowmatrix <- matrix(1:15,nrow=5,ncol=3,byrow=T, 
                    dimnames=list(c("r1","r2","r3","r4","r5"),c("c1","c2","c3")))
rowmatrix

dim(rowmatrix) #= 행과 열의 수
nrow(rowmatrix) #행 수
ncol(rowmatrix) #열 수
dim(rowmatrix) <-c(3,5)
dimnames(rowmatrix)
rownames(rowmatrix)
colnames(rowmatrix)

#행이름과 열이름 수정
dimnames(rowmatrix) <-list(c('1월','2월','3월','4월','5월'),c('kim','lee','choi'))
dimnames(rowmatrix)
rowmatrix




# 행렬의 곱을 이용하여 선형회귀식 도출
x<-c(2,4) #공부량
y<-c(40,60) #점수
X<-matrix(c(x,rep(1,NROW(x))),nrow=2,ncol=2,byrow=FALSE)
X
Y=matrix(y,ncol=1)
Y
#X%*%ab=Y
#solve(X) %*% X %ab=solve(X) %*%Y
ab<-solve(X) %*%Y
ab
ab[1]
ab[2]
plot(x,y)

lines(x,x*ab[1]+ab[2])


x<-c(32,64,96,118,126,144,152.5,158)
y<-c(18,24,61.5,49,52,105,130.3,125)

X<-matrix(c(x,rep(1,NROW(x))),ncol=2)
X
Y<-matrix(y,ncol=1)
Y

# X%*%ab=Y
# 전치행렬을 곱해서 정방행렬화
t(X)
t(Y)
t(X)%*%X #2*8 %*% 8@2 => 2*2 정방행렬

# X%*%ab=Y  양변에 역행렬 곱하기
# t(X) %*% X %*% ab = t(X) %*% Y
# solve(t(X) %*% X )%*% t(X) %*% X %*% ab = solve(t(X) %*% X ) %*%t(X) %*% Y
# ab = solve(t(X) %*% X ) %*%t(X) %*% Y
ab = solve(t(X) %*% X ) %*%t(X) %*% Y
ab

plot(x,y)
lines(x,x*ab[1]+ab[2])

#다변량에서의 회귀분석 도출
x1<-c(60,65,55) #변량은 소문자 매트릭스는 대분자
x2<-c(5.5,5.0,6.0) #키
x3<-c(1,0,1) #흡연유무
y<-c(66,74,78)
X<-matrix(c(x1,x2,x3),ncol=3)
X
Y<-matrix(y,ncol=1)
Y

t(X)%*%X%*%ab = t(X)%*%Y
solve(t(X)%*%X) %*% t(X)%*%X%*%ab = solve(t(X)%*%X)%*%t(X)%*%Y
ab = solve(t(X)%*%X)%*%t(X)%*%Y
ab

# 80kg, 6.5pt,금연 수명?
80*ab[1]+6.5*ab[2]+0*ab[3]

# 행렬연산(사칙연산 등등..%*%)
a<- matrix(1:4,nrow=2,ncol=2)
a
b<- matrix(seq(10,40,10),nrow=2,ncol=2)
b
a+b
a*b
a^b
a %% b
  ## 행렬연산 중 행렬곱(%*%)
payMatrix<-matrix(c(12000,26000,18000),ncol=3)
dimnames(payMatrix)<-list(c('시간당 수당'),c('철수','영희','말자'))
payMatrix

workerMatrix <- matrix(c(c(5,4,9),c(7,3,2)),ncol=2)
dimnames(workerMatrix)<-list(c('철수','영희','말자'),c('1월','2월'))
workerMatrix

cost<-payMatrix %*% workerMatrix
rownames(cost)<-c('인건비')
cost


# 9. 배열
dataArray <- array(1:24, dim = c(3,4,2))  #3행4열2면 3차원배열
dataArray
dim(dataArray) #차원의 크기 조회

nrow(dataArray) #행 수 조회
NROW(dataArray)
ncol(dataArray) #열 수 조회
NCOL(dataArray)
length((dataArray)) #요소 갯수
dimnames(dataArray) <-list(c('1행','2행','3행'),
                           c('1열','2열','3열','4열'),
                           c('1면','2면'))
dataArray
dim(dataArray)<-c(3,8)
dim(dataArray)<-c(8,3) #reshape
attr(dataArray,'dim')<-c(3,8)
dataArray

# 10. 데이터 프레임
student_id <- c('20211','20212','20213','20214')
student_name<-c('hin','eric','den','kei')
student_eng<-c(60,85,90,95)
student_kor<-c(100,95,95,90)
student_gender<-c('남','여','남','여')
student_data <- data.frame(student_id,student_name,student_eng,student_kor,student_gender)
student_data

#데이터프레임에 열 추가 및 삭제
student_data$mat<-c(100,100,99,98)
student_data$student_id<-NULL # 열 삭제
student_data
class(student_data$student_gender)
# (3) 열의 형변환
student_data$student_gender<-as.factor(student_data$student_gender)
class(student_data$student_gender)
str(student_data) #구조 보기
summary(student_data)

# (4) 열이름 변경
student_data
install.packages("reshape")
library("reshape")
require("reshape")
student<-rename(student_data,c("student_name"="name","student_eng"="eng","student_kor"="kor","student_gender"="gender"))
student

names(student_data) <-c("name","eng","kor","gender","mat")
student_data

# (5) 데이터 프레임 합치기
  # 행으로 합치기 rbind
newStudent <- rbind(student_data,student)
newStudent
  # 열로 합치기 cbind
student
id=data.frame(student_id)
id
student<-cbind(id,student)
student
names(student)<-c("id","name","eng","kor","gender","mat")
student

#부분 데이터 조회
student<-rbind(student,student) #2회 실행-16행
nrow(student)
student[1,1] #1행1열
student[1,] #1행1열
student[,1] #1행1열
student[c(1:3),] #1행부터 3행까지의 데이터
student[,c(2,3,4,5)]
student[,-c(2,3,4,5)]
student[,c(-2,-4,-5)]

student[c(1:3),c(-1,-5)]#1행부터 3행까지 1열과 5열 제외한 데이터

# 국어점수가 90점 이상인 데이터
subset(student,subset=(student$kor>=95))
subset(student,student$mat>99)
subset(student,select=c(1,4)) #1열과 4열 데이터
subset(student,select=-c(1,4)) #1열과 4열 데이터  
subset(student,select=c("name","kor","mat")) #"name","kor","mat"열만

#수학점수가 99점 이상인 여학생만 출력
subset(student,student$mat>=99 & student$gender == '여')

#처음 5행만
student[c(1:5),]
head(student)
#처음 3행만
head(student,3)
edit(student)

emp<- read.csv(file.choose()) #탐색기에서 선택한 csv파일을 emp변수에 할당.
emp
head(emp)
class(emp)
  #1. 직원이름만 출력
emp$ename
subset(emp,select=c("ename"))

  #2. 직원이름, job, sal
subset(emp,select=c("ename","job","sal"))

  #3. 직원이름이 king인 직원의 empno, job, hiredate, sal

subset(emp,subset=(emp$ename=='KING'), select=c("empno", "job", "hiredate", "sal"))

  #4 sal이 2000이상 직원의 empno,ename, sal
subset(emp,subset=(emp$sal>=2000),select=c("empno", "ename", "sal"))

  #5 sal이 2000이상 3000이하인 직원의 ename, sal
subset(emp,subset=(emp$sal>=2000 & emp$sal<=3000 ),select=c( "ename", "sal"))



#11. 타입 판별 및 타입 변환
tail(emp,6)
tail(emp)
class(emp) #emp의 타입
str(emp)
emp$deptno <-as.factor(emp$deptno)
str(emp)



edit(iris)
str(iris)
iris$Species<-as.character(iris$Species)
str(iris)
iris$Species<-as.factor(iris$Species)
levels(iris$Species)

#타입판별
class(iris$Species)
is.factor(iris$Species)
str(iris$Species)

# 12.문자열과 날짜
name<-'Eric'
length(name) #요소 갯수
nchar(name) #문자의 갯수

names<-c("eric","Larray","Cruly")
nchar(names)
length(names) #3

#하위문자열 추출하기 : substr
? substr

substr ('ABCDEF',1,4) #1~4번째 문자 추출.
substr ('ABCDEF',4,10) #1~10번째 문자 추출.없는문자는 ""로 처리
substr(names,1,2)

#names 안에 각각의 이름의 맨 마지막 자리 앞글자, 맨 마지막 글자
substr(names,nchar(names)-1,nchar(names))

#문자열 연결하기 : paste, paste0
names<-c("Eric","Larray","Curly")
paste(names,'loves','starts')
paste(names,'loves','starts',sep='_')
paste(names,'loves','starts',sep='_',collapse=', and ')
paste0(names,'loves','starts')

#문.
name<-c("yun","Lim","Lee"); hobby<-c("swim","sleep","eat")
#결과 yun의 취미는 swim이고, lim의 취미는 ~
paste(name,hobby,sep="의 취미는 ",collapse='이고, ')
cat(paste(name,hobby,sep="의 취미는 ",collapse='이고, '))

#문자열 분할(구분자 분할하기)
path<-'home/hadoop/data/speech.csv'
strsplit(path,'/')
customerInfo<-'jin@gmail.com,010-9999-8888,seoul korea' #이런 데이터 여럿 있을 때.
customers<-c('jin@gmail.com,010-9999-8888,seoul korea',
             'yun@gmail.com,010-1111-8222,pusan korea',
             'ann@gmail.com,010-451-5112,pusan korea')
strsplit(customers,'[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}')
#문자열 대체: sub(oldStr,newStr,string)
            #gsub(oldStr,newStr,string)
s<-'Curly is the smart one. Curly is funny, too.'
sub('Curly','Eric',s)
gsub('Curly','Eric',s)
gsub(' ','',s)
