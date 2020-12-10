package com.lec.ex06_lunch;

import com.lec.cons.PriceTable;

public class TestMain {
	public static void main(String[] args) {
//		Child1 child1=new Child1(350,1000,100,300,800,350);
//		Child2 child2=new Child2(350,1000,100,300,800,350);
//		이 방식은 안좋다.
		Child1 child1=new Child1(PriceTable.RICE,PriceTable.BULGOGI,
				PriceTable.SOUP,PriceTable.BANANA,
				PriceTable.MILK,PriceTable.ALMOND);
		Child2 child2=new Child2(PriceTable.RICE,PriceTable.BULGOGI,
				PriceTable.SOUP,PriceTable.BANANA,
				PriceTable.MILK,PriceTable.ALMOND);
		System.out.println("child1형 식대: "+child1.calculate());
		System.out.println("child2형 식대: "+child2.calculate());
	}
}
