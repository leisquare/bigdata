package com.lec.ex11_store;

//본사 지침         : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
public class HeadQuarterStore {
	private String name; // 가게이름

	public HeadQuarterStore(String name) {
		this.name = name;
	}

	public void kimchi() {
		System.out.println("김치찌개 5000원");
	}

	public void bude() {
		System.out.println("부대찌개 6000원");
	}

	public void bibim() {
		System.out.println("비빔밥 6000원");
	}

	public void sundae() {
		System.out.println("순대국 5000원");
	}

	public void bab() {
		System.out.println("공기밥 1000원");
	}

	public String getName() {
		return name;
	}

}
