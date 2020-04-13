package com.jse.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; //awt 망함

public class JoinView extends JFrame implements ActionListener { // Frame을 extends했기 때문에 frame 객체 생성했던 것은 지워야 한다
	private static final long serialVersionUID = 1L; // what is this?
// 메서드끼리는 공유해야 하니까
	JPanel panel;
	JTextField[] fields;
	JTextArea[] textArea;
	JLabel[] labels;
	JLabel areaLabel;
	JButton saveButton, listButton, loginButton;
	MemberService service;

	public JoinView() {
		service = new MemberServiceImpl();
	}

	public void open() {
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ?
		panel = new JPanel();
		this.add(panel); // 여러개 갖는다
		this.setVisible(true);

		// 라벨 : 단순 반복되는 것에는 for가 좋음.. 아주 많이 쓰이는 패턴이므로 외워둘 것

		labels = new JLabel[5];
		fields = new JTextField[5];
		JTextArea textArea = new JTextArea();
		String[] names = { "이름", "아이디", "비밀번호", "주민번호", "주소" }; // 예외처리, "내용" : notation
		for (int i = 0; i < names.length; i++) {// 5줄을 한줄로 바꾸자..
			labels[i] = new JLabel(names[i]);
			panel.add((labels[i]));
			fields[i] = new JTextField();
			panel.add(fields[i]);
		}
		// 필드
		areaLabel = new JLabel("검색결과");
		panel.add(areaLabel);
		panel.add(textArea);
		saveButton = new JButton("저장");
		listButton = new JButton("목록");
		listButton = new JButton("로그인");
		saveButton.addActionListener(this);
		listButton.addActionListener(this);
		panel.add(saveButton);
		panel.add(listButton);
		panel.add(loginButton);
		labels[0].setBounds(40, 10, 40, 40);
		labels[1].setBounds(40, 50, 40, 40);
		labels[2].setBounds(40, 90, 60, 40);
		labels[3].setBounds(40, 130, 40, 40);
		labels[4].setBounds(40, 170, 60, 40);
		areaLabel.setBounds(40, 210, 60, 40);
		fields[0].setBounds(120, 10, 200, 30);
		fields[1].setBounds(120, 50, 200, 30);
		fields[2].setBounds(120, 90, 200, 30);
		fields[3].setBounds(120, 130, 280, 30);
		fields[4].setBounds(120, 180, 280, 30);
		textArea.setBounds(120, 220, 280, 150);
		saveButton.setBounds(125, 330, 80, 30);
		listButton.setBounds(240, 330, 80, 30); // x y좌료, 가로세로 크기
		loginButton.setBounds(340, 400, 80, 30);

		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == saveButton) { // 주소값 비교
			fields[0].setText("홍길동,유관순,이순신,신사임당,이도"); // setText : 자동으로 글 들어감
			fields[1].setText("hong,you,lee,shin,leedo");
			fields[2].setText("1,1,1,1,1");
			fields[3].setText("900101-1,960101-2,980101-1,011010-4,020606-3");
			fields[4].setText("서울,서울,서울,부산,부산");
			String data = String.format("%s / %s / %s / %s /%s", fields[0].getText(), fields[1].getText(),
					fields[2].getText(), // 클릭 : notation(기호와 리터럴의 조합)\r\n
					fields[3].getText(), fields[4].getText()); // text인가 string이 아니고?? .도 받아야 하니까..)

			String[] arr = data.split("/");// 각 스플릿을 통해 담는다 = 전처리
			Member[] members = new Member[5];
			String[] names = arr[0].split(",");
			String[] userids = arr[1].split(",");
			String[] passwords = arr[2].split(",");
			String[] uniques = arr[3].split(",");
			String[] addrs = arr[4].split(",");
			for (int i = 0; i < 5; i++) {
				members[i] = new Member(); // members[i] = elements라서 for안에서만 객체로서 활동
				members[i].setName(names[i]);
				members[i].setUserid(userids[i]);
				members[i].setPassword(passwords[i]);
				members[i].setUnique(uniques[i]);
				members[i].setAddr(addrs[i]);
				service.add(members[i]);
			}

		} else if (e.getSource() == listButton) {
			JOptionPane.showMessageDialog(this, "CLICK");
			Member[] members = service.getMembers();
			for (int i = 0; i < members.length; i++) {
				System.out.println("화면 목록 결과");
				System.out.println(members);

			}
		}
	}
}