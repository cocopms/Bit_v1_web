package com.jse.game;
//UI
import javax.swing.*; //awt 망함

public class GameSwing {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Member Sign-up"); // 레이아웃과 이름, import new
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ?
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.add(panel);
		JLabel namelabel = new JLabel("이름"); // 라벨 위에 라벨 쌓기
		JLabel useridlabel = new JLabel("아이디");
		JLabel passwordlabel = new JLabel("비밀번호");
		JLabel emaillabel = new JLabel("주민등록번호");
		JLabel etclabel = new JLabel("추가사항");
		panel.add(namelabel);
		panel.add(useridlabel);
		panel.add(passwordlabel);
		panel.add(emaillabel);
		JTextField namefield = new JTextField();
		JTextField useridfield = new JTextField();
		JTextField passwordfield = new JTextField();
		JTextField emailfield = new JTextField();
		JTextField etcfield = new JTextField();
		panel.add(namefield);
		panel.add(useridfield);
		panel.add(passwordfield);
		panel.add(etcfield);
		
		JButton savebutton = new JButton("저장");
		JButton closebutton = new JButton("취소");
		panel.add(savebutton);
		panel.add(closebutton);

		namelabel.setBounds(40, 50, 40, 40);
		useridlabel.setBounds(40, 90, 60, 40);
		passwordlabel.setBounds(40, 130, 40, 40);
		emaillabel.setBounds(40, 170, 60, 40);
		etclabel.setBounds(120, 10, 200, 30);
		namefield.setBounds(120, 50, 200, 30);
		useridfield.setBounds(120, 90, 200, 30);
		passwordfield.setBounds(120, 130, 280, 30);
		emailfield.setBounds(125, 330, 80, 30);
		etcfield.setBounds(240, 330, 80, 30); // x y좌료, 가로세로 크기


		frame.add(panel); // 여러개 갖는다
	}
}
/*
//회원가입창
class JoinFrame extends JFrame {

}
*/