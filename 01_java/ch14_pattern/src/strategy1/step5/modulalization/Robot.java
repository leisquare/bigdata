package strategy1.step5.modulalization;

import strategy1.step4.component.IFly;
import strategy1.step4.component.IKnife;
import strategy1.step4.component.IMissile;

public abstract class Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;

	public abstract void shape();

	public void actionWalk() {
		System.out.println("걸을 수 있다.");
	}

	public void actionRun() {
		System.out.println("뛸 수 있다.");
	}

	public void actionFly() {
		fly.fly();

	}

	public void actionMissile() {
		missile.missile();
	}

	public void actionKnife() {
		knife.knife();

	}
	
	public void setFly(IFly fly) {
		this.fly = fly;
	}

	public void setMissile(IMissile missile) {
		this.missile = missile;
	}

	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
}