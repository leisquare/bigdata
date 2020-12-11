package strategy1.step1;

public class LowRobot {
	public void shape() {
		System.out.println("LowRobot은 팔, 다리, 머리, 몸통으로 이루어져 있다");
	}
	public void actionWalk() {
		System.out.println("걸을 수 있다.");
	}
	public void actionRun() {
		System.out.println("뛸 수 있다.");
	}
	public void actionFly() {
		System.out.println("날 수 없다.");
	}
	
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 없다.");
	}
	
	public void actionKnife() {
		System.out.println("나이프가 없다.");
	}
}
