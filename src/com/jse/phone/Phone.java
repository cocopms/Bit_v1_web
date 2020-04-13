package com.jse.phone;

import lombok.Data;

@Data
public class Phone {
	private String phonenumber, name, company, move, search, bigsize;
	private boolean portable;

	public CellPhone(String phonenumber, String name, String company, boolean portable) { // 만들어줌
		// super가 받을 값 : 저장공간 공유(저장공간 phone) + 공유하지 않는건(저장공간 cellphone) 추가
		super(phonenumber, name, company);
		this.portable = portable; // 메서드니까 가져와야 함
		setPortable(portable); // setPortable로 바로 가게 하기 true니까
	}

	public void setPortable(boolean portable) { // boolean은 변형
		this.portable = portable;
		/*
		 * if (portable) { // 원래 연산자 들어가지 않나? 이게 변형인가? this.move = "휴대 가능"; } else {
		 * this.move = "휴대 불가능"; }
		 */
		this.move = (portable) ? "휴대가능" : "휴대불가능"; // 삼항연산자 : 결과값 = (컨디션) ? 참 : 거짓 if else는 적극적으로 제거
	}

	public boolean isPortable() {
		return portable;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", 휴대가능성 : " + portable;
	}

//iphone

	public Iphone(String phonenumber, String name, String company, boolean portable, String search) {
		super(phonenumber, name, company, portable);
		this.search = search;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "검색어 : " + search;
	}

	public GalaxyNote(String phonenumber, String name, String company, boolean portable, String search, String bigsize) { //지저분하지 않은가?
		super(phonenumber, name, company, portable, search);
		// TODO Auto-generated constructor stub
		this.bigsize = bigsize;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "사이즈 : " + bigsize;
	}
}
