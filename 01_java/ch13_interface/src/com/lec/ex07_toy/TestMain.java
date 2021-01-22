package com.lec.ex07_toy;

public class TestMain {
	public static void main(String[] args) {
		
	
	IToy[] toy = { new Pooh(), new MazingerToy(), new AirplaneToy()};

//	for(
//	IToy t:toy)
//	{
//		System.out.println(t.getClass().getName());
//	 //t.toString()호출
//		System.out.println(t);
//		System.out.println("~~~~~~~~");
//	}
//}}

//	IToy pooh = new Pooh();
//	IToy mazinger = new MazingerToy();
//	IToy airPlanToy = new AirplaneToy();
	for(
	IToy t:toy)
	{
		System.out.println(t.getClass().getName());
	}
}
}