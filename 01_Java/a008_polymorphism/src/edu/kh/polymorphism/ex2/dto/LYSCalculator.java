package edu.kh.polymorphism.ex2.dto;

// 각자 계산기 구현하기
public class LYSCalculator extends Person implements Calculator, KH{

	@Override
	public int plus(int a, int b) {
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		return a-b;
	}

	@Override
	public int multiple(int a, int b) {
		return a*b;
	}

	@Override
	public int divide(int a, int b) {
		
		return a/b;
	}

	@Override
	public double divide2(int a, int b) {
		return (double)a/b;
	}

	@Override
	public double areaOfCircle(double r) {
//      return Calculator.PI * r * r; // (정확한 표기법)		
		return r*r*PI;
	}

	@Override
	public int square(int a, int x) {
		
		// 재귀 호출
		if(x == 1) {
			return a;
		}
		
		return a * square(a, x-1);
	}

	@Override
	public void lesson() {
		
	}

}





