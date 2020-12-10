package com.lec.loop;

//1~10 ´©Àû°ö
public class Q1 {
	public static void main(String[] args) {
		int tot = 1;
		for (int i = 1; i < 11; i++) {
			// totº¯¼ö¿¡ i°ª ´©Àû
			tot = tot * i;
			if (i != 10) {
				System.out.print(i + "*");
			} else {
				System.out.print(i + "=");
			} // if´Ý
		} // for´Ý
		System.out.println(tot);
	}// main´Ý
}

//tot *= i; 