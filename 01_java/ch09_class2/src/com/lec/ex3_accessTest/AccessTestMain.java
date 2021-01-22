package com.lec.ex3_accessTest;

import com.lec.ex3_accessTest.AccessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember);
		System.out.println(obj.defaultMember); //같은 패키지라 가능
		System.out.println(obj.protectedMember); //같은 패키지라 가능
		System.out.println(obj.publicMember);
//		obj.privateMethod();
		obj.defaultMethod(); //같은 패키지라 가능
		obj.protectedMethod(); //같은 패키지라 가능
		obj.publicMethod();
	}
}
