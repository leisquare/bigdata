package com.lex.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex10_dayCal {
	public static void main(String[] args) {
		Date checkOutDate = new Date(new GregorianCalendar(2020,10,15).getTimeInMillis());
		Date now = new Date();
		long diff = now.getTime()-checkOutDate.getTime(); // gettime 하면 밀리세컨으로 들어옴.
		long day = diff/(1000*60*60*24); //checkOutDate로부터 며칠 지났는지 나옴.
		
		
		//14일이 지났는지 안 지났는지 보는 로직
		if(day>14) {
			day = day -14;
			System.out.println("연체료"+(day*100)+"원을 받으셨나요?(Y/N)");
			Scanner scanner = new Scanner(System.in);
			String ok = scanner.next();
			if( !ok.equalsIgnoreCase("y")) {   //Y를 누르지 않으면! 이니까 !를 붙여줘야 한다. 
				System.out.println("연체료 미납시 반납처리 불가.");
				return; //메인함수로 돌아감. 
			}
		}
		System.out.println("반납합니다.");
		
		
	}
}
