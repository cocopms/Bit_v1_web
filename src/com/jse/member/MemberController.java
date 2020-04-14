package com.jse.member;

import javax.swing.JOptionPane;
import com.jse.util.Constants;

public class MemberController {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		Member members = null;
		String value = "";
		while (true) {
			switch (JOptionPane.showInputDialog(Constants.MEMBER_MENU)) {
			case "0":
				return;
			case "1":
				members = new Member();
				for (int i = 0; i < 3; ++i) {
					String[] values = JOptionPane.showInputDialog(Constants.MEMBER_JOIN).split(",");
					members.setUserid(values[0]);
					members.setPassword(values[1]);
					members.setName(values[2]);
					members.setAge(Integer.parseInt(values[3]));
				}
				break;
			case "2":
				JOptionPane.showMessageDialog(null, service.printMember());
				break;
			case "3" : 
				value = JOptionPane.showInputDialog(Constants.MEMBER_GENDER);
				members.setSsn(value);
				JOptionPane.showMessageDialog(null, service.gender());
				break;
			case "4" : 
				String[] values = JOptionPane.showInputDialog(Constants.MEMBER_KAUP).split(",");
				members.setHeight(Double.parseDouble(values[0]));
				members.setWeight(Double.parseDouble(values[1]));
				JOptionPane.showMessageDialog(null, service.kaupcal());
				break;
			}
		}
	}
}
