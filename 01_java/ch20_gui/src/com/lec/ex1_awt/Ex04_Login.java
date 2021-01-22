package com.lec.ex1_awt;

import java.awt.*;

public class Ex04_Login extends Frame {
	private Panel panel;
	private TextField txtId, txtPw;
	private Button btnLogin;
	
	public Ex04_Login(String title) {
		super(title);
		panel = new Panel();
		panel.setLayout(new GridLayout(2,2));
		txtId = new TextField("ID",20);
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("Login");
		panel.add(new Label("   I d   ", (int)CENTER_ALIGNMENT));
		panel.add(txtId);
		panel.add(new Label("   P W   ", (int)CENTER_ALIGNMENT));
		panel.add(txtPw);
		add(panel, BorderLayout.NORTH);
		add(btnLogin,BorderLayout.SOUTH);
		setSize(new Dimension(400,200));
//		setLocation(0,0);  없으면 자동 기본값 0,0
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Ex04_Login("Login");
	}
	
}
