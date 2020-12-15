package com.lec.ex04_Object;

public class Person {
	private long juminNo; // 9301111252012

	public Person(long juminNo) {
		super();
		this.juminNo = juminNo;

	}

	@Override
	public boolean equals(Object obj) {
		//Person p3;
		//p1.equals(str1) ->false / p1.equals9str1)=>false 리턴
		//p1.equals(p2) ->this는 p1,obj는 p2
		//this.juminNo와 obj.juminNo가 같으면 true를 return
		
		if(obj!=null && obj instanceof Person) {
			//juminNo == obj.JuminNo 여부 리턴 
			return juminNo == ((Person)obj).juminNo;
		}
		
		return  false;
	} //equals
	  
}//class
