package edu.kh.jdbc.run;

import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.dao.SelectjobNameDAO;
import edu.kh.jdbc.dto.Employee1;
import edu.kh.jdbc.dto.Employee2;

public class JDBCExample4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("직급명 입력 : ");
		String input = sc.nextLine();
		
		// DAO 생성 후 메서드 호출
		
		SelectjobNameDAO dao = new SelectjobNameDAO();
		
		List<Employee2> empList =  dao.select(input);
		
		if(empList.isEmpty()) {
			System.out.println("일치하는 직급명이 없습니다.");
			return;
		}
		
		for(Employee2 emp : empList) {
			
			System.out.printf("%s / %s / %s / %s \n", 
					emp.getDepartmentTitle(),
					emp.getJobName(),
					emp.getEmpName(),
					emp.getEmail());
		}
	}
}
