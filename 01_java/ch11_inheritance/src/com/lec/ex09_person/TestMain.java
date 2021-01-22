package com.lec.ex09_person;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("아빠곰");
		papa.setCharacter("뚱뚱해");
		Person mom = new Person("엄마곰","날씬해")	;
		papa.intro();
		mom.intro();
		Baby child1=new Baby();
		Baby child2 = new Baby("아기곰", "귀여워");
		child1.setName("아기곰1");
		child1.setCharacter("귀여워");
		child1.intro();
		child1.cry();
	}
}
