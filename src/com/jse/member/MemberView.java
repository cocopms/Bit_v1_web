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
	private JButton saveButton, listButton, loginButton, detailButton, nameButton, genderButton, countButton,
			updateButton, deleteButton;
	public MemberService service;

	public void open() {
		service = new MemberServiceImpl();
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

		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Arial", Font.PLAIN, 15));
		saveButton.setSize(100, 20);
		saveButton.setLocation(100, 400);
		saveButton.addActionListener(this);
		container.add(saveButton);

		listButton = new JButton("List");
		listButton.setFont(new Font("Arial", Font.PLAIN, 15));
		listButton.setSize(100, 20);
		listButton.setLocation(220, 400);
		listButton.addActionListener(this);
		container.add(listButton);

		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
		loginButton.setSize(100, 20);
		loginButton.setLocation(340, 400);
		loginButton.addActionListener(this);
		container.add(loginButton);

		detailButton = new JButton("detail");
		detailButton.setFont(new Font("Arial", Font.PLAIN, 15));
		detailButton.setSize(100, 20);
		detailButton.setLocation(100, 440);
		detailButton.addActionListener(this);
		container.add(detailButton);

		nameButton = new JButton("name");
		nameButton.setFont(new Font("Arial", Font.PLAIN, 15));
		nameButton.setSize(100, 20);
		nameButton.setLocation(220, 440);
		nameButton.addActionListener(this);
		container.add(nameButton);

		genderButton = new JButton("gender");
		genderButton.setFont(new Font("Arial", Font.PLAIN, 15));
		genderButton.setSize(100, 20);
		genderButton.setLocation(340, 440);
		genderButton.addActionListener(this);
		container.add(genderButton);

		countButton = new JButton("count");
		countButton.setFont(new Font("Arial", Font.PLAIN, 15));
		countButton.setSize(100, 20);
		countButton.setLocation(100, 480);
		countButton.addActionListener(this);
		container.add(countButton);

		updateButton = new JButton("update");
		updateButton.setFont(new Font("Arial", Font.PLAIN, 15));
		updateButton.setSize(100, 20);
		updateButton.setLocation(220, 480);
		updateButton.addActionListener(this);
		container.add(updateButton);

		deleteButton = new JButton("delete");
		deleteButton.setFont(new Font("Arial", Font.PLAIN, 15));
		deleteButton.setSize(100, 20);
		deleteButton.setLocation(340, 480);
		deleteButton.addActionListener(this);
		container.add(deleteButton);

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
		int i = 0;
		if (e.getSource() == saveButton) {// 주소값 비교
			nameText.setText("홍길동,유관순,이순신,신사임당,이도");// 자연어
			useridText.setText("hong,you,lee,shin,leedo");
			passwordText.setText("1,1,1,1,1");
			ssnText.setText("900101-1,960101-2,980101-1,011010-4,020606-3");
			addrText.setText("서울,서울,서울,부산,부산");// text인가 string이 아니고?? .도 받아야 하니까..)

			String[] names = nameText.getText().split(",");// String으로 넘어가는순간 자연어가 자바어가됨, 전처리시작
			String[] userids = useridText.getText().split(",");
			String[] passwords = passwordText.getText().split(",");
			String[] ssns = ssnText.getText().split(",");
			String[] addrs = addrText.getText().split(",");

			Member member = null; // 사바딘에 보내야하므로 굳이 여기는 배열공간을 만들 필요가 없다 s, d,
			for (; i < names.length; i++) {
				member = new Member();
				member.setName(names[i]); // 정형화중
				member.setUserid(userids[i]);
				member.setPassword(passwords[i]);
				member.setSsn(ssns[i]);
				member.setAddr(addrs[i]);
				service.add(member); // 서버단에 보내줘야 함(write, 서버단에 쓴다, return type 없고 파라미터값이 있고 setter)
			}

		} else if (e.getSource() == listButton) {
			JOptionPane.showMessageDialog(this, "CLICK");
			Member[] members = service.list(); // 서버단에서 가져와야 함(read, return type 있고 getter)
			// 리턴타입 변수 = 갖고오기, 이후에 받아줘야함..

			String result = "";
			for (; i < members.length; i++) {// 한차원 낮춰서 출력해야 함(elements), 차원이 낮은 member에 정보가 있음
				result += members[i] + "\n";
			}
			nameText.setText("");
			useridText.setText("");
			passwordText.setText("");
			ssnText.setText("");
			addrText.setText(""); // null값, 왜초기화?
			resultText.setText(result);

		} else if (e.getSource() == loginButton) { //3번째 로그인 시도 시 실패뜸
			JOptionPane.showMessageDialog(this, "로그인 \n" + useridText.getText() + "," + passwordText.getText());
			Member member = new Member();
			member.setUserid(useridText.getText()); // 박스에 담아서 보안상태로 보낸다
			member.setPassword(passwordText.getText());
			Member membervalue = service.login(member);

			if (membervalue != null) {
				resultText.setText(membervalue.toString()); // text를 문자열로 바꿔야 할 때 toString으로 바꾼다
			} else {
				JOptionPane.showMessageDialog(this, "로그인실패");
				useridText.setText("");
				passwordText.setText("");
				resultText.setText("");
			}
		}
		if (e.getSource() == detailButton) {
			if(useridText.getText() != null) {
				resultText.setText(service.detail(useridText.getText()).toString());
			} else {
				JOptionPane.showMessageDialog(this, "등록된 아이디가 없습니다");
			}
		} else if (e.getSource() == nameButton) {
			if(useridText.getText() != null) {
				Member[] returnMembers = service.searchByName(nameText.getText());
				String result = "";
				for(; i < returnMembers.length; i++) {
					result += returnMembers[i].toString()+"\n";
				}
			resultText.setText(result);
			} else {
				JOptionPane.showMessageDialog(this, "등록된 회원정보가 없습니다");
			}
		} else if (e.getSource() == genderButton) {
			service.serarchByGender(ssnText.getText());
		} else if (e.getSource() == countButton) {
			resultText.setText(String.valueOf(service.count())); //string > int
		} else if (e.getSource() == updateButton) {
			JOptionPane.showMessageDialog(this, "아이디, 변경하고자 하는 비밀번호를 입력해주세요");
			Member updateMember = new Member();
			updateMember.setUserid(useridText.getText());
			updateMember.setPassword(passwordText.getText());
			service.update(updateMember);
		} else if (e.getSource() == deleteButton) {
			JOptionPane.showMessageDialog(this, "아이디, 비밀번호를 입력해주시면 탈퇴가 정상적으로 이루어집니다");
			Member deleteMember = new Member();
			deleteMember.setUserid(useridText.getText());
			deleteMember.setPassword(passwordText.getText());
			service.delete(deleteMember);
		}
	}
}