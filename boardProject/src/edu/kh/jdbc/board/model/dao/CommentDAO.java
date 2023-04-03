package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Comment;

public class CommentDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public CommentDAO() {
	
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("comment-sql.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 댓글 목록 조회 SQL 수행
	 * @param conn
	 * @param input
	 * @return commentList
	 * @throws Exception
	 */
	public List<Comment> selectCommentList(Connection conn, int input) throws Exception{
		
		// 결과 저장용 객체 생성
		List<Comment> commentList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectCommentList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Comment c = new Comment();
				
				c.setCommentNo(rs.getInt(1));
				c.setCommentContent(rs.getString(2));
				c.setMemberNo(rs.getInt(3));
				c.setMemberName(rs.getString(4));
				c.setCreateDate(rs.getString(5));
				
				commentList.add(c); // 리스트에 추가
				
			}
		
		} finally {

			close(rs);
			close(pstmt);
		
		}
		
		return commentList;
	}

	/** 댓글삽입 SQL 수행
	 * @param conn
	 * @param commentContent
	 * @param boardNo
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int insertComment(Connection conn, String commentContent, 
										int boardNo, int memberNo) throws Exception{
		
		int result = 0;
		
		try { 
			String sql = prop.getProperty("insertComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, boardNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);
		
		}
		
		return result;
	}

	/** 게시글에 작성된 댓글 조회 SQL 수행
	 * @param conn
	 * @param input
	 * @return comment
	 * @throws Exception
	 */
	public Comment selectComment(Connection conn, int input, int memberNo, int boardNo) throws Exception{
		
		Comment comment = null;
		
		try {
			
			String sql = prop.getProperty("selectComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, boardNo);
			pstmt.setInt(3, input);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			
				int commentNo = rs.getInt("COMMENT_NO");

				comment = new Comment();
				
				comment.setCommentNo(commentNo);
				
				}
				
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return comment ;
	}

	/** 댓글 수정 SQL 수행
	 * @param conn
	 * @param input
	 * @param commentContent
	 * @return result
	 * @throws Exception
	 */
	public int updateComment(Connection conn, int input, String commentContent) throws Exception {
		
		int result = 0;
		
		try {
		
			String sql = prop.getProperty("updateComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, input);
			
			result = pstmt.executeUpdate();
			
		} finally {
		
		close(pstmt);
			
		}
		
		return result;
	}

	/** 일치여부 SQL 실행
	 * @param conn
	 * @param input
	 * @param boardNo
	 * @param memberNo
	 * @return check
	 * @throws Exception
	 */
	public int check(Connection conn, int input, int boardNo, int memberNo) throws Exception{
		
		int check = 0;
		
		try {
			String sql = prop.getProperty("check");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, input);
			
			check = pstmt.executeUpdate();

		} finally {
			
			close(pstmt);
			
		}
		
		return check;
	}

	/** 댓글 삭제 SQL 수행
	 * @param conn
	 * @param input
	 * @return result
	 * @throws Exception
	 */
	public int deleteComment(Connection conn, int input) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			result = pstmt.executeUpdate();
		
		} finally {
			close(pstmt);
		
		}
		
		return result;
	}

}










