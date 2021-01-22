package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex12_tokenArray {
	public static void main(String[] args) {
		//str을 토큰처리해서 names 배열에 넣기. 
		String str = "정혜인 유준상 강동원 김윤석 하정우";
		String[] names;
		StringTokenizer count1 = new StringTokenizer(str);	
		names = new String [count1.countTokens()];
		
		
		int idx = 0;
		while (count1.hasMoreElements()) {
			names[idx++] = (count1.nextToken());
		}
		System.out.println("확인");
		for(String name: names) {
			System.out.println(name);
		}
		
	
	}
}
