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


