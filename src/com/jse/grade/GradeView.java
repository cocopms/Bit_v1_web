package com.jse.grade;

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

public class GradeView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Container container;
	private JLabel title, nameLabel, koreanLabel, englishLabel, mathLabel, javaLabel;
	private JTextField nameText, koreanText, englishText, mathText, javaText;
	private JTextArea resultText;
	private JButton submitButton, listButton;
	public GradeService service;

	public void open() {
		service = new GradeServiceImpl();
		setTitle("Swing Exercise");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		container = getContentPane();
		container.setLayout(null);

		title = new JLabel("Swing Form");
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

		koreanLabel = new JLabel("korean");
		koreanLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		koreanLabel.setSize(100, 20);
		koreanLabel.setLocation(100, 150);
		container.add(koreanLabel);

		koreanText = new JTextField();
		koreanText.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		koreanText.setSize(150, 20);
		koreanText.setLocation(200, 150);
		container.add(koreanText);

		englishLabel = new JLabel("english");
		englishLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		englishLabel.setSize(100, 20);
		englishLabel.setLocation(100, 200);
		container.add(englishLabel);

		englishText = new JTextField();
		englishText.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		englishText.setSize(150, 20);
		englishText.setLocation(200, 200);
		container.add(englishText);

		mathLabel = new JLabel("math");
		mathLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		mathLabel.setSize(100, 20);
		mathLabel.setLocation(100, 250);
		container.add(mathLabel);

		mathText = new JTextField();
		mathText.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		mathText.setSize(150, 20);
		mathText.setLocation(200, 250);
		container.add(mathText);

		javaLabel = new JLabel("java");
		javaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		javaLabel.setSize(100, 20);
		javaLabel.setLocation(100, 300);
		container.add(javaLabel);

		javaText = new JTextField();
		javaText.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		javaText.setSize(150, 20);
		javaText.setLocation(200, 300);
		container.add(javaText);

		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Arial", Font.PLAIN, 15));
		submitButton.setSize(100, 20);
		submitButton.setLocation(150, 450);
		submitButton.addActionListener(this);
		container.add(submitButton);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			JOptionPane.showMessageDialog(this, "전송");
			nameText.setText("홍길동,유관순,이순신,신사임당,이도"); // 자연어
			koreanText.setText("90,70,20,50,50");
			englishText.setText("50,40,5,20,20");
			mathText.setText("40,40,20,30,30");
			javaText.setText("10,20,10,20,20");
			Grade[] grades = new Grade[5];
			String[] names = nameText.getText().split(",");
			String[] korean = koreanText.getText().split(",");
			String[] english = englishText.getText().split(",");
			String[] math = mathText.getText().split(",");
			String[] java = javaText.getText().split(",");
			int i;
			for (i = 0; i < 5; ++i) {
				grades[i] = new Grade(); // 차원을 높인다, grade 공간인데 배열이니까...
				grades[i].setName(names[i]);
				grades[i].setKorean(Integer.parseInt(korean[i])); // 형변환은 split 후에 해주어야 .(점) 오류가 없다
				grades[i].setEnglish(Integer.parseInt(english[i]));
				grades[i].setMath(Integer.parseInt(math[i]));
				grades[i].setJava(Integer.parseInt(java[i]));
				service.add(grades[i]); //전송
			}
		} else if (e.getSource() == listButton) {
			JOptionPane.showMessageDialog(this, "리스트");
			Grade[] graderesult = service.getGrades(); //가져오기
			
			String result = ""; //여기부터 몰랐음
			int i;
			for(i=0; i<graderesult.length; ++i) {
				result += graderesult[i]+"\n";
			}
			nameText.setText(""); //null
			koreanText.setText("");
			englishText.setText("");
			mathText.setText("");
			javaText.setText("");
			resultText.setText(result); //Text니까 String type 맞춰주기
		}

	}
}
