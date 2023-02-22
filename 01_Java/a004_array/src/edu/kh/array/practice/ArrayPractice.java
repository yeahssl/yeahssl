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
	
	/* 풀이 : 스캐너 사용법
	 
	 public void scannerEx() {
	 	Scanner sc = new Scanner(System.in);
	 	
	 	// 1) next() : 한 단어 (띄어쓰기, 엔터를 만나면 입력 종료)
	 	      nextLine() : 한 문장 (엔터를 만나면 입력 종료)	
	 
	  System.out.print("입력 : "); // hello world
	  String str = sc.nextLine();
	  
	  System.out.println(str); // next() : hello
	  							  nextLine : hello world
	  							  
	  	// 2) 스캐너 입력 버퍼와 nextXXX의 의미
	  	 
	  	      입력 ->  입력 버퍼에 저장 -> nextXXX() 통해 버퍼 내용을 읽어옴
	  	
	  	      nextLine() : hello world(엔터) -> hello world -> 엔터 제거
	  	      /다음엔터/       /입력버퍼/      /nextXXX()/      후처리
	  	      
	  	      nextInt() :  100(엔터)   ->    100  
	  	      /다음정수/
	  	  	  ** next(), nextDouble(), nextInt() 등
	  	  	     모두 입력 버퍼에서 (엔터)를 제외 하고 내용만 읽어옴 **
	  	  	     
	  System.out.print("nextInt() : "); // 입력버퍼 : [ 100(엔터) ]	  	     
	  int a = sc.nextInt();
	  // 100 	  // 입력버퍼 : [ (엔터) ]	
	   
	  // 문제해결 // 
	  sc.nextLine(); 
	  
	  System.out.print("nextLine() : "); // 입력버퍼 : [ a b c (엔터) ]
	  int s = sc.nextLine();
	  // a b c // 입력버퍼 : [  ]
	  	  						  
	  System.out.println("종료");
	  // nextInt() 이후 입력 버퍼에 남아있는 엔터 때문에
	   * 다음 nextLine() 수행 시 버퍼에 남아있는 (엔터)를 읽어버리기 때문에
	   * 추가적인 입력을 시도하지 못하고 다음 코드로 넘어가는 문제 발생.
	   
	     [해결방법]
	  // 입력을 위한 nextLine() 수행 전
	   * 입력 버퍼에서 (엔터)를 제거
	   * -> 빈 공강에 sc.nextLine() 구문을 작성하면 (엔터)가 삭제됨
	   
	    
	   // 문제풀이
	    * 1. 첫 배열 크기 지정
	   
	    System.out.print("배열의 크기를 입력하세요 : ");
        int size = sc.nextInt(); // 입력 버퍼에 개행문자(엔터)가 남음
        
	    sc.nextLine(); // 입력 버퍼에 남은 개행문자(엔터) 제거
	    
	    * 2. 첫 배열 생성
	    String[] books = new String[size];
	    
	    * 3. 첫 배열에 저장할 문자열 입력 받기
	    for (int i = 0; i < books.length; i++) {
            System.out.print((i + 1) + "번째 문자열 : ");
            books[i] = sc.nextLine(); // 입력 버퍼에서 다음 엔터까지 읽어옴
        }
        
        * 4. n이 입력 될 때까지 무한 반복 -> n 입력 시 break
        while (true) {
            System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
            char ch = sc.next().charAt(0);
            
            if(ch == 'N') {
            	break;
            }
            
        * 5. 더 입력 받을 개수 입력
           
                System.out.print("더 입력하고 싶은 개수 : ");
                int addSize = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
                
                
        * 6. 기존 배열보다 늘어난 개수만큼 큰 새 배열 생성        
                
                String[] newBooks = new String[books.length + addSize];
        
        * 7. 깊은 복사를 통해 기존 배열 내용을 새 배열로 복사
				
				System.arraycopy(books, 0, newBooks, 0, books.length);
				
		* 8. 새 배열의 빈간 부터 새로운 입력을 받아서 저장
	
                for (int i = books.length; i < newBooks.length; i++) {
                    System.out.print((i + 1) + "번째 문자열 : ");
                    newBooks[i] = sc.nextLine();
                }
		* 9. 기존 참조배열 books에 newBooks의 주소를 얕은 복사
		 	
		 	books = newBooks;
		 	
		// while 종료
		 
		*10. 배열에 저장된 모든 값 출력
		 
		 	System.out.println(Arrays.toString(books));
	    
	    
	  */  
	
		
	
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
	
	/*풀이
		
	// 1. 4행 4열 2차원 배열 생성
	int [][] arr = new int[4][4];
	
	final int LAST_ROW_INDEX = arr.length - 1; // 행 마지막 인덱스
	final int LAST_COL_INDEX = arr[0].length - 1; // 열 마지막 인덱스
	
	// 2. 0행 0열 ~ 2행 2열 까지 1~10 사이 난수 대입
	Random random = new Random();
		
//  random.nextInt(); 0이상 1미만 정수		
	
	for() {int row=0; row <LAST_ROW_INDEX; row++) {
		for() {int col=0; col <LAST_COL_INDEX; col++){
			
			arr[row][col] = random.nextInt(10) + 1;
			
			// 3행 3열에 발생된 난수 모두 누적
			arr[LAST_ROW_INDEX][LAST_COL_INDEX] += arr[row][col];
			
			// 난수 대입과 동시에 해당 행/열의 끝에 누적
			arr[row][LAST_COL_INDEX] += arr[row][col]; // 각 행 마지막 열에 누적
			arr[LAST_ROW_INDEX][col] += arr[row][col]; // 각 행 마지막 열에 누적
			}
		}
	
	// 출력용 2중 for문 
	for() {int row=0; row <LAST_ROW_INDEX; row++) {
		for() {int col=0; col <LAST_COL_INDEX; col++){
			System.out.printf("%3d", arr[row][col])
		}
	}	

}
	*/
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
