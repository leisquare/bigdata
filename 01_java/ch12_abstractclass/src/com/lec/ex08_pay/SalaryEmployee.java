package com.lec.ex08_pay;

public class SalaryEmployee extends Employee {

	private int annualSalary;

	public SalaryEmployee(String name, int annualSalary) {
		super(name);
		this.annualSalary = annualSalary;
	}

	@Override
	public int computePay() {
		return annualSalary / 14;
	}

	public void printPay() {
		System.out.println("~~~월급명세서~~~");
		System.out.println("성함 : " + getName());
		System.out.println("월급 : " + computePay());
		
		System.out.println("상여금 : " + Computeincentive());
		System.out.println("수 고 하 셨 습 니 다");

	}

	public int getAnnualSalary() {
		return annualSalary;
	}
	
	
	
	
	
}
