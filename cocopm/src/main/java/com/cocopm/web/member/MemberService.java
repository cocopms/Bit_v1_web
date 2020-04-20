package com.cocopm.web.member;

// 기본 : add, list, detail, count, update, delete
public interface MemberService {
	public void add(Member member);

	public Member[] list();

	public Member detail(Member member);

	public int count();

	public void update(Member member);

	public void delete(Member member);
}