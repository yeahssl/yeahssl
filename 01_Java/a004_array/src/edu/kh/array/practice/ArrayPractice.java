package edu.kh.array.practice;

import java.util.Arrays;
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
		
		for(int i = 0 ; i < 8; i++) {
			a[i] = num.charAt(i);
		
				System.out.print(a[i]);
		} 
		for(int z = 8; z <num.length(); z++ ) {
			a[z] = num.charAt(z);
			System.out.printf("*",a[z]);
		}
		
	}
	
	public void ex8() {
		/* 3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고, 
		 * 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
		 * 딘, 입력한 정수가 홀수가 아니거나 3미만일 경우 "다시 입력하세요"를 출력하고
		 * 다시 정수를 받도록 하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			
			System.out.print("정수 : ");
		
			int num = sc.nextInt();
		
			int[] arr = new int[num];
		
			if(num >= 3 && num % 2 == 1) {
				for(int i=0; i<arr.length; i++) {
					arr[i] = i+1;
					System.out.printf("%d,",arr[i]);
				}for(int z=num-2; z>-1; z--) {
					if(z == 0) {
					System.out.printf("%d",arr[z]);	
					}else {
					System.out.printf("%d,",arr[z]);	
					}
				}break;
					} 
		}
	}
		
	
		
		
	
	public void ex9() {
		
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
		// 1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
		
		int[] arr = new int[11];
		
		
		for(int i=1; i<11; i++) {
			
			arr[i] = (int)(Math.random()*10+1);
		    
			System.out.print(arr[i] + " ");
			
		}
	}
		
	
	public void ex10() {
		
		
		int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			
			arr[i] = (int)(Math.random()*10+1);
		    
			System.out.print(arr[i] + " ");
			
		}System.out.println();
		
		int max = -1;
		int min = 11;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
				
			if(arr[i] < min) {
				min = arr[i];
			}
	
		}
		 System.out.printf("최대값 : %d\n" ,max);
		 System.out.printf("최소값 : %d" ,min);
		 
	}
	public void ex11() {
//		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
//		1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요
		
		int[] arr = new int[10];
		
		
		for(int i=0; i<arr.length; i++) {
			int num = (int)(Math.random()*10+1);
			arr[i] = num;
			for(int z=0; z<i; z++) {
			if(arr[i]==arr[z]) {
				  i--; 
				 
			}   break;
			} 
			System.out.print(arr[i] + " ");
		}
			
			} 
			
	
				
		
	
	public void ex12() {
		// 로또 번호 자동 생성기 프로그램을 만들기.
		// (중복 값 없이 오름차순으로 정렬하여 출력하세요.)
		
		int lotto[] = new int[6];
		
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45+1);
			for(int z=1; z<i; z++) {
				if(lotto[i] == lotto[z]) {
					i--;
				}
			}	
		}
			Arrays.sort(lotto);
			for(int i : lotto)
					System.out.print(i + " ");		
	}
			
	public void ex13() {
		
		
//		문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
//		문자의 개수와 함께 출력하세요. (중복 제거)
		
//		[실행 화면]
//		문자열 : application
//		문자열에 있는 문자 : a, p, l, i, c, t, o, n
//		문자 개수 : 8
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String alp = sc.next();
		
		char[] a = alp.toCharArray();
        Arrays.sort(a);

        int charCount = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i-1]) {
                charCount++;
            }
        }

        System.out.print("문자열에 있는 문자 : ");
        for (int i = 0; i < a.length; i++) {
            if (i == 0 || a[i] != a[i-1]) {
                System.out.print(a[i] + ", ");
            }
        }
        System.out.println();
        System.out.println("문자 개수 : " + charCount);
    }
	
	
	public void ex14() {
		Scanner sc = new Scanner(System.in);

        System.out.print("배열의 크기를 입력하세요 : ");
        int size = sc.nextInt();

        String[] arr = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + "번째 문자열 : ");
            arr[i] = sc.next();
        }

        while (true) {
            System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
            String input = sc.next();

            if (input.equalsIgnoreCase("y")) {
                System.out.print("더 입력하고 싶은 개수 : ");
                int count = sc.nextInt();

                
                String[] newArray = new String[size + count];
                System.arraycopy(arr, 0, newArray, 0, size);

                for (int i = size; i < size + count; i++) {
                    System.out.print((i + 1) + "번째 문자열 : ");
                    newArray[i] = sc.next();
                }

                arr = newArray;
                size += count;
            } else if (input.equalsIgnoreCase("n")) {
                break;
            }
        }

        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }
		
	
	public void ex15() {
		
		int[][] arr = new int[3][3];
			
			for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[row].length; col++) {
				System.out.print("(" + row + "," + col +")" );
				
				}
			System.out.println();
			}	
		
		}
	
	public void ex16() {
		int[][] arr = new int[4][4];
		
		int count = 1;
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col<arr[row].length; col++) {
				arr[row][col] = count;
				count++;
			}
		}
		for(int row=0; row<arr.length; row++) {
			for(int col = 0; col<arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}System.out.println();
		}
	}
	
	public void ex17() {
		int[][] arr = new int[4][4];
		
		int count = 16;
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col<arr[row].length; col++) {
				arr[row][col] = count;
				count--;
			}
		}
		for(int row=0; row<arr.length; row++) {
			for(int col = 0; col<arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}System.out.println();
		}
		
	}
	public void ex18() {
		int [][] arr = new int[4][4];
		
		for (int i = 0; i < 3; i++) {
		    for (int z = 0; z < 3; z++) {
		    	arr[i][z] = (int)(Math.random()*10+1);
		    }
		}
		for (int i = 0; i < 3; i++) {
		    int rowSum = 0;
		    int colSum = 0;
		    for (int z = 0; z < 3; z++) {
		        rowSum += arr[i][z];
		        colSum += arr[z][i];
		    }
		    arr[i][3] = rowSum;
		    arr[3][i] = colSum;
		}

		int totalSum = 0;
		for (int i = 0; i < 3; i++) {
		    totalSum += arr[3][i];
		}
		arr[3][3] = totalSum;

		for (int i = 0; i < 4; i++) {
		    for (int z = 0; z < 4; z++) {
		        System.out.print(arr[i][z] + " ");
		    }
		    System.out.println();
		}
	}
	
	public void ex19() {
		Scanner sc = new Scanner(System.in);
		System.out.print("행 크기 : ");
		int size1 = sc.nextInt();
		System.out.print("열 크기 : ");
		int size2 = sc.nextInt();
		
		int [][] arr = new int[size1][size2];
		
		
		
	}	
	

}
