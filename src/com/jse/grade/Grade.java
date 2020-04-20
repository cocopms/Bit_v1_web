package com.jse.grade;

public class Grade {
	private String name;
	private int korean, english, math, java;

	public void setName(String name) {
		this.name = name;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public void setJava(int java) {
		this.java = java;
	}
	
	public String getName() {
		return name;
	}
	public int getKorean() {
		return korean;
	}
	public int getEnglish() {
		return english;
	}
	public int getMath() {
		return math;
	}
	public int getJava() {
		return java;
	}

}