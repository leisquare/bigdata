package com.lec.ex1;

import com.lec.ex.Arithmetic;

public class ex {
	public static void main(String[] args) {
		Arithmetic ar = new Arithmetic();
		System.out.println("합은"+ar.sum(20));
	}
}

//다른 패키지에 넣었으면 import 를 써야함.