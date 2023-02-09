package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		// 정수를 입력받아 양수/음수/0을 구분하세요.
		
		System.out.println("[실행화면]");
		
		System.out.printf("정수 입력 : " );
	    int input1 = sc.nextInt();
	    
	    String result = input1 > 0 ? "양수 입니다." : "음수 입니다.";
				
	    System.out.println(result);
	    
	    System.out.printf("정수 입력 : " );
	    int input2 = sc.nextInt();
	    
	    String result2 = input1 < 0 ? "양수 입니다." : "음수 입니다.";
	    
	    System.out.printf(result2);
	    
	    
	    // 풀이 (input == 0 ? "0" : (input > 0 ? : "양수" : "음수");
	    // System.out.print("정수 입력 : " );
	    // int input1 = sc.nextInt();
	    
	    // String result = input == 0 ? "0" : (input > 0 ? : "양수" : "음수"); 
	    // System.out.println(result + "입니다.")
	    
	}	    
}
