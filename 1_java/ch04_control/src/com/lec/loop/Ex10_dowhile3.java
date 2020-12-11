package com.lec.loop;

import java.util.Scanner;

public class Ex10_dowhile3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lotto = (int) (Math.random() * 45) + 1; // ��ǻ�� ����
		int su; // ����ڿ��� �Է¹��� ���� �����ϴ� ����
		System.out.println(lotto);
		do {
			System.out.print("�ζ� ��ȣ �Ѱ��� ���纸����");
			su = scanner.nextInt();
			if (su > lotto) {
				System.out.println(su + "���� ���� ���� �����ϼ���");
			} else if (su < lotto) {
				System.out.println(su + "���� ū ���� �����ϼ���");
			}
		} while (su != lotto);
		System.out.println("�����մϴ�!");
		scanner.close();
	}

}

//System.out.println(Math.random()); //0�̻� 1�̸� ���� �Ǽ�
//System.out.println(Math.random()*45); //0�̻� 45�̸� ���� �Ǽ�
//System.out.println((int)(Math.random())*45); //0~44 ���� ����
//System.out.println((int)(Math.random())*45+1); //1~45 ���� ����