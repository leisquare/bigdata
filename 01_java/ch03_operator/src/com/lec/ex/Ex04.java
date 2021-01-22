package com.lec.ex;
//논리연산자(&&: and ||: or)
//true && true = true
//true && false = false
//false && true = false
//false && false = false
public class Ex04 {
	public static void main(String[] args) {
		 int i = 1, j=10, h=10;
		 System.out.printf("i<j && ++j>h 는 " +((i<j) && (++j>h)));
		 System.out.println("\nj="+j);
		 //
		 System.out.printf("i>j && ++j>h 는 " +((i>j) && (++j>h)));
		 System.out.println("\nj="+j);
		 //(i>j) && (++j>h)에서 앞쪽이 이미 false라 뒤쪽 연산을 안해버리고 false를 출력한다.
		 //결국, ++j가 실행되지 않아서 j값은 변하지 않았다.
		 //System.out.println("\nj="+j);
		 //이것은 스트링+정수를 할 수 없어서 뒤를 그냥 스트링으로 변환해서 붙여버리는 원리임
		 
		 System.out.printf("i<j || ++j>h 는 " +((i<j) || (++j>h)));
		 System.out.println("\nj="+j);
		 //
		 System.out.printf("i>j || ++j>h 는 " +((i>j) || (++j>h)));
		 System.out.println("\nj="+j);
		//이쪽도 앞이 true면 true로 실행해버리고 넘어간다. 
	}
}
