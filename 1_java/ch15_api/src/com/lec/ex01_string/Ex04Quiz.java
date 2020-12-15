package com.lec.ex01_string;

import java.util.Scanner;

// I를 누르면 체크인
// O를 누르면 대출되었습니다 출력
// X를 누르면 종료
public class Ex04Quiz {
	public static void main(String[] args) {


	Scanner scanner = new Scanner(System.in);
	String fn;
	while(true)
	{
		System.out.print("I:checkIn, O:checkOut, x:Exit ?");
		fn = scanner.next();
		if (fn.equalsIgnoreCase("x")) {
			break;
		} else if (fn.equalsIgnoreCase("i")) {
			System.out.println("반납되었습니다");
		} else if (fn.equalsIgnoreCase("o")) {
			System.out.println("대출되었습니다");
		}

		System.out.println("DONE");
	}
}

//	
//	do{
//		System.out.println("I:CheckIn, O:CheckOut, X: Exit. ?");
//		fn = scanner.next();
//		if (fn.equalsIgnoreCase("i")) {
//			System.out.println("반납되었습니다.");
//		} else if (fn.equalsIgnoreCase("o")) {
//			System.out.println("대출되었습니다.");
//		}
//	}while(!fn.equalsIsIgnoreCase("x"));
//	System.out.println("종료.");
//}
}
