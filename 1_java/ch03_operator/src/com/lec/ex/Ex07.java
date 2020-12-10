package com.lec.ex;
// 비트연산자 : &,|
public class Ex07 {
	public static void main(String[] args) {
		int n1=10; // 0~01010
		int n2=5; //  0~00101
				//  	00000  결과는 결국 0이된다
		int result = n1&n2;
		System.out.printf("%d %c %d = %d\n", n1, '&',n2, result);
		int result2 = n1|n2;
		System.out.printf("%d %c %d = %d\n", n1, '|',n2, result2);
		
	}
}
