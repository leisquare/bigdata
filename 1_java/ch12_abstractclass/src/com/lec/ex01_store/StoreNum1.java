package com.lec.ex01_store;

// 주택가에 매장1호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-6,000 순대국-안팔아 공기밥-1,000원
public class StoreNum1 extends HeadQuarterStore {
//클래스에 마우스대고 컨트롤 1.
	public StoreNum1(String name) {
		super(name);

	}

	// 오버라이드(재정의): 부모클래스의 메소드를 재저으이
	// 오버로딩(중복정의): 매개변수이ㅡ 수나 타입으로 같은 이름의 함수를 중복정의.
	@Override
	public void kimchi() {
		System.out.println("김치찌개 4500원");
		
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
		System.out.println("순대국 안팔아");
	}

	@Override
	public void bab() {
		System.out.println("공기밥 1000원");
		
	}
}
