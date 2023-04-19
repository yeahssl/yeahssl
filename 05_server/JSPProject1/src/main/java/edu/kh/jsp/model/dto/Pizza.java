package edu.kh.jsp.model.dto;

public class Pizza {
	
	private String name;
	private int price;

	public Pizza() {}
	

	public Pizza(String name, int price) { // alt + shift + s + o  -> 매개변수 생성자 자동완성 
		super();
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
