package com.lec.ex02_store;

//주택가에 매장3호점: 김치찌개-6,000  부대찌개-7,000  비빔밥-7,000 순대국-6,000
public class StoreNum3 implements HeadQuarterStore {

	private String name;

	public StoreNum3(String name) {
		this.name = name;
	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개 6000원");

	}

	@Override
	public void bude() {
		System.out.println("부대찌개 7000원");
	}

	@Override
	public void bibim() {
		System.out.println("부대찌개 7000원");

	}

	@Override
	public void sundae() {
		System.out.println("순대국 6000원");
	}

	@Override
	public void bab() {
		System.out.println("공기밥 1000원");
	}

	public String getName() {
		return name;
	}
}