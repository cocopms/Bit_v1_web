package com.jse.member;

public class MemberServiceImpl implements MemberService {
	private Member[] members; //4개변수의 집합
	private Member member;

	public MemberServiceImpl() {
		setMembers(new Member[10]);
	}

	public Member[] getMembers() {
		return members;
	}

	public void setMembers(Member[] members) {
		this.members = members;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String printMember() {
		String result = "";
		for (int i = 0; i < 3; ++i) {
			result += String.format("아이디 : %s, 비밀번호 : %s, 이름 : %s, 나이 : %d", members[i].getUserid(),
					members[i].getPassword(), members[i].getName(), members[i].getAge());
		}
		return result;
	}

	public String gender() {
		char ch = member.getUnique().replace("-","").charAt(6);
		String gender = "";
		switch(ch) {
		case '1' : case '3' : gender = "남성"; break;
		case '2' : case '4' : gender = "여성"; break;
		case '5' : case '6' : gender = "외국인"; break;
		default : ;
		}
		return gender;
	}

	public String kaupcal() {
		double cal = member.getWeight() / (member.getHeight() * member.getHeight());
		String result = "";
		if (cal > 0 && cal < 18) {
			result = "저체중";
		} else if (cal <= 23) {
			result = "정상";
		} else if (cal > 23) {
			result = "비만";
		} else {
			result = "잘못된 값입니다..";
		}
		return result;
	}
	
	public void add(Member member) {
		
	}
}