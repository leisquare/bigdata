package singleton_step1;

public class TestMain {
	public static void main(String[] args) {
		SingletonClass obj1 = SingletonClass.getInstance();
		SingletonClass obj2 = SingletonClass.getInstance();
		System.out.println("초기화된 I값 :" + obj1.getI());
		obj1.setI(999);
		;
		System.out.println("I값 :" + obj1.getI());
		System.out.println("obj2의 값" + obj2.getI());
	}
}
