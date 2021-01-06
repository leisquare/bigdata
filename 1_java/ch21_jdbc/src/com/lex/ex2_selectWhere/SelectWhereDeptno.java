package com.lex.ex2_selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//사용자에게 원하는 부서번호를 입력받아 부서정보 뿌리기
public class SelectWhereDeptno {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; // DB연결객체 변수
		Statement stmt = null; // SQL전송 객체변수
		ResultSet rs = null; // Select문 결과 받는 객체 변수
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 부서번호는?");
		int deptno = scanner.nextInt();
		String sql = "SELECT * FROM dept where deptno=" + deptno;

		try {
			Class.forName(driver); // (1)
			conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
			stmt = conn.createStatement(); // (3)
			rs = stmt.executeQuery(sql); // (4+5)
			if (rs.next()) {// 해당부서있음
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno + "부서의 정보는 다음과 같습니다.");
				System.out.println("부서명: " + dname);
				System.out.println("위치: " + loc);

			} else { // 해당부서없음
				System.out.println("부서가 존재하지 않습니다.");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

			}
		}

	}

}
