//package com.lec.loop;
//
//public class Q4 {
//	public static void main(String[] args) {
//		for (int i = 1; i < 10; i++) {
//			for (int j = 1; j < 10; j++) {
//				int tot = j * i;
//				System.out.print(j + "*" + i + "=" + tot);
//			}
//			System.out.println();
//		}
//	}
//}

package com.lec.loop;

public class Q4 {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				int tot = j * i;
				System.out.printf("%d*%d=%2d\t", j, i, tot);
				// System.out.printf("%d*%d=%2d\n", num1, i, num1*i);
			}
			System.out.println();
		}
	}
}