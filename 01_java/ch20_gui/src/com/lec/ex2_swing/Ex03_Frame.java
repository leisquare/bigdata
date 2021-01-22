package com.lec.ex2_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex03_Frame extends JFrame implements ActionListener {

	public static void main(String[] args) {
		new Ex03_Frame("GUI ex");
	}

	private Container container;
	private JPanel jp;
	private JTextField jtxtName, jtxtTel, jtxtAge;
	private ImageIcon icon;
	private JButton btnOut;
	private JTextArea jta;
	private JScrollPane scrollbar; // 텍스트 에어리어가 그냥은 스크롤바가 생기지 않아서 스크롤바를 연동해줘야한다.

	public Ex03_Frame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		// container.setLayout(new Borderlayout());
		jp = new JPanel(new GridLayout(3, 2));
		jtxtName = new JTextField();
		jtxtTel = new JTextField();
		jtxtAge = new JTextField();
		icon = new ImageIcon("icon/output.png");
		btnOut = new JButton("출력", icon);
		jta = new JTextArea(5, 30);
		scrollbar = new JScrollPane(jta);

		jp.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jp.add(jtxtName);
		jp.add(new JLabel("전화", (int) CENTER_ALIGNMENT));
		jp.add(jtxtTel);
		jp.add(new JLabel("나이", (int) CENTER_ALIGNMENT));
		jp.add(jtxtAge);

		container.add(jp, BorderLayout.NORTH);
		container.add(btnOut, BorderLayout.CENTER);
		container.add(scrollbar, BorderLayout.SOUTH);

		setVisible(true);
//		setSize(new Dimension(400,300));
//		setLocation(100,100);
		setBounds(100, 100, 400, 300); // 위의 두 줄을 이걸로 처리할 수 있다는것 같다.

		btnOut.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOut) {
			String name = jtxtName.getText().trim();
			String tel = jtxtTel.getText().trim();
			if (!name.contentEquals("") && !tel.contentEquals("")) {
				int age;
				try {
					age = Integer.parseInt(jtxtAge.getText());
				} catch (NumberFormatException ex) {
					age= -1;
				}
				String result = "[이름]"+name+"\t[전화]"+tel;
				if(age>=0 && age<130) {
					result += "\t[나이]"+age;
				}else {
					result += "\t[나이] 유효하지 않은 나이를 입력";
				}
				
				System.out.println(result);
				//jta.setText(result);
				jta.append(result+"\r\n");
				jtxtName.setText("");
				jtxtTel.setText("");
				jtxtAge.setText("");


				return;
			} else {
				System.out.println("이름과 전화번호는 반드시 입력");
			}
		}

	}

}
