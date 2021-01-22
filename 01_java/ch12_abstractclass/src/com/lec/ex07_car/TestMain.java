package com.lec.ex07_car;

import com.lec.cons.CarSpecs;

public class TestMain {
	public static void main(String[] args) {
		Car lowCar = new LowGradeCar(CarSpecs.GREYCAR, CarSpecs.TIRE_NORMAL, CarSpecs.DISPLACEMENT_1000, CarSpecs.HANDLE_POWER);
		Car highCar = new LowGradeCar(CarSpecs.REDCAR, CarSpecs.TIRE_WIDE, CarSpecs.DISPLACEMENT_2000, CarSpecs.HANDLE_POWER);
		Car[] car = {lowCar, highCar};
		
		lowCar.getSpec();
		highCar.getSpec();
	}
}
