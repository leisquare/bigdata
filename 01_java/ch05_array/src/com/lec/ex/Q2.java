package com.lec.ex;

public class Q2 {
	public static void main(String[] args) {
		int[][] arr = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 }, { 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30 } };
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				sum = sum + arr[i][j];
			}
		}
		System.out.println(sum);
	}
}


//arr,length를 더 많이 쓰는 게 좋겠다
//
//package com.lec.ex;
//
//public class Q2 {
//	public static void main(String[] args) {
//		int[][] arr = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 }, { 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30 } };
//		int sum = 0;
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				sum = sum + arr[i][j];
//			}
//		}
//		System.out.println(sum);
//	}
//}