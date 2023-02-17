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
		
//		사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
//		배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
//		그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
//		
//		[실행 화면]
//		정수 : 5
//		배열 0번째 인덱스에 넣을 값 : 4
//		배열 1번째 인덱스에 넣을 값 : -4
//		배열 2번째 인덱스에 넣을 값 : 3
//		배열 3번째 인덱스에 넣을 값 : -3
//		배열 4번째 인덱스에 넣을 값 : 2
//		4 -4 3 -3 2 
//		총 합 : 2
		
	Scanner sc = new Scanner(System.in);
	
	System.out.printf("정수 : ");
	int input = sc.nextInt();
	
	int[] arr = new int[input];
	
	for(int i = 0; i < arr.length; i++) {
		
		System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
		int num = sc.nextInt();
		
		arr[i] = num;
		
	} int sum = 0;
	for(int i = 0; i < arr.length; i++) {
		System.out.printf(arr[i] + " ");
		
		sum += arr[i];
	}
	System.out.printf("\n총합 : %d", sum);
	
}
	
	
	public void ex7() {
//		주민등록번호를 입력 받아 char 배열에 저장한 후 출력하세요.
//		단, char 배열 저장 시 성별을 나타내는 숫자 이후부터 *로 저장하세요.
//		[실행 화면]
//		주민등록번호(-포함) : 123456-1234567
//		123456-*******
		
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호 : ");
		String num = sc.next();
		
		char[] a = new char[num.length()];
		
		
		
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
