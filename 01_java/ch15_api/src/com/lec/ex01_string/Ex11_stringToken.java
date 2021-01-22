package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex11_stringToken {
	public static void main(String[] args) {
		String str1 = "정해인 유준상 강동원 김윤석 하정우";
		String str2 = "2020/12/14";
		StringTokenizer token1 = new StringTokenizer(str1); // space, \t, \n 단위로 토큰 나눔
		StringTokenizer token2 = new StringTokenizer(str2, "/"); // 다른 단위를 넣을 때는 콤마 치고 넣으면 되는듯.

		System.out.println("token1의 token 갯수: " + token1.countTokens());

		while (token1.hasMoreTokens()) {
			System.out.println(token1.nextToken());
		}
		
		System.out.println("token2의 token 갯수:" +token2.countTokens());
		
		while (token2.hasMoreElements()) {
			System.out.println(token2.nextToken());
		}
	}
}
