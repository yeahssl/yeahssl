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
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		System.out.print("수학 : ");
		int math = sc.nextInt();
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		String result;
		int sum = kor+math+eng;
		int avg=sum/3;
		
		if(kor >=40 && math >=40 && eng >=40 && avg>=60) {
		   System.out.printf("국어 : %d\n" + "수학 : %d\n" + "영어 : %d\n" + 
				   			"합계 : %d\n" + "평균 : %d\n", kor, math, eng, sum, avg);
		   System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("불합격 입니다.");
			
	} 
}
	
	public void practice3 () {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		String result;
	
		
		switch(month) {
		case 12 : case 1 :  case 3 : case 5 : case 7 : case 8 : case 10 : result = "31일까지 있습니다."; break; 
		case 2 : result = "28일까지 있습니다."; break;
		case 4 :  case 6 :  case 11 :  result = "30일까지 있습니다."; break;
		default :  result = "잘못 입력된 달입니다."; break;	
	}
		System.out.printf(result);
	}	
	
	
	public void practice4 () {
		
	}
	
	public void practice5 () {
		
	}

}


























