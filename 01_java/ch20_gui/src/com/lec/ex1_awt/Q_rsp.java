package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.ActionListener;

import javafx.event.ActionEvent;

public class Q_rsp extends Frame implements ActionListener {

	// 변수
	private Panel panel;
	private Button btnRock;
	private Button btnScissors;
	private Button btnPaper;
	private List list;
	private Button btnExit;

	// 매서드
	public Q_rsp(String title) {
		setTitle("R,S,P");

		panel = new Panel();
		btnRock = new Button("rock");
		btnScissors = new Button("scissors");
		btnPaper = new Button("paper");
		list = new List(5);
		btnExit = new Button("Exit");

		panel.add(btnRock);
		panel.add(btnScissors);
		panel.add(btnPaper);

		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		add(btnExit, BorderLayout.SOUTH);

		setVisible(true);
		setSize(new Dimension(300, 200));

		btnRock.addActionListener(this);
		btnScissors.addActionListener(this);
		btnPaper.addActionListener(this);
		btnExit.addActionListener(this);

	}

	public Q_rsp() {
		this("");
	}

	public static void main(String[] args) {
		new Q_rsp();
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		int computer = (int) (Math.random() * 3); // (0이 바위, 1이 가위, 2가 보)
		if (e.getSource() == btnRock) {
			switch (computer) {
			case 0:
				list.add("Draw : Rock");
				break;
			case 1:
				list.add("You Win : you Rock, Computer Scissors");
				break;
			case 2:
				list.add("You Lose : you Rock, Computer Paper");
				break;
			}
		} else if (e.getSource() == btnScissors) {
			switch (computer) {
			case 0:
				list.add("You Lose : you Scissors, Computer Rock");
				break;
			case 1:
				list.add("Draw : Scissors");
				break;
			case 2:
				list.add("You Win : you Scissors, Computer Paper");
				break;
			}
		} else if (e.getSource() == btnPaper) {
			switch (computer) {
			case 0:
				list.add("You Win : you Paper, Computer Rock");
				break;
			case 1:
				list.add("You Lose : you Paper, Computer Scissors");
				break;
			case 2:
				list.add("Draw : Papers");
				break;
			}
		} else if (e.getSource() == btnExit) {
			//list.removeAll();
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

}
