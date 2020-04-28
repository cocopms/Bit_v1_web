package com.cocopm.web.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocopm.web.util.Credit;
import com.cocopm.web.util.Messanger;

//컨트롤러는 무조건 리턴값을 가져야 한다.

@RestController
@RequestMapping("/grade")
public class GradeController {

	@Autowired GradeService service;

	@PostMapping("/register")
	public Messanger register(@RequestBody Grade grade) {
		int current = service.count();
		System.out.println(grade.toString()); //혹시모를 출력
		service.add(grade);
		return (service.count() == (current+1)) ? Messanger.SUCCESS : Messanger.FAIL;
	}
	
	@GetMapping("/report/{userid}") //path, detail
	public Credit report(@PathVariable String userid) {
		return service.detail(userid);
	}
}