package com.lec.studentGUI;

import java.util.ArrayList;
import java.util.Scanner;

public class SwingStudentMng2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentSwingDao dao = StudentSwingDao.getInstance();
		String fn;
		String mName;
		String sName;
		String sNo;
		
		do {
			System.out.println("1:학번검색| 2: 이름검색 | 3:학과별출력 | 3:전체출력 | 4:학생입력 "
							+ "| 5: 학생수정 | 6: 비제적학생 | 7: 제적학생 | 8: 제적처리 그외:종료 >");
			fn = scanner.next();
			switch(fn) {
			case "0": // 이름, 직업명, 국영수 입력받아 dao.insertPerson()호출
				//학과명 insert
//				
				
			case "1": //학번검색
				System.out.print("조회할 학번");
				sNo = scanner.next();
				StudentSwingDto dto = dao.selectsNo(sNo);
				if(dto != null) {
					System.out.println("등수\t이름\t학과\t점수");
					System.out.println(dto);
				}else {
					System.out.println("해당 학번의 학생이 없습니다.");
				}
				break;
				
			case "2": //이름검색
				System.out.print("조회할 이름");
				sName = scanner.next();
				ArrayList<StudentSwingDto> dtos = dao.selectsName(sName);
				if(dtos .size()!=0) {
					System.out.println("등수\t이름\t학과\t점수");
					for(StudentSwingDto d : dtos ) {
						System.out.println(d);
					}
				}else {
					System.out.println("해당 이름의 학생이 없습니다.");
				}
				break;
				
			case "3": //전공검색
				System.out.print("조회할 학과명은(빅데이터학 | 경영정보학 | 컴퓨터공학 | 소프트웨어 | 인공지능학)? ");
				mName = scanner.next();
				dtos = dao.selectmName(mName);
				if(dtos .size()!=0) {
					System.out.println("등수\t이름\t학과\t점수");
					for(StudentSwingDto d : dtos ) {
						System.out.println(d);
					}
				}else {
					System.out.println("해당 학과 학생이 없습니다");
				}
				break;
			case "4": //학생입력
				System.out.print("입력할 이름 >");
				sName = scanner.next();
				System.out.print("학과명 >");
				mName = scanner.next();
				System.out.print("점수 >");
				int score = scanner.nextInt();
				if(score<0 || score>100) {
					System.out.println("유효하지 않은 점수.");
					continue;
				}
				int result = dao.insertStudent(sName, mName, score);
				System.out.println(result==StudentSwingDao.SUCCESS? "입력성공":"입력실패");
				break;
				
			case "5": // 학생 수정
				System.out.println("수정할 학생의 학번");
				sNo = scanner.next();			
				StudentSwingDto s = dao.selectsNo(sNo);
				if(s != null) {
					System.out.println("등수\t이름\t학과\t점수");
					System.out.println(s);
					System.out.println("수정할 학생의 성적");
					score = scanner.nextInt();
					result = dao.updateStudent(sNo,score);
					System.out.println(result==StudentSwingDao.SUCCESS? "입력성공":"입력실패");
					break;
				}else {
					System.out.println("해당 학번의 학생이 없습니다.");
				}
				break;		
				
			case "6": // 비 제적학생 전체 출력
				dtos = dao.getStudents();
				if(dtos.size()!=0) {
					System.out.println("등수\t이름\t학과\t점수");
					for(StudentSwingDto d : dtos) {
						System.out.println(d);
					}
				}else {
					System.out.println("해당 학과 학생이 없습니다");
				}
				break;
			case "7": // 제적자 출력
				dtos = dao.getStudentsExpel();
				if(dtos.size()!=0) {
					System.out.println("등수\t이름\t학과\t점수");
					for(StudentSwingDto d : dtos) {
						System.out.println(d);
					}
				}else {
					System.out.println("해당 학과 학생이 없습니다");
				}
				break;
			case "8": // 제적 처리			
				System.out.println("제적처리할 학생의 학번");
				sNo = scanner.next();		
				int e = dao.sNoExpel(sNo);				
				if(e==1) { 
					System.out.println("제적처리");
				}else {
					System.out.println("해당 학번의 학생이 없습니다.");
					break;

				}	
			}
		}while(fn.equals("1")||fn.equals("2")||
					fn.equals("3")||fn.equals("4")||fn.equals("5")||fn.equals("6")||
					fn.equals("7")||fn.equals("8"));
		System.out.println("BYE");
	}
}
