package com.lex.ex3_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		Scanner scanner = new Scanner(System.in);
		System.out.print("입력할 부서번호는?");
		int deptno = scanner.nextInt();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String selectsql = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectsql); // 4+5
			if (rs.next()) {
				System.out.println("중복된 부서번호는 입력이 불가능합니다.");
			} else {
				System.out.print("입력할부서이름?");
				String dname = scanner.next();
				System.out.print("입력할부서위치?");
				scanner.nextLine();
				String loc = scanner.nextLine();
				String insertSql = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')", deptno, dname, loc);

				int result = stmt.executeUpdate(insertSql);
				System.out.println(result > 0 ? "부서입력성공" : "실패");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
