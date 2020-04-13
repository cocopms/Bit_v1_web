package com.jse.phone;
//전화기도 팔고, 휴대전화도 팔고... 서비스센터를 만드는 것이 목표
import javax.swing.JOptionPane;
import com.jse.util.Constants;

public class PhoneController {
	public static void main(String[] args) {
		PhoneServiceImpl phones = new PhoneServiceImpl();
		Phone phone = null;
		while (true) {
			switch (JOptionPane.showInputDialog(Constants.MENU)) {
			case "0":
				return;
			case "1":
				phone = new Phone();
				for (int i = 0; i < 3; ++i) {
					String[] values = JOptionPane.showInputDialog(Constants.PHONE_MENU).split(",");
					phone.setPhonenumber(values[0]);
					phone.setName(values[1]);
					phone.setCompany(values[2]);
				} break;
			case "2":
			JOptionPane.showMessageDialog(null, phones.printphone()); break;
			case "3":
				
				for (int i = 0; i < 3; ++i) {
					String[] values = JOptionPane.showInputDialog(Constants.CELLPHONE_MENU).split(",");
					phone.setPhonenumber(values[0]);
					phone.setName(values[1]);
					phone.setCompany(values[2]);
					phone.setPortable(true);
				} break;
			case "4":
				JOptionPane.showMessageDialog(null, phones.printcell());
				break;
			case "5":
				for (int i = 0; i < 3; ++i) {
					String[] values = JOptionPane.showInputDialog(Constants.IPHONE_MENU).split(",");
					phone.setPhonenumber(values[0]);
					phone.setName(values[1]);
					phone.setCompany(values[2]);
					phone.setPortable(true);
					phone.setSearch(values[4]);
				}
				break;
			case "6":
					JOptionPane.showMessageDialog(null, phones.printiphone());
				break;
			case "7":
				for (int i = 0; i < 3; ++i) {
					String[] values = JOptionPane.showInputDialog(Constants.GALAXYNOTE_MENU).split(",");
					phone.setPhonenumber(values[0]);
					phone.setName(values[1]);
					phone.setCompany(values[2]);
					phone.setPortable(true);
					phone.setSearch(values[4]);
					phone.setBigsize(values[5]);
				}
				break;
			case "8":
				JOptionPane.showMessageDialog(null, phones.printgalaxy());
				break;
			}
		}
	}
}