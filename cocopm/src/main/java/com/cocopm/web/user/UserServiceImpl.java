package com.cocopm.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private Map<String, Object> map;
	//interface<type : 스트링을 오브젝트화한다> variable
	//배열이 아닌 """"배열들의 집합""""" = 배열
	//키값만 보고 루프 없이 찾기 때문에 count,for이 필요없다

	public UserServiceImpl() {
		map = new HashMap<>();
				//구현체
	}

	@Override
	public void add(User user) {
		map.put(user.getUserid(), user);
	}

	@Override
	public int count() {
		return map.size(); //=length
	}

	@Override
	public User login(User user) {
		User loginUser = null;
		if(map.containsKey(user.getUserid())) { //로그인할 때 입력한값
			User u = detail(user.getUserid()); 
			if(user.getPasswd().equals(u.getPasswd())) {
				loginUser = u;
			}
		}
		return loginUser;
	}

	@Override
	public User detail(String userid) { //map에 저장된 값
		return (User) map.get(userid); //object
	}
}
