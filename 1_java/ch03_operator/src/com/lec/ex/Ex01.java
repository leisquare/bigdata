package com.lec.ex;
//산술연산자(+.-,*,/,%(나머지연산))

public class Ex01 {
	public static void main(String[] args) {
		int n1=33, n2=10;
		int result;
		double resultDouble;
			
		result = n1+n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);
		result = n1-n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		result = n1*n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		result = n1/n2;
		System.out.printf("%d %c %d = %d\n", n1, '/', n2, result);
		resultDouble = (double)n1 / n2;
		System.out.printf("%d %c %d = %.1f\n", n1, '/', n2, resultDouble);
		result = n1%n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
		// 나머지 연산자의 쓰임새
		if(n1%2==0)
			System.out.println("짝수");
		else
			System.out.println("홀수");
	} //메인함수 끝
} // 클래스 끝


/*resultDouble = (double)(n1 / n2);
		System.out.printf("%d %c %d = %.1f\n", n1, '/', n2, resultDouble);
	
이것은 3.0이 나온다.
뒤에 더블 넣어도 됨.
  */
