package com.lec.ex02_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		String[] strArr = new String[5];
		ArrayList<String> strList = new ArrayList<String>();
		HashMap<Integer,String> hashmap = new HashMap<Integer,String>();
		hashmap.put(11, "str11");
		hashmap.put(22, "str22");
		hashmap.put(39, "str40");
//		hashmap.put(39, "str40");  키는 중복을 허용하지 않는다. 이렇게 넣으면 위의 것이 사라져버림
		System.out.println(hashmap.get(39));
		System.out.println("remove 전:" +hashmap);
		hashmap.remove(22);
		System.out.println("remove 후:" +hashmap);
		hashmap.clear(); 
		hashmap.put(0, "홍길동");
		hashmap.put(1,  "김길동");
		hashmap.put(2, "이순신");
		hashmap.put(3, "유아인");
		Iterator<Integer> iterator = hashmap.keySet().iterator();
		while(iterator.hasNext());
		Integer key = iterator.next();
		System.out.println(key+"의 데이터는 "+hashmap.get(key));
		
		

		
		
	}
}
