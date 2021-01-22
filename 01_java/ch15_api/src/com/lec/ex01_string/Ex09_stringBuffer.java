package com.lec.ex01_string;

public class Ex09_stringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		StringBuilder strBu = new StringBuilder("abc");
		System.out.println("1."+ strBu);
		strBu.append("def");
		System.out.println("2."+strBu);
		strBu.insert(3, "AAA");
		System.out.println("3."+strBu);
		strBu.delete(3, 6);
		System.out.println("4."+strBu); //3번 인덱스부터 6번 앞까지 삭제
		int capacitySize = strBu.capacity();
		System.out.println("가용크기"+capacitySize); 
		System.out.println("현 strBu의 해쉬코드"+strBu.hashCode()); 
		strBu.append("012345678910112312123123123112");
		capacitySize = strBu.capacity();
		System.out.println("가용크기"+capacitySize); 
		System.out.println("현 strBu의 해쉬코드"+strBu.hashCode());
		//가용크기를 인위적으로 널리기
		strBu.ensureCapacity(1000);
		capacitySize = strBu.capacity();
		System.out.println("가용크기"+capacitySize); 
		System.out.println("현 strBu의 해쉬코드"+strBu.hashCode());
	}
}
