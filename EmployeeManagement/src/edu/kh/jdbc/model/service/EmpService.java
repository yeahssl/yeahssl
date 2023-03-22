package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {

	private EmpDAO dao = new EmpDAO();

	/** 현재 재직중인 전체 사원 정보 반환 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectAll() throws SQLException {
		
		// 1. 커넥션 생성
		
		Connection conn = getConnection();
		
		// 2. DAO의 메서드를 호출하여 필요한 결과를 DB에서 조회해서 반환 받기
		
		List<Emp> empList = dao.selectAll(conn);
		
		// 3. Connection 반환
		close(conn);
		
		// 4. 결과 반환
		return empList;
	}

	/** 퇴사한 사원 정보 반환 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectRetire() throws SQLException{
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectRetire(conn);
		
		close(conn);
		
		return empList;
	}

	public Emp selectOne(int input) throws SQLException{
		
		Connection conn = getConnection();
		
		Emp emp = dao.selectOne(conn,input);
		
		close(conn);
		
		return emp;
	}
}

























