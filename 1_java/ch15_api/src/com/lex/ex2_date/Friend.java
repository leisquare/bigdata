package com.lex.ex2_date;

public class Friend {
	private String name;
	private String tel;
	private String birth;
	
	public Friend(){}
	public Friend(String name, String tel, String birth) {
		super();
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	//f.print()

	public void print() {
		System.out.printf("[이름] %s [전화] %s [생일] %s \n",name, tel, birth);
	}
//	System.out.println(f.toString())
//	@Override
//	public String toString() {
//		return "[이름] "+name+"  [전화] "+tel+"  [생일] "+birth;
//	}

	
	
	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getBirth() {
		return birth;
	}
	
	
}
