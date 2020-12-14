package com.lex.ex2_date;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex02_gregorianCalendar {
	public static void main(String[] args) {
		
		GregorianCalendar gc = new GregorianCalendar();
		
		System.out.println(gc);
		
		int year = gc.get(Calendar.YEAR);
		int month = gc.get(Calendar.MONTH) + 1; // 시스템은 0월부터 11월까지 나온다
		int day = gc.get(Calendar.DAY_OF_MONTH);
		int week = gc.get(Calendar.DAY_OF_WEEK);
		int hour24 = gc.get(Calendar.HOUR_OF_DAY); // 24시간단위.
		int hour12 = gc.get(Calendar.HOUR); // 12시간단위.
		int ampm = gc.get(Calendar.AM_PM); // am이 0, 1이 pm
		int minute = gc.get(Calendar.MINUTE);
		int second = gc.get(Calendar.SECOND);
		int millisec = gc.get(Calendar.MILLISECOND);
		System.out.printf("%d년 %d월 %d일 ", year, month, day);
		switch (week) {
		case 1:
			System.out.print("일요일");
			break;
		case 2:
			System.out.print("월요일");
			break;
		case 3:
			System.out.print("화요일");
			break;
		case 4:
			System.out.print("수요일");
			break;
		case 5:
			System.out.print("목요일");
			break;
		case 6:
			System.out.print("금요일");
			break;
		case 7:
			System.out.print("토요일");
			break;
		}
		System.out.printf(" %d시 %d분 %d초", hour24, minute, second, millisec);

		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tH시 %tM분 %tS초\n", gc,gc,gc,gc,gc,gc,gc);

		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 %1$tM분 %1$tS초\n", gc);
		System.out.printf((ampm == 0) ? "오전" : "오후");
		System.out.printf("%d시 %d분 %d초", hour24, minute, second);
		System.out.printf("%tl시 %tM분 %tS초 \n",gc,gc,gc);
		//tY년 tm월 td일 ta요일 tH시간 tl12시간 tM분 tS초
		//d정수 f실수 s문자열 c문자 b(true/false)
	}
}
