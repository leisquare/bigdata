package com.lex.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

//날짜데이터를 간단하게 예쁘게 표현해주기.
public class Ex04_CalDateSimpleFormat {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
				//2020년 12월 14일 3시 03분 05초
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		/* yyyy(1993) yy(93)
		 * M(9) MM(09)
		 * d(9) dd(09)
		 * E 요일
		 * a 오전오후
		 * H 14시간 시
		 * h 시
		 * m 분
		 * s 초
		 * S 밀리세컨
		 * w 이버년도 몇번째 주/W는 이번 월 몇번째 주 D는 올해 몇번째 날
		 */
		String today = sdf.format(cal.getTime());
		System.out.println(today);
	}
}
