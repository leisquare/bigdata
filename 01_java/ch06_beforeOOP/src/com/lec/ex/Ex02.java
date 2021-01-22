package com.lec.ex;

public class Ex02 {

	private static int sum(int to) {
		//한 메소드의 다형성. 매개변수 하나로 넣으면 위를, 두개로 넣으면 아래를 실행한다.
		int result = 0;
		for (int i = 1; i <= to; i++) {
			result = result + i; // result +=i;
		}
		return result;
	}
	
	private static int sum(int from, int to) {
		int result = 0;
		for (int i = from; i <= to; i++) {
			result = result + i; // result +=i;
		}
		return result;
		//return을 만나면 메인으로 돌아가기 때문에 그 아래의 코드에는 도달할 수 없다. 
		//return 없으면 메소드 깥나면 메인으로 돌아가는데 값을 안가져간다. 이런 경우 static 뒤를 void로 침(그 자리는 들고 돌아갈 것의 형태 이야기임)
		//return으로 보낼 수 있는 값은 1개이다. 2개 이상 보낼거면 배열로 만들어서 보내야함
	}

	private static String evenOdd(int value) {
		String result = value % 2 == 0 ? "짝수입니다" : "홀수입니다";
		return result;

	}

	public static void main(String[] args) {
		// 1
		int sum = sum(1, 10);
		System.out.println("합은" + sum);
		System.out.println(evenOdd(sum));
		// 2
		sum = sum(1, 50);
		System.out.println("합은" + sum);
		System.out.println(evenOdd(sum));
		// 3
		sum = sum(10, 50);
		System.out.println("합은" + sum);
		System.out.println(evenOdd(sum));
		
		sum = sum(30);
		System.out.println("합은" + sum);
		System.out.println(evenOdd(sum));

	}

}
// sum() method
