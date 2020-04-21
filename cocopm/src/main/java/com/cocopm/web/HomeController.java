package com.cocopm.web;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

	//이동창

@SpringBootConfiguration
@Controller //@component, 객체 생성을 자동으로 해줌
public class HomeController {
	@GetMapping("/")
	public String hello() {
		return "index.html";

	}
}