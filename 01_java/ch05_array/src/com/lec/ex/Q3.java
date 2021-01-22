package com.lec.ex;

public class Q3 {
	public static void main(String[] args) {
		int[] coinunit = { 500, 100, 50, 10 };
		int a = 2680;
		for (int i = 0; i < coinunit.length; i++) {
			int y = a / coinunit[i];
			System.out.printf("%d원짜리는 %d개\n", coinunit[i], y);
			a -= (y * coinunit[i]);
		}
	}
}

//for(int i = 0 ; i<coinunit.length ; i++}) {
//	system.out.print(coinunit[i])+"개, ");
//	money % = coinunit[i]; // money%coinunit[e];
//
//}