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
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("숫자 : ");
		int input = sc.nextInt();
		
		if(input >= 2 && input <= 9) {
			for(int i = input; i <= 9; i++) {
			    System.out.printf("==== %d단 ==== \n", i);
			    for(int x = 1 ; x <= 9; x++) {	    
			    System.out.printf(" %d * %d = %2d \n", i, x, i*x);
			    }
			   }
			}else{
				System.out.println("2~9 사이 숫자만 입력해주세요");
	     	} 
		
	}
	
	
	public void practice7() {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int x = 1 ; x<=input; x++ ) {
			for(int i=1 ; i<=x ; i++) { 
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	public void practice8() {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int x = input ; x>=1; x-- ) {
			for(int i=x ; i>=1 ; i--) { 
				System.out.print("*");
			}
			System.out.println();
		}
	}

	
	
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수 입력 : ");
		int input = sc.nextInt();
		
		for( int z = 1 ; z <= input ; z++ ) {
			for(int x = input-1 ; x>=z; x-- ) {
				System.out.print(" ");}
			for(int x = 1 ; x<=z ; x++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}

		
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수 입력 : ");
		int input = sc.nextInt();
		
			for( int z=1; z<=input; z++) {
				for(int i=1; i<=z; i++) {
					System.out.print("*");
				}
			System.out.println();
			} for(int z=input; z>=2; z--) {
				for(int i=z; i>=2; i--) {
					System.out.print("*");
				}
			System.out.println();
		}
	}

	public void practice11() {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수 입력 : ");
		int input = sc.nextInt();
		
		for( int z = 1 ; z <= input ; z++ ) {
			for(int x = input-1 ; x>=z; x-- ) {
				System.out.print(" ");}
			for(int x = 1 ; x<=(z*2)-1 ; x++) {
				System.out.printf("*");
			}
			System.out.println();
		}
			
	}
		
	
	public void practice12() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수 입력 : ");
		int input = sc.nextInt();
		
	
		for(int z=input*1; z<=input; z++) {
			for(int i=1; i<=z; i++) {
				System.out.print("*");
			    }
			for(int i=z; i>=0; i--) {
				System.out.printf("*");
			  }
			System.out.println();
		  }
			for(int z1=input*1; z1<=input; z1++) {
				for(int i1=1; i1<=z1; i1++) {
					System.out.printf("*");
	   }
	}
}
		
		
		
		
		
		
		
	
	
	
	public void practice13() {
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
}



















