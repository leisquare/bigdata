package com.lec.ex;

public class Q1 {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum = sum + arr[i];
		}
		System.out.println(sum);
	}
}


//for (int i = 0; i<arr.length; i++) 이렇게 쓰는게 더 좋다
//
//for(int temp:arr) {
//	tot+=temp;
//}