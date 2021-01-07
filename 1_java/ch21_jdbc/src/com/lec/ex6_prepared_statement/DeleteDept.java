package com.lec.ex6_prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDept {
	// 삭제할 부서번호를 입력받기
	// 2-1 입력한 부서번호가 있을시, 진짜 XX부서를 삭제하시겠습니까?
	// 2-1-1 Y를 누르면 삭제완료 메시지.
	// 2-1-2 그 외는 삭제 안하고 종료.
	// 2-2 입력한 부서번호가 없을시, 없다 하고 종료.
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO=?";
		String deleteSql = "DELETE FROM DEPT WHERE DEPTNO =?";
		System.out.println("삭제할 부서번호는?");
		int deptno = scanner.nextInt();

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, deptno);
			;
			rs = pstmt.executeQuery();
			if (rs.next()) { // 삭제 진행
				System.out.println(deptno + "번 부서를 진짜 삭제하시겠습니까?");
				String answer = scanner.next();
				if (answer.equalsIgnoreCase("Y")) {
					rs.close();
					pstmt.close();
					pstmt = conn.prepareStatement(deleteSql);
					pstmt.setInt(1, deptno);
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? deptno + "번 삭제 성공" : "삭제 실패");

				}

			} else { 
				System.out.println(deptno + "번 부서는 존재하지 않습니다.");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
