package com.lec.ex01_store;

//본사 지침         : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
public abstract class HeadQuarterStore {
	//추상 클래스. 추상 메소드가 1개 이상 있는 클래스. 
	
	private String name; 

	public HeadQuarterStore(String name) {
		this.name = name;
	}
	
	//abstract는 반드시 오버라이딩해야하는 것. 괄호 안은 메소드 선언, 중괄호 안은 메서드 구현부분
	
	public abstract void kimchi(); //추상 메소드

	public abstract void bude();

	public abstract void bibim();

	public abstract void sundae();

	public abstract void bab();
	
//	public abstract void bab(); {} 
//	위처럼 쓰면 안되는 이유를 이제 알 수 있다. 추상메서드가 하나 생기고 뒤에 새 명령어가 추가되는 형식이었던 것. 
	

	public String getName() {
		return name;
		
//		public void kimchi() {
//		System.out.println("김치찌개 가격 0원. 재량껏 책정하세요");
//	}
//
//	public void bude() {
//		System.out.println("부대찌개 가격 0원. 재량껏 책정하세요");
//	}
//
//	public void bibim() {
//		System.out.println("비빔밥 가격 0원. 재량껏 책정하세요");
//	}
//
//	public void sundae() {
//		System.out.println("순대국 가격 0원. 재량껏 책정하세요");
//	}
//
//	public void bab() {
//		System.out.println("공기밥 가격 0원. 재량껏 책정하세요");
//	}
		
		
		
	}

}
