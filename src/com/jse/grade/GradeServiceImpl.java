package com.jse.grade;

public class GradeServiceImpl implements GradeService {
	private Grade[] grades;
	private int count;

	public GradeServiceImpl() {
		grades = new Grade[3];
		count = 0;
	}

	@Override
	public void setGrades(Grade[] grades) {
		this.grades = grades;
	}

	@Override
	public Grade[] getGrades() {
		return grades;
	}

	@Override
	public void add(Grade grade) {
		grades[count] = grade;
		count++;
	}

	@Override
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int getCount() {
		return count;
		
	}

	@Override
	public int total(Grade grade) { 
		return grade.getKorean() + grade.getEnglish() + grade.getMath();
	}

	@Override
	public int average(Grade grade) {
		return total(grade) / 3;
	}

	@Override
	public String record(Grade grade) {
		String result = "";
		int average = average(grade);
		switch(result) { 
		case "A":  break;
		}
		if (average >= 90) {
			result = "A";
		} else if (average >= 80) {
			result = "B";
		} else if (average >= 70) {
			result = "C";
		} else if (average >= 60) {
			result = "D";
		} else if (average >= 50) {
			result = "E";
		} else if (average < 50) {
			result = "F";
		} else {
			System.out.println("값을 잘못 입력하셨습니다.");
		}
		return result;
	}

	@Override
	public String printGrade() {
		Grade[] grades = getGrades();
		String result = "";
		for (int i = 0; i < 3; i++) {
			result += String.format("이름 : %s, 총점 : %d 점, 평균 : %d 점, 학점 : %s \n", grades[i].getName(),
					total(grades[i]), average(grades[i]), record(grades[i]));
		}
		return result;
	}

	@Override
	public String ranking() {
		grades = getGrades();
		int a = total(grades[0]);
		int b = total(grades[1]);
		int c = total(grades[2]);
		String rank = "";
		rank = (a>b && b>c) ? "1등 : a, 2등 : b, 3등 : c" : "false";
		rank = (a>c && c>b) ? "1등 : a, 2등 : c, 3등 : b" : "false";
		rank = (b>a && a>c) ? "1등 : b, 2등 : a, 3등 : c" : "false";
		rank = (a>c && c>a) ? "1등 : b, 2등 : c, 3등 : a" : "false";
		rank = (c>a && a>c) ? "1등 : c, 2등 : a, 3등 : b" : "false";
		rank = (c>b && b>a) ? "1등 : c, 2등 : b, 3등 : a" : "false";
		return rank;
	}
}