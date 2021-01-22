package com.lec.ex04_Object;

public class Card {
	private char kind;
	private int num;

	// 변수
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;

	}

	@Override
	public String toString() {
		return "카드 모양은 " + kind + "" + num;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Card) {
			boolean kindChk = this.kind == ((Card) obj).kind;
			boolean numChk = this.kind == ((Card) obj).kind;
			return kindChk && numChk;
		}
		return false;
	}

}
