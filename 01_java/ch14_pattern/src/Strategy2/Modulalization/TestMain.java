package Strategy2.Modulalization;

import Strategy2.component.*;

public class TestMain {
	public static void main(String[] args) {
		Car genesis = new Genesis();
		Sonata sonata = new Sonata();
		Accent accent = new Accent();
		Car[] cars = {genesis, sonata, accent};
		for(Car car:cars) {
			car.shape();
			car.drive();
			car.isEngine();
			car.isKm();
			car.isFuel();
		}//for
		System.out.println("소나타의 엔진을 하이브리드로. 연비를 20km으로");
		sonata.setEngine(new EngineHybrid());
		sonata.setKm(new Km20());
		for(Car car:cars) {
			car.shape();
			car.drive();
			car.isEngine();
			car.isKm();
			car.isFuel();
	}
}
}
