
######################################################
#혼자서 해보기1 : mpg 데이터를 이용해 분석 문제를 해결해 보세요.
######################################################
#Q1. 자동차 배기량에 따라 고속도로 연비가 다른지 알아보려고 합니다. 
#displ(배기량)이 4 이하인 자동차와 5 이상인 자동차 중 어떤 자동차의 hwy(고속도로 연비)가 평균적으로 더 높은지 알아보세요.

#mpg_rank<-ifelse(mpg$displ<=4,"a",ifelse(mpg$displ<5,"b","c"))


mpg %>%
  mutate(mpg_rank=ifelse(mpg$displ<=4,"displ<=4",ifelse(mpg$displ<5,"displ<5","displ>=5"))) %>% 
  filter(mpg_rank=="displ<=4"|mpg_rank=="displ>=5")%>% 
  group_by(mpg_rank) %>% 
  summarise(tot_mean1=mean(hwy))
  

# Q2. 자동차 제조 회사에 따라 도시 연비가 다른지 알아보려고 합니다.
#"audi"와 "toyota" 중 어느 manufacturer(자동차 제조 회사)의 cty(도시 연비)가
#평균적으로 더 높은지 알아보세요.

mpg %>% 
  filter(manufacturer=='audi'|manufacturer=='toyota') %>% 
  group_by(manufacturer) %>% 
  summarise(cty_mean1=mean(cty))

# Q3. "chevrolet", "ford", "honda" 자동차의 고속도로 연비 평균을 알아보려고 합니다.
#이 회사들의 자동차를 추출한 뒤 hwy 전체 평균을 구해보세요.
mpg %>% 
  filter(manufacturer=='chevrolet'|manufacturer=='ford'|manufacturer=='honda') %>% 
  summarise(hwytotalmean=mean(hwy))

######################################################
#혼자서 해보기 2 . mpg 데이터를 이용해서 분석 문제를 해결해보세요.
######################################################
#Q1. mpg 데이터는 11개 변수로 구성되어 있습니다. 이 중 일부만 추출해서 분석에 활용하려고 합니다. 
#mpg 데이터에서 class(자동차 종류), cty(도시 연비) 변수를 추출해 새로운 데이터를 만드세요. 
#새로 만든 데이터의 일부를 출력해서 두 변수로만 구성되어 있는지 확인하세요.

newdata<-mpg %>% select(class,cty)
head(newdata)

#Q2. 자동차 종류에 따라 도시 연비가 다른지 알아보려고 합니다. 
#앞에서 추출한 데이터를 이용해서 class(자동차 종류)가 "suv"인 자동차와 
#"compact"인 자동차 중 어떤 자동차의 cty(도시 연비)가 더 높은지 알아보세요.

newdata %>% 
  filter(class=='suv'|class=='compact')%>%
  group_by(class) %>%
  summarise(cty_mean_newdata=mean(cty)) %>%
  arrange(-cty_mean_newdata)

#Q3. "audi"에서 생산한 자동차 중에 어떤 자동차 모델의 hwy(고속도로 연비)가 높은지 
#알아보려고 합니다. "audi"에서 생산한 자동차 중 hwy가 1~5위에 해당하는 
#자동차의 데이터를 출력하세요.

mpg %>% 
  filter(manufacturer=='audi')%>%
  arrange(-hwy) %>% 
  head(5)


