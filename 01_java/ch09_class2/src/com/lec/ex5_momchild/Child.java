package com.lec.ex5_momchild;

public class Child {
	private String name;
	static MomPouch momPouch = new MomPouch();  //static이 없으면 각자 따로 엄마 지갑을 생성해버림

	public Child(String name) {
		this.name = name;
	}

	public void takeMoney(int money) {
		if(momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name+"가"+money+"가져가서 엄마지갑엔 "+momPouch.money);
		}else {
			System.out.println(name+"가 돈을못받음. 현재 엄마 돈은"+momPouch.money);
		}
	}
}
