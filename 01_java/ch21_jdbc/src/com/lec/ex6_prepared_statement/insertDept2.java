package com.lec.ex6_prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class insertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
		
		Connection conn=null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);

		String insertSql="INSERT INTO DEPT VALUES(?,?,?)";
		String selectSql="SELECT * FROM DEPT WHERE DEPTNO=?";
		
		System.out.println("추가할 부서번호는?");
		int deptno = scanner.nextInt();
		
		//해당부서번호가 있는지 확인 후 부서 추가
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if(!rs.next()) {  //추가 가능
				System.out.println("추가할 부서이름은?");
				String dname=scanner.next();
				System.out.println("추가할 부서위치는?"); //띄어쓰기있을수있으니 nextline 
				scanner.nextLine();
				String loc=scanner.nextLine();
				//sql문을 변경하면서 pstmt 객체 를 변경할때는 기존의 pstmt를 닫고 다시 설정하는게 좋다.
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(insertSql);
				pstmt.setInt(1,deptno);
				pstmt.setString(2,dname);
				pstmt.setString(3,loc);
				int result = pstmt.executeUpdate();
				System.out.println(result>0? deptno+"번 부서 추가 성공":"추가 실패");
			}else {
				System.out.println("중복된 부서번호. 추가 불가");
			}		
		
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(deptno+"번 추가 실패");
		}finally {
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

		