package com.lec.ex01_string;

public class Ex01 {
	public static void main(String[] args) {
		String str1= "java";
		String str2= "java";
		String str3= new String("java");
		if(str1 == str2) {
			System.out.println("둘은 같은 주소");
		}else {
			System.out.println("둘은 다른 주소");
		}
		str1= "java2";
		if(str1 == str2) {
			System.out.println("둘은 같은 주소");
		}else {
			System.out.println("둘은 다른 주소");
		}
		if(str1==str3) {
			System.out.println("둘은 같은 주소");
		}else {
			System.out.println("둘은 다른 주소");
		}
		System.out.println(str1.hashCode());
		System.out.println("2와 3은 같은 스트링?"+
		(str2.equals(str3)? "같다":"트리다"));	
		}
	
}
