package com.lec.ex2_man;
// man kim = new man(20, 170, 60, "010-9999-9999");

//man kim = new man(20, 170, 60, );
//man kim = new man(20, "010-9999-9999"); 이것은 만들 수 없다.
//man kim = new man(170, "010-9999-9999"); 이것은 만들 수 없다.

public class Man {
	// 나이 키 몸무게 전화번호
	private int age;
	private int height;
	private int weight;
	private String tel;

	public Man() {
	} // 디폴트생성자 하나는 만들어줘야함

	public Man(int age, int height, int weight, String tel) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.tel = tel;
	}

	public Man(int age, int height, int weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public Man(int age, String tel) {
		this.age = age;
		this.tel = tel;
	}

	// BMI반환메소드
	public double calculateBMI() {
		double result = weight / (height + 0.01) * (height + 0.01);
		return result;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}
}

//man kim = new man(20, "010-9999-9999"); 
//man kim = new man(170, "010-9999-9999");
//위와 같은 것은 분류가 안 되기 때문에 이렇게 입력할 수 없다. 입력하게 하려면 아래와 같은 식에 if 처리 할 것.
//	public Man(int value, string tel) {
//		
//	}
//}