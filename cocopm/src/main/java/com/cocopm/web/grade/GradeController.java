package com.cocopm.web.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocopm.web.util.Credit;

//컨트롤러는 무조건 리턴값을 가져야 한다.

@RestController
@RequestMapping("/grade")
public class GradeController {

	@Autowired
	GradeService service;

	@PostMapping("/register")
	public Credit addUrl(@RequestBody Grade grade) {
		System.out.println(grade.toString());
		Credit result = null;
		int count = service.add(grade);
		if()
		return result;
	}

	@PostMapping("/list")
	public Grade[] list() {
		return service.list();
	}

	@PostMapping("/detail")
	public Grade detail(@RequestBody Grade grade) {
		Grade detailGrade = new Grade();
		service.detail(grade);
		return detailGrade;
	}

	@PutMapping("/update")
	public Grade update(@RequestBody Grade grade) {
		Grade updateGrade = new Grade();
		service.update(grade);
		return updateGrade;
	}
	
	@DeleteMapping("/delete")
	public Grade delete(@RequestBody Grade grade) {
		Grade deleteGrade = new Grade();
		service.delete(grade);
		return deleteGrade;
	}
}
