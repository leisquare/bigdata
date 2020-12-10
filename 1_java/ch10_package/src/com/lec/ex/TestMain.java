package com.lec.ex;

import com.acom.ex.Emp;

public class TestMain {
	public static void main(String[] args) {
		Emp emp = new Emp(101); //acom꺼 
		com.bcom.ex.Emp emp1 = new com.bcom.ex.Emp(); //bcom. 이렇게 다 써주지 않으면 적용되지 않음, 두개나 import해도 적용되지 않는다. 
		
	}
}
