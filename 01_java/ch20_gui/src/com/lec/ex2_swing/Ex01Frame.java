package com.lec.ex2_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex01Frame extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel jlbl;
	private JButton btn;

	public Ex01Frame(String title) {
		super(title);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = (JPanel) getContentPane(); // 컨테이너(프레임)를 얻어옴
		panel.setLayout(new FlowLayout()); // 컨테이너프레임이 보더레이아웃을 쓰고 있어서 잡아줄것
		jlbl = new JLabel("monday", (int) CENTER_ALIGNMENT);
		jlbl.setPreferredSize(new Dimension(150, 200));
		btn = new JButton("end");
		btn.setPreferredSize(new Dimension(200, 200));
		panel.add(jlbl);
		panel.add(btn);

		setVisible(true);
		// pack(); 최소한의 사이즈 셋팅
		setSize(new Dimension(500, 300));
		setVisible(true);
		// btn에 이벤트리스너 추가
		btn.addActionListener(this);

	}

	public static void main(String[] args) {
		new Ex01Frame("example");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

}
