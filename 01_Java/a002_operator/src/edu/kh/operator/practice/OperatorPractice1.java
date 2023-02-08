package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[실행화면]");
		
		System.out.print("인원 수 : ");
		int input1 = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int input2 = sc.nextInt();
		
		
		System.out.print("1인당 사탕 개수 : " );
		System.out.println(input2/input1);
		

		System.out.print("남는 사탕 개수 : " );
		System.out.println(input2 % input1);
		
	
	}

}
