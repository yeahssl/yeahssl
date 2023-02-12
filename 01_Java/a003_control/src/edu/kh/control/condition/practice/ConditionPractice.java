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
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int input = sc.nextInt();
		
		System.out.print("수학점수 : ");
		int input2 = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int input3 = sc.nextInt();
		
		String res;
		
		int sum = input + input2 + input3;
		double avg = sum / 3.0;
		
		switch(input) {
		case 1 : if( input >= 40 && input2 >= 40 && input3 >= 40 && avg >= 60 ) {
    		System.out.printf("%d : %d ");
			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.printf("%d %s %d = %d", num1, op, num3, num1/num3);
		}break;
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public void practice3 () {
		
	}
	
	public void practice4 () {
		
	}
	
	public void practice5 () {
		
	}

}
