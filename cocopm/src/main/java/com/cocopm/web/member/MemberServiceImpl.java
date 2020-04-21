package com.cocopm.web.member;

import org.springframework.stereotype.Service;

//controller은 네트워크에서 new를 해주고 있다
@Service
public class MemberServiceImpl implements MemberService {
	private Member[] members;
	private int count;

	public MemberServiceImpl() {
		members = new Member[5];
		count = 0;
	}

	@Override
	public void add(Member member) {
		members[count] = member;
		++count;
	}

	@Override
	public Member[] list() {
		return members;
	}

	@Override
	public Member detail(Member member) {
		Member detailValue = null;
		for (int i = 0; i < count; ++i) {
			if (member.getUserid().equals(members[i].getUserid())) {
				detailValue = new Member();
				detailValue = members[i];
			}
		}
		return detailValue;
	}

	@Override
	public int count() {
		return count;
	}
	
	@Override
	public boolean login(Member member) {
		boolean loginVal = false;
		for(int i=0;i< count;i++) {
			if(member.getUserid().equals(members[i].getUserid())
					&&
				member.getPasswd().equals(members[i].getPasswd())) {
				loginVal = true;
			}
		}
		return loginVal;
	}

	@Override
	public void update(Member member) {
		for (int i = 0; i < count; ++i) {
			if (member.getUserid().equals(members[i].getUserid())) {
				members[i].setPasswd(member.getPasswd());
			}
		}
	}

	@Override
	public void delete(Member member) {
		for (int i = 0; i < count; ++i) {
			if (member.getUserid().equals(members[i].getUserid())
					&& member.getPasswd().equals(members[i].getPasswd())) {
				members[i] = members[count - 1];
				members[count - 1] = null;
			}
		}
	}
}
