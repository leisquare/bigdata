package com.lex.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.lex.ex1_string.Friend;

public class Ex07_birthDay {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("홍길동", "010-9999-9999", "12-09"),
				new Friend("김길동", "010-8888-8888", "11-01"),
				new Friend("이선동", "010-6666-6666", "12-14") };

		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now);
		System.out.println("오늘은 " + today);
		boolean searchOk = false;
		System.out.println("오늘 생일인 사람의 목록은 다음과 같습니다");
		for (int idx = 0; idx < friends.length; idx++) {
			String birthday = friends[idx].getBirth();
			if (birthday.equals(today)) {
				
				System.out.println(friends[idx]);
				searchOk = true;
			} // if
		} // for
		if (!searchOk)
			System.out.println("오늘이 생일인 사람은 없습니다.");
	}// if
}
