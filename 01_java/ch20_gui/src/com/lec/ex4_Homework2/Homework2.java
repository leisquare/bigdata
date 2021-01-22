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

public class Homework2 extends JFrame implements ActionListener {

	private Container container;
	private JPanel jpUp, jpDown;
//	private JLabel num,name,point;
	private JTextField txtPhone, txtName, txtPoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea jta;
	private JScrollPane scrollbar;

	String phone, name, point;
	ArrayList<Customer> customers = new ArrayList<Customer>();

	public Homework2(String title) {
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
		setResizable(false);
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
			int point=1000;
			// 나이 값 설정
			try {
				point = Integer.parseInt(txtPoint.getText());
			} catch (Exception ex) {
			}
			int preIdx = phone.indexOf("-");
			int postIdx = phone.lastIndexOf("-");

			if (!phone.contentEquals("") && !name.contentEquals("") && preIdx < postIdx) {
				
//				Customer new_customer = new Customer(phone, name, point);
//				customers.add(new_customer);
//				jta.append(new_customer.toString() + "\r\n");
				customers.add(new Customer(phone, name, point));
				txtPhone.setText("");
				txtName.setText("");
				txtPoint.setText("");
				jta.append(customers + "\r\n");
			} else {
				System.out.println("유효하지 않은 값");
			}

		} else if (e.getSource() == btnSearch) {
			String searchPhone = txtPhone.getText().trim();
			int idx;
			for(idx=0 ; idx<customers.size() ; idx++) {
				String phone = customers.get(idx).getPhone();
				String postPhone = phone.substring(phone.lastIndexOf('-')+1);
				if(postPhone.equals(searchPhone)) {
					txtPhone.setText(customers.get(idx).getPhone());
					txtName.setText(customers.get(idx).getName());
					txtPoint.setText(String.valueOf(customers.get(idx).getPoint()));
					break;
				}
			}
			
			if(idx == customers.size()) {
				txtPhone.setText("없는 회원님");
				txtName.setText("");
				txtPoint.setText("1000");
			}			
			Iterator phone = customers.iterator();
			while (phone.hasNext())
				System.out.println(phone.next() + "\t");

			
			
		} else if (e.getSource() == btnOutput) {
			try {
				writer = new FileWriter("txtFile/Customer.txt",true);
				for (Customer customer : customers) {
					writer.write(customer.toString());
				}
			} catch (FileNotFoundException e1) {
				System.out.println("파일 못 찾음" + e1.getMessage());
			} catch (IOException e1) {
				System.out.println("쓰기 예외" + e1.getMessage());
			} finally {
				try {
					if (writer != null)
						writer.close();
				} catch (Exception e1) {
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
		new Homework2("example");
	}

}
