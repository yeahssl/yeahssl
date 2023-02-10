package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForPractice {

	public void practice1() {
		Scanner sc = new Scanner(System.in);

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();

		if (num >= 1) {
			for (int i = 1; i <= num; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}
	}

	public void practice2() {
		Scanner sc = new Scanner(System.in);

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();

		if (num >= 1) {
			for (int i = num; i >= 1; i--) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 하나 입력하세요. : ");
		int num = sc.nextInt();

		int sum = 0;  // 합계용 변수
		
			for (int i = 1; i <= num; i++) {
				sum += i;
				System.out.print(i);
			if( i != num) {
				System.out.print(" + ");
			}
		}
			System.out.println(" = " + sum);
	}
	
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);

		System.out.print("첫 번째 숫자 : ");
		int num = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
	   if(num >=1 && num2 >=1) {
		   for(int i=1; i<=num; i++){
			   System.out.print(i + " ");
		   } 
	   } else {
		   System.out.println("1 이상의 숫자를 입력해 주세요");
	   }
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);	
		System.out.printf("숫자 : ");
		int input = sc.nextInt();
		System.out.println("==== 4단 ====");
		
		
		for(int i = 1; i <= 9; i++) {
			System.out.printf(" %d * %d = %2d \n", input, i, input*i);
			
		}
		
		
		
	}
	
	
	public void practice6() {

	}
	public void practice7() {
		
	}
	public void practice8() {
		
	}
	public void practice9() {
		
	}
	public void practice10() {
		
	}
	public void practice11() {
		
	}
	public void practice12() {
		
	}

	
	
	
	
}
