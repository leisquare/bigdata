package com.lec.ex01_list;

import java.util.LinkedList;

public class Ex02_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("str0"); //0인덱스
		linkedList.add("str1"); //2인덱스
		linkedList.add("str2"); //3인덱스
		linkedList.add(1, "1111"); //1인덱스
		System.out.println("linkedList");
		for(int i=0 ; i<linkedList.size() ; i++)
			System.out.println(linkedList.get(i));
		linkedList.remove("1111");
		linkedList.clear();
		System.out.println(linkedList.isEmpty()? "비워졌다":"안 비워졌다");
		
	}
}
