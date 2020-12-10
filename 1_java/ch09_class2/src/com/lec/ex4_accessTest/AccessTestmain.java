package com.lec.ex4_accessTest;

import com.lec.ex3_accessTest.AccessTest;

public class AccessTestmain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
//		System.out.println(obj.defaultMember);  //다른 패키지라서 안됨
//		System.out.println(obj.protectedMember); //다른 패키지라서 안됨
		System.out.println(obj.publicMember);
//		obj.defaultMethod(); //다른 패키지라서 안됨
//		obj.protectedMethod(); //다른 패키지라서 안됨
		obj.publicMethod();
	}
}
