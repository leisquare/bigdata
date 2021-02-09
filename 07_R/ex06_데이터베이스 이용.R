
##############################################################
#6장. 데이터 베이스 이용
##############################################################

#SQL문으로 데이터프레임과 DB테이블 이용
rm(list=ls(all.names=T))
#6.1 sql문을 이용한 데이터 프레임 처리
install.packages("sqldf")
#fastmap.bit.cachem...등을 의존합니다.
library(sqldf) #sqldf()함수를 통해 데이터프레임을 DB의 테이블처럼 사용가능
sqldf("select from iris")
#중복행 제거하여 한번만 출력(iris의 종을 출력)
sqldf("select distinct Species from iris")
names(table(iris$Species))
library(dplyr)
iris %>%
  group_by(Species) %>% 
  summarise()

#행 제한 조건 설정(virginica종만 출력)
sqldf("select * from iris where species =='virginica'")
iris[iris$Species=='virginica',]
iris %>% 
  filter$Species=='virginica'

#virfinica종이면서 Sepal.Length가 7.5를 초과하는 것만
sqldf("select * from iris where species=='virginica'and `Sepal.length`>7.5 ") 
#컬럼명에 .이 있는 경우 ``(1 옆에 있는 것)으로 감싼다.

iris[iris$Species=='virginica' & iris$Sepal.Length>7.5,]
iris %>% 
  filter(Species)

#종별 Sepal.Length의 합을 출력
sqldf("select Species, sum(`Sepal.length`) from iris group by Species")
tapply(iris$Sepal.Length,iris$Species,mean)
by(iris$Sepal.Length,iris$Species,mean)
library(doBy)
summaryBy(Sepal.Length~Species,iris,FUN=mean)
aggregate(iris$Sepal.Length,by=list(iris$Species),mean)

#정렬(Sepql.Length가 1~5등,6~10등)
sqldf("select * from iris order by `sepal.length` limit 5")
sqldf("select * from iris order by `sepal.length` limit 5,5") #5등부터 5개. Sql은 0번부터니까...

#sql함수(mySql함수) 사용: Petal.length,petal.width의 평균과 표준편차
sqldf("select avg(`Petal.length`)as mean_Length, stdev(`petal.length`)as st_Length,
      avg(`petal.width`)as mean_width,stdev(`petal.width`) as st_width from iris")

apply(iris[,c('Petal.Length','Petal.Width')],2,mean)
apply(iris[,c('Petal.Length','Petal.Width')],2,sd)
apply(iris[,c(3:4)],2,mean);apply(iris[,c(3:4)],2,sd)


#sql함수(mySQL함수) 사용: 종에 따른 Petal.length, petal.width의 평균과 표준편차
sqldf("select species, avg(`Petal.length`)as mean_Length, stdev(`petal.length`)as st_Length,
      avg(`petal.width`)as mean_width,stdev(`petal.width`) as st_width from iris group by species")

summaryBy(Petal.Length+Petal.Width~Species,iris,FUN=c(mean,sd))

sqldf("select round(avg(`petal.length`))from iris")
sqldf("select round(avg(`petal.length`),2)from iris")

iris %>% 
  summarise(mean=round(mean(Petal.Length),2))

#조인
getwd() #작업디렉토리 출력력
setwd('E:/kim_jiwon/src/07_R') #작업디렉토리 변경

emp<-read.csv("inData/emp.csv",header=T)
head(emp)
dept<-read.csv("inData/dept.csv",header=T)
head(dept)

#사번, 이름, 직책, 월급, 부서번호, 부서이름
sqldf("select empno,ename,job,sal, e.deptno, dname from emp e, dept d where e.deptno=d.deptno")

#사번, 일므, 부서번호, 부서이름
sqldf("select empno, ename, e.deptno,dname from emp e join dept d on e.deptno=d.deptno")  #mysql문법. emp e와 dept를 조인한다 on 조건


#2. 데이터베이스 연결
#전 작업:  자바를 설치하고 환경설정(JAVA_HOME), 작업 디렉토리(getwd()의 위치에 ojdbc6.JAR 넣기
getwd()
# 패키지 설치 및 로드:RJDBC
install.packages("RJDBC")
library(RJDBC)
# 드라이버 클래스 로드
drv<-JDBC("oracle.jdbc.driver.OracleDriver",classPath="ojdbc6.jar")
drv
#데이터베이스 연결
con<-dbConnect(drv,"jdbc:oracle:thin:@127.0.0.1:1521:xe","scott","tiger")
con
#SQL전송(select), 결과 받기
emp<-dbGetQuery(con,"select * from emp")
emp
class(emp)
summary(emp)
tail(emp)
emp[1:2,'EMPNO']

#테이블 전체 데이터 조회
dept<-dbReadTable(con,"dept")
dept

#SQL전송(updatd,insert,delete)-DB데이터 수정
dbSendUpdate(con,"insert into dept values (50,'it','PUSAN')")
dbSendUpdate(con,"update dept set loc = 'inchon' WHERE DEPTNO=50")
dbSendUpdate(con,"DELETE From DEPT WHERE DEPTNO=50")

# 데이터베이스 연결 해제
dbDisconnect(con)

# 드라이버 언로드..DB연결해제시 자동 언로드 됨
dbUnloadDriver(drv)
detach("package:RJDBC",unload=TRUE)

# 3. MySql 데이터베이스 연결
#MySQL Workbench에서 
#ALTER USER '아이디'@'localhost' IDENTIFIED WITH mysql native_password BY '비밀번호';

install.packages("RMySQL")
library(RMySQL)
drv <- dbDriver("MySQL")
con<-(dbConnect(drv,host="127.0.0.1",dbname="kimdb",user="root",password="mysql"))
rs<-dbSendQuery(con,"select * from personal")
personal<-fetch(rs,n=1)
personal

class(personal)
dbDisconnect(con)
dbUnloadDriver(drv)
