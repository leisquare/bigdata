package com.lec.condition;

public class Ex02_if {
	public static void main(String[] args) {
		int seoulLunchPrice = 8000;
		if (seoulLunchPrice > 7000) {
			System.out.println("서울밥값비싸네");
		} else if (seoulLunchPrice >= 6000) {
			System.out.println("재료값만큼이네");
		} else if (seoulLunchPrice >= 4000) {
			System.out.println("밥 값 괜찮네");
		} else {
			System.out.println("주인은 괜찮나?");
		}
	}
}