package ch07_oop;
	// Car myPorsche = new Car();
	// myPorsche.color = "red";
	//Scanner sc = new Scanner(~)
public class Car {
	private String color;  //데이터는 보통 프라이빗, 메소드는 보통 퍼블릭.
	private int cc;
	private int speed;
	
	
	public Car() { //생성자 함수. 리턴 타입이 없다. 클래스명과 같은 이름의 메소드.
		//디폴트 생성자함수는 생성자함수가 없을때 JVM이 자동 생성해줌.
		//객체변수 생성시 자동 호출
		//생성자함수는 myPorsche.car()로 호출할 수 없음.
		cc=1000;
		System.out.println("cc=1000");

	}
	public void drive() {
		speed = 60;
		System.out.println("운전한다 지금 속도 : "+speed);
	}
	public void park() {
		speed = 0;
		System.out.println("주차한다 지금속도: "+speed);
	}
	public void race() {
		speed = 120;
		System.out.println("레이싱한다. 지금 속도: "+speed);
	}
	
	//색을 세팅하는 메소드를 만든다.
	//~.setColor("red")
	public void setColor(String color) {
		this.color = color; //객체 안의 color에 넣어라< this
	}
	// ~.getColor()
	public String getColor() {
		return color;
	}
	
	public int getcc() {
		return cc;
	}
}