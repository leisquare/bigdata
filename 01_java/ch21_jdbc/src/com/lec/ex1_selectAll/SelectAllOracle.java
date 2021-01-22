package com.lec.ex1_selectAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; // DB연결객체 변수
		Statement stmt = null; // SQL전송 객체변수
		ResultSet rs = null; // Select문 결과 받는 객체 변수
		String sql = "SELECT * FROM EMP";
		try {
			Class.forName(driver); // (1) 드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger"); // (2) DB연결
			stmt = conn.createStatement(); // (3) SQL 전송객체생성
			rs = stmt.executeQuery(sql); // (4) SQL 전송+ (5) SQL 전송결과 받기
			// (6) 결과 받아 원하는 로직 수행하기 - rs에 있는 데이터 콘솔에 출력
			System.out.println("사번\t 이름\t 직책 \t 상사사번 \t 입사일\t 급여\t \t상여금\t부서번호");
			while (rs.next()) {
				int empno = rs.getInt("empno"); // 그냥 숫자를 넣으면 몇번째 열인지 말하는 게 된다.
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				// Date hiredate = rs.getDate("hiredate");
				// String hiredate = rs.getString("hiredate");
				Timestamp hiredate = rs.getTimestamp("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				if (job != null && job.length() < 7) {
					System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n", empno, ename, job, mgr, hiredate, sal,
							comm, deptno);
				} else {
					System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n", empno, ename, job, mgr, hiredate, sal,
							comm, deptno);
				}
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
