package com.lex.ex1_selectAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver"; // 8.0ver
		String url = "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String query = "SELECT * FROM PERSONAL";
		try {
			Class.forName(driver); // (1)
			conn = DriverManager.getConnection(url, "root", "mysql"); // (2)
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query); // (4)+(5)
			System.out.println("사번\t 이름\t 직책\t\t  상사사번\t 입사일\t\t  급여\t 상여금\t 부서번호");
			if (rs.next()) { // select 결과있음
				do {
					int pno = rs.getInt("pno");
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					int manager = rs.getInt("manager");
					Date startdate = rs.getDate("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					if (pname != null && pname.length() < 7) {
						System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n", pno, pname, job, manager,
								startdate, pay, bonus, dno);
					} else {
						System.out.printf("%d\t %s %s\t %d\t %TF\t %d\t %d\t %d\n", pno, pname, job, manager, startdate,
								pay, bonus, dno);
					}

				} while (rs.next());

			} else {
				System.out.println("사원정보가 없습니다");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();// ⑥연결 해제
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
