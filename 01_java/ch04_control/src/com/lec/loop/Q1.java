package com.lec.loop;

//1~10 누적곱
public class Q1 {
	public static void main(String[] args) {
		int tot = 1;
		for (int i = 1; i < 11; i++) {
			// tot변수에 i값 누적
			tot = tot * i;
			if (i != 10) {
				System.out.print(i + "*");
			} else {
				System.out.print(i + "=");
			} // if닫
		} // for닫
		System.out.println(tot);
	}// main닫
}

//tot *= i;