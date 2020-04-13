package com.jse.member;

import javax.swing.*;

public class Swing {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Member Sing-up");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); //
		
		JPanel panel = new JPanel();
		frame.add(panel);
		JLabel nameLabel = new JLabel("이름");
		JLabel useridLabel = new JLabel("아이디");
		JLabel passwordLabel = new JLabel("패스워드");
		JLabel addressLabel = new JLabel("주소");
		JLabel contentLabel = new JLabel("추가사항");
		panel.add(nameLabel);
		panel.add(useridLabel);
		panel.add(passwordLabel);
		panel.add(addressLabel);
		panel.add(contentLabel);
		JTextField nameField = new JTextField();
		JTextField useridField = new JTextField();
		JTextField passwordField = new JTextField();
		JTextField addressField = new JTextField();
		JTextField contentField = new JTextField();
		panel.add(nameField);
		panel.add(useridField);
		panel.add(passwordField);
		panel.add(addressField);
		panel.add(contentField);
		JButton saveButton = new JButton("저장");
		JButton cancelButton = new JButton("취소");
		panel.add(saveButton);
		panel.add(cancelButton);
		nameLabel.setBounds(40, 10, 40, 40);
		useridLabel.setBounds(40, 50, 40, 40);
		passwordLabel.setBounds(40, 90, 60, 40);
		addressLabel.setBounds(40, 130, 40, 40);
		contentLabel.setBounds(40, 170, 60, 40);
		nameField.setBounds(120, 10, 200, 30);
		useridField.setBounds(120, 50, 200, 30);
		passwordField.setBounds(120, 90, 200, 30);
		addressField.setBounds(120, 130, 280, 30);
		contentField.setBounds(120, 180, 280, 120);
		saveButton.setBounds(125, 330, 80, 30);
		cancelButton.setBounds(240, 330, 80, 30);
		
		frame.setLocationRelativeTo(null);

	}
}
