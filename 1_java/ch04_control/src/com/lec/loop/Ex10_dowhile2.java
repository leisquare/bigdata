package com.lec.loop;

import java.util.Scanner;

public class Ex10_dowhile2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lotto = (int)(Math.random()*45)+1; //��ǻ�� ����
		int su; //����ڿ��� �Է¹��� ���� �����ϴ� ���� 
		int min=1;
		int max=45;
		System.out.println(lotto);
		do {
			System.out.printf("%d~%d ������ �ζ� ��ȣ �Ѱ��� ���纸����",min,max);
			su= scanner.nextInt();
			if(su>lotto) {
				System.out.println(su+"���� ���� ���� �����ϼ���");
				max= su-1;
			}else if(su<lotto){
				System.out.println(su+"���� ū ���� �����ϼ���");
				min= su+1;
			}
		}while (su != lotto);
		System.out.println("�����մϴ�!");
		
		scanner.close();
	}

}



//System.out.println(Math.random()); //0�̻� 1�̸� ���� �Ǽ�
//System.out.println(Math.random()*45); //0�̻� 45�̸� ���� �Ǽ�
//System.out.println((int)(Math.random())*45); //0~44 ���� ����
//System.out.println((int)(Math.random())*45+1); //1~45 ���� ����