package com.jse.grade;
//선언
public interface GradeService {
	//메서드(기능)선언
	public void add(Grade grade); //추상메서드
	public Grade[] list();
	public Grade detail(Grade grade); //Member의 login과 같은 역할
	public int count();
	
	public int total(Grade grade); //private은 파라미터값으로 전달해주어야 함(같은 클래스 내에서만 사용 가능하니까)
	public int average(Grade grade);
	public String record(Grade grade);
	public String ranking();
	public String printGrade();
	
	public void update(Grade grade);
	public void delete(Grade grade);
}