package com.lec.ex01_string;

public class Ex08 {

	public static void main(String[] args) {
		String str1 = "월드컵"; // String str1 = new String("월드컵");
		String str2 = "월드컵";
		if (str1 == str2) {
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소");
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		str1 = str1.concat("2002"); // )+"2002";
		if (str1 == str2)

		{
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소");
		}
	}
}
