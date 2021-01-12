package com.lec.studentGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.lec.student.StudentDto;

public class StudentSwingDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static StudentSwingDao INSTANCE;

	public static StudentSwingDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StudentSwingDao();
		}
		return INSTANCE;
	}

	public StudentSwingDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 0. 전공이름을 콤보박스에 추가(mName)
	public Vector<String> getMNamelist(){
		Vector<String> mnames = new Vector<String>();
		mnames.add("");
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		String sql = "SELECT MNAME FROM MAJOR";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs   = stmt.executeQuery(sql); 
			while(rs.next()) {
				mnames.add(rs.getString("mname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return mnames;
	}
	// 1. 학번검색
	public StudentSwingDto selectsNo(String sNo) {
		StudentSwingDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO,SNAME,MNAME,SCORE" + "    FROM MAJOR M,STUDENT S" + "    WHERE M.MNO=S.MNO AND SNO=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dto = new StudentSwingDto(sNo, sName, mName, score);
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
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// 2. 이름검색
	public ArrayList<StudentSwingDto> selectsName(String sName) {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO,SNAME,MNAME,SCORE" + "    FROM MAJOR M,STUDENT S"
				+ "    WHERE M.MNO=S.MNO AND SNAME=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String sNo = rs.getString("sNo");
				int score = rs.getInt("score");
				String mName = rs.getString("mName");
				dtos.add(new StudentSwingDto(sNo, sName, mName, score));

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

	// 3. 전공검색

	public ArrayList<StudentSwingDto> selectmName(String mName) {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT ROWNUM RANK, SNAME||'('||SNO||')' AS STUDENT, MNAME||'('||S.MNO||')' AS MAJOR , SCORE "
				+ "    FROM MAJOR M,STUDENT S " + "    WHERE M.MNO=S.MNO AND MNAME=?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mName.trim());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int Rank = rs.getInt("RANK");
				String sName = rs.getString("STUDENT");
				int score = rs.getInt("SCORE");
				mName = rs.getString("MAJOR");
				dtos.add(new StudentSwingDto(Rank, sName, mName, score));
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

	// 4. 학생입력
	public int insertStudent(String sName, String mName, int score) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES"
				+ "    (TO_CHAR(SYSDATE, 'YYYY') ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),"
				+ "    ?,(SELECT mNO FROM MAJOR WHERE mNAME=?), ?)";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
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

	// 5. 학생수정
	public int updateStudent(String sNo, int score) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET SCORE=?" + "	WHERE SNO=? ";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, score);
			pstmt.setString(2, sNo);
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

	// 6. 학생 출력
	public ArrayList<StudentSwingDto> getStudents() {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "  SELECT ROWNUM RANK, sNAME||'('||sNO||')' STUDENT, mNAME||'('||MNO||')' MAJOR, SCORE"
				+ "    FROM (SELECT SNO, SNAME,S.MNO MNO,SCORE,SEXPEL,MNAME "
				+ "FROM STUDENT S , MAJOR M WHERE S.mNO= M.mNO AND sEXPEL=0" + "       ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int Rank = rs.getInt("RANK");
				String sName = rs.getString("STUDENT");
				String mName = rs.getString("MAJOR");
				int score = rs.getInt("SCORE");

				// 오른쪽 큰따옴표 안 부분 WHILE 안에 들어오는 건 오라클에서 열이름으로 뜬 거만 들어오는 거임
				dtos.add(new StudentSwingDto(Rank, sName, mName, score));
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

	// 7. 제적자 출력

	public ArrayList<StudentSwingDto> getStudentsExpel() {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "  SELECT ROWNUM RANK, sNAME||'('||sNO||')' STUDENT, mNAME||'('||MNO||')' MAJOR, SCORE"
				+ "    FROM (SELECT SNO, SNAME,S.MNO MNO,SCORE,SEXPEL,MNAME "
				+ "FROM STUDENT S , MAJOR M WHERE S.mNO= M.mNO AND sEXPEL=1" + "       ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int Rank = rs.getInt("RANK");
				String sName = rs.getString("STUDENT");
				String mName = rs.getString("MAJOR");
				int score = rs.getInt("SCORE");

				// 오른쪽 큰따옴표 안 부분 WHILE 안에 들어오는 건 오라클에서 열이름으로 뜬 거만 들어오는 거임
				dtos.add(new StudentSwingDto(Rank, sName, mName, score));
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
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 8. 제적처리
	public int sNoExpel(String sNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET sEXPEL=1 WHERE SNO=?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
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

}
