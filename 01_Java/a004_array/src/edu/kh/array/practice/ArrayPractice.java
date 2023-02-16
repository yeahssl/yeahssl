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
		
		int[] arr = new int[5];
		Scanner sc = new Scanner(System.in);
		
		
		for(int i=0; i<5; i++) {
			System.out.printf("입력 %d : ", i);
			arr[i]= sc.nextInt();
		}
			System.out.print("검색할 값 : ");
			int search = sc.nextInt();
			int index = 0;
		
			boolean flag = true;
			
			for(int i=0; i<arr.length; i++) {
				if(search == arr[i]) {
					index = i;
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("존재하지 않습니다.");
			} else {
				System.out.printf("인덱스 : %d", index);
			}
		}
		
	
	public void ex5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.next();
		
		System.out.print("문자 : ");
		char a = sc.next().charAt(0);
		
		System.out.printf("%s에 %s가 존재하는 위치(인덱스) : ", str, a);
		
		char[] b = new char[str.length()];
		int count = 0;
		
		for(int i = 0 ; i < b.length; i++) {
			b[i] = str.charAt(i);
			if( b[i] == a ) {
				System.out.print(i + " ");
				count++;
			}
		} System.out.printf("\n %s 개수 : %d" ,a , count );
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
