package com.jse.phone;

import lombok.Data;

@Data
public class Phone {
	private String phonenumber, name, company, move, search, bigsize;
	private boolean portable;

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
}
