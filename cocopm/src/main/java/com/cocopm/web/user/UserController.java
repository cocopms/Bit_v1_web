package com.cocopm.web.user;
import java.util.HashMap;
import java.util.Map;

//상위개념, 일은 서버단에서
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocopm.web.util.Messanger;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired UserService service;
	
		@PostMapping("/join")
		public Messanger join(@RequestBody User user) {
			System.out.println(user);
			int count = service.count();
			service.add(user);
			return (count+1 == service.count()) ? Messanger.SUCCESS : Messanger.FAIL;
		}	//정상적으로 들어갔는가?
		
		@PostMapping("/login")
		public Map<String,Object> login(@RequestBody User user) {
			Map<String,Object> returnMap = new HashMap<>();
			User loginUser = service.login(user);
			if(loginUser != null) { //map이 배열이라 여러개를 담을 수 있음
				returnMap.put("user", loginUser); //박스에 씌었기 때문에 js에선 d.user, d.messanger로 가져가야함
				returnMap.put("messanger", Messanger.SUCCESS); //string으로 주는것
			}else {
				returnMap.put("messanger", Messanger.FAIL);
			}
			return returnMap;
		}
}