//package com.lec.condition;
//import java.util.Scanner;
//public class Q4 {
//	public static void main(String[] args) {
//		Scanner score = new Scanner(System.in);
//		System.out.print("수를 입력:");
//		int a = score .nextInt();
//		
//	if (a>=90) {
//		System.out.println("학점은 A");
//	}else if (a>=80) {
//		System.out.println("학점은 B");
//		}else if (a>=70) {
//		System.out.println("학점은 C");
//		}else if (a>=60) {
//		System.out.println("학점은 D");
//		}else {
//		System.out.println("학점은 F");
//		}
//	score.close();
//	}
//}
//

package com.lec.condition;
import java.util.Scanner;
public class Q4 {
	public static void main(String[] args) {
		Scanner score = new Scanner(System.in);
		System.out.print("점수:");
		int b=score.nextInt();
		int temp= b == 100 ? b-1 : b;

switch(temp/10) {
case 9:
	System.out.println("A"); break;
case 8:
	System.out.println("B"); break;
case 7:
	System.out.println("C"); break;
case 6:
	System.out.println("D"); break;
default:
	System.out.println("F"); break;
		}

	}
}


/*
 * int score = scanner.nextInt();
 * switch(score/10)
 */


