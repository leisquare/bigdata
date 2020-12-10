package com.lec.ex;

public class Arithmetic {
	//1개짜리 sum
	public int sum(int to) {
		//한 메소드의 다형성. 매개변수 하나로 넣으면 위를, 두개로 넣으면 아래를 실행한다.
		int result = 0;
		for (int i = 1; i <= to; i++) {
			result = result + i; // result +=i;
		}
		return result;
	}
	//2개짜리 sum
	public int sum(int from, int to) {
		int result = 0;
		for (int i = from; i <= to; i++) {
			result = result + i; // result +=i;
		}
		return result;
		//return을 만나면 메인으로 돌아가기 때문에 그 아래의 코드에는 도달할 수 없다. 
		//return 없으면 메소드 깥나면 메인으로 돌아가는데 값을 안가져간다. 이런 경우 static 뒤를 void로 침(그 자리는 들고 돌아갈 것의 형태 이야기임)
	}
	//짝홀판별
	public String evenOdd(int value) {
		String result = value % 2 == 0 ? "짝수입니다" : "홀수입니다";
		return result;
	}
	
	public static int abs(int value) {
		// int result = (value >=0)? value ; -value;
		int result;
		if(value>=0) {
			result=value;
		}else {
			result=-value;
		}
		return result;
	}
}
