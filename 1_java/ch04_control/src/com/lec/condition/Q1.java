package com.lec.condition;
import java.util.Scanner;
public class Q1 {
	public static void main(String[] args) {
		Scanner integ = new Scanner(System.in);
		System.out.print("���� �Է�:");
		int a = integ .nextInt();
		
	if (a>=0) {
		System.out.println(a);
	}else {
		System.out.println(-1*a);
		}
	integ.close();
	}
}



