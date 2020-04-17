package com.jse.member;

public interface MemberService {
//	public Member[] getMembers(); //여러데이터를 한번에 넣진 않으므로 쓰진 않음
//	public void setMembers(Member[] members)
//	public void setCount(int count);

	public void add(Member member);
	public Member[] list(); //getter과 같은 역할을 하므로 getter과 취합해버림
	public Member[] searchByName(String name); //read, 검색결과 : all, some(0~manythings), one, int // 100% String
	public Member[] serarchByGender(String gender);
	public Member detail(String userid); //조회.. 키값

	public int count(); //getCount 이름을 바꿈
	public int count(String name);
	
	public Member login(Member member); //여기에서만 사용하는 특수한 메소드
	public void update(Member member);
	public void delete(Member member);
	/*
	public String printMember();
	public String gender();
	public String kaupcal()
	*/;
}
//getter 3개 setter 3개