package com.cocopm.web.grade;
	//CRUD
public interface GradeService {
	public void add(Grade grade);
	public Grade[] list();
	public Grade detail(Grade grade);
	
	//여기서부터 파라미터값을 넣을지 말지 고민하기
	public int total();
	public int average();
	public Grade record();
	public Grade[] ranking();
	
	public void update(Grade grade);
	public void delete(Grade grade);
}
