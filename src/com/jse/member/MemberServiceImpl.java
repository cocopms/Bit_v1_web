package com.jse.member;

//CRUD 순서대로 메소드 정렬
public class MemberServiceImpl implements MemberService {
	private Member[] members; // 4개변수의 집합
	private Member member;
	private int count;
	public int i;
	public MemberServiceImpl() {
		members = new Member[5];
		count = 0;
		i = 0;
	}

	public void add(Member member) {
		members[count] = member;
		count++;
	}

	@Override
	public Member[] list() {
		return members;
	}

//매우중요, 돌지 않음
	public Member[] searchByName(String name) {
		Member[] returnMembers = null; // 배열은 항상 존재해야 한다, 리턴타입으로부터 선언 및 초기화 시작
		int searchCount = count(name);
		if (searchCount != 0) { // 확실한 건 else로 보내고 확실하지 않은거 잡기
			returnMembers = new Member[searchCount];
			int j = 0; // 따로 움직이는 애
			for (int i = 0; i < count; ++i) {
				if (name.equals(members[i].getName())) {
					returnMembers[j] = members[i]; // 타입 맞추기
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
		// TODO Auto-generated method stub
		return null;
	}

	public Member detail(String userid) { // 왜 type이 member인가?
//		아이디를 줬을 때 그에 맞는 나머지 정보들을 서치해서 가져올 것
		Member member = new Member();
		for (int i = 0; i < count; ++i) {
			if (userid.equals(members[i].getUserid())) { // 보안이 필요없으므로 userid 그대로 쓴다
				member = members[i];
				break;
			} // for에서 진위여부를 밝히면 안되는 이유
		}
		return member;
	}

	@Override
	public int count() {
		return count;
	}

	public int count(String name) { // 동명이인이 있는 경우에 값이 1씩 추가된다, 메모리공간 save
		int returnCount = 0;
		for (; i < count; ++i) {
			if (name.equals(members[i].getName())) {
				returnCount++;
			}
		}
		return returnCount;
	}
	
	@Override
	public Member login(Member member) { // id, password, 어차피 해당 값이 필요하기 때문에 Member타입
		System.out.println(member);
		Member membervalue = null; // 주소 없으면 주소 null
		for (; i < count; ++i) { // 5명거 중 파라미터 받은 건 1명 id, pw
			// 5중 1맞는 게 있는지 "검색 엔진 search engine" = 기본은 이렇게 진행
			if (member.getUserid().equals(members[i].getUserid()) && // elements vs object
					member.getPassword().equals(members[i].getPassword())) { // 변수.메서드
				membervalue = members[i]; // 덩어리 전체를 주는 것, count와 동일한 원리
				break; // for는 답을 찾아도 계속 돌기때문
			}
		}
		System.out.println(membervalue);
		return membervalue; // 주소값 null
	}

	@Override
	public void update(Member member) { // 아이디가 같으면 비밀번호 변경 가능!!!
		for (; i < count; ++i) {
			if (member.getUserid().equals(members[i].getUserid())) {
				members[i].setPassword(member.getPassword());
				break;
			}
		}
		/* 1000명일 때 : length : 최대 길이, count : 회원수
		 * 		for (; i < count; ++i) {
			if (member.getUserid().equals(members[i].getUserid())) {
				members[i] = members[count-1];
				members[count -1] = null;
				count --; 
			}
		}
		 */
	}

	@Override
	public void delete(Member member) { // 회원탈퇴
		for (int i = 0; i < count; ++i) {
			if (member.getUserid().equals(members[i].getUserid()) &&
					member.getPassword().equals(member.getPassword())) {
				members[i] = members[count-1]; //삭제 및 덮어씌우기
				members[count -1] = null; //주소가 두개 만들어지니까 비워주기
				count --; //add 값이 제대로된 주소에 들어갈 수 있도록
			}
		}
	}



	public String printMember() {
		String result = "";
		for (; i < 3; ++i) {
			result += String.format("아이디 : %s, 비밀번호 : %s, 이름 : %s, 나이 : %d", members[i].getUserid(),
					members[i].getPassword(), members[i].getName(), members[i].getAge());
		}
		return result;
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
}
/*
 * boolean ok = false; // 초기화는 아무 값이나 줘도 상관 없음 for (i = 0; i < members.length;
 * ++i) { // 5명거 중 파라미터 받은 건 1명 id, pw // 5중 1맞는 게 있는지 "검색 엔진 search engine" =
 * 기본은 이렇게 진행 if (member.getUserid().equals(members[i].getUserid()) && //
 * elements vs object member.getPassword().equals(members[i].getPassword())) {
 * // 변수.메서드 ok = true; // 기본값이 false이기 때문에 else는 굳이 안 써도 됨 } }
 */