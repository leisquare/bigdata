package com.lec.ex3_Homework;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

import java.util.ArrayList;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
	private JPanel jp, jp2, jp3;
	private Container container;
	private ImageIcon icon;
	private JButton btnIn, btnOut;
	private JTextField jtxtName, jtxtTel, jtxtAge;

	String name, tel, age;
	ArrayList<Person> persons = new ArrayList<Person>();

	public MyFrame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		jp = new JPanel(new GridLayout(3, 2));
		jp2 = new JPanel(new FlowLayout());
		jp3 = new JPanel(new GridLayout(2, 1));

		// container.setLayout(new FlowLayout());

		jtxtName = new JTextField();
		jtxtTel = new JTextField();
		jtxtAge = new JTextField();

		icon = new ImageIcon("icon/add1.png");
		btnIn = new JButton("입력", icon);
		btnOut = new JButton("출력", icon);

		btnIn.addActionListener(this);
		btnOut.addActionListener(this);

		// 상단칸구성
		jp.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jp.add(jtxtName);
		jp.add(new JLabel("전화", (int) CENTER_ALIGNMENT));
		jp.add(jtxtTel);
		jp.add(new JLabel("나이", (int) CENTER_ALIGNMENT));
		jp.add(jtxtAge);

		// 하단칸구성
		jp2.add(btnIn);
		jp2.add(btnOut);

		jp3.add(jp);
		jp3.add(jp2);

		container.add(jp3);

		setVisible(true);
		setBounds(100, 100, 300, 200);
	}

	PrintWriter printWriter = null;
	OutputStream os = null;
	Writer writer = null;

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIn) {
			int age;
			String name = jtxtName.getText().trim();
			String tel = jtxtTel.getText().trim();
			//나이 값 설정
			try {
				age = Integer.parseInt(jtxtAge.getText());
			} catch (NumberFormatException ex) {
				age = -1;
			}
			
			if (!name.contentEquals("") && !tel.contentEquals("")&& age !=-1) {
				persons.add(new Person(name, tel, age));
				jtxtName.setText("");
				jtxtTel.setText("");
				jtxtAge.setText("");
			}else {
				System.out.println("유효하지 않은 값");
			}

		} else if (e.getSource() == btnOut) {

			try {
				writer = new FileWriter("txtFile/Person.txt");
				for (Person person : persons) {
					System.out.println(person);
					writer.write(person.toString());
				}

			} catch (FileNotFoundException ex2) {
				System.out.println("파일 못 찾음" + ex2.getMessage());
			} catch (IOException ex2) {
				System.out.println("쓰기 예외" + ex2.getMessage());
			} finally {
				try {
					if (writer != null)
						writer.close();
				} catch (Exception ignore) {
					System.out.println(ignore.getMessage());
				}
			}
		}
	}

	public static void main(String[] args) {
		new MyFrame("GUI ex2");
	}

}
