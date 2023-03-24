package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dto.Emp;

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	/** 재직 중인 사원 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectAll(Connection conn) throws SQLException {
		
		// 1. 결과 저장 변수/ 객체 
		List<Emp> empList = new ArrayList<>();
		
		try {
			// 2. Statement, ResultSet에 객체 대입 
			// 1) SQL 작성
			
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, PHONE, EMAIL\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE ENT_YN = 'N'"
					+ "ORDER BY JOB_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 3. 조회 결과 컬럼값 List에 담기
			
			while(rs.next()) { // 행이 여러개가 나올 가능성이 있기 때문에 반복문을 사용한다.
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String departmentTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				// setter를 사용하여 결과를 담으면 매개변수 생성을 하지 않아도 된다.
				
				
				
				Emp emp = new Emp(Integer.parseInt(empId), empName, departmentTitle,
						jobName,salary,phone,email);
				
				empList.add(emp);
				
			}
			
			
		} finally {
			
			// 4.JDBC 객체 자원 반환 ( conn 제외 )
			
			close(rs);
			close(stmt);
			
		}
		
		// 5. 결과 반환
		return empList;
	}


	/** 퇴사한 사원 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectRetire(Connection conn) throws SQLException{
		
		List<Emp> empList = new ArrayList<>();
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, PHONE, EMAIL, TO_CHAR(ENT_DATE, 'YYYY\"년\"MM\"월\" DD\"일') ENT_DATE\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "WHERE ENT_YN = 'Y'\r\n"
					+ "ORDER BY ENT_YN";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String entDate = rs.getString("ENT_DATE"); // TO_CHAR로 형변환 해서 조회
				
				Emp emp = new Emp(empId,empName,phone,email,entDate);
				
				empList.add(emp);
				
			}
			
		} finally {
			
			close(rs);
			close(stmt);
		}
		
		return empList;
	}


	/** 사번이 일치하는 사원 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @param input
	 * @return emp
	 * @throws SQLException
	 */
	public Emp selectOne(Connection conn, int input) throws SQLException{
		
		Emp emp = null;
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, PHONE, EMAIL, HIRE_DATE, ENT_YN \r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE EMP_ID = "+input;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String departmentTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				Date hireDate = rs.getDate(8);
				String entYn = rs.getString(9);
				
				emp = new Emp(empId,empName,departmentTitle,jobName,salary,phone,
						email, hireDate, entYn);
			} 
		} finally {
			
			close(rs);
			close(stmt);
			
		}
		
		return emp; // 조회 결과가 있으면 null이 아님
					// 조회 결과가 없으면 null
	}


	/** 사원 정보를 삽입하는 SQL 수행 후 결과 행 개수 반환하는 메서드
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int addEmp(Connection conn, Emp emp) throws SQLException {
		
		int result = 0;
		
		try {
		
		String sql = "INSERT INTO EMPLOYEE VALUES(SEQ_EMP_ID.NEXTVAL,"
				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, emp.getEmpName());
		pstmt.setString(2, emp.getEmpNo());
		pstmt.setString(3, emp.getEmail());
		pstmt.setString(4, emp.getPhone());
		pstmt.setString(5, emp.getDeptCode());
		pstmt.setString(6, emp.getJobCode());
		pstmt.setString(7, emp.getSalLevel());
		pstmt.setInt(8, emp.getSalary());
		pstmt.setDouble(9, emp.getBonus());
		pstmt.setInt(10, emp.getManagerId());
		
		result = pstmt.executeUpdate();
		
		
		} finally {
			
			close(pstmt);
			
		} 
		return result;
	}


	/** 사번이 일치하는 사원 정보 수정 SQL 수행 후 결과 반환
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmp(Connection conn, Emp emp) throws SQLException {
		
		// 1. 결과 저장용 변수/ 객체 선언
		int result = 0;
		
		
		try {
		
			// 2. SQL 구문 작성
			//    PreparedStatement / Statement 생성
			String sql = "UPDATE EMPLOYEE\r\n"
					+ "SET PHONE = ?, \r\n"
					+ "	EMAIL = ?,\r\n"
					+ "	SALARY = ?,\r\n"
					+ "	BONUS = ?\r\n"
					+ "WHERE EMP_ID = ?";
		
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getPhone());
			pstmt.setString(2, emp.getEmail());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setDouble(4, emp.getBonus());
			pstmt.setInt(5, emp.getEmpId());
			
		
			// 3. 수행 후 결과 반환 받아 결과 저장용 변수에 저장
			//    SELECT문 : executeQuery([SQL]), 
			//    DML문	   : executeUpdate([SQL])
			//    [SQL] 작성하는 경우 : Statement 객체 사용 할 때

			result = pstmt.executeUpdate();
			
		
		// 4. JDBC 객체 자원 반환
		} finally {
			close(pstmt);

		}
		
		// 5. 결과 반환
		return result;
	}


	/** 사원 정보 삭제 SQL 수행 후 결과 반환
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public int deleteEmp(Connection conn, int input) throws SQLException {

		
		int result = 0;
		
		
	}


	/** 존재하는 사원인지 ,퇴직한 사원인지 조회하는 SQL 수행 후 결과 반환
	 * @param conn
	 * @param input
	 * @return check
	 * @throws SQLException
	 */
	public int checkEmployee(Connection conn, int input) throws SQLException{
		int check = 0;
		
		try {
			String sql = "SELECT CASE \r\n"
					+ "   WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ?) = 0\r\n"
					+ "   THEN 0\r\n"
					+ "   WHEN (SELECT COUNT(*) FROM EMPLOYEE \r\n"
					+ "        WHERE EMP_ID = ? AND ENT_YN = 'Y') = 1\r\n"
					+ "   THEN 1\r\n"
					+ "   ELSE 2\r\n"
					+ "   END \"CHECK\"\r\n"
					+ "FROM DUAL";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			pstmt.setInt(2, input);
				
			rs = pstmt.executeQuery();	
				
			
			if(rs.next()) {
				check = rs.getInt("check");
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return check;
	}


	/** 퇴직처리 SQL 수행
	 * @param conn
	 * @param input
	 * @throws SQLException
	 */
	public void retireEmployee(Connection conn, int input) throws SQLException{
		
		try {
			String sql = "UPDATE EMPLOYEE \r\n"
					+ "SET ENT_YN = 'Y',\r\n"
					+ "	ENT_DATE = SYSDATE \r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			pstmt.executeQuery();
			
			
		} finally {
			close(pstmt);
			
		}
		
	}

	/** 최근 입사한 사원 5명 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> maxEmp(Connection conn) throws SQLException {
		
		List<Emp> empList = new ArrayList<>();
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, HIRE_DATE FROM\r\n"
					+ "	(SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE,'부서없음')DEPT_TITLE, HIRE_DATE\r\n"
					+ "	FROM EMPLOYEE \r\n"
					+ "	LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "	ORDER BY HIRE_DATE DESC)\r\n"
					+ "WHERE ROWNUM <= 5";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
		while(rs.next()) {
			
			int empId = rs.getInt("EMP_ID");
			String empName = rs.getString("EMP_NAME");
			Date hireDate = rs.getDate("HIRE_DATE");
			String departmentTitle = rs.getString("DEPT_TITLE");
			
			Emp emp = new Emp(empId,empName,hireDate,departmentTitle);
			
			empList.add(emp);
			
		}	
			
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return empList;
	}
	
	/** 부서별 통계 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return mapList
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDepartment(Connection conn) throws SQLException {

		// 1. 결과 저장용 객체 생성
		List<Map<String, Object>> mapList= new ArrayList<>();
		
		try {
			
			// 2. SQL 작성 후 수행

			String sql = "SELECT DEPT_CODE, NVL(DEPT_TITLE, '부서없음')DEPT_TITLE, COUNT(*) 인원, FLOOR(AVG(SALARY)) 평균\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)\r\n"
					+ "GROUP BY DEPT_CODE, DEPT_TITLE\r\n"
					+ "ORDER BY DEPT_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String deptTitle = rs.getString("DEPT_TITLE");
				int count = rs.getInt("인원");
				int avg = rs.getInt("평균");
				
				Map<String, Object> map = new LinkedHashMap<>();
											// 입력 순서가 유지되는 Map
				
				
				map.put("deptTitle", deptTitle);
				map.put("count", count);
				map.put("avg", avg);
				
				//Map을 List에 추가
				mapList.add(map);
				
			} 
			
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		// 5. 결과 반환
		return mapList;
	}

}

