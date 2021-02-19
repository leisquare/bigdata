#########################################
# # #        14장. 지도시각화       # # # 
#########################################
#1. 미국 주별 강력 범죄율 시각화(USArrests 데이터 셋 이용)
view(usArrests)
#(1) 패키지 준비
install.packages("ggiraphExtra") #지도시각화를 위한 패키지
library(ggiraphExtra)
install.packages("mapproj") #ggChoropleth함수 사용을 위한 패키지
library(mapproj)
install.packages("maps")
library(ggplot2)
library(tibble)

#(2) 행이름을 변수로
head(USArrests,1)
crime<-rownames_to_column(USArrests,var="state")
class(crime)
head(crime,3)

crime$state<-tolower(crime$state) #주 이름을 소문자로바꾸기
#(3) 미국 지도 주 정보 가져오기
state_map<-map_data("state")

view(map_data("state"))
#(4) 지도 시각화
ggChoropleth(data=crime, #지도에 표현할 데이터
             aes(fill=Murder, #지도에 채워질 변수
                 map_id=state), #지역 변수
             map=state_map,  #위도경도 지도 데이터
             interactive=T) #인터렉티브.

# 2. 대한민국 시도별 인구, 결핵 환자 수 단계 구분도 만들기
rm(list=ls())
install.packages("stringi")
install.packages("devtools")
devtools::install_github #깃허브에있는거 가져오려고 받은 함수임
#https://github.com/cardiomoon/kormaps2014에서 cardiomoon/kormaps2014만가져온다

devtools::install_github("cardiomoon/kormaps2014")
library(kormaps2014)
head(korpop1)
#korpop1: 2015년 센서스 데이터(시도별)
#korpop1: 2015년 센서스 데이터(시군구별)
#korpop1: 2015년 센서스 데이터(읍면동별)

str(changeCode(korpop1)) #utf-8로 인코딩된 데이터를 cp949로 변환출력
library(dplyr)
korpop1<-rename(korpop1,
                pop=총인구_명,
                name=행정구역별_읍면동)
str(changeCode(korpop1))

head(kormap1)
head(changeCode(kormap1))
head(changeCode(korpop1[,c('name','pop','code')]))

library(ggiraphExtra)
library(ggplot2)

#
korpop1$name<-iconv(korpop1$name,'utf-8','CP949')

ggChoropleth(data=korpop1,
             aes(fill=pop,
                 map_id=code,
                 tooltip=name),
             map=kormap1,
             interactive = T)
#korpop1$name; utf-8을 cp949로

###############################################
head(tbc)
head(changeCode(tbc))
tbc$name1<-iconv(tbc$name1,'UTF-8','cp949')
tbc$name<-iconv(tbc$name,'UTF-8','cp949')
head(tbc)
ggChoropleth(data=tbc,
             aes(fill=NewPts,
                 map_id=code,
                 tooltip=name1),
             map=kormap1,
             interactive = T)

#한국행정지도(2014) 패키지 kormaps2014 안내
#https://rpubs.com/cardiomoon/222145