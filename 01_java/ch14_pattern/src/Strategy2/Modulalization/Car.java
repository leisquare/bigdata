package Strategy2.Modulalization;

import Strategy2.component.*;

public abstract class Car {
	private EngineImpl engine;
	private KmImpl km;
	private FuelImpl fuel;

	public void shape() {
		System.out.println("제네시스 door, sheet, handle가 있습니다.");
	}

	public void drive() {
		System.out.println("드라이브 할 수 있습니다.");
	}

	public void isEngine() {
		engine.engine();
	}

	public void isKm() {
		km.km();
	}

	public void isFuel() {
		fuel.fuel();
	}

// 겟셋
	public EngineImpl getEngine() {
		return engine;
	}

	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}

	public KmImpl getKm() {
		return km;
	}

	public void setKm(KmImpl km) {
		this.km = km;
	}

	public FuelImpl getFuel() {
		return fuel;
	}

	public void setFuel(FuelImpl fuel) {
		this.fuel = fuel;

	}

}
