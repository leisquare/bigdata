package com.lec.ex07_super;

public class ChildClass extends ParentClass {
	private String cStr = "자식클래스";

	public ChildClass() {
		System.out.println("자식 생성자");
	}
	@Override
	public void getMamiName() {
		// TODO Auto-generated method stub
		//super. 슈퍼에 원래 있었던 것. 부모의.
		//super() 부모 클래스의 생성자함수(반드시 맨윗줄에.)
		System.out.print("이쁜 아주 이쁜");
		super.getMamiName(); //원래의 함수를 다시 불러옴.	
	}
	public String getcStr() {
		return cStr;
	}
	public void setcStr(String cStr) {
		this.cStr = cStr;
	}
	

}
