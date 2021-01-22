package com.lec.ex02_throws;

public class ThrowsEx_2 {
	public ThrowsEx_2() {
		actionC();
	}

	private void actionC() {
		System.out.println("actionC 전반부");
		try {
		actionB();
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("메시지 없음"); //e.getMessage()던지면 안나옴
		}
		System.out.println("actionC 후반부");
	}

	private void actionB() throws ArrayIndexOutOfBoundsException {  //exception으로 받아도 됨, 어차피 받은 걸 던지는것이므로
		System.out.println("actionB 전반부");
			actionA();
		System.out.println("actionB 후반부");
	}

	private void actionA() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionA 전반부");
		int[] arr = { 0, 1, 2, 3 };
		System.out.println(arr[4]); // exception발생위치
		System.out.println("actionA 후반부");
	}

}
