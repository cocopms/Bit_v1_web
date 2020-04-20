package com.jse.game;

import lombok.Data;

@Data
public class Game {
	private int userval, comval, dicenum;
	private String expect;

	public void setUserval(int userval) {
		this.userval = userval;
	}

	public void setUcomval(int comval) {
		this.comval = comval;
	}

	public void setDicenum(int dicenum) {
		this.dicenum = dicenum;
	}

	public void setExpect(String expect) {
		this.expect = expect;
	}
	
	public int getUserval() {
		return userval;
	}
	public int getComval() {
		return comval;
	}
	public int getDicenum() {
		return dicenum;
	}
	public String getExpect() {
		return expect;
	}
}
