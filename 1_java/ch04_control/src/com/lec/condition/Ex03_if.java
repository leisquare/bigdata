package com.lec.condition;
import java.util.Scanner;
public class Ex03_if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ù��° ����?");
		int num1 = scanner.nextInt();
		System.out.print("�ι�° ����?");
		int num2 = scanner.nextInt();
		if(num1>num2) {
			System.out.println("�Է��Ͻ� ������ �ִ밪��"+num1);
		}else {
			System.out.println("�Է��Ͻ� ������ �ִ밪��"+num2);
		}
	}
}
