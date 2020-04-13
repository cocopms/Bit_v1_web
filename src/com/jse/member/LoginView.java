package com.jse.member;

//꼭 강사님 소스 볼 것
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//UI
import javax.swing.*; //awt 망함

public class LoginView extends JFrame implements ActionListener { // Frame을 extends했기 때문에 frame 객체 생성했던 것은 지워야 한다
	private static final long serialVersionUID = 1L; // what is this?
	JButton[] buttons; // 메서드끼리는 공유해야 하니까
	JPanel panel;
	JTextField[] fields;
	JLabel[] labels;
	JButton saveButton, cancelButton;

	public void open() {
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ?
		panel = new JPanel();
		this.add(panel); // 여러개 갖는다
		this.setVisible(true);

		// 라벨 : 단순 반복되는 것에는 for가 좋음.. 아주 많이 쓰이는 패턴이므로 외워둘 것
		labels = new JLabel[2];
		String[] names = { "아이디", "비밀번호" }; // 예외처리, "내용" : notation

		fields = new JTextField[2];
		for (int i = 0; i < 2; i++) {// 5줄을 한줄로 바꾸자..
			labels[i] = new JLabel(names[i]);
			panel.add((labels[i]));
			fields[i] = new JTextField();
			panel.add(fields[i]);
		}
		// 필드

		saveButton = new JButton("로그인");
		cancelButton = new JButton("취소");
		saveButton.addActionListener(this);
		cancelButton.addActionListener(this);
		panel.add(saveButton);
		panel.add(cancelButton);
		labels[0].setBounds(40, 10, 100, 40);
		labels[1].setBounds(40, 50, 40, 40);
		fields[0].setBounds(120, 10, 200, 30);
		fields[1].setBounds(120, 50, 200, 30);
		saveButton.setBounds(125, 330, 80, 30);
		cancelButton.setBounds(240, 330, 80, 30); // x y좌료, 가로세로 크기

		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveButton) { // 주소값 비교
			JOptionPane.showMessageDialog(this, fields[0].getText()); // 클릭 : notation(기호와 리터럴의 조합) 클릭은 test, 왜
																			// text인가 string이 아니고?? .도 받아야 하니까...
		} else if (e.getSource() == cancelButton) {

		}

	}
}