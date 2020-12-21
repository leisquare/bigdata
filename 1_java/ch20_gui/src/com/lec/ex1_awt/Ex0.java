package com.lec.ex1_awt;

import java.awt.*;

public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("title");
		Button btn = new Button("button");
		Button btn1 = new Button("just button");
		frame.add(btn,BorderLayout.NORTH);
		frame.add(btn1,BorderLayout.CENTER);
		frame.setSize(new Dimension(300,200));
		frame.setLocation(100,50);
		frame.setVisible(true);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		frame.setVisible(false);  //화면에서 안보이게
		frame.dispose();	//프레임의 모든 자원을 해제
		System.exit(0);
	}
}
