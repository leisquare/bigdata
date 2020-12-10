package com.lec.ex02_store;

//주택가에 매장2호점: 부대찌개-5,000  비빔밥-5,000   공기밥-무료
public class StoreNum2 implements HeadQuarterStore {

//블럭 잡고 알트 화살표키로 위치 이동 가능
	private String name;

	public StoreNum2(String name) {
		this.name = name;
	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개 5000원");
	}

	@Override
	public void bude() {
		System.out.println("부대찌개 5000원");
	}

	@Override
	public void bibim() {
		System.out.println("부대찌개 5000원");
	}

	@Override
	public void sundae() {
		System.out.println("순대국 5000원");
	}

	@Override
	public void bab() {
		System.out.println("공기밥 무료");
	}

	public String getName() {
		return name;
	}
}