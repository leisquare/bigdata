package com.lec.ex13_final;

public class Testmain {

	public static void main(String[] args) {
		Animal animal =new Animal();
		animal.running();
		animal.running();
		animal.running();
		animal.stop();
		Dog dog = new Dog();
		dog.running();
		dog.stop();
		dog.method();
		Animal dog2 = new Dog();
//		dog2.method();
//		animal에 메서드가 없어서 호출하질 못함. 이걸 하려면 instance of라는...다른게 필요.
		Object dog3 = new Dog();
//		dog3.stop(); 
//		object에 있는 건 이렇게 쓸 수 없다. 가면 있지만 쓸 수 없다?
//		지금은 Animal을 dog과 비슷하게 만들어놓아서 animal이나 dog나 비슷하게 느껴진다.
		Rabbit rabbit = new Rabbit();
		rabbit.running();
		rabbit.stop();
	}

}
