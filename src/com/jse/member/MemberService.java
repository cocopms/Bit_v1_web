package com.jse.member;

public interface MemberService {
	public Member[] getMembers();
	public void setMembers(Member[] members);
	public String printMember();
	public String gender();
	public String kaupcal();
	public void add(Member member);
	public Member login(Member member);
}