package com.lec.ex08_pay;

public abstract class Employee {
	private String name;
//	private int computeincentive;
//	private int computePay;
//	private int annualSalary;
//	private int hoursWorked;
//	private int moneyPerHour;

//	public Employee(String name, int annualSalary, int hoursWorked,int moneyPerHour) {
//		this.name = name;
//		this.annualSalary = annualSalary;
//		this.hoursWorked =hoursWorked;
//		this.moneyPerHour = moneyPerHour;
//	}
	
	public Employee(String name) {
		this.name = name;
	}


	public abstract int computePay();
	
	public int Computeincentive() {
		int pay = computePay();
		if (pay>=200) {
			return (int)( pay*0.1);
		}else {
			return 0;
		}
		
	}
	

	public String getName() {
		return name;
	}
}
