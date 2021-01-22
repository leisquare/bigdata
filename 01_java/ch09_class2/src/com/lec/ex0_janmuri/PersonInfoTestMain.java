package com.lec.ex0_janmuri;

//퍼블릭이 안 붙으면 디폴트가 되는데 디폴트와 퍼블릭은 다름. 메인은 거의 반드시 퍼블릭이 붙어야하는데 한 파일 안에 퍼블릭이 둘 들어가진 않느낟.

class PersonInfo {
	private String name;
	private int age;
	private char gender; // 성별 '남','여'

	public PersonInfo() {
	} // 생성자 없는 경우 디폴트 생성자는 JVM이 생성함.

	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}// 생성자 오버로딩

	public void print() {
		System.out.println("이름=" + name + "\t나이 =" + age + "\t성별=" + gender);
	}

	public String infoString() {
		String result = "이름=" + name + "\t나이 =" + age + "\t성별=" + gender;
		return result;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public char getGender() {
		return gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
}
//
//public class PersonInfoTestMain {
//	
//	public static void main(String[] args) {
////		PersonInfo p = new PersonInfo("홍길동", 22, '남');
////		p.print();
////		System.out.println(p.infoString());
//		int[] iArr = { 10, 20, 30 };
//		PersonInfo[] person = { new PersonInfo("홍길동", 20, '남'), new PersonInfo("홍길순", 22, '여'), new PersonInfo() }; //배열
//		person[2].setName("홍길숙");
//		person[2].setAge(21);
//		person[2].setGender('여');
//		for(PersonInfo p : person) {
//			p.print();
//			System.out.println(p.infoString());
//		}
//		for(int i = 0 ; i <person.length ; i++) {
//			System.out.println(person[i].infoString());
//			person[i].print();
//		}
//	}//메인
//
//
//}// 클래스
//
//}
