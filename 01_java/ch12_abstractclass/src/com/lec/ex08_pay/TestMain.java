package com.lec.ex08_pay;

public class TestMain {
	public static void main(String[] args) {
		SalaryEmployee salaryemployee1 = new SalaryEmployee("홍길동", 50000);
		SalaryEmployee salaryemployee2 = new SalaryEmployee("김길동", 80000);
		SalaryEmployee salaryemployee3 = new SalaryEmployee("신길동", 100000);
		HourlyEmployee hourlyemployee1 = new HourlyEmployee("나길동", 100,10);
		HourlyEmployee hourlyemployee2 = new HourlyEmployee("유길동", 300,10);
				
		salaryemployee1.printPay();
		salaryemployee2.printPay();
		salaryemployee3.printPay();
		hourlyemployee1.printPay();
		hourlyemployee2.printPay();
	}
}
