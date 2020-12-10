package com.lec.ex08_pay;

public class HourlyEmployee extends Employee {
	private int hoursWorked;
	private int moneyPerHour;

	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}

	@Override
	public int computePay() {
		return hoursWorked * moneyPerHour;
	}

	public void printPay() {
		System.out.println("~~~월급명세서~~~");
		System.out.println("성함 : " + getName());
		System.out.println("월급 : " + computePay());
		
		System.out.println("상여금 : " + Computeincentive());
		System.out.println("수 고 하 셨 습 니 다");

	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public int getMoneyPerHour() {
		return moneyPerHour;
	}

}
