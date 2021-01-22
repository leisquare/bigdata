package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Ex02_lotto {
	public static void main(String[] args) {
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		while (lotto.size() < 6)
			lotto.add((int) (Math.random() * 45) + 1);
		System.out.println(lotto);
	}
	
}
