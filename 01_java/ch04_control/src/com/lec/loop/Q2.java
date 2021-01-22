package com.lec.loop;

//1~10까지 짝수 또는 홀수의 합
public class Q2 {
	public static void main(String[] args) {
		int tot = 0;
		for (int i = 1; i < 11; i++) {
			// tot변수에 i값 누적
			if (i % 2 == 1) {
				System.out.print(i);
				if (i != 9) {
					System.out.print("+");
				}
				tot = tot + i;
			} else {
			} // if닫

		} // for닫
		System.out.print("=" + tot);
	}// main닫
}

/*
 * for(int i=1 ; i<11; i++){ if(i%2 ==1) { sum +=i; } }
 */

//for (int i = 1; i < 11; i+=2) 로도 설정 가능