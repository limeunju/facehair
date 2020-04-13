package com.kh.jsp.member.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static com.kh.jsp.common.JDBCTemplate.*;
import com.kh.jsp.member.model.vo.Member;

public class MemberDAO {
	
	private Properties prop = new Properties();
	
	public MemberDAO() {
		try {
			prop.load(new FileReader(
						MemberDAO.class
						.getResource("/mappers/member.properties")
						.getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Connection con, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("insertMember");
		
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getEmail());
			pstmt.setDate(5, m.getDateOfBirth());
			pstmt.setString(6, m.getGender());
			pstmt.setString(7, m.getPhone());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Member selectOne(Connection con, Member m) {
		Member result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			
			String sql  = prop.getProperty("selectMember");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = new Member();
				
				// --- 원래 알고 있던 정보
				result.setUserId(m.getUserId());
				result.setPassword(m.getPassword());
				
				// --- DB로부터 가져온 정보
				result.setUserNo(rset.getInt("USERNO"));
				result.setUserName(rset.getString("USERNAME"));
				result.setEmail(rset.getString("EMAIL"));
				result.setDateOfBirth(rset.getDate("DATEOFBIRTH"));
				result.setGender(rset.getString("GENDER"));
				result.setPhone(rset.getString("PHONE"));
				result.setEnrollDate(rset.getDate("ENROLLDATE"));
				result.setMlevel(rset.getInt("MLEVEL"));
				result.setStatus(rset.getString("STATUS"));
				
				System.out.println("result 값 확인 : " + result);
				
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updateMember(Connection con, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql  = prop.getProperty("updateMember");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getPassword());
			pstmt.setString(2, m.getUserName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection con, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql  = prop.getProperty("deleteMember");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int idDupCheck(Connection con, String userId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idDupCheck");
		
		try {
			pstmt= con.prepareCall(sql);
			
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int nameDupCheck(Connection con, String name) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("nameDupCheck");
		
		try {
			pstmt= con.prepareCall(sql);
			
			pstmt.setString(1, name);

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int emailDupCheck(Connection con, String email) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("emailDupCheck");
		
		try {
			pstmt= con.prepareCall(sql);
			
			pstmt.setString(1, email);

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

}
