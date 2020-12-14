package com.lex.ex1_string;

public class Ex10_speedChk {
	public static void main(String[] args) {
		String str = "A";
		// 시작시간 측정
		long start = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			str = str.concat("a");
		}
		// 끝나는 시간 측정
		long end = System.currentTimeMillis();
		System.out.println("스트링변경시간 " + (end - start));

		StringBuffer strBuf = new StringBuffer("A");
		start = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			strBuf.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("스트링변경시간 " + (end - start));

		StringBuilder strBuil = new StringBuilder("A");
		start = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			strBuil.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("스트링변경시간 " + (end - start));
	}
}
