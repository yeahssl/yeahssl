package edu.kh.jdbc.run;

// 다른 패키지 안의 클래스를 사용하기 위해서는 클래스 이름 앞에 패키지를 붙여야 합니다. 
// 하지만 다른 패키지에 속한 클래스의 이름 앞에 매번 패키지 이름을 붙이는 것은 상당히 번거로운 작업이기 때문에 
// 파일의 앞머리에 임포트(import)라는 작업으로 패키지를 매번 입력하는 단점을 없애 줄 수 있습니다.


// JDBCTemplate에 존재하는 static 필드/메서드를 가져와서 사용
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.kh.jdbc.common.JDBCTemplate;

public class TestRun {
	public static void main(String[] args) {
		
		// JDBCTemplate 사용 예시
		
		// 1. JDBC 객체 참조 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			// 2. 참조 변수에 알맞은 객체 타입
			
			conn = getConnection();
			
			// SQL 작성
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY FROM EMPLOYEE";
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL(select) 수행 후 결과(ResultSet) 반환
			rs = stmt.executeQuery(sql);
			
			// 3. 조회 결과의 행을 반복 접근하며 출력
			while(rs.next()) {
				// rs.next() : 커서를 다음 행으로 이동하여 다음 행이 존재하면 true 반환 
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				
				System.out.printf("%s / %s / %d \n", empId, empName, salary);
				
			}
			
		} catch(Exception e)  {
			e.printStackTrace();
			
		} finally {
			
			// 4. 사용한 JDBC 객체 자원 반환
			close(rs);
		    close(stmt);
			close(conn);
		}
	}
}