package com.lex.ex1_string;
//다양한 스트링 함수들
public class Ex02 {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String ("ABCxabc");
		String str3 = "   JA  BA  ";
		System.out.println("1. concat : "+str1.concat(str2));
		System.out.println("2. substring(3) : "+str1.substring(3)); //~부터
		System.out.println("3. "+str1.substring(3,5));  //에서~까지
		System.out.println("4. "+str1.length());  //문자길이
		System.out.println("5. "+str1.toUpperCase()); //대문자로 반환
		System.out.println("6. "+str2.toLowerCase()); //소문자로 반환
		System.out.println("7. "+str1.charAt(3)); //n번째숫자반환. 이 번째<는 0번째부터임. 즉 3번 인덱스
		System.out.println("8. "+str1.indexOf("b")); //b가 있는 인덱스
		System.out.println("9. "+str1.indexOf("b",3)); //b를 찾는다, 3번 인덱스로부터 찾아본다는 의미 
		System.out.println("10. "+str1.lastIndexOf("b")); //마지막 b의 인덱스
		System.out.println("11 " +str1.indexOf("z")); //없는건 -1을 반환한다.
		System.out.println("12 " +str1.equals(str2)); //같은가틀린가
		System.out.println("13 " +str1.equalsIgnoreCase(str2)); //같은가틀린가
		System.out.println("14 " +str3.trim()); //같은가틀린가
		System.out.println("15 " +str1.replace("a", "멍")); //같은가틀린가
		System.out.println("16 " +str1.replace("ab", "")); //같은가틀린가
		System.out.println("최종 str1: "+str1); //같은가틀린가
	}
}
