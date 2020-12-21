package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex05_Frame extends Frame implements ActionListener {

	private Panel panel;
	private TextField txtField;
	private Button btnOk;
	private Button btnExit;
	private List list;

	public Ex05_Frame(String title) {
		setTitle(title);
		// layOut셋팅, 컴포넌트 생성 후 add, setVisible, setSize
		// setLayout(new BorderLayout());
		panel = new Panel(); // panel은 Flowlayout이 기본값
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("Exit");
		list = new List();
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		setVisible(true);
		setSize(new Dimension(400, 200));
		// 1. implements ActionListener
		// 2. 이벤트리스너 추가
		// 3. 로직 추가
		btnOk.addActionListener(this); // this.actionPerformed가 자동호출됨.
		btnExit.addActionListener(this);
	}

	public Ex05_Frame() {
		this("");
	}

	public static void main(String[] args) {
		new Ex05_Frame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			// txtField의 텍스트를 리스트로 추가하고 txt필드를 비우고싶다.
			list.add(txtField.getText());
			txtField.setText("");
		} else if (e.getSource() == btnExit) {
			// 종료
			setVisible(false);
			dispose();
			System.exit(0);

		}
	}

}
