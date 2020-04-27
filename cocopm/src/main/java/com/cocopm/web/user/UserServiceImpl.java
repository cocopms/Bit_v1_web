package com.cocopm.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.cocopm.web.util.FileTest;

@Service
public class UserServiceImpl implements UserService{
	private Map<String, Object> map; //이젠 끄면 사라지는 맵에 저장하지 않고, 오프라인에 저장하려 한다
	
	public UserServiceImpl() {
		map = new HashMap<>();
	}

	@Override
	public void add(User user) {
		map.put(user.getUserid(), user);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<User> list() {
		List<User> list = new ArrayList<>();
		@SuppressWarnings("rawtypes")
		Set set = map.entrySet(); //set = map의 entry를 넣는, map 순서가 없기 때문에 순서 없는 set으로..
		@SuppressWarnings("rawtypes")
		Iterator it= set.iterator();
		while(it.hasNext()) { //다음게 있냐없냐
			@SuppressWarnings("unchecked")
			Map.Entry<String, User> e = (Entry<String, User>) it.next(); //순서대로 리턴
			list.add(e.getValue()); //키는 빼고 value만.. 
		}
		for(int i=0; i<list.size(); ++i) {
			System.out.println(list.get(i));
		}
		return list;
	}

	@Override
	public int count() {
		return map.size();
	}

	@Override
	public User login(User user) {
		User returnUser = null;
		if(map.containsKey(user.getUserid())) {
			User u = detail(user.getUserid());
			if(user.getPasswd().equals(u.getPasswd())) {
				return u;
			}
		}
		return returnUser;
	}

	@Override
	public User detail(String userid) {
		System.out.println("서비스 detail 들어온 id: "+userid);
		User t = (User) map.get(userid);
		System.out.println("===============> "+t);
		return t;
	}

	@Override
	public boolean update(User user) {
		map.replace(user.getUserid(), user);
		return true;
	}

	@Override
	public boolean remove(String userid) {
		map.remove(userid);
		return true;
	}

	@Override //조회할 때마다 데이터를 가져오는 건 너무 느린 짓
	public void savefile(User user) {
		
	}

	@Override
	public List<User> readfile() {
		List<User> userList = new ArrayList<>();
		List<String> list = new ArrayList<>();
		try {
			File file = new File(FileTest.FILE_PATH + "list.txt"); // io
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message = "";
			while((message = reader.readLine()) != null) {
				list.add(message); 
			}
			reader.close();
		} catch (Exception e) { // 100프로 이거임
			System.out.println("에러 발생");
		}
		User user = new User();
		for(int i = 0; i<list.size(); ++i) {
			String[] arr = list.get(i).split(",");
			user.setUserid(arr[0]);
			user.setPasswd(arr[1]);
			user.setName(arr[2]);
			user.setSsn(arr[3]);
			user.setAddr(arr[4]);
			userList.add(user);
		}
		return userList;
	}
}
