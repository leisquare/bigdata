package com.lex.ex4_Object;

public class Ex01_person {
	public static void main(String[] args) {

		String str1 = "java";
		String str2 = new String("java");
		if (str1.equals(str2)) {
			System.out.println("같은 문자열");
		} else {
			System.out.println("다른 문자열");
		}

		Person p1 = new Person(9311111111111L);
		Person p2 = new Person(9311111111111L);
		if (p1.equals(p2)) {
			System.out.println("같은 Person 객체다");
		} else {
			System.out.println("다른 Person 객체다");
		}
	}
}
