package com.lec.ex;

public class Q4 {
	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		// 아래로 합출력
		int sum = 0;
		for (int a = 0; a < 8; a++) {
			sum += arr[a];
		}
		System.out.printf("합은 %d\n", sum);
		// 아래로 평균출력
		double avg = 0;
		avg = sum / (double) (arr.length);
		System.out.printf("평균은 %.2f\n", avg);
		// 아래로 최소값 추력
		int min = 999;
		int max = -999;
		for (int a = 0; a < 8; a++) {
			if (arr[a] <= min) {
				min = arr[a];
			} else if (arr[a] >= max) {
				max = arr[a];
			}
		}
		System.out.printf("최소값은 %d\n", min);
		System.out.printf("최대값은 %d\n", max);
	}
}