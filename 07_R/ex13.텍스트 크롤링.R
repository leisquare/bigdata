#########################################
# # #       13. 웹 데이터 수집      # # # 
#########################################

#1.정적 웹크롤링-단일 페이지 크롤링.(rvest패키지 사용)
install.packages("rvest")
library(rvest)
?rvest
url<-'https://movie.naver.com/movie/point/af/list.nhn'
text<-read_html(url,encoding='Cp949')
text


#영화제목; .movie
nodes<-html_nodes(text,'.movie')
title<-html_text(nodes)


#해당 영화 링크
movieInfo<-html_attr(nodes,'href')
movieInfo<-paste0(url,movieInfo)
movieInfo

#평점; .list_nerizen_score em
nodes<-html_nodes(text,".list_netizen_score em")
nodes
point<-html_text(nodes)
point

#영화 리뷰; .title

nodes<-html_nodes(text,'.title')
nodes
review<-html_text(nodes)
review

review<-gsub('\t','',review)
review<-gsub('\n','',review)

review<-unlist(strsplit(review,'중[0-9]{1,2}'))[seq(2,20,2)]
review<-gsub('신고','',review)
review

page<-cbind(title,movieInfo)
page<-cbind(page,point)
page<-cbind(page,review)
View(page)

#csv파일로 cut
write.csv(page,"outData/movie_review.csv",row.names=F)


#여러 페이지 정적 웹 크롤링
home='https://movie.naver.com/movie/point/af/list.nhn?'
site='https://movie.naver.com/movie/point/af/list.nhn?&page='
movie.review<-NULL

for(i in 1:100){
  url<-paste0(site,i);
  cat(url,'\n')
  #영화제목; .movie
  nodes<-html_nodes(text,'.movie')
  title<-html_text(nodes)
  #해당 영화 링크
  movieInfo<-html_attr(nodes,'href')
  movieInfo<-paste0(home,movieInfo)
  #평점; .list_nerizen_score em
  nodes<-html_nodes(text,".list_netizen_score em")
  point<-html_text(nodes)
  #영화 리뷰; .title
  nodes<-html_nodes(text,'.title')
  review<-html_text(nodes)
  review<-gsub('\t','',review)
  review<-gsub('\n','',review)
  review<-unlist(strsplit(review,'중[0-9]{1,2}'))[seq(2,20,2)]
  review<-gsub('신고','',review)
  page<-cbind(title,movieInfo)
  page<-cbind(page,point)
  page<-cbind(page,review)
  movie.review<-rbind(movie.review,page)
}

view(movie.review)
write.csv(movie.review,'outData/movie_review100page.csv')



#1~100페이지까지 크롤링한 영화들 중 평점이 높은 10개를 시각화하시오.
#불러오기
movie_review100page<-read.csv('outData/movie_review100page.csv')

(movie_review100page)

movie_review100page %>% 
  group_by(title) %>% 
  summarise(point_mean=mean(point),
            point_sum=sum(point)) %>% 
  arrange(-point_mean) %>% 
  ggplot(aes(x=title,y=point_mean,fill=title))+
  geom_col()


#영화 리뷰 내용만 뽑아 최빈단어 10개 워드 크라우드 시각화.
reviewtxt<-movie_review100page$review
reviewtxt<-str_replace_all(reviewtxt,'[ㄱ-ㅎ]',' ')
reviewtxtnouns<-extractNoun(reviewtxt)  
reviewwordcount<-table(unlist(reviewtxtnouns))                              
reviewwordcount
rw_wordcount<-as.data.frame(reviewwordcount,stringsAsFactors=FALSE)

rw_wordcount
#이름바꾸기
rw_wordcount<-rename(rw_wordcount,word=Var1,freq=Freq)
#최빈단어뽑기
rw_wordcount20<-rw_wordcount[order(rw_wordcount$freq,decreasing=T),][1:20,]


rw_wordcount %>% 
  arrange(desc(freq)) %>% 
  head(10) %>% 
  ggplot(aes(x=freq,y=reorder(word,freq)))+
  geom_col()

#워드 클라우드
set.seed(1234)
pal<-brewer.pal(9,'Blues')[5:9]
wordcloud(words=rw_wordcount$word,
          freq=rw_wordcount$freq,
          min.freq=5,
          max.words=200,
          random.order=F,
          rot.per=0.1,
          scale=c(2,0),
          colors=pal)

wordcloud(words=rw_wordcount20$word,
          freq=rw_wordcount20$freq,
          min.freq=5,
          max.words=200,
          random.order=F,
          rot.per=0.1,
          scale=c(2,0),
          colors=pal)

#2.동적 웹크롤링-셀레니움 패키지 이용:스크롤 다운, 로그인 이후, 버튼입력 등.
#특정 폴더 생성 후 3개의 파일을 다운받아 압축을 풀고 셀레니움 서버 가동.
#1. 정적 웹크롤링
#https://chrome.google.com/webstore/search/SelectorGadget?utm_source=chrome-ntp-icon ; SelectorGadget 다운로드 주소 (크롬 웹스토어에서 selectorGadget 검색 후 확장 설치)
#
#2. 동적 웹크롤링
#https://github.com/mozilla/geckodriver/releases/tag/v0.17.0
#https://sites.google.com/a/chromium.org/chromedriver/
#  https://www.seleniumhq.org/download/
  
#해당 폴더의 주소창에서 cmd접속, 아래 복사해 입력
#java -Dwebdriver.gecko.driver="geckodriver.exe" -jar selenium-server-standalone-3.141.59.jar -port 4445

#필요한 패키지 다운로드, 로드
install.packages("RSelenium")
library(httr)
library(rvest)
library(RSelenium)

###셀레니움 동적 웹크롤링 준비 끝
#예제 1. 특정 부분에 text를 입력한 후 엔터한 결과를 크롤링.
remDr<- remoteDriver(port=4445L, #포트번호
                     browserName='chrome' #사용할 브라우저
                     )
#사용할 브라우저
remDr$open() #창을 켜라
remDr$navigate('https://www.youtube.com') #어느 사이트로 가라

welElem<-remDr$findElement(using='css',
                           '#search')
welElem$sendKeysToElement(list('과학 다큐 비욘드',key='enter'))

#입력할 창의 태그를 SelectorGadget로 찾아내고.
#현재 페이지의 HTML소스 가져오기.
html<-remDr$getPageSource()[[1]] 
html<-read_html(html)

# '#video-title' css안의 txt 가져오기
youtube_title<-html %>% 
  html_nodes('#video-title') %>% 
  html_text()

youtube_title[1:5]

youtube_title<-gsub('\n','',youtube_title)
youtube_title<-trimws(youtube_title)
youtube_title[1:5]

youtube_title_url<-html %>% html_nodes('#video-title') %>% 
  html_attr('href')

youtube_title_url[1:10]
youtube_title_url<-
  ifelse(is.na(youtube_title_url),'',
         paste0('https://www.youtube.com',youtube_title_url))

#youtube_title만 text파일로 out
write.table(youtube_title,
            file='outData/과학다큐결과.txt',
            sep=',',
            row.names=FALSE,
            quote=FALSE)

#csv파일로 내보내기
result<-cbind(youtube_title,youtube_title_url)
write.csv(result,
          file='outData/과학다큐결과.csv'#,
          #row.names=FALSE
          )


#예제 2. 마우스 스크롤 다운한 후 크롤링(댓글)
remD<-remoteDriver(port=4445L,
                   browserName='chrome')
remD$open() #서버를 통해 브라우저 오픈
remD$navigate("https://youtu.be/tZooW6PritE")

btn<-remD$findElement(using='css selector',
                      value='.html5-main-video')
btn$clickElement() # 메인 동영상 플레이 멈춤

#마우스 스트롤 다운
remD$executeScript("window.scrollTo(0,500)")
remD$executeScript("window.scrollTo(1000,1500)")
remD$executeScript("window.scrollTo(1000,6000)")

#현재 페이지의 html 소스 가져오기
html<-remD$getPageSource()[[1]]
html<-read_html(html)

comments<-html %>% 
  html_nodes('#content-text') %>% html_text()
comments[1:10]

write.table(comments,
            file="outData/댓글.txt",
            sep=',',
            row.names=F,
            quote=F)

nnames<-html %>% 
  html_nodes('#author-text') %>% html_text()
nnames<-gsub('\n','',nnames)
nnames<-trimws(nnames)
nnames[1:10]



