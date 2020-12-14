package com.lec.condition;

public class Ex01_if {
	public static void main(String[] args) {
		int i = 10, j = 20, h = 30;
		if (i + j == h) {
			System.out.println("i+j는 h입니다.");
			System.out.println("그러니 같다");
		} // 둘 다 실행시키려면 실행시킬 조건 둘 다 중괄호안에 넣기
		if (i > j) {
			System.out.println("i>j입니다");
		} else {
			System.out.println("i>j가 아닙니다");
		}
	}
}