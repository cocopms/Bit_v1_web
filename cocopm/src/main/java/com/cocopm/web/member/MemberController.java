package com.cocopm.web.member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // 인터넷url을 처리하는 컨트롤러
public class MemberController {
	public MemberService service;
	
	//컨트롤러는 무조건 return값이 있어야 한다
	
	@PostMapping("/join") //join의 post와 매핑시키는 작업, url
	public Member addUrl(@RequestBody Member member) { 
		System.out.println(">>>>");
		System.out.println(member.toString()); //롬복 안 걸면 toString 만들어야 함
		service = new MemberServiceImpl();
		service.add(member); //서버단에 url 연결, 왜 이렇게 나눴는가? 보안때문에 한절차를 걸쳐서 주는 것(방화벽)
		return member;
	}
}
