package com.lec.ex01_string;

import java.util.Scanner;

//전화번호 뒷자리로 친구 찾기
public class Ex07searchFriend {
	public static void main(String[] args) {
		Friend[] friend = {new Friend("홓길동","010-9999-9999","12-14"),new Friend("최민재","010-9999-9123","08-01"),new Friend("윤현우","010-3333-9999","06-14")};
		//찾을 친구의 전화번호 뒷자리를 입력받음
		//friend배열에서 해당 전화번호 뒷자리와 같은 친구가 있으면 친구를 출력.
		//없으면 없다고 출력한다.
		int idx;
		boolean searchOk = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("찾고있는 번호는?");
		String searchTel = scanner.next();
		for(idx = 0; idx< friend.length ; idx++) {
			String temp = friend[idx].getTel();
			String post = temp.substring(temp.lastIndexOf("-")+1);
			if(post.contentEquals(searchTel)) {
				System.out.println(friend[idx]);
				//friend[idx].print();
				searchOk = true;
				break;
			}//if
		}//for
		if(!searchOk) {
			System.out.println("해당번호의 친구가 없습니다..");
		}
		if(idx==friend.length) {
			System.out.println("찾을 수 없습니다..");
		}
	}
}
