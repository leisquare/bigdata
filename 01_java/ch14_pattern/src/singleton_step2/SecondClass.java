package singleton_step2;

public class SecondClass {
	public SecondClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("세컨드클래스 생성자");
		System.out.println(singletonObject.getI());
		System.out.println("세컨드클래스형 생성자 끝");
	}
}
