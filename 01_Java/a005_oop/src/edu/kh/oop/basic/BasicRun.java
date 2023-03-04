package edu.kh.oop.basic;

public class BasicRun {

	public static void main(String[] args) {

		// Java에서의 Object == 클래스의 정의된 내용을 토대로 
		//						new 연산자를 통해 메모리에 생성되는 것
		
		// 국민 객체 생성
		Nation n1 = new Nation(); // Nation n1이라는 참조형 변수를 new Nation에 대입시키겠다는 뜻.
		Nation n2 = new Nation();
		Nation n3 = new Nation();
		
		//n1.pNo = "990123-1234567";
		n1.setpNo("990123-1234567(간접 접근 이용)");
		
		
		n1.name = "홍길동";
		n1.gender = '남';
		n1.adress = "서울시 중구 남대문로 120";
		n1.phone = "010-1234-1234";
		n1.age = 25;
		
		
		// 객체의 속성에 저장된 값 출력
//		System.out.println(n1.pNo);

		System.out.println( n1.getpNo() );
		System.out.println(n1.name);
		System.out.println(n1.gender);
		System.out.println(n1.adress);
		System.out.println(n1.phone);
		System.out.println(n1.age);
	
		// 객체의 기능 호출하기
		n1.medicalBenefits();
		n1.speakKorean();
		
		
	}
//  [출력화면]
//	990123-1234567(간접 접근 이용)
//	홍길동
//	남
//	서울시 중구 남대문로 120
//	010-1234-1234
//	25
//	의료 혜택을 받을 수 있다.
//	가나다라 한국말 가능(세종대왕님 만세)

	
}
