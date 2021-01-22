package com.lec.ex4_Homework2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import com.lec.ex3_Homework.Person;

public class Homework extends JFrame implements ActionListener {

	private Container container;
	private JPanel jpUp, jpDown;
//	private JLabel num,name,point;
	private JTextField txtPhone, txtName, txtPoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea jta;
	private JScrollPane scrollbar;

	String phone, name, point;
	ArrayList<Customer> customers = new ArrayList<Customer>();

	public Homework(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();

		// 레이아웃 배치
		jpUp = new JPanel(new GridLayout(3, 2));
		jpDown = new JPanel(new FlowLayout());

		//
		txtPhone = new JTextField();
		txtName = new JTextField();
		txtPoint = new JTextField();

		btnJoin = new JButton("가입");
		btnSearch = new JButton("조회");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");

		jta = new JTextArea(15, 30);
		scrollbar = new JScrollPane(jta);

		// 첫칸구성
		jpUp.add(new JLabel("폰번호", (int) CENTER_ALIGNMENT));
		jpUp.add(txtPhone);
		jpUp.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpUp.add(txtName);
		jpUp.add(new JLabel("포인트", (int) CENTER_ALIGNMENT));
		jpUp.add(txtPoint);

		// 중간구성
		jpDown.add(btnJoin);
		jpDown.add(btnSearch);
		jpDown.add(btnOutput);
		jpDown.add(btnExit);

		container.add(jpUp, BorderLayout.NORTH);
		container.add(jpDown, BorderLayout.CENTER);
		container.add(scrollbar, BorderLayout.SOUTH);

		setVisible(true);
		setBounds(100, 100, 400, 450);

		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);

	}

	PrintWriter printWriter = null;
	OutputStream os = null;
	Writer writer = null;
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		jta.setText("");
		if (e.getSource() == btnJoin) {
			String phone = txtPhone.getText().trim();
			String name = txtName.getText().trim();
			int point;
			// 나이 값 설정
			try {
				point = Integer.parseInt(txtPoint.getText());
			} catch (NumberFormatException ex) {
				point = 1000;
			}
			int preIdx = phone.indexOf("-");
			int postIdx =phone.lastIndexOf("-");
			
			if (!phone.contentEquals("") && !name.contentEquals("")&& preIdx < postIdx) {
				customers.add(new Customer(phone, name, point));
				txtPhone.setText("");
				txtName.setText("");
				txtPoint.setText("");
			} else {
				System.out.println("유효하지 않은 값");
			}
			for (Customer customer : customers) {
				System.out.println(customer);
				jta.append(customer+"\r\n");
			}

		} else if (e.getSource() == btnSearch) {				
			int idx;
			boolean searchOk = false;
			String searchTel = txtPhone.getText().trim(); //입력한 수를 변수에 넣는다
			//customers의 전화번호를 추출한다
				
			//변수를 customers의 전화번호에 순차적으로 대입한다	
//			for(idx = 0; idx<customers.length ; idx++) {
//				String temp =customers.contains(searchTel);//getPhone();
//				String post = temp.substring(temp.lastIndexOf("-")+1);
//				if(post.contentEquals(searchTel)) {
//					jta.append(customers+"\r\n");
//					searchOk = true;
//					break;
//				}
//			}			
			Iterator phone = customers.iterator();
			while(phone.hasNext())
				System.out.println(phone.next()+"\t");
			
			
			
		} else if (e.getSource() == btnOutput) {

			try {
				writer = new FileWriter("txtFile/Customer.txt");
				for (Customer customer : customers) {
					writer.write(customer.toString());
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
			txtPhone.setText("");
			txtName.setText("");
			txtPoint.setText("");
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Homework("example");
	}

}
