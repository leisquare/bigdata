package com.lec.ex01_tryCatch;

public class Ex04_finally {
	public static void main(String[] args) {
		int[] iArr = {0,1,2};
		for(int i=0; i<=iArr.length ; i++) {
			try {
				System.out.println("iArr["+i+"] = "+iArr[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("에외 메세지: "+e.getMessage());
			}finally {
				System.out.println("try절 실행 후에도 finally 실행, catch를 실행 후에도 여기는 꼭 실행");
			}
		}//for
		System.out.println("프로그램 끝");
	}
}
