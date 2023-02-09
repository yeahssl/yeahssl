package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("국어 : " );
	    int k = sc.nextInt();
	    
	    System.out.printf("영어 : " );
	    int e = sc.nextInt();
	    
	    System.out.printf("수학 : " );
	    int m = sc.nextInt();
		
	    System.out.println("합계 : " + (k + e + m) );
	    System.out.printf("평균 : %.1f \n", (k + e + m)/3.0 );
	    
	    String r = k >= 40 && e >= 40 && m >= 40 && (k + e + m)/3.0 >=60 ? "합격":"불합격";
	    System.out.println(r);
	 
	    
	    // 풀이
	    
	    // System.out.print("국어 : " );
	    // int kor = sc.nextInt();
	    
	    // System.out.print("영어 : " );
	    // int eng = sc.nextInt();
	    
	    // System.out.print("수학 : " );
	    // int math = sc.nextInt();
	    
	    // (합계) int sum = kor + eng + math;
	    // (평균) double avg = sum / 3.0(double);
	    
	    // String result = (k >= 40 && e >= 40 && m >= 40 && (k + e + m)/3.0 >=60) 
	    //					? "합격":"불합격";
	    
	    // System.out.println("합계 : "+ sum);
	    // System.out.printf("평균 : %.1f \n", avg);
	    // System.out.println(result);
	    
	}

}
