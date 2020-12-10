package com.lec.q1_student;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	private int No;

	public static int count =0;

	//생성자
	public Student() {}
	public Student(String name, int kor, int eng, int math) {
		this.No= ++count;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		tot = kor+eng+math;
		avg = tot/3.0;
	}


		public void No() {
			System.out.println("학번="+No);
		}

	public void print() {
//		System.out.println("이름=" + name + "\t국어 =" + kor + "\t영어=" + eng+"\t수학"+math);
		System.out.printf("%d\t %s\t %d\t %d\t %d\t %d\t %.1f\n",No,name,kor,eng,math,tot,avg);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
	
	
}
