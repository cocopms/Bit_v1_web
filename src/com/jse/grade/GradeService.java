package com.jse.grade;
//선언
public interface GradeService {
	//메서드(기능)선언
	public void setGrades(Grade[] grades);
	public Grade[] getGrades();
	public void add(Grade grade); //추상메서드
	public void setCount(int count);
	public int getCount();
	public int total(Grade grade); //private은 파라미터값으로 전달해주어야 함(같은 클래스 내에서만 사용 가능하니까)
	public int average(Grade grade);
	public String record(Grade grade);
	public String printGrade();
	public String ranking();
}