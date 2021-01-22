package com.lec.ex6_prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		Scanner scanner = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql1 = "SELECT * FRIM DEPT WHERE DEPTNO=?";
		String sql2 = "UPDATE DEPT SET DNAME = ?, LOC = ? " + "  WHERE DEPTNO=?";
		System.out.println("수정하고자 하는 부서번호는?");
		int deptno = scanner.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("수정할 부성 이름은?");
				String dname = scanner.next();
				System.out.println("수정할 부서 위치는?");
				String loc = scanner.next();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "수정성공" : "실패");

			} else {
				System.out.println("존재하지않는 부서입니다.");
			}

		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
	}
}
