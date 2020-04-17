package com.jse.member;

public class MemberServiceImpls implements MemberService {
	private Member[] members;
	private int count;
	//i를 여기에 선언하였을 때 계속 초기화된다

	public MemberServiceImpls() {
		members = new Member[5];
		count = 0;
	}

	@Override
	public void add(Member member) {
		members[count] = member;
		++count;
	}

	@Override
	public Member[] list() { // getter
		return members;
	}

	@Override // 참고한 부분
	public Member[] searchByName(String name) {
		Member[] returnMembers = null;
		int searchCount = count(name);
		if (searchCount != 0) {
			returnMembers = new Member[searchCount];
			int j = 0;
			for (int i=0; i < count; ++i) {
				if (name.equals(members[i].getName())) {
					returnMembers[i] = members[i];
					j++;
					if (searchCount == j) {
						break;
					}
				}
			}
		}
		return returnMembers;
	}

	@Override
	public Member[] serarchByGender(String gender) {
		return null;
	}

	@Override
	public Member detail(String userid) {
		Member member = null;
		for (int i=0; i < count; ++i) {
			if (userid.equals(members[i].getUserid())) { // 성능
				member = new Member();
				member = members[i];
			}
		}
		return member;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public int count(String name) { // 동명이인이 존재할 때
		int returnCount = 0;
		for (int i=0; i < count; ++i) {
			if (name.equals(members[i].getName())) { // 성능
				returnCount++;
			}
		}
		return returnCount;
	}

	@Override
	public Member login(Member member) {
		Member returnMember = null;
		for (int i=0; i < count; ++i) {
			if (member.getUserid().equals(members[i].getUserid())
					&& member.getPassword().equals(members[i].getPassword())) {
				returnMember = new Member();
				returnMember = members[i];
				break;
			}
		}
		return returnMember;
	}

	public void update(Member member) { // 아이디가 같으면 비밀번호 변경 가능!!!
		for (int i=0; i < count; ++i) {
			if (member.getUserid().equals(members[i].getUserid())) {
				// 참고한 부분
				members[i].setPassword(member.getPassword());
				break; //참고한부분
			}
		}
	}
	

	@Override
	public void delete(Member member) {
		for (int i=0; i < count; ++i) {
			if (member.getUserid().equals(members[i].getUserid())
					&& member.getPassword().equals(members[i].getPassword())) {
				// 참고한 부분
				members[i] = members[count - 1];
				members[count - 1] = null; //참고
				count --;
			}
		}
	}
	/*
	@Override
	public String printMember() {
		String result = "";
		for (; i < 3; ++i) {
			result += String.format("아이디 : %s, 비밀번호 : %s, 이름 : %s, 나이 : %d", members[i].getUserid(),
					members[i].getPassword(), members[i].getName(), members[i].getAge());
		}
		return result;
	}
	
	@Override
	public String gender() {
		char ch = member.getSsn().replace("-", "").charAt(6);
		String gender = "";
		switch (ch) {
		case '1':
		case '3':
			gender = "남성";
			break;
		case '2':
		case '4':
			gender = "여성";
			break;
		case '5':
		case '6':
			gender = "외국인";
			break;
		default:
			;
		}
		return gender;
	}

	@Override
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
	*/
}
