package com.cocopm.web.grade;

import com.cocopm.web.util.Credit;

//CRUD
public interface GradeService {
	public void add(Grade grade);
	public Credit detail(String userid);
	
	//여기서부터 파라미터값을 넣을지 말지 고민하기
	public int count();
}
