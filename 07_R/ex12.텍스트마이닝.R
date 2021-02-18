#########################################
# # #       12. 텍스트 마이닝       # # # 
#########################################

#문자로 된 비정형 텍스트 데이터로부터 가치있는 정보를 얻어내는 분석.
#텍스트 마이닝시 가장 먼저 할 일은 형태소 분석. 

install.packages("rJava")
install.packages("memoise")
install.packages("KoNLP") #not available 오류

#google에서 koNLP를 검색하면 CRAN - Package KoNLP가 나옴. archive 클릭
#

library(KoNLP)
library(dplyr)

Sys.setenv(JAVA_HOME="C:/Program Files/Java/jre1.8.0_271/")

#우측의 packages->install 도구를 이용해 인스톨하기 위해 필요한 것
install.packages("devtools")

#KoNLP가 의존하는 package 미리 install.
install.packages("hash")
install.packages("tau")
install.packages("Sejong")


#KoNLP를 Packages탭의 install도구를 이용해서 설치. 

# C:\Users\tjoeun\Documents\R\win-library\4.0\KoNLP\java 이 폴더에 scala-library-2.11.8.jar를 넣는다. 

library(KoNLP)
Sys.getenv("JAVA_HOME")

useNIADic()

extractNoun("대한민국의 영토는 한반도와 그 부속 도서로 한다.")
extractNoun("의미있는 하루 하루 알차고 활기찬 하루 하루 감사해요")

#1. 힙합 가사 텍스트 마이닝
#1.1
txt<-readLines("inData/hiphop.txt") #비정형데이터
extractNoun(txt)

head(txt)

#특수문자 제거
#gsub(oldStr,newStr,string)
#str_replace_all(string,oldStr,newStr)

#1.2. 국정원 트윗 텍스트 마이닝
temp<-gsub('\\W',' ',txt)
temp<-gsub('\\d',' ',temp)
txt<-str_replace_all(txt,'\\W',' ')  ############이거 안됨
temp==txt
temp
#1.3 명사 추출
head(txt)
nouns<-extractNoun(temp)  #명사만 추출해 list형태로 변환
class(nouns)
head(unlist(nouns))
wordcount<-table(unlist(nouns)) #워드카운트(단어별 빈도표) 생성
class(wordcount)
head(wordcount,100)
sort(wordcount)

df_word<-as.data.frame(wordcount,stringsAsFactors=F) #stringsAsFactors 문자를 factor형으로 잡히지 않게 하려고.
head(df_word,20)
str(df_word)
library(dplyr)
df_word<-rename(df_word,word=Var1,freq=Freq)
df_word

df_word<-df_word %>%
  filter(nchar(word)>=2) #nchar 문자수 반환

df_word<-filter(df_word,nchar(word)>=2)
head(df_word)

#자주 사용되는 안어 빈도표 top 20

top20<-df_word[order(-df_word$freq),][1:20,]
top20$word

top20<-df_word %>% 
  arrange(desc(freq)) %>% 
  head(20)
top20$word

#자주 사용되는 안에 top20 그래프 그리기
library(ggplot2)
ggplot(data=top20,aes(x=freq,y=reorder(word,freq)))+
  geom_col()+
  geom_text(aes(label=freq),vjust=-0.5,col='red')

library(RColorBrewer)
display.brewer.all()


#워드 클라우드
# 1. 비정형text 데이터 확보.
#2. 패키지 설치 및 로드(KoNLP,wordcloud)
#3. 확보된 text데이터 읽어오기
#4. 명사 추출
#5. 필요없는 데이터 삭제(특수문자, zz,ㅋㅋ,ㅎㅎ 등)
#6. 워드카운트 생성
#7. worldcloud함수 이용해서 워드클라우드 생성.

install.packages("wordcloud")
library(wordcloud)
library(stringr)

set.seed(1234) #난수 생성결과를 일치시키기 위함
round(runif(6,min=1,max=45))

display.brewer.all()
pal<-brewer.pal(8,"Dark2") #색상 목록 생성

wordcloud(words=df_word$word, #뿌려질 단어
          freq=df_word$freq, #단어빈도
          min.freq=2, #최소단어빈도
          max.words=200, #표현될단어수
          random.order=F, #최빈단어를 중앙배치
          rot.per= 0.1, #회전 단어 비율율
          scale=c(2,0.3), # 단어 크기 범위
          #colors=pal  #단어 색상
          colors=topo.colors(10)
          )

#과학다큐비욘드_인공지능 1부<보면 재밌을 것.
#국정원 트윗 데이터 텍스트 마이닝
rm(list=ls())
twitter<-read.csv('inData/twitter.csv',
                  header=TRUE,
                  stringsAsFactors=F,
                  fileEncoding='utf-8')
head(twitter)
View(twitter)
class(twitter)
twitter<-rename(twitter,no=번호,id=계정이름, date=작성일, tw=내용)
twitter

#필요없는 문자, 단어 삭제하기
twitter$tw<-str_replace_all(twitter$tw,'\\W',' ')
twitter$tw<-str_replace_all(twitter$tw,'[ㄱ-ㅎ]',' ')

twitter$tw<-gsub('\\W',' ',twitter$tw)


nouns<-extractNoun(twitter$tw)

class(nouns)
nouns
wordcount<-table(unlist(nouns))
class(wordcount)
df_word<-as.data.frame(wordcount,stringsAsFactors=FALSE)
str(df_word)

df_word<-rename(df_word,word=Var1,freq=Freq)
head(df_word)

#출현단어중 2글자이상만 출력
df_word<-filter(df_word,nchar(word)>1)
head(df_word)

#최빈단어 top20 뽑고 그래프 그리기
top20<-df_word[order(df_word$freq,decreasing=T),][1:20,]
top20

df_word %>% 
  arrange(desc(freq)) %>% 
  head(20) %>% 
  ggplot(aes(x=freq,y=reorder(word,freq)))+
  geom_col()

top20<-df_word %>% 
  arrange(desc(freq)) %>%
  head(20)
ggplot(top20,aes(x=freq,y=reorder(word,freq)))+
  geom_col()+
  geom_text(aes(label=freq),hjust=1,size=3,col='yellow')


#워드클라우드 그리기

set.seed(1234)
pal<-brewer.pal(9,'Blues')[5:9]
wordcloud(words=df_word$word,
          freq=df_word$freq,
          min.freq=5,
          max.words=200,
          random.order=F,
          rot.per=0.1,
          scale=c(3,0.3),
          colors=pal)

#글 게시 수가 150회 이상 트윗한 게시물에 대해 
#최빈 top20개 단어를 출력, 시각화하고 워드 클라우드를 완성하시오.
idcount<-as.dat.frame(table(twitter$id))
head(idCount)
idCount<-rename(idCount,id=Var1,count=Freq)
twitter<-left_join(twitter,idCount,by='id')
most<-idcount[idCount$count>=150,'id']
twitter1<-subset(twitter,subset=id %in% most)

#필요없는 단어문자 삭제
twitter1$tw<-str_replace_all(twitter1$ts,'\\W',' ')
twitter1$tw<-str_replace_all(twitter1$ts,'[ㄱ-ㅎ]',' ')

#워드카운트 생성
wordcount<-table(unlist(nouns))
df(word<-ds.data.frame(wordcount))



#####################################텍스트 마이닝은 여기까지.






