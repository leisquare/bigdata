package com.lec.loop;

//1~10���� ¦�� �Ǵ� Ȧ���� ��
public class Q2 {
	public static void main(String[] args) {
		int tot = 0;
		for (int i = 1; i < 11; i++) {
			// tot������ i�� ����
			if (i % 2 == 1) {
				System.out.print(i);
				if (i != 9) {
					System.out.print("+");
				}
				tot = tot + i;
			} else {
			} // if��

		} // for��
		System.out.print("=" + tot);
	}// main��
}

/*
 * for(int i=1 ; i<11; i++){ if(i%2 ==1) { sum +=i; } }
 */

//for (int i = 1; i < 11; i+=2) �ε� ���� ����
