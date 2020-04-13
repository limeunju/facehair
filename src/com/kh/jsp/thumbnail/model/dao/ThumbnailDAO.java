package com.kh.jsp.thumbnail.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.jsp.thumbnail.model.vo.Attachment;
import com.kh.jsp.thumbnail.model.vo.Thumbnail;
import static com.kh.jsp.common.JDBCTemplate.*;

public class ThumbnailDAO {
	private Properties prop = new Properties();

	public ThumbnailDAO() {
		try {
			prop.load(new FileReader(ThumbnailDAO.class
					.getResource("/mappers/thumbnail.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Thumbnail> selectList(Connection con) {
		ArrayList<Thumbnail> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
		
			stmt = con.createStatement();
		
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				
				Thumbnail t = new Thumbnail();
				
				t.setBno(rset.getInt("BNO"));
				t.setBtype(rset.getInt("BTYPE"));
				t.setWriter(rset.getInt("writer"));
				t.setScontent(rset.getString("scontent"));
				t.setScount(rset.getInt("SCOUNT"));
				t.setBfile(rset.getString("CHANGENAME")); // Attachment 테이블의 정보
				t.setSdate(rset.getDate("SDATE"));
				
				list.add(t);				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}		
		return list;
	}
	
	public int insertBoard(Connection con) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoard");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertThumbnail(Connection con, Thumbnail t) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertThumbnail");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, t.getWriter());
			pstmt.setString(2, t.getScontent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectCurrentBno(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCurrentBno");
		
		try {
		
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return result;
	}

	public int insertAttachment(Connection con, ArrayList<Attachment> list) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAttachment");
		
		try {
		
			for(int i = 0 ; i < list.size() ; i++) {
				
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, list.get(i).getBno());
				pstmt.setString(2, list.get(i).getOriginName());
				pstmt.setString(3, list.get(i).getChangeName());
				pstmt.setString(4, list.get(i).getFilePath());
				
				// 첫 이미지는 0 level (대표)
				// 나머지는 1 level (서브)
				
				if(i == 0) pstmt.setInt(5, 0);
				else pstmt.setInt(5, 1);
				
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}		
		
		return result;
	}

	public HashMap<String, Object> selectOne(Connection con, int bno) {
		HashMap<String, Object> hmap = null;
		Thumbnail t = null;
		ArrayList<Attachment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
		
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Attachment>();
			
			while(rset.next()) {
				
				t = new Thumbnail();
				t.setBno(bno);
				t.setBtype(rset.getInt("BTYPE"));
				t.setScontent(rset.getString("SCONTENT"));
				t.setWriter(rset.getInt("WRITER"));
				t.setScount(rset.getInt("SCOUNT"));
				// t.setBfile(rset.getString("BFILE"));
				t.setSdate(rset.getDate("SDATE"));
				t.setStatus(rset.getString("STATUS"));
				
				Attachment at = new Attachment();
				
				at.setFno(rset.getInt("FNO"));
				at.setBno(bno);
				at.setOriginName(rset.getString("ORIGINNAME"));
				at.setChangeName(rset.getString("CHANGENAME"));
				at.setFilePath(rset.getString("FILEPATH"));
				at.setFlevel(rset.getInt("FLEVEL"));
				at.setUploadDate(rset.getDate("UPLOADDATE"));
				at.setStatus(rset.getString("STATUS"));
				
				list.add(at);				
			}
			hmap = new HashMap<>();
			
			hmap.put("thumbnail", t);
			hmap.put("attachment", list);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return hmap;
	}

	public int updateThumbnail(Connection con, Thumbnail t) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateThumb");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, t.getScontent());
			pstmt.setInt(2, t.getBno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}

	public int updateAttachment(Connection con, ArrayList<Attachment> list) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAtt");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			for(int i = 0; i < list.size(); i++) {
				pstmt.setString(1, list.get(i).getOriginName());
				pstmt.setString(2, list.get(i).getChangeName());
				pstmt.setInt(3, list.get(i).getFno());
				
				result += pstmt.executeUpdate();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}	
		
		return result;
	}

	public int deleteThumbnail(Connection con, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteThumb");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
		
			close(pstmt);
			
		}
		
		return result;
	}

	public int deleteAttachment(Connection con, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteAtt");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
		
			close(pstmt);
			
		}
		
		return result;
	}

	public int addReadCount(Connection con, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("addReadCount");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}

	public int insertLike2(Connection con, int bno, int userNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("insertLike2");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, bno);
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteLike2(Connection con, int bno, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("deleteLike2");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, bno);
			
			result = pstmt.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int likeCount2(Connection con, int bno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("countLike2");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT(*)");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	
	
	
	public int likechk2(Connection con, int bno, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int chk = 0;
		String sql = "SELECT * FROM LIKEPOST WHERE WNO = ? AND BNO = ?";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, bno);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				chk = 1;
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return chk;
	}
}







