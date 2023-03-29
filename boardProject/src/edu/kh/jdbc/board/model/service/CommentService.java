package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.board.model.dao.BoardDAO;
import edu.kh.jdbc.board.model.dao.CommentDAO;

public class CommentService {

	private CommentDAO commentDao = new CommentDAO();
	
	private BoardDAO dao = new BoardDAO();
	
	
	/** 댓글 삽입 서비스
	 * @param string
	 * @param boardNo
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int insertComment(String commentContent, int boardNo, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = commentDao.insertComment(conn, commentContent, boardNo, memberNo);
		
		if(result > 0) commit(conn);
		else 		   rollback(conn);
		
		close(conn);
		
		return result;
	}



	
	public int updateComment(int input, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = commentDao.updateComment(conn, input, memberNo);
		
		if(result > 0) commit(conn);
		else 		   rollback(conn);
		
		close(conn);
		
		return result;
		

	}
	
	/** 댓글 수정
	 * @param input
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */

	public int updateComment(int input, String  commentContent, int memberNo) {
		
		
		Connection conn = getConnection();
		
		int result = commentDao.updateComment(conn, commentContent, memberNo);
		
		if(result > 0) commit(conn);
		else 		   rollback(conn);
		
		close(conn);
		
		return result;
	}

}
