package com.cocopm.web.member;

import lombok.Data;

@Data //이 외의 값을 자바스크립트에 입력하면 null값이 뜬다
public class Member {
	private String name, userid, passwd, ssn, addr;

}
