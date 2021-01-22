package com.lec.condition;

public class Ex04_switch {
	public static void main(String[] args) {
		int num = 2;
		switch (num) {
		case 1:
			System.out.println("주사위눈 1");
			break;
		case 2:
			System.out.println("주사위눈 2");
			break;
		case 3:
			System.out.println("주사위눈 3");
			break;
		case 4:
			System.out.println("주사위눈 4");
			break;
		case 5:
			System.out.println("주사위눈 5");
			break;
		default:
			System.out.println("주사위눈 6");
			break;

		}
	}
}