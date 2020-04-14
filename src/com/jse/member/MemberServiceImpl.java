package com.jse.member;

public class MemberServiceImpl implements MemberService {
	private Member[] members; // 4개변수의 집합
	private Member member;
	private int count;

	public MemberServiceImpl() {
		setMembers(new Member[5]);
		this.count = 0;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

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
		System.out.println("서비스로 들어온 멤버");
		System.out.println(member);
		members[count] = member;
		count++;
	}

	@Override
	public Member login(Member member) { // id, password, 어차피 해당 값이 필요하기 때문에 Member타입
		int i;
		Member membervalue = null; //주소 없으면 주소 null
		for (i = 0; i < members.length; ++i) { // 5명거 중 파라미터 받은 건 1명 id, pw
			// 5중 1맞는 게 있는지 "검색 엔진 search engine" = 기본은 이렇게 진행
			if (member.getUserid().equals(members[i].getUserid()) && // elements vs object
					member.getPassword().equals(members[i].getPassword())) { // 변수.메서드
				membervalue = new Member(); //맞을 때에만 주소 할당
				membervalue = members[i]; //덩어리 전체를 주는 것, count와 동일한 원리
				break; //for는 답을 찾아도 계속 돌기때문
			}
		}
		return membervalue; //주소값 null
	}
}
/*
boolean ok = false; // 초기화는 아무 값이나 줘도 상관 없음
for (i = 0; i < members.length; ++i) { // 5명거 중 파라미터 받은 건 1명 id, pw
	// 5중 1맞는 게 있는지 "검색 엔진 search engine" = 기본은 이렇게 진행
	if (member.getUserid().equals(members[i].getUserid()) && // elements vs object
			member.getPassword().equals(members[i].getPassword())) { // 변수.메서드
		ok = true;
		// 기본값이 false이기 때문에 else는 굳이 안 써도 됨
	} 
}
*/