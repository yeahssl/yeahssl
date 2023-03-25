package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

	/** 사번과 일치하는 사원 정보 반환 서비스
	 * @param input
	 * @return emp
	 * @throws SQLException
	 */
	public Emp selectOne(int input) throws SQLException{
		
		Connection conn = getConnection();
		
		Emp emp = dao.selectOne(conn,input);
		
		close(conn);
		
		return emp;
	}

	/** 사원 정보 삽입 서비스
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int addEmp(Emp emp) throws SQLException {
		
		Connection conn = getConnection();
		
		int result = dao.addEmp(conn,emp);
		
		if(result > 0)
			commit(conn);
		
		else
			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 사번으로 사원 정보 수정 서비스
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmp(Emp emp) throws SQLException {
		
		// 반환형이 int인 이유
		// -> DML 수행 결과는 반영된(성공) 행의 개수 반환
		// --> 행의 개수는 정수형 --> int 사용
		
		Connection conn = getConnection();
		
		int result = dao.updateEmp(conn,emp);
		
		if(result > 0)
			commit(conn);
		
		else
			rollback(conn);
		
		close(conn);
		
		return result;
		
	
	}

	/** 사원 정보 삭제 서비스
	 * @param input
	 * @return result
	 * @throws Exception
	 */
	public int deleteEmp(int input) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteEmp(conn,input);
		
		if(result > 0)
			commit(conn);
		
		else
			rollback(conn);
		
		close(conn);
		
		return result;
		
	}
	
	

	/** 존재하는 사원인지, 퇴직한 사원인지 결과를 반환하는 서비스
	 * @param input
	 * @return check (0 : 없는 사원, 1 : 퇴직한 사원, 2 : 재직중인 사원)
	 * @throws SQLException
	 */
	public int checkEmployee(int input) throws SQLException{
		
		Connection conn = getConnection();
		
		int check = dao.checkEmployee(conn,input);
		
		close(conn);
		
		return check;
	}

	/** 퇴직 사원 결과 반환
	 * @param input
	 * @throws SQLException
	 */
	public void retireEmployee(int input) throws SQLException {
		
		Connection conn = getConnection();
		
		dao.retireEmployee(conn,input); // 성공 또는 예외
		
		
		// 트랜잭션 처리
		// DB 예외 발생 시 SQL 수행이 정상적으로 진행되지 않음
		commit(conn);
	
		close(conn);
	}
	
	
	
	/** 최근 입사한 사원 5명 조회
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> maxEmp() throws SQLException {
	
		Connection conn = getConnection();
		
		List<Emp> empList = dao.maxEmp(conn);
		
		close(conn);
		
		return empList;
		
	}
	
	
	
	/** 부서별 통계 조회 서비스
	 * @return mapList
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDepartment() throws SQLException {
		
		Connection conn = getConnection();
		
		List<Map<String, Object>> mapList = dao.selectDepartment(conn);
		
		close(conn);
		
		return mapList;
		
	}

}

























