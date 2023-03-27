package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee2;

public class SelectjobNameDAO {

	private Object jobName;

	/**
	 * @param jobName
	 * @return empList
	 */
	public List<Employee2>  select(String jobName) {
		
		List<Employee2> empList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost";
			String port = ":1521";
			String dbName = ":ORCL";
			String user = "kh_lys";
			String pw = "oracle_lys5034A";
			
			conn = DriverManager.getConnection(type+ip+port+dbName, user, pw );
			
			
			String sql = "SELECT NVL(DEPT_TITLE,'부서없음'), JOB_NAME, EMP_NAME, EMAIL "
					+ "FROM EMPLOYEE "
					+ "JOIN JOB USING (JOB_CODE) "
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) "
					+ "WHERE JOB_NAME = '" + jobName + "'"
					+ "ORDER BY JOB_NAME";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
		while(rs.next()) {
			
			String departmentTitle = rs.getString(1);
			String jobName1 = rs.getString(2);
			String empName = rs.getString(3);
			String email = rs.getString(4);
		
			Employee2 emp = new Employee2(departmentTitle, jobName1, empName, email);
			
			empList.add(emp);
			
		}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				 if( rs != null) rs.close();
				 if( stmt != null) stmt.close();
				 if( conn != null) conn.close();
				
			}catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		
		
		return empList;
	
	
	}
}
