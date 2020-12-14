//아래의 코드는 어디가 틀렸을까?
//package com.lec.condition;
//public class Q2 {
//	    public static void main(String[] args) {
//		int num1 = 27;
//		int num2 = 32;
//		if(num1>num2){
//			int max1 = num1;
//		} else {
//			int max1 = num2;
//		}
//		System.out.println(max1);
//	    }
//	}

//블럭 내에서 변수를 선언하면 블럭 내에서만 사용 가능한 변수가 됨. 그래서 오류가 난다.

package com.lec.condition;

public class Q2 {
	public static void main(String[] args) {
		int num1 = 27;
		int num2 = 32;
		int max;
		if (num1 > num2) {
			max = num1;
		} else {
			max = num2;
		}
		System.out.println(max);
	}
}