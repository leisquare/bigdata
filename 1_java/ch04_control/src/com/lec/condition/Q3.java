package com.lec.condition;

import java.util.Random;
import java.util.Scanner;

//����ڷκ��� ����(0)����(1)��(2)�� �Է¹ް�, ��ǻ�͵� �ϳ��� ������ ���ڸ� ���
public class Q3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("����(-),����(1),��(2)�� �ϳ��� ����:");
		int you = scanner.nextInt();
		if(you == 0) {
			System.out.println("����!");
		}else if (you==1) {
			System.out.println("����!");
		}else if(you==2) {
			System.out.println("��!");
		}else {
			System.out.println("����");
		System.exit(0);
		}
		scanner.close();
//��ǻ��
		int computer= (int)(Math.random()*3); //math random�� 0~1����.
		if(computer == 0) {
			System.out.println("����!");
		}else if (computer ==1) {
			System.out.println("����!");
		}else if(computer ==2) {
			System.out.println("��!");
		}else {
			System.out.println("����");
		}
//��������
		if((you+2)%3==computer){
			System.out.println(("you win"));
		}else if ((you+2)%3<computer){
			System.out.println("draw");
		}else {
			System.out.println("you lose");
		}
	}//main�Լ�
}//class
