package com.lec.ex01_list;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		for (int idx = 0; idx < array.length; idx++) {
			System.out.println("array[" + idx + "]=" + array[idx]);

		}

		for (String arr : array) {
			System.out.println(arr);
		}

		ArrayList<String> arrayList = new ArrayList<String>(); //
		arrayList.add("str0"); // 0인덱스
		arrayList.add("str1"); // 2인덱스
		arrayList.add("str2"); // 3인덱스
		arrayList.add(1, "111111"); // 1인덱스. 이런식으로 뒤에서 꽂으면 해당 번호부터 뒷번호로 다 밀림
		for (int idx = 0; idx < arrayList.size(); idx++) {
			System.out.println("arrayList의 " + idx + "번째 = " + arrayList.get(idx));
		}

		arrayList.remove(1); // 1번 인덱스값 삭제(2번인덱스가 1번으로, 3번 인덱스가 2번으로)
		arrayList.clear(); // 리스트의 모든 값 날려버림. 사이즈가 0이 된다.
		if (arrayList.size() == 0) { // =if(arrayList.isEmpty()==0)
			System.out.println("arrayList 비워짐");
		}

		for (String arr : arrayList) {
			System.out.println(arr);
		}
		System.out.println(arrayList);
		
		arrayList = null;
		if(arrayList.size()==0);
			System.out.println("arrayList 비워짐");
		}
	}


//콜렉션은 객체로만 만들수있다. 그래서 스트링형은 가능해도 인트형은 안됨. 만들거면 인테져 형으로 해야한다.
