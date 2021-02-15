

### 연습문제 1
#datasets::cars데이터 셋을 이용하여 속도에 대한 제동거리의 산점도와 적합도(신뢰구간\그래프)를 나타내시오
#(단, 속도가 5부터 20까지 제동거리 0부터 100까지만 그래프에 나타냄).
ggplot(cars,aes(x=speed,y=dist))+
  coord_cartesian(xlim=c(5,20),ylim=c(0,100))+
  geom_point()+
  geom_smooth()

### 연습문제 2
#gapminder::gapminder 데이터 셋을 이용하여 1인당국내총생산에 대한 기대수명의 산점도를 
#대륙별 다른 색으로 나타내시오.

library(ggplot2)
ggplot(gapminder,aes(x=gdpPercap,y=lifeExp,col=continent))+
  geom_point()

### 연습문제 3
#gapminder::gapminder 데이터 셋을 이용하여 기대 수명이 70을 초과하는 데이터에 대해 대륙별 데이터 갯수
library(ggplot2)
gapminder %>% 
  filter(lifeExp>70) %>% 
  group_by(continent) %>% 
  summarise(n=n()) %>% 
  ggplot(aes(x=continent,y=n,fill=continent))+
  geom_bar(stat='identity')+
  labs(title="연습문제 3",
       subtitle="기대수명이 70을 초과하는 데이터 빈도(대륙별)",
       x="대륙",y="빈도")


### 연습문제 4
# gapminder::gapminder 데이터 셋을 이용하여 기대수명이 70을 초과하는 데이터에 대해 대륙별 나라 갯수.

library(ggplot2)
gapminder %>% 
  filter(lifeExp>70) %>% 
  group_by(continent,country) %>% 
  summarise(n=n()) %>% 
  group_by(continent) %>% 
  summarise(n=n())%>% 
  ggplot(aes(x=continent,y=n,fill=continent))+
  geom_col()+
  labs(title="연습문제 4",
       subtitle="기대수명이 70을 초과하는 대륙별 나라 빈도",
       x="대륙",y="나라 빈도")


### 연습문제 5
#gapminder::gapminder 데이터 셋을 이용하여 대륙별 기대수명의 사분위수를 시각화
ggplot(gapminder, aes(y=lifeExp, x=continent))  +
  geom_boxplot(aes(col=continent),fill='white')+
  labs(title="연습문제 5",
       subtitle="대륙별 기대수명의 사분위수")

### 연습문제 6
#gapminder::gapminder 데이터 셋을 이용하여 년도별로 gdp와 기대수명과의 관계를
#산점도를 그리고 대륙별 점의 색상을 달리 시각화
ggplot(gapminder, aes(x=gdpPercap,y=lifeExp))  +
  geom_point(aes(col=continent),alpha=0.6,pch=16)+
  facet_wrap(~year)+
  scale_x_log10()+
  #coord_cartesian(xlim=c(5,10000))
  labs(title="연습문제 6",
       subtitle="GDP와 기대수명과의 관계",
       x="gdpPercap",y="lifeExp")

### 연습문제 7
#gapminder::gapminder 데이터 셋에서 북한과 한국의 년도별 GDP 변화를 산점도로 시각화하시오
#(북한:Korea, Dem. Rep. 한국:Korea, Rep. substr(str, start, end)함수 이용)

gapminder %>% 
  filter(substr(country, 1, 5) =='Korea') %>% 
  ggplot(aes(x=year,y=gdpPercap))  +
  geom_point(aes(col=country),pch=16)+
  labs(title="연습문제 7",
       subtitle="GDP의 변화(한국과 북한)")+
  theme(legend.position = c(0.3,0.85))

  
### 연습문제 8
#gapminder::gapminder데이터 셋을 이용하여 한중일 4개국별 GDP 변화를 산점도와 추세선으로 시각화 하시오.

gapminder %>% 
  filter(substr(country, 1, 5) %in% c('Korea','China','Japan')) %>% 
  ggplot(aes(x=year,y=gdpPercap))  +
  geom_point(aes(col=country),pch=16)+
  geom_line(mapping=aes(x=year,y=gdpPercap,group=country,color=country))+
  labs(title="연습문제 8",
       subtitle="한중일 4개국의 GDP 변화 꺾은선그래프 ")

### 연습문제 9
#gapminder::gapminder 데이터 셋에서 한중일 4개국별 인구변화 변화를 산점도와 추세선으로 시각화 하시오

gapminder %>% 
  filter(substr(country, 1, 5) %in% c('Korea','China','Japan')) %>% 
  ggplot(aes(x=year,y=pop))  +
  geom_point(aes(col=country),pch=16)+
  geom_line(mapping=aes(x=year,y=pop,group=country,color=country))+
  labs(title="연습문제 9",
       subtitle="한중일 4개국의 인구변화 꺾은선그래프 ")+
  scale_y_continuous(labels = scales::comma)



### 연습문제 10
#Ggplot2::economic 데이터 셋의 개인 저축률(psavert)가 시간에 따라 어떻게 변해 왔는지 알아보려 한다.
#시간에 따른 개인 저축률의 변화를 나타낸 시계열 그래프와 추세선을 시각화하시오

economics %>% 
  #filter(substr(country, 1, 5) %in% c('Korea','China','Japan')) %>% 
  ggplot(aes(x=date,y=psavert))  +
  #geom_point(aes(col=country),pch=16)+
  geom_line(mapping=aes(x=date,y=psavert,color='red'))+
  labs(title="연습문제 10",
       subtitle="개인저축률 시계열그래프 ")+
  theme(legend.position ="none")





