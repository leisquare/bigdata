package singleton_step1;

public class SingletonClass {
	private int i;
	private static SingletonClass INSTANCE; // 싱글톤클래스형 객체주소(처음에는 NULL)

	public static SingletonClass getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}

	private SingletonClass() {
		i = 10;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}

//생성자는 프라이빗
//클래스와 똑같은 형이ㅡ 변수를 스태틱으로넣을 것(스태틱 변수)
// 생성자가 프라이빗이므로 생성을 한번만 할 수 잇는 퍼블릭 스태틱 메소드를 만들어둬야 함.
