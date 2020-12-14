package com.lex.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex08_dateCal {
	public static void main(String[] args) {
		GregorianCalendar now = new GregorianCalendar();
		long nowMillis = now.getTimeInMillis(); // 1970~12/14
		GregorianCalendar thatTime = new GregorianCalendar(2020, 10, 30, 9, 30, 0);
		long thatMillis = thatTime.getTimeInMillis(); // 1970~11/30
		long day = (int) (nowMillis - thatMillis) / (1000 * 60 * 60 * 24);
		System.out.println("개강한 이후" + day + "일 지남");
		long thatDay = (new GregorianCalendar(2020, 10, 30, 9, 30, 0).getTimeInMillis());
	}

}
