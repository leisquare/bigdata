# -*- coding: utf-8 -*-
"""
점수를 입력받아 메시지 출력


score = int(input("점수는: "))
if score>=90:
    print('참 잘했어요')
    print('다음에도 기대할게요')
else :
    print('분발하세요')
    
print("done")

"""

import sys
if len(sys.argv)==1:
    score = int(input('점수 :'))
else:
    score=int(sys.argv[1])


score = int(input("Enter your score>"))
if 90<=score<=100:
    grade="A"
elif 80<=score<90:
    grade="B"
elif 70<=score<80:
    grade="C"
elif 60<=score<70:
    grade="D"
elif 0<=score<60:
    grade="F"
else:
    grade="유효하지 ㅇ낳은 점수"

print("입력한 점수는 {} 등급은 {}".format(score,grade))
