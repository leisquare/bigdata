package com.lec.ex;
// 관계연산자(비교연산자) : 같은가?(==) 다른가?(!=) 큰가?(>) 작은가?(<) 크거나 같은가?(>=)
public class Ex03 {
	public static void main(String[] args) {
		int n1=10, n2=5;
		boolean result = n1 > n2;
		// 비교연산자의 연산순서가 빠르니까 오른쪽먼저 계산되고 왼쪽계산으로 넘어감
		System.out.printf("%d %s %d = %b\n", n1, ">", n2, result);
		//%b는 불린!
		result = n1 >= n2;
		System.out.printf("%d %s %d = %b\n", n1, ">=", n2, result);
		result = n1 == n2;
		System.out.printf("%d %s %d = %b\n", n1, "==", n2, result);
		result = n1 != n2;
		System.out.printf("%d %s %d = %b\n", n1,"!=",n2,result);
	}

}
