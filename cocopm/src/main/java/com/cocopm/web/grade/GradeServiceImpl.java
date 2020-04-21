package com.cocopm.web.grade;

import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {
	private Grade[] grades;
	private int count;
	
	public GradeServiceImpl() {
		grades = new Grade[5];
		count = 0;
	}
	
	@Override
	public void add(Grade grade) {
		grade = grades[count];
		count++;
	}

	@Override
	public Grade[] list() {
		return grades;
	}

	@Override
	public Grade detail(Grade grade) {
		Grade detailGrade = null;
		for(int i = 0; i < count; ++i) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				detailGrade = new Grade();
				detailGrade = grades[i];
			}
		}
		return detailGrade;
	}

	@Override
	public int total() {
		Grade grade = new Grade();
		return Integer.parseInt(grade.getKorean() + grade.getEnglish() + grade.getMath() + grade.getJava());
	}

	@Override
	public int average() {
		return total() / 4;
	}

	@Override
	public Grade record() {
		
		return null;
	}

	@Override
	public Grade[] ranking() {
		
		return null;
	}

	@Override
	public void update(Grade grade) {
		for(int i=0; i<count; ++i) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				grades[i].setKorean(grade.getKorean());
				grades[i].setEnglish(grade.getEnglish());
				grades[i].setMath(grade.getMath());
				grades[i].setJava(grade.getJava());
			}
		}
	}

	@Override
	public void delete(Grade grade) {
		for(int i=0; i<count; ++i) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				grades[i] = grades[count -1];
				grades[count -1] = null;
			}
		}
	}

}
