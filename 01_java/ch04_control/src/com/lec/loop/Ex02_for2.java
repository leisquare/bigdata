package com.lec.loop;

//1~20 누적합 출력
//1+2+3+4+.....+20= 출력하기
public class Ex02_for2 {
	public static void main(String[] args) {
		int tot = 0;
		for (int i = 1; i < 21; i++) {
			// tot변수에 i값 누적
			tot += i;
			if (i != 20) {
				System.out.print(i + "+");
			} else {
				System.out.print(i + "=");
			} // if닫
		} // for닫
		System.out.println(tot);
	}// main닫
}