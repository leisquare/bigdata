package com.lec.ex03_exceptionExs;

public class Ex02_Numberformat {
	public static void main(String[] args) {
		String str = "";
		int i = 0;
		try {
			i = Integer.parseInt(str.trim());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(i);

	}
}
