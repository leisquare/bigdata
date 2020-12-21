package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javafx.event.ActionEvent;

public class Ex02_MyFrame extends Frame implements ActionListener{

	private Label lbl1; // 추가한 컴포넌트 변소들 선언
	private Button btnExit;

	public Ex02_MyFrame() {
		// 프레임과 라벨에 버튼 추가 후 setVisible과 setsize
		// 프레임의 레이아웃스타일을 플로우레이아웃으로- add순서ㄷ대로 차곡차곡왼쪽부터 쌓인다.
		setLayout(new FlowLayout()); // 보더 레이아웃이 기본값이다.
		// setLayout(new GridLayout(2,2)); 2행2열짜리 격자형 레이아웃
		lbl1 = new Label("these days");
		lbl1.setPreferredSize(new Dimension(150, 200)); // 컴포넌트사이즈
		btnExit = new Button("Exit");
		btnExit.setPreferredSize(new Dimension(200, 200));
		add(lbl1);
		add(btnExit);
		setVisible(true);
		setSize(new Dimension(500, 300));
		setLocation(100, 100);
		
		//btnExit 클릭 이벤트 this.actionPerformed(btnExit)호출
		btnExit.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}

		});
	}

	public Ex02_MyFrame(String title) {
		this();
		setTitle(title);
	}
	
	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		if(e.getSource() ==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	
	public static void main(String[] args) {
		new Ex02_MyFrame("second GUI Example");
	}

}
