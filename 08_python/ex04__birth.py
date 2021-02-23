# -*- coding: utf-8 -*-
"""
태어난 년도를 입력받아 나이와 성인인지 여부 확인
청소년: 15~19살/아동(14세 미만)
1992년도에 태어난 당신은 30살이고 성인입니다.
python ch04_year.py 1992
python ch04_year.py

"""

import sys
if len(sys.argv)==1:
    birth = int(input("생년을 입력하세요>"))
else:
    birth=int(sys.argv[1])

age=(2021-birth+1)
if 20<=age:
    group="성인"
elif 15<=age<20:
    group="청소년"
elif 0<=age<15:
    group="아동"
else:
    group="유효하지 않은 나이"
    
print("{}년도생이신 당신은 {}살이고 {}입니다.".format(birth,age,group))