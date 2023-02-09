package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPractice {
	public void practice1 () {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		int input = sc.nextInt();
		
		
		String result;
		
		switch(input) {
		case 1 : if(input > 0 && input % 2  == 0) {		
			System.out.println("짝수 입니다.");
		} else {
			System.out.println("홀수입니다.");
		} break;
		default : 
		    System.out.println("양수만 입력해주세요."); break;
		}
	}

	
	public void practice2 () {
		
	}
	
	public void practice3 () {
		
	}
	
	public void practice4 () {
		
	}
	
	public void practice5 () {
		
	}

}
