package com.lec.loop;

//1~20 ������ ���
//1+2+3+4+.....+20= ����ϱ�
public class Ex02_for2 {
	public static void main(String[] args) {
		int tot = 0;
		for (int i = 1; i < 21; i++) {
			// tot������ i�� ����
			tot += i;
			if (i != 20) {
				System.out.print(i + "+");
			} else {
				System.out.print(i + "=");
			} // if��		
		} // for��
		System.out.println(tot);
	}// main��
}
