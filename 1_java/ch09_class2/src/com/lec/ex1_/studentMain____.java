package com.lec.ex1_;

public class studentMain____ {
	public static void main(String[] args) {
		Student[] student = { new Student("정우성", 90, 90, 90), new Student("김하늘", 90, 90, 91),
				new Student("황정민", 81, 80, 80), new Student("강동원", 80, 80, 80), new Student("유아인", 70, 70, 70) };
//		for(Student s : student) {
//			s.print();
//		} 확장 for문을 이용할 줄 아는 사람이 되자. 

		for (int ct1 = 1; ct1 < 50; ct1++) { // ■■■■■■■■■■■■■■■■■■■
			System.out.printf("■");
		}

		System.out.println();

		System.out.println("성적표");
		for (int ct2 = 1; ct2 < 50; ct2++) {// ---------------------
			System.out.print("-");
		}
		System.out.println();

		for (int i = 0; i < student.length; i++) {
//			System.out.println(student[i].print());
			student[i].print();
			int[] tot = new int[5];
			double[] avg = new double[5]; // (각 과목들 평균 저장)
			for (Student s : student) {
				s.print();
				tot[0] += s.getKor();
				tot[0] += s.getEng();
				tot[0] += s.getMath();
				tot[0] += s.getTot();
				tot[0] += s.getAvg();
			}

			for (int idx = 0; idx < avg.length; idx++) {
				avg[idx] = tot[idx] / student.length;
			}

			System.out.println("\t-------------------------");
			System.out.print("\t총점");
			for (int idx = 0; idx < avg.length; idx++) {// 평균계산
				avg[idx] = tot[idx] / student.length;
				System.out.print("\t " + tot[idx]);
			}
			System.out.print("\n\t평균");
			for (double a : avg) {
				System.out.print("\t" + a);
			}

			for (int ct4 = 1; ct4 < 50; ct4++) { // ---------------------
				System.out.print("-");
			}
			System.out.println();

			System.out.println();
			for (int ct5 = 1; ct5 < 50; ct5++) { // ■■■■■■■■■■■■■■■■■■■
				System.out.printf("■");
			}
		}
	}
}
