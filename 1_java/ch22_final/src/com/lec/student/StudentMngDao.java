package com.lec.student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMngDao {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentDao dao = StudentDao.getInstance();
		String fn;
		ArrayList<StudentDto> student;
		do {
			System.out.println("1:입력 2: 학과이름별출력 3:비제적학생조회  4: 제적학생조회 그외: 종료>");
			fn = scanner.next();
			switch (fn) {
			case "1": // 이름, 직업명, 국영수 입력받아 dao.insertPerson()호출
				System.out.println("학번?");
				String sno = scanner.next();
				System.out.println("이름?");
				String sname = scanner.next();
				System.out.println("학과번호?");
				int mno = scanner.nextInt();
				System.out.println("점수?");
				int score = scanner.nextInt();
				System.out.println("재적상황");
				int sexpel = scanner.nextInt();
				StudentDto newStudent = new StudentDto(sno,sname,mno,score,sexpel);
				int result = dao.insertStudent(newStudent); // 입력 끝
				System.out.println(result == StudentDao.SUCCESS ? "입력성공" : "실패");

				break;
			case "2": // 학과명 입력받기 dao.selectJname()호출하여 결과 출력
				System.out.println("조회할 학과명");
				String mname = scanner.next();
				student = dao.selectMname(mname);
				if (student.size() != 0) {
					System.out.println("등수\t 이름\t 학과명\t 점수");
					
					for (StudentDto s : student) {
						System.out.println(s);
					}
				} else {
					System.out.println("존재하지 않음");				
				}

				break;
			case "3": // dao.selectAll() 호출하여 결과 출력
				student = dao.selectAll1();
				if (student.size() != 0) {
					System.out.println("등수\t 이름\t 학과명\t 점수");
					System.out.println("------------------------------------");
					for (StudentDto s : student) {
						System.out.println(s);
					}
				} else {
					System.out.println("없습니다");
				}
				break;
				
			case "4": // dao.selectAll() 호출하여 결과 출력, 3과 반대
				student = dao.selectAll2();
				if (student.size() != 0) {
					System.out.println("등수\t 이름\t 학과명\t 점수");
					System.out.println("------------------------------------");
					for (StudentDto s : student) {
						System.out.println(s);
					}
				} else {
					System.out.println("없습니다");
				}
				break;
			}
		} while (fn.equals(1) || fn.equals(2) || fn.equals(3)||fn.equals(4));
		System.out.println("BYE");

	}
}
