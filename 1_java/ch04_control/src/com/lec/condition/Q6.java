//package com.lec.condition;
//import java.util.Scanner;
//public class Q6 {
//	public static void main(String[] args) {
//		Scanner month = new Scanner(System.in);
//		System.out.print("��:");
//		int b=month.nextInt();
//		
//		switch (b){
//		case 1:
//			System.out.println("�ܿ�");break;
//		case 2:
//			System.out.println("��");break;
//		case 3:
//			System.out.println("��");break;
//		case 4:
//			System.out.println("��");break;
//		case 5:
//			System.out.println("����");break;
//		case 6:
//			System.out.println("����");break;
//		case 7:
//			System.out.println("����");break;
//		case 8:
//			System.out.println("����");break;
//		case 9:
//			System.out.println("����");break;
//		case 10:
//			System.out.println("����");break;
//		case 11:
//			System.out.println("�ܿ�");break;
//		case 12:
//			System.out.println("�ܿ�");break;
//		default:
//			System.out.println("�߸��� �Է�");break;
//			
//		}
//	}
//}

package com.lec.condition;
import java.util.Scanner;
public class Q6 {
	public static void main(String[] args) {
		Scanner month = new Scanner(System.in);
		System.out.print("��:");
		int b=month.nextInt();
		
		if(b==12 || b==1 || b==2) {
			System.out.println("�ܿ�");
		}else if (b==3 || b==4 || b==5) {
			System.out.println("��");
		}else if (b==6 || b==7 || b==8) {
			System.out.println("����");
		}else if (b==9 || b==10 || b==11) {
			System.out.println("����");
		}else {
			System.out.println("�߸��� �Է�");
		}
	}
	
}
		
