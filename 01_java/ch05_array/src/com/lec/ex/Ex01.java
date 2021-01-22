package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10; // 변수선언과 초기화를 동시에 했음
		int[] iArr = { 10, 20, 30, 40, 50 }; // 배열선언과 초기화를 동시에 했음
		iArr[1] = 200; // 배열은 인덱스로 접근(index: 0~4)
		for (int idx = 0; idx < 5; idx++) {
			System.out.println(iArr[idx]);
		}

		int[] iArr2 = new int[5]; // 2. 배열 변수 선언과 배열 메모리공간 확보. new로 확보된 것은 안쪽 값이 전부 0인 상태(자바에서만)
		iArr2[0] = 999;
		for (int idx = 0; idx < iArr2.length; idx++) { // 일반 for문)
			System.out.println(idx + "번째값:" + iArr2[idx]);
		}

		int[] iArr3; // 3. 배열변수 선언
		iArr3 = new int[5];
		for (int idx = 0; idx < iArr3.length; idx++) { // 일반 for문으로 값변경
			iArr3[idx] = idx;
		}

		for (int temp : iArr3) {// 확장for문
			System.out.println(temp);

			// 확장for문으로 값변경하려고하면 이런식으로 되어서 안 된다는 예
			int[] iArr4;
			iArr4 = new int[5];
			for (int temp1 : iArr4) {
				temp1 = 10;
			}
		}
	}
}

//(int idx=0 ; idx<iArr3.length ; idx++)}//확장 for문
//System.out.println(iArr3[0]);
//}