package com.lec.ex1_awt;

import java.awt.*;

public class Ex03_Login extends Frame {
	private Label lbl1;
	private TextField txtId;
	private Label lbl2;
	private TextField txtPw;
	private Button btnLogin;

	public Ex03_Login(String title) {
		super(title);
		setLayout(new FlowLayout()); // 프레임의 레이아웃 세팅
		lbl1 = new Label("  ID  ");
		txtId = new TextField("ID", 20);
		lbl2 = new Label("  Pw  ");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*'); // 글자를 별로 가리기
		btnLogin = new Button("Login");
		add(lbl1);
		add(txtId);
		add(lbl2);
		add(txtPw);
		add(btnLogin);
		setSize(new Dimension(250, 150));
		setResizable(false); // 사용자가 사이즈 조절 불가
		setLocation(100, 100);
		setVisible(true);

	}

	public Ex03_Login() {

	}

	public static void main(String[] args) {
		new Ex03_Login("Login");
	}

}
