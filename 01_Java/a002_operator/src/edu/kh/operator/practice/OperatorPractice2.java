package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
	// 키보드로 입력 받은 값들을 변수에 기록하고 저장된 변수 값을 화면에 출력하여 확인하세요.	
		
	    System.out.printf("이름 : " );
	    String input1 = sc.next();
	    
	    System.out.printf("학년(정수) : " );
	    int input2 = sc.nextInt();
		
	    System.out.printf("반(정수) : " );
	    int input3 = sc.nextInt();		
		
	    System.out.printf("번호(정수) : " );
	    int input4 = sc.nextInt();
	    
	    System.out.printf("성별(남학생/여학생) : " );
	    String input5 = sc.next();
	    
	    System.out.printf("성적(소수점 아래 둘째 자리까지) : " );
	  
	    double input6 = sc.nextDouble();
	    
	    System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다." 
	    ,input2, input3, input4, input1, input5, input6); 
	   
	    
	    // 풀이
	    // System.out.printf("이름 : " );
	    // String input1 = sc.next();
	    
	    // System.out.print("학년(정수) : " );
	    // int input2 = sc.nextInt();
		
	    // System.out.print("반(정수) : " );
	    // int input3 = sc.nextInt();		
		
	    // System.out.print("번호(정수) : " );
	    // int input4 = sc.nextInt();
		// System.out.printf("이름 : " );
		// String input1 = sc.next();
		//	    
		// System.out.printf("학년(정수) : " );
		// int input2 = sc.nextInt();
		//		
		// System.out.printf("반(정수) : " );
		// int input3 = sc.nextInt();		
		//		
		// System.out.printf("번호(정수) : " );
		// int input4 = sc.nextInt();
		//	    
		// System.out.printf("성별(남학생/여학생) : " );
		// String input5 = sc.next();
		//	    
		// System.out.printf("성적(소수점 아래 둘째 자리까지) : " );
		//	  
		// double input6 = sc.nextDouble();
		//	    
		// System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다." 
		// ,input2, input3, input4, input1, input5, input6); 
	   
	    // System.out.print("성별(남학생/여학생) : " );
	    // String input5 = sc.next();
	    
	    // System.out.print("성적(소수점 아래 둘째 자리까지) : " );
	    // double input6 = sc.nextDouble();
	    
	    // System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다." 
	    // ,input2, input3, input4, input1, input5, input6); 
	   
	    
	}

}
