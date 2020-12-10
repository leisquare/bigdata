package ch07_oop;

import java.util.Scanner;

public class Carmain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Car myPorsche = new Car(); //new Car 라는 것은 Car라는 클래스를 메모리에 하나 싹 지정하는 것. 
		
		Car yourPorsche = new Car();
		myPorsche.drive();
		yourPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		yourPorsche.park();
		yourPorsche.race();
		
		myPorsche.setColor("red") ;//		myPorsche.color = "red";
		System.out.println(myPorsche.getColor());
		System.out.println(yourPorsche.getColor());
		System.out.println(myPorsche.getcc());
		System.out.println(yourPorsche.getcc());
	}

}


//클래스라는것은 타입을 만드는 것이다.
//일반변수는 기본데이너
//객체변수는 앞이 대문자로 시작하는 변수. 변수 값이 있는ㄱ ㅔㅇ 아니라 변수에는 주소가 있고 그 주소로 가면 변수가...있나?

//기본값은 int로 넣었으면 0, string이었으면 null로 처리됨. 
//getter, setter는 get대문자 set대문자- 식으로 씀