package com.lex.ex2_selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*사용자에게 원하는 부서번호 입력받아
(1) 부서가 있으면 부서 정보, 사원 출력(사원이 존재하는 경우 사원의 사번, 이름, 급여, 상사명 출력. 존재하지 않을 경우 사원이 없다고 출력
(2) 해당 부서번호가 존재하지 않을 경우 "존재하지 않는 부서번호" 라고 출력
*/

//부서명 입력받아 해당 무서명 정보와 사원 리스트 출력

public class SelectWhereDname2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 부서명은?");
		String dname = scanner.next();
		String sql1 = "SELECT * FROM DEPT WHERE DNAME='" + dname + "'";
		String sql2 = "SELECT E.EMPNO, E.ENAME,E.SAL,S.GRADE FROM EMP E, SALGRADE S, DEPT D "
					+ "WHERE E.DEPTNO=D.DEPTNO "
					+ "AND E.SAL BETWEEN S.LOSAL AND S.HISAL AND D.DNAME='"+dname+"'";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);

			if (rs.next()) {

				String loc = rs.getString("loc");
				String deptno = rs.getString("deptno");
				System.out.println(dname + " 부서의 정보는 다음과 같습니다.");
				System.out.println("부서번호: " + deptno);
				System.out.println("위치: " + loc);

				rs.close();
				rs = stmt.executeQuery(sql2);
				if (rs.next()) {
					System.out.println("사번\t 이름\t 급여\t 급여등급");
					while (rs.next()) {
						int empno = rs.getInt("EMPNO");
						String ename = rs.getString("ENAME");
						int sal = rs.getInt("SAL");
						int grade = rs.getInt("GRADE");
						System.out.printf("%d\t %s\t %d\t %d\n", empno, ename, sal, grade);
					}
				} else { // 해당부서없음
					System.out.println("사원이 존재하지 않습니다.");
				}
			} else { // 해당부서없음
				System.out.println("부서가 존재하지 않습니다.");
			}
		} catch (ClassNotFoundException e) {
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
