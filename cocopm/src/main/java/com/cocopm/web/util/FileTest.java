package com.cocopm.web.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FileTest {
	public final static String FILE_PATH = "C:\\Users\\bit\\Basic\\Bit\\cocopm\\src\\main\\resources\\static\\user\\";

	public static void main(String[] args) {
		try {
			// 파일처리 3인방 1.초기화 2,경로지정,이름 3.Buffer2종
			File file = new File(FILE_PATH + "list.txt"); // io
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			List<String> list = new ArrayList<>();
			while(true) {
				switch(JOptionPane.showInputDialog("0.종료 1.쓰기 2.읽기")) {
				case "0": return;
				case "1": 
					String message = JOptionPane.showInputDialog("메시지 입력");
					System.out.println(message);
					writer.write(message);
					writer.newLine();
					writer.flush();
					break;
				case "2": 
					while((message = reader.readLine()) != null) {
						list.add(message+"/"); 
					}
					JOptionPane.showMessageDialog(null, list);
					reader.close();
					break;
				}
			}
		} catch (Exception e) { // 100프로 이거임
		}
	}
}