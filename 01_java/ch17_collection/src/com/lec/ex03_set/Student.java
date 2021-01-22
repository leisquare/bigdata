package com.lec.ex03_set;

//이름, 학년 new Student("홍길동",5);

public class Student {
	private String name;
	private int grade;

	public Student(String name, int grade) {
		super();
		this.name = name;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return name + ":" + grade;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj instanceof Student) {
			boolean nameChk = name.equals(((Student) obj).name);
			boolean gradeChk = grade == ((Student) obj).grade;
			return nameChk && gradeChk;
		}
		return false;

	}

	@Override
	public int hashCode() {
		return toString().hashCode();

	}

}
