package com.jse.member;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Container container;
	private JLabel title, nameLabel, useridLabel, passwordLabel, ssnLabel, addrLabel;
	private JTextField nameText, useridText, passwordText, ssnText, addrText;
	private JTextArea resultText;
	private JButton submitButton, listButton, loginButton;
	public MemberService memberService;

	public void open() {
		memberService = new MemberServiceImpl();
		setTitle("Swing Form");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		container = getContentPane();
		container.setLayout(null);

		title = new JLabel("Registration Form");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
		title.setLocation(300, 30);
		container.add(title);

		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		nameLabel.setSize(100, 20);
		nameLabel.setLocation(100, 100);
		container.add(nameLabel);

		nameText = new JTextField();
		nameText.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		nameText.setSize(190, 20);
		nameText.setLocation(200, 100);
		container.add(nameText);

		useridLabel = new JLabel("Userid");
		useridLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		useridLabel.setSize(100, 20);
		useridLabel.setLocation(100, 150);
		container.add(useridLabel);

		useridText = new JTextField();
		useridText.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		useridText.setSize(150, 20);
		useridText.setLocation(200, 150);
		container.add(useridText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordLabel.setSize(100, 20);
		passwordLabel.setLocation(100, 200);
		container.add(passwordLabel);

		passwordText = new JTextField();
		passwordText.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		passwordText.setSize(150, 20);
		passwordText.setLocation(200, 200);
		container.add(passwordText);

		ssnLabel = new JLabel("SSN");
		ssnLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		ssnLabel.setSize(100, 20);
		ssnLabel.setLocation(100, 250);
		container.add(ssnLabel);

		ssnText = new JTextField();
		ssnText.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		ssnText.setSize(150, 20);
		ssnText.setLocation(200, 250);
		container.add(ssnText);

		addrLabel = new JLabel("Address");
		addrLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		addrLabel.setSize(100, 20);
		addrLabel.setLocation(100, 300);
		container.add(addrLabel);

		addrText = new JTextField();
		addrText.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		addrText.setSize(150, 20);
		addrText.setLocation(200, 300);
		container.add(addrText);

		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Arial", Font.PLAIN, 15));
		submitButton.setSize(100, 20);
		submitButton.setLocation(150, 450);
		submitButton.addActionListener(this);
		submitButton.addActionListener(this);
		container.add(submitButton);

		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
		loginButton.setSize(100, 20);
		loginButton.setLocation(390, 450);
		loginButton.addActionListener(this);
		container.add(loginButton);

		listButton = new JButton("List");
		listButton.setFont(new Font("Arial", Font.PLAIN, 15));
		listButton.setSize(100, 20);
		listButton.setLocation(270, 450);
		listButton.addActionListener(this);
		container.add(listButton);

		resultText = new JTextArea();
		resultText.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		resultText.setSize(300, 400);
		resultText.setLocation(500, 100);
		resultText.setLineWrap(true);
		resultText.setEditable(false);
		container.add(resultText);

		setVisible(true);
	}

	@Override // 기능 : controller
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {// 주소값 비교
			nameText.setText("홍길동,유관순,이순신,신사임당,이도");// 자연어
			useridText.setText("hong,you,lee,shin,leedo");
			passwordText.setText("1,1,1,1,1");
			ssnText.setText("900101-1,960101-2,980101-1,011010-4,020606-3");
			
			addrText.setText("서울,서울,서울,부산,부산");// text인가 string이 아니고?? .도 받아야 하니까..)
			Member[] members = new Member[5]; // 배열 차원이 올라감
			String[] names = nameText.getText().split(",");// String으로 넘어가는순간 자연어가 자바어가됨, 전처리시작
			String[] userids = useridText.getText().split(",");
			String[] passwords = passwordText.getText().split(",");
			String[] ssns = ssnText.getText().split(",");
			String[] addrs = addrText.getText().split(",");
			
			for (int i = 0; i < 5; i++) {
				members[i] = new Member(); // members[i] = elements라서 for안에서만 객체로서 활동
				members[i].setName(names[i]); // 정형화중
				members[i].setUserid(userids[i]);
				members[i].setPassword(passwords[i]);
				members[i].setSsn(ssns[i]);
				members[i].setAddr(addrs[i]);
				memberService.add(members[i]); // 서버단에 보내줘야 함(write, 서버단에 쓴다, return type 없고 파라미터값이 있고 setter)
			}
			
		} else if (e.getSource() == listButton) {
			JOptionPane.showMessageDialog(this, "CLICK");
			Member[] members = memberService.getMembers(); // 서버단에서 가져와야 함(read, return type 있고 getter)
			// 리턴타입 변수 = 갖고오기, 이후에 받아줘야함..

			String result = "";
			for (int i = 0; i < members.length; i++) {// 한차원 낮춰서 출력해야 함(elements), 차원이 낮은 member에 정보가 있음
				result += members[i] + "\n";
			}
			nameText.setText("");
			useridText.setText("");
			passwordText.setText("");
			ssnText.setText("");
			addrText.setText(""); // null값, 왜초기화?
			resultText.setText(result);
			
		} else if (e.getSource() == loginButton) {
			JOptionPane.showMessageDialog(this, "로그인 \n" + useridText.getText() + "," + passwordText.getText());
			Member member = new Member();
			member.setUserid(useridText.getText()); //박스에 담아서 보안상태로 보낸다
			member.setPassword(passwordText.getText());
			Member membervalue = memberService.login(member);
			
			if(membervalue != null) {
				JOptionPane.showMessageDialog(this, "로그인성공");
				resultText.setText(membervalue.toString()); //text를 문자열로 바꿔야 할 때 toString으로 바꾼다
			} else {
				JOptionPane.showMessageDialog(this, "로그인실패");
			}
		}

	}
}