package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Emp;

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	/** 전체 사원 조회 SQL 수행 후 결과 반환 메서드
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
			
			while(rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String departmentTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				
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
			
			String sql = "SELECT EMP_ID, EMP_NAME, PHONE, EMAIL, ENT_DATE\r\n"
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
				String entDate = rs.getString("ENT_DATE");
				
				Emp emp = new Emp(empId,empName,phone,email,entDate);
				
				empList.add(emp);
				
			}
			
		} finally {
			
			close(rs);
			close(stmt);
		}
		
		return empList;
	}


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
		
		
		
		
		return emp;
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


	public int deleteEmp(Connection conn, int input) {
		
		int result = 0;
		
		
		String sql = "DELETE FROM EMPLOYEE\r\n"
				+ "WHERE EMP_ID = ?";
		
		pstmt = conn.prepareStatement(sql);
		
		
	
		
		
		
		
		return result;
	}
}











