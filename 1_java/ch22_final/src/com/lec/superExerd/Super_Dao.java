package com.lec.superExerd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.lec.studentGUI.StudentSwingDto;

public class Super_Dao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static Super_Dao INSTANCE;
	
	public static Super_Dao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Super_Dao();
		}
		return INSTANCE;
	}
	public Super_Dao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 0. 콤보박스에 추가(levelname;)
		public Vector<String> getLevelNames() {
			Vector<String> levelName = new Vector<String>();
			Connection conn = null;
			Statement  stmt = null;
			ResultSet  rs   = null;
			String sql = "SELECT LEVELNAME FROM CUS_LEVEL ORDER BY LEVELNO";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				stmt = conn.createStatement();
				rs   = stmt.executeQuery(sql); 
				while(rs.next()) {
					levelName.add(rs.getString("LEVELNAME"));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage()+"error");
			}finally {
				try {
					if(rs  !=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return levelName;
		}
	
		//1. 아이디 검색
		public Super_Dto selectcId(int cId) {
			Super_Dto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql= "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME," + 
					"    (SELECT HIGH-CAMOUNT+1" + 
					"        FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) AS FORLEVELUP" + 
					"    FROM CUSTOMER C, CUS_LEVEL L" + 
					"    WHERE C.LEVELNO = L.LEVELNO AND cID = ?";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String cTel = rs. getString("cTel");
					String cName = rs. getString("cName");
					int cPoint = rs.getInt("cPoint");
					int cAmount = rs.getInt("cAmount");
					String levelName  = rs.getString("levelName");
					int forLevelup = rs.getInt("forLevelup");
					dto = new Super_Dto(cId, cTel, cName, cPoint, cAmount, levelName, forLevelup);
					
				}	
				}catch (SQLException e) {
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
		
		//2. 폰번호 검색
		public ArrayList<Super_Dto> selectcTel(String cTel) {
			ArrayList<Super_Dto> dtos = new ArrayList<Super_Dto>();
			Super_Dto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql= "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, \r\n" + 
					"    (SELECT HIGH-CAMOUNT+1 \r\n" + 
					"        FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) AS FORLEVELUP\r\n" + 
					"    FROM CUSTOMER C, CUS_LEVEL L\r\n" + 
					"    WHERE C.LEVELNO = L.LEVELNO AND cTel Like '%'||?"; 
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cTel);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int cId =rs.getInt("cId");
					cTel = rs. getString("cTel");
					String cName = rs. getString("cName");
					int cPoint = rs.getInt("cPoint");
					int cAmount = rs.getInt("cAmount");
					String levelName  = rs.getString("levelName");
					int forLevelup = rs.getInt("forLevelup");
					dtos.add(new Super_Dto(cId, cTel, cName, cPoint, cAmount, levelName, forLevelup));
					
				}	
				}catch (SQLException e) {
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
		
		//3. 고객명 검색	
		public ArrayList<Super_Dto> selectcName(String cName) {
				ArrayList<Super_Dto> dtos = new ArrayList<Super_Dto>();
			Super_Dto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql= "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, \r\n" + 
					"    (SELECT HIGH-CAMOUNT+1 \r\n" + 
					"        FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) AS FORLEVELUP\r\n" + 
					"    FROM CUSTOMER C, CUS_LEVEL L\r\n" + 
					"    WHERE C.LEVELNO = L.LEVELNO AND CNAME =?"; 
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cName);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int cId =rs.getInt("cId");
					cName = rs. getString("cName");
					String cTel = rs. getString("cTel");
					int cPoint = rs.getInt("cPoint");
					int cAmount = rs.getInt("cAmount");
					String levelName  = rs.getString("levelName");
					int forLevelup = rs.getInt("forLevelup");
					dtos.add(new Super_Dto(cId, cTel, cName, cPoint, cAmount, levelName, forLevelup));
					
					
				}	
				}catch (SQLException e) {
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
		//4. 포인트로 구매
		public int updatecPoint(int cId, int cPoint) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE CUSTOMER SET CPOINT = CPOINT - ? WHERE CID = ?";
			
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cPoint);
				pstmt.setInt(2, cId);
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
		//5. 물품 구매(포인트 누적, 누걱금액변경, 등급변경)
		public int buy(int cAmount, int cId) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE CUSTOMER SET CPOINT = CPOINT + ?*0.05," + 
					"                    CAMOUNT = CAMOUNT + ?," + 
					"                    LEVELNO = (SELECT L.LEVELNO" + 
					"                      FROM CUSTOMER C, CUS_LEVEL L" + 
					"                      WHERE CAMOUNT+? BETWEEN LOW AND HIGH AND CID=?)" + 
					"                WHERE CID=?";
			
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cAmount);
				pstmt.setInt(2, cAmount);
				pstmt.setInt(3, cAmount);
				pstmt.setInt(4, cId);
				pstmt.setInt(5, cId);
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
		//6. 등급별 출력
			public ArrayList<Super_Dto> levelNameGetCustomers(String levelname) {
				ArrayList<Super_Dto> dtos = new ArrayList<Super_Dto>();
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME," + 
						"    (SELECT HIGH - CAMOUNT+1" + 
						"        FROM CUSTOMER WHERE CID = C.CID AND LEVELNO !=5) FORLEVELUP" + 
						"        FROM CUSTOMER C, CUS_LEVEL L" + 
						"            WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME = ?" + 
						"            ORDER BY CAMOUNT DESC";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, levelname);
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						int cId=rs.getInt("cId");
						String cTel=rs.getString("cTel");
						String cName=rs.getString("cName");
						int cPoint=rs.getInt("cPoint");
						int cAmount=rs.getInt("cAmount");
						String levelName  = rs.getString("levelName");
						int forLevelup = rs.getInt("forLevelup");
						dtos.add(new Super_Dto(cId, cTel, cName, cPoint, cAmount, levelName, forLevelup));
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
		//7. 전체 출력			
			public ArrayList<Super_Dto> getCustomers() {
				ArrayList<Super_Dto> dtos = new ArrayList<Super_Dto>();
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME," + 
						"    (SELECT HIGH - CAMOUNT+1" + 
						"        FROM CUSTOMER WHERE CID = C.CID AND LEVELNO !=5) FORLEVELUP" + 
						"        FROM CUSTOMER C, CUS_LEVEL L" + 
						"            WHERE C.LEVELNO = L.LEVELNO" + 
						"            ORDER BY CAMOUNT DESC";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						int cId=rs.getInt("cId");
						String cTel=rs.getString("cTel");
						String cName=rs.getString("cName");
						int cPoint=rs.getInt("cPoint");
						int cAmount=rs.getInt("cAmount");
						String levelName  = rs.getString("levelName");
						int forLevelup = rs.getInt("forLevelup");
						dtos.add(new Super_Dto(cId, cTel, cName, cPoint, cAmount, levelName, forLevelup));
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
		//8. 회원가입
			public int insertCustomer(String cTel, String cName) {
				int result = FAIL;
				Connection conn = null;
				PreparedStatement pstmt = null;
				String sql = "INSERT INTO CUSTOMER (CID, CTEL, CNAME) VALUES" + 
						"    (CUSTOMER_SEQ.NEXTVAL, ?, ?)";
				
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, cTel);
					pstmt.setString(2, cName);
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
		//9, 회원정보 수정(번호수정)
			public int updateCustomer(int cId, String cTel) {
				int result = FAIL;
				Connection conn = null;
				PreparedStatement pstmt = null;
				String sql = "UPDATE CUSTOMER SET CTEL = ? WHERE CID=?";
				
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, cTel);
					pstmt.setInt(2, cId);
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
		// 10. 회원 탈퇴
			public int deleteCustomer(String cTel) {
				int result = FAIL;
				Connection conn = null;
				PreparedStatement pstmt = null;
				String sql = "DELETE FROM CUSTOMER WHERE Ctel=?";
				
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, cTel);
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

