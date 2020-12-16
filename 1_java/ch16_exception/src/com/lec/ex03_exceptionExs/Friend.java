package com.lec.ex03_exceptionExs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private Date enterDate;

	public Friend() {
	}

	public Friend(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
		enterDate = new Date();
	}

	@Override
	public String toString() {
		String post = tel.substring(tel.lastIndexOf("-") + 1);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY년도 인구됨");
		return "Friend [name=" + name + ", tel=***-****-" + post + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
