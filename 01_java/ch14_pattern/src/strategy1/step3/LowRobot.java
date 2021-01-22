package strategy1.step3;

public class LowRobot extends Robot{
	
	@Override
	public void actionFly() {
		System.out.println("날 수 없다.");
	}
	
	@Override
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 없다.");
	}
	
	@Override
	public void actionKnife() {
		System.out.println("나이프가 없다.");
	}
}
