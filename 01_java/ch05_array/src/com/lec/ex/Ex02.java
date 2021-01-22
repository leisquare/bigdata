package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
//		double[] hak = {4.5,3.3,3.0};
//		String[] names = {"홍길동","김길동"}; 다양한 배열을 선언 가능하다.
		int[] s = score; //s에 score배열의 주소가 들어가서 같은곳을 참조하게 되어버린다. 
		s[0]=100;
		for (int idx = 0; idx < score.length; idx++) {
			System.out.printf("score[%d]=%d, s[%d]=%d\n", idx, score[idx], idx, s[idx]);
		}
		
	}
}
