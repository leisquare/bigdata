package com.lec.q1_student;

public class StudentTestMain {
	public static void main(String[] args) {
		Student[] student = { new Student("정우성", 90, 90, 90), 
				new Student("김하늘", 90, 90, 91),
				new Student("황정민", 81, 80, 80), 
				new Student("강동원", 80, 80, 80), 
				new Student("유아인", 70, 70, 70) };

		for (int ct1 = 1; ct1 < 60; ct1++) { //■■■■■■■■■■■■■■■■■■■
			System.out.printf("■");	
		}
		
		System.out.println(); 
		
		System.out.println("성적표"); 
		for (int ct2 = 1; ct2 < 60; ct2++) {//---------------------
			System.out.print("-");
		}
		System.out.println(); 
		
		System.out.printf("번호 \t 이름\t 국어\t 영어\t 수학\t 총점\t 평균\t \n");
		
		for (int ct3 = 1; ct3 < 60; ct3++) { //---------------------
			System.out.print("-");
		}
		System.out.println(); 

		for (int i = 0; i < student.length; i++) {
//			System.out.println(student[i].print());
			student[i].print();
			
		}
		//각 과목총점
		int sumK=0;
		for(int j = 0; j < student.length ; j++) {
			sumK = sumK+ student[j].getKor(); 			
		}
		
		int sumE=0;
		for(int j = 0; j < student.length ; j++) {
			sumE = sumE+ student[j].getEng(); 			
		}
		
		int sumM=0;
		for(int j = 0; j < student.length ; j++) {
			sumM = sumM+ student[j].getMath(); 			
		}
		
		int sumT=0;
		for(int j = 0; j < student.length ; j++) {			
			sumT = sumT+ student[j].getTot(); 			
		}
		
		double sumV=0; //평균합
		for(int j = 0; j < student.length ; j++) {			
			sumV = sumV+ student[j].getAvg(); 			
		}
		
		//각 과목평균
		double avgK=sumK/student.length;
		double avgE=sumE/student.length;
		double avgM=sumM/student.length;
		double avgT=sumT/student.length;
		double avgV=sumV/student.length;
		
		System.out.println(); 
		
		for (int ct4 = 1; ct4 < 60; ct4++) { //---------------------
			System.out.print("-");
		}
		System.out.println(); 
		
		System.out.printf("\t 총점\t %d\t %d\t %d\t %d\t %.1f\t",sumK,sumE,sumM,sumT,sumV);
		System.out.println(); 
		System.out.printf("\t 평균\t %.1f\t %.1f\t %.1f\t %.1f\t %.1f\t",avgK,avgE,avgM,avgT,avgV);
		
		System.out.println(); 
		for (int ct5 = 1; ct5 < 60; ct5++) { //■■■■■■■■■■■■■■■■■■■
			System.out.printf("■");	
		}
	}
}

