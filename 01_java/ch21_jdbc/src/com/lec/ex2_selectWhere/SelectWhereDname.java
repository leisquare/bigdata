package com.lec.ex2_selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		System.out.print("원하는 부서명은?");
		String dname = scanner.next();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT WHERE DNAME='" + dname + "'";
//		sql = String.format("SELECT * FROM DEPT WHERE DNAME='%s'", dname);
		try {
			Class.forName(driver); // (1)
			conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
			stmt = conn.createStatement(); // (3)
			rs = stmt.executeQuery(sql); // (4+5)
			if (rs.next()) { // (6)
				System.out.println("부서번호: " + rs.getInt("deptno"));
				System.out.println("부서이름: " + dname);
				System.out.println("부서위치: " + rs.getString("loc"));
			} else {
				System.out.println("해당 부서명이 존재하지 않습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // (7)
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
