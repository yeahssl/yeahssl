package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.board.model.dao.BoardDAO;
import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Comment;

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


	/** 댓글 확인 서비스
	 * @param input
	 * @param memberNo
	 * @return comment
	 * @throws Exception
	 */
	public Comment selectComment(int input, int memberNo, int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		Comment comment = commentDao.selectComment(conn, input, memberNo, boardNo);
		
		if(comment.getMemberNo() == memberNo) {
			
			
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return comment;
	}


	/** 댓글 수정 서비스
	 * @param input
	 * @param string
	 * @return result
	 * @throws Exception
	 */
	public int updateComment(int input, String commentContent) throws Exception {
		
		
		Connection conn = getConnection();
		
		int result = commentDao.updateComment(conn, input, commentContent);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		close (conn);
		
		return result;
	}



	

	

}
