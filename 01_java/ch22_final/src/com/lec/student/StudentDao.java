package com.lec.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.person_dao.PersonDto;

public class StudentDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	// int insertStudent(String sName, mName,score)
//	ArrayList<studentDto> selectMnam(String mName);
//	ArrayList<StudentDto> selectStudent();
//	ArrayList<StudentDto> selectExpel();
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static StudentDao INSTANCE;

	public static StudentDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}

	private StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1번 insert student(studentdto dto)
	public int insertStudent(String sName, String mName, int score) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES"
				   + "    (TO_CHAR(SYSDATE, 'YYYY') ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000'))," 
				   + "    ?,(SELECT mNO FROM MAJOR WHERE mNAME=?), ?";

//		try {
//			conn = DriverManager.getConnection(url, "scott", "tiger");
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, dto.getSno());
//			pstmt.setString(2, dto.getSname());
//			pstmt.setInt(3, dto.getMno());
//			pstmt.setInt(4, dto.getScore());
//			pstmt.setInt(5, dto.getSexpel());
//			result = pstmt.executeUpdate();
//			
			try {
				conn = DriverManager.getConnection(url, "scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sName);
				pstmt.setString(2, mName);
				pstmt.setInt(3, score);
				result = pstmt.executeUpdate();	
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 2번 select mname(string mname)
	public ArrayList<StudentDto> selectMname(String mName) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' sNAME, mNAME, SCORE"
				+ "    FROM (SELECT * FROM MAJOR M, STUDENT S " + "            WHERE M.mNO=S.mNO AND mNAME = ?)"
				+ "    ORDER BY SCORE DESC";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("RANK");
				String sname = rs.getString("sNAME");
				int score = rs.getInt("SCORE");
				String mname = rs.getString("mNAME");
				
				//이 부분 WHILE 안에 들어오는 건 오라클에서 열이름으로 뜬 거만 들어오는 거임
				dtos.add(new StudentDto(rank, sname, score, mname));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return dtos;
	}

	// 3번 제적당하지 않은 전체 학생을 조회 후 점수가 높은 순으로 출력
	public ArrayList<StudentDto> selectAll1() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " SELECT ROWNUM RANK, sNAME||'('||sNO||')' sNAME, mNAME, SCORE"
				+ "    FROM (SELECT * FROM STUDENT S , MAJOR M"
				+ "            WHERE S.mNO= M.mNO AND sEXPEL=0"
				+ "       ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("RANK");
				String sname = rs.getString("sNAME");
				int score = rs.getInt("SCORE");
				String mname = rs.getString("mNAME");
				
				//오른쪽 큰따옴표 안 부분 WHILE 안에 들어오는 건 오라클에서 열이름으로 뜬 거만 들어오는 거임
				dtos.add(new StudentDto(rank, sname, score, mname));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return dtos;

	}
	// 4를 누르면 제적당한 학생을 조회 후 후 점수가 높은 순으로 출력한다.
	public ArrayList<StudentDto> selectAll2() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " SELECT ROWNUM RANK, sNAME||'('||sNO||')' sNAME, mNAME, SCORE"
				+ "    FROM (SELECT * FROM STUDENT S , MAJOR M" + "            WHERE S.mNO= M.mNO AND sEXPEL=1"
				+ "       ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("RANK");
				String sname = rs.getString("sNAME");
				int score = rs.getInt("SCORE");
				String mname = rs.getString("mNAME");
				
				//이 부분 WHILE 안에 들어오는 건 오라클에서 열이름으로 뜬 거만 들어오는 거임
				dtos.add(new StudentDto(rank, sname, score, mname));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return dtos;

	}
}
