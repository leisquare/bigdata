//package com.lec.condition;
//import java.util.Scanner;
//public class Q6 {
//	public static void main(String[] args) {
//		Scanner month = new Scanner(System.in);
//		System.out.print("월:");
//		int b=month.nextInt();
//		
//		switch (b){
//		case 1:
//			System.out.println("겨울");break;
//		case 2:
//			System.out.println("봄");break;
//		case 3:
//			System.out.println("봄");break;
//		case 4:
//			System.out.println("봄");break;
//		case 5:
//			System.out.println("여름");break;
//		case 6:
//			System.out.println("여름");break;
//		case 7:
//			System.out.println("여름");break;
//		case 8:
//			System.out.println("가을");break;
//		case 9:
//			System.out.println("가을");break;
//		case 10:
//			System.out.println("가을");break;
//		case 11:
//			System.out.println("겨울");break;
//		case 12:
//			System.out.println("겨울");break;
//		default:
//			System.out.println("잘못된 입력");break;
//			
//		}
//	}
//}

package com.lec.condition;
import java.util.Scanner;
public class Q6 {
	public static void main(String[] args) {
		Scanner month = new Scanner(System.in);
		System.out.print("월:");
		int b=month.nextInt();
		
		if(b==12 || b==1 || b==2) {
			System.out.println("겨울");
		}else if (b==3 || b==4 || b==5) {
			System.out.println("봄");
		}else if (b==6 || b==7 || b==8) {
			System.out.println("여름");
		}else if (b==9 || b==10 || b==11) {
			System.out.println("가을");
		}else {
			System.out.println("잘못된 입력");
		}
	}
	
}
		
