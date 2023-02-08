package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[실행화면]");
		
		System.out.printf("정수 입력 : " );
	    int input1 = sc.nextInt();
	    
	    String result = input1 > 0 ? "양수 입니다." : "음수 입니다.";
				
	    System.out.println(result);
	    
	    System.out.printf("정수 입력 : " );
	    int input2 = sc.nextInt();
	    
	    String result2 = input1 < 0 ? "양수 입니다." : "음수 입니다.";
	    
	    System.out.printf(result2);
	    
	}

}
