package com.lec.loop;

//1~10 ������
public class Q1 {
	public static void main(String[] args) {
		int tot = 1;
		for (int i = 1; i < 11; i++) {
			// tot������ i�� ����
			tot = tot * i;
			if (i != 10) {
				System.out.print(i + "*");
			} else {
				System.out.print(i + "=");
			} // if��
		} // for��
		System.out.println(tot);
	}// main��
}

//tot *= i; 