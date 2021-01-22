package com.lec.q1_student;

public class StudentTestMain2 {
	public static void main(String[] args) {
		Student[] student = { new Student("정우성", 90, 90, 90), new Student("김하늘", 90, 90, 91),
				new Student("황정민", 81, 80, 80), new Student("강동원", 80, 80, 80), new Student("유아인", 70, 70, 70) };

		for (int ct1 = 1; ct1 < 60; ct1++) { // ■■■■■■■■■■■■■■■■■■■
			System.out.printf("■");
		}

		System.out.println();

		System.out.println("성적표");
		for (int ct2 = 1; ct2 < 60; ct2++) {// ---------------------
			System.out.print("-");
		}
		System.out.println();
		System.out.printf("번호\t 이름\t 국어\t 영어\t 수학\t 총점\t 평균\t \n");
		System.out.println();

			int[] tot = new int[5];
			double[] avg = new double[5]; // (각 과목들 평균 저장)
			
			for (Student s : student) {
				s.print();				
				tot[0] += s.getKor();
				tot[1] += s.getEng();
				tot[2] += s.getMath();
				tot[3] += s.getTot();
				tot[4] += s.getAvg();
			}
			
			for (int ct3 = 1; ct3 < 60; ct3++) { // ---------------------
				System.out.print("-");
			}	
			//총점평균
			System.out.println();
			System.out.print("\t총점");
			for(int idx=0 ; idx<avg.length ; idx++) { 
				avg[idx] = tot[idx] / student.length;
				System.out.print("\t "+tot[idx]);
			}
			System.out.print("\n\t평균");
			for(double a : avg) {
				System.out.print("\t"+a);		
			}
			System.out.println();
			//총점평균끝
			
			for (int ct4 = 1; ct4 < 60; ct4++) { // ---------------------
				System.out.print("-");
			}
			System.out.println();

			System.out.println();
			for (int ct5 = 1; ct5 < 60; ct5++) { // ■■■■■■■■■■■■■■■■■■■
				System.out.printf("■");
			}
		}
	}

