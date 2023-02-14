package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPractice {

	public void ex1() {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
			if(i%2==0) {
				sum += arr[i];
			}
		}
			System.out.printf("\n짝수 번째 인덱스 합 : %d" , sum);
	} 
		
	public void ex2() {
		int[] arr = {9,8,7,6,5,4,3,2,1};
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
			if((i-1)%2==0) {
				sum += arr[i];
			}
		}
			System.out.printf("\n홀수 번째 인덱스 합 : %d" , sum);
	}
	

	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		for(int i=0 ; i<arr.length; i++ ) {
			System.out.print(i+1 + " ");
		}
		
	}
	
	public void ex4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 0 : ");
		int num1 = sc.nextInt();
		
		
		
	}
	public void ex5() {
		
		
	}
	public void ex6() {
		
		
	}
	public void ex7() {
		
		
	}
	public void ex8() {
		
		
	}
	public void ex9() {
		
		
	}
	public void ex10() {
		
		
	}
	public void ex11() {
		
		
	}
	public void ex12() {
		
		
	}
	public void ex13() {
		
		
	}
	public void ex14() {
		
		
	}
	public void ex15() {
		
		
	}
	public void ex16() {
		
		
	}
	public void ex17() {
		
		
	}
	public void ex18() {
		
		
	}
	public void ex19() {
		
		
	}
	public void ex20() {
		
		
	}
	public void ex21() {
		
		
	}
	public void ex22() {
		
		
	}
	public void ex23() {
		
		
	}
	public void ex24() {
		
		
	}
}
