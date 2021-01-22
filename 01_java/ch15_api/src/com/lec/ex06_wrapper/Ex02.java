package com.lec.ex06_wrapper;

public class Ex02 {
	public static void main(String[] args) {
		int total = valueSum("10", "20");
		System.out.println("들어온 값의 합계는"+ total);
	}

	private static int valueSum(String ... value) {
		int result = 0;
		for(int i = 0; i<value.length ; i++) {
			result += Integer.parseInt(value[i]);
		}
		
		return result;
	}
}
