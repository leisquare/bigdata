####주석은 샵으로 붙인다.
##############################################################
#2장. R lanquage 기초

#1. 도움말 기능
# 1.1 도움말
iris
edit(iris)
?iris #도움말 출력
help(iris) #도움말 출력

# 1.2 검색기능
?? iris
help.search('iris')

# 1.3 패키지 도움말
library(help="datasets")

# 1.4 함수 도움말
methods(as) #형변환 함수들
as.integer(1.25)
?as.integer
example("as.integer")



# 1.5 정보조회
data <-c(10,20,30)
mean(data)
?mean
example(mean)

edit(iris)
attributes(iris)

# 1.6 주석과 자동완성
# 주석
#자동완성: tab


## 2. 패키지
# R내에 기본 패키지는 다운로드받을 수 있다.
# 2.1 패키지 설치
  # 설치 : install.package("패키지명")
  # 설치된 패키지를 메모리에 로드. library("패키지명")
  # 패키지 내의 데이터나 함수들 막 사용
  # 패키지 언로드: detach("package:패키지명",unload=true)
iris
detach("package:datasets",unload=TRUE)
iris
install.packages("arules")
library("arules")
?apriori
detach("package:arules",unload=true)

# 데이터의 경우는 메모리에 패키지 로드 없이 사용 가능
data(iris,package="datasets")


#변수들 다 삭제
ls()
rm(list=ls())

# 2.2

## 3. 변수
#변수: 특수문자 중 . , _ 사용가능
# 할당 : <-, <<- 사용
result <- 0 # 전역변수 result
class(result) #타입
add <- function(a,b){
  #result <- a+b  #지역변수가 됨
  result <<-a+b # 전역변수 할당
  return(result)
}
add(10,20)
result

#변수목록 조회
x<-10
y<-10
(z<-x+y)
ls() #변수들 출력
ls(all.names = TRUE) #hidden변수도 포함함. hidden 변수는 앞에 .이 있다.


## 4. 출력
result
print(result)
(z<- z+10)

paste('hello','world')
paste('result 값은', result)
# print('result 값은 '+result) R에서는 오류가 발생해버리니 그냥 paste를 쓴다.
paste('Hello','world',sep=',')

1:3
paste(c(1,2,3),c('하나','둘','셋'), sep='은 ')
paste(c(1,2,3),c('하나','둘','셋'),sep='은 ',collapse='/')


month.name
(nth<-paste(1:12,c('st','nd','rd',rep('th',9)),sep=""))
paste(month.name,nth, sep = '은 ',collapse=" ; ")


#5. 변수 삭제
rm(z) #z변수 한 개 삭제
rm(list=ls()) #히든변수와 일반 변수 삭제
rm(list= ls(all.names = TRue)) #히든변수까지 삭제

#6
# ~.R: R스크립트 파일(R실행코드 저장)

#~.RData:R작업공간
#~.Rhistory: 콘솔창에 실행한 R명령어들의 history 저장장

#문. kor에 '한국,'일본','미국'
#usa에 'korea','japan','america'
#출력은 한국:Korea, 일본:Japan, 미국:America 


kor<-paste(c('한국','일본','미국')) #반드시 동질자료형일 것
usa<-paste(c('korea','japan','america'))
paste(kor,usa,sep=':',collapse=", ")

strVector<-paste(kor,usa,sep=':',collapse=", ")


#문 2. Mass:: Cars93 데이터를 출력해보세요.

Cars93 #패키지 로드
data.Cars93 
library(MASS)#안되면 패키지 로드하기 패키지 설치하기
install.packages("MASS")

library(MASS)
Cars93

edit(Cars93)
head(Cars93) #1~5행까지만만


