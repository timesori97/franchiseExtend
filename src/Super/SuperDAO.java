package Super;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.ChickenDTO;


public class SuperDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	 private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	 private String id = "system";
	 private String pass = "1111";
	 private Connection conn = null;
	 private static SuperDAO superdao = null;
	Scanner in = new Scanner(System.in);
	
	 public static SuperDAO getInstance() {
		 if(superdao == null) {
			 superdao = new SuperDAO();
		 }
		 return superdao;
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

	
	 public void insert(ChickenDTO cdto,Super s) {
		 PreparedStatement stmt = null;
			try {
				// 연결하기
				if(getConnection()!=null) {
					// 쿼리문정의
					String sql = "insert into Super values (?,?,?,?)";
					// statement 생성
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, s.getFname());
					stmt.setString(2, s.getFaddr());
					stmt.setString(3, s.getMname());
					stmt.setString(4, s.getType());
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
		   
			
			
			
			
			
			
	
	 public void select() {
	 }
		 
		 
	
	 public void delete(String fname) {
		 PreparedStatement stmt = null;
			try {
				// 연결하기
				if(getConnection()!=null) {
					// 쿼리문정의
					String sql = "delete from Super where fname = ?";
					// statement 생성
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, fname);
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
	 
	 public void updatefaddr(String fname,String faddr) {
		 PreparedStatement stmt = null;
			try {
				// 연결하기
				if(getConnection()!=null) {
					// 쿼리문정의
					String sql = "update Super set faddr = ? where fname = ?";
					// statement 생성
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, faddr);
					stmt.setString(2, fname);
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
	
	 public void updatemname(String fname,String mname) {
		 PreparedStatement stmt = null;
			try {
				// 연결하기
				if(getConnection()!=null) {
					// 쿼리문정의
					String sql = "update Super set mname = ? where fname = ?";
					// statement 생성
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, mname);
					stmt.setString(2, fname);
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
