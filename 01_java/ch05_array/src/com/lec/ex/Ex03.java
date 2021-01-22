package com.lec.ex;

//이미 존재하는 배열을 복제해 그 안의 값을 바꾸기
public class Ex03 {
	public static void main(String[] args) {
		int[] score = { 10, 20, 30, 40, 50 };
		int[] s = new int[score.length];
//		for (int i = 0; i < score.length; i++) {
//			s[i] = score[i];
//		}
		System.arraycopy(score, 0, s, 0, score.length);
		s[0] = 999;
		for (int i = 0; i< s.length; i++) {
			System.out.printf("score[%d]=%d, s[%d]=%d\n", i, score[i], i, s[i]);
		}
	}
}