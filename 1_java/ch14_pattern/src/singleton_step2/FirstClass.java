package singleton_step2;

public class FirstClass {
	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("FirstClass형 객체 생성");
		System.out.println(singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("변경후 i값(firstclass에서)"+singletonObject.getI());
		System.out.println("퍼스트클래스형 생성자 끝");
	}
}
