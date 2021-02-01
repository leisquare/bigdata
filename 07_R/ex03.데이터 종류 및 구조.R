
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
