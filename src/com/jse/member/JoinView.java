package com.jse.member;

//꼭 강사님 소스 볼 것
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//UI
import javax.swing.*; //awt 망함

public class JoinView extends JFrame implements ActionListener { // Frame을 extends했기 때문에 frame 객체 생성했던 것은 지워야 한다
	private static final long serialVersionUID = 1L; // what is this?
	JButton[] buttons; // 메서드끼리는 공유해야 하니까
	JPanel panel;
	JTextField[] fields;
	JLabel[] labels;
	JButton saveButton, cancelButton;
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

		labels = new JLabel[4];
		String[] names = { "이름", "아이디", "비밀번호", "주소" }; // 예외처리, "내용" : notation
		fields = new JTextField[4];
		for (int i = 0; i < 4; i++) {// 5줄을 한줄로 바꾸자..
			labels[i] = new JLabel(names[i]);
			panel.add((labels[i]));
			fields[i] = new JTextField();
			panel.add(fields[i]);
		}
		// 필드
		saveButton = new JButton("저장");
		cancelButton = new JButton("취소");
		saveButton.addActionListener(this);
		cancelButton.addActionListener(this);
		panel.add(saveButton);
		panel.add(cancelButton);
		labels[0].setBounds(40, 10, 40, 40);
		labels[1].setBounds(40, 50, 40, 40);
		labels[2].setBounds(40, 90, 60, 40);
		labels[3].setBounds(40, 130, 40, 40);
		fields[0].setBounds(120, 10, 200, 30);
		fields[1].setBounds(120, 50, 200, 30);
		fields[2].setBounds(120, 90, 200, 30);
		fields[3].setBounds(120, 130, 280, 30);
		saveButton.setBounds(125, 330, 80, 30);
		cancelButton.setBounds(240, 330, 80, 30); // x y좌료, 가로세로 크기

		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveButton) { // 주소값 비교
			fields[0].setText("홍길동,유관순,이순신,신사임당,이도"); // setText : 자동으로 글 들어감
			fields[1].setText("hong,you,lee,shin,leedo");
			fields[2].setText("1,1,1,1,1");
			fields[3].setText("900101-1,960101-2,980101-1,011010-4,020606-3");
			String data = String.format("%s / %s / %s / %s",
					fields[0].getText(),
					fields[1].getText(),
					fields[2].getText(),  // 클릭 : notation(기호와 리터럴의 조합)\r\n
					fields[3].getText()); // text인가 string이 아니고?? .도 받아야 하니까..)
//			JOptionPane.showMessageDialog(this, data);//데이터 가지고 왔습니다. this의 의미는 무엇일까??

			String[] arr = data.split("/");// 각 스플릿을 통해 담는다 = 전처리
			String[][] mtx = new String[4][5]; // 4개의 데이터를 5번

			for (int i = 0; i < arr.length; ++i) {
				
				String[] t = arr[i].split(",");
				for (int j = 0; j < t.length; ++j) {
					mtx[i][j] = t[j];
				}
				System.out.println();
				service.add(member);
			}
			

			
		} else if (e.getSource() == cancelButton) {

		}
	}
}
