package store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ChickenDTO;
import Super.Super;
import Super.SuperDAO;

public class ChickenDAO extends SuperDAO {
	 


	private String driver = "oracle.jdbc.driver.OracleDriver";
	 private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	 private String id = "system";
	 private String pass = "1111";
	 private Connection conn = null;
	 private static ChickenDAO chickendao = null; 
	 
	 ChickenDAO() {
			super();
			init();
		}
	 
	 
	 public static ChickenDAO getInstance() {
		 if(chickendao == null) {
			 chickendao = new ChickenDAO();
		 }
		 return chickendao;
	 }
	 
	
	
	private Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url,id,pass);
			
			System.out.println("연결성공");
		} catch (Exception e) {
		   System.out.println("연결오류");
		   conn = null;
		}
		return conn;
	}
	 
	
	private void init() {
		 try {
			Class.forName(driver);
			System.out.println("클래스 load 성공");
		} catch (Exception e) {
			System.out.println("클래스 로드 실패");
			e.printStackTrace();
		}
	 }


	@Override
	public void insert(ChickenDTO cdto,Super s) {
		
		PreparedStatement stmt = null;
		try {
			// 연결하기
			if(getConnection()!=null) {
				// 쿼리문정의
				String sql = "insert into chicken values (?,?,?,?,?)";
				// statement 생성
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, cdto.getMenuname());
				stmt.setString(2, cdto.getCsize());
				stmt.setString(3, cdto.getCcook());
				stmt.setString(4, cdto.getCscore());
				stmt.setString(5, cdto.getType());
				// 쿼리전송및 결과값 받기
				int result = stmt.executeUpdate();
				System.out.println(result + "건 삽입");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				// 연결해제-자원반납
				stmt.close();
				conn.close();			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}


	@Override
	public void select() {
		
		
		 
		Statement stmt = null;
	    ResultSet rs = null;
	    try {
	        if (getConnection() != null) {
	            String sql = "SELECT DISTINCT s.fname, s.faddr, s.mname, c.menuname, c.csize, c.ccook, c.cscore " +
	                         "FROM Super s " +
	                         "JOIN chicken c ON s.type = c.type";
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(sql);
	            while (rs.next()) {
	                String fname = rs.getString("fname");
	                String faddr = rs.getString("faddr");
	                String mname = rs.getString("mname");
	                String menuname = rs.getString("menuname");
	                String csize = rs.getString("csize");
	                String ccook = rs.getString("ccook");
	                String cscore = rs.getString("cscore");

	                System.out.println("---------------------------------------------");
	                System.out.println("프렌차이즈 이름 : " + fname);
	                System.out.println("프렌차이즈 주소 : " + faddr);
	                System.out.println("매니저 이름 : " + mname);
	                System.out.println("치킨 이름 : " + menuname);
	                System.out.println("치킨 사이즈 : " + csize);
	                System.out.println("치킨 조리 방법 : " + ccook);
	                System.out.println("치킨 평점 : " + cscore);
	                System.out.println("---------------------------------------------");
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
			
		
		
		
	}


	@Override
	public void delete(String menuname) {
		 PreparedStatement stmt = null;
			try {
				// 연결하기
				if(getConnection()!=null) {
					// 쿼리문정의
					String sql = "delete from chicken where menuname = ?";
					// statement 생성
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, menuname);
					// 쿼리전송및 결과값 받기
					int result = stmt.executeUpdate();
					System.out.println(result + "건 삭제");
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					// 연결해제-자원반납
					stmt.close();
					conn.close();			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}


	 public void updatesize(String chicken,String csize) {
		 PreparedStatement stmt = null;
			try {
				// 연결하기
				if(getConnection()!=null) {
					// 쿼리문정의
					String sql = "update chicken set csize = ? where menuname = ?";
					// statement 생성
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, csize);
					stmt.setString(2, chicken);
					// 쿼리전송및 결과값 받기
					int result = stmt.executeUpdate();
					System.out.println(result + "건 수정");
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					// 연결해제-자원반납
					stmt.close();
					conn.close();			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	 
	 public void updatecook(String chicken,String ccook) {
		 PreparedStatement stmt = null;
			try {
				// 연결하기
				if(getConnection()!=null) {
					// 쿼리문정의
					String sql = "update chicken set ccook = ? where menuname = ?";
					// statement 생성
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, ccook);
					stmt.setString(2, chicken);
					// 쿼리전송및 결과값 받기
					int result = stmt.executeUpdate();
					System.out.println(result + "건 수정");
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					// 연결해제-자원반납
					stmt.close();
					conn.close();			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	 }
	 public void updatescore(String chicken,String cscore) {
		 PreparedStatement stmt = null;
			try {
				// 연결하기
				if(getConnection()!=null) {
					// 쿼리문정의
					String sql = "update chicken set cscore = ? where menuname = ?";
					// statement 생성
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, cscore);
					stmt.setString(2, chicken);
					// 쿼리전송및 결과값 받기
					int result = stmt.executeUpdate();
					System.out.println(result + "건 수정");
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					// 연결해제-자원반납
					stmt.close();
					conn.close();			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	 }
	 
	 
	
}
