package com.lec.ex01_store;

public class TestMain2 {
	public static void main(String[] args) {
		HeadQuarterStore[] store = { //new HeadQuarterStore("본사"), 
				new StoreNum1("주택가 1호점"), 
				new StoreNum2("대학가 2호점"),
				new StoreNum3("증권가 3호점") };
//추상 클래스는 new로 객체를 만들 수 없다.
		System.out.println("=============================");
		for (int idx = 0; idx < store.length; idx++) {
			System.out.println(store[idx].getName());
			store[idx].kimchi();
			store[idx].bude();
			store[idx].bibim();
			store[idx].sundae();
			store[idx].bab();
			System.out.println("=============================");

		}
	}
}
