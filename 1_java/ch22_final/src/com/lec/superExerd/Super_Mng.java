package com.lec.superExerd;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.lec.studentGUI.StudentSwingDao;
import com.lec.studentGUI.StudentSwingDto;

public class Super_Mng extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtCId, txtCTel, txtCName, txtCPoint, txtCAmount;
	private Vector<String> levelname;
	private JComboBox<String> comLevelName;
	private JButton btnCIdSearch, btnCTelSearch, btnCNameSearch, btnBuyWithPoint;
	private JButton btnBuy, btnLevelNameOutput, btnAllOutput, btnInsert, btnCTelUpdate, btnDelete, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	Super_Dao dao = Super_Dao.getInstance();

	public Super_Mng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3));
		jpbtn = new JPanel();
		txtCId = new JTextField(20);
		txtCTel = new JTextField(20);
		txtCName = new JTextField(20);
		txtCPoint = new JTextField(20);
		txtCAmount = new JTextField(20);
		levelname = dao.getLevelNames();
		comLevelName = new JComboBox<String>(levelname);
		btnCIdSearch = new JButton("아이디 검색");
		btnCTelSearch = new JButton("폰4자리(FULL) 검색");
		btnCNameSearch = new JButton("고객 이름 검색");
		btnBuyWithPoint = new JButton("포인트로만 구매");
		jpup.add(new JLabel(" 아 이 디 ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCId);
		jpup.add(btnCIdSearch);
		jpup.add(new JLabel("고 객 전 화", (int) CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);
		jpup.add(new JLabel("고 객 이 름", (int) CENTER_ALIGNMENT));
		jpup.add(txtCName);
		jpup.add(btnCNameSearch);
		jpup.add(new JLabel("포  인  트", (int) CENTER_ALIGNMENT));
		jpup.add(txtCPoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("구 매 금 액", (int) CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel(""));// 빈 라벨 추가하는 부분
		jpup.add(new JLabel("고 객 등 급", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		btnBuy = new JButton("물품 구매");
		btnLevelNameOutput = new JButton("등급별출력");
		btnAllOutput = new JButton("전체출력");
		btnInsert = new JButton("회원가입");
		btnCTelUpdate = new JButton("번호수정");
		btnDelete = new JButton("회원탈퇴");
		btnExit = new JButton("나가기");
		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOutput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCTelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);
		txtPool = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(800, 400));
		setLocation(200, 200);
		setVisible(true);
		txtPool.setText("\t 검색 후 구매할 것.");

		btnCIdSearch.addActionListener(this);
		btnCTelSearch.addActionListener(this);
		btnCNameSearch.addActionListener(this);
		btnBuyWithPoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLevelNameOutput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCTelUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCIdSearch) {
			int cId = 0;

			try {
				cId = Integer.parseInt(txtCId.getText().trim());
			} catch (NumberFormatException e1) {
				txtPool.setText("고객ID를 입력할 것");
				return;
			}
			Super_Dto dto = dao.selectcId(cId);
			if (dto != null) {
				txtPool.setText("\tID\t전화\t이름\t포인트\t구매누적액\t 고객레벨\t 레벨업을 위한 남은 액수\n");
				txtPool.append("\t───────────────────────────────\n");

				// txtCId.setText(dto.getCid());
				txtPool.append(dto.toString() + "\n");
				txtCTel.setText(dto.getcTel());
				txtCName.setText(dto.getcName());
				txtCPoint.setText(String.valueOf(dto.getcPoint()));
				txtCAmount.setText("");
				comLevelName.setSelectedItem(dto.getLevelname());

				txtPool.setText(cId + " 검색 완료");
			} else {
				txtPool.setText(cId + "은 없는 회원번호입니다");
			} // if

		} else if (e.getSource() == btnCTelSearch) {// 2. 폰번호 검색

			String cTel = txtCTel.getText().trim();
			if (cTel.length() < 4) {
				txtPool.setText("4자리 번호를 입력하세요.");
				return;
			}
			ArrayList<Super_Dto> dtos = dao.selectcTel(cTel);
			if (dtos.size() >= 1) {
				txtPool.setText("\tID\t전화\t이름\t포인트\t구매누적액\t 고객레벨\t 레벨업을 위한 남은 액수\n");
				txtPool.append("\t───────────────────────────────\n");
				for (Super_Dto d : dtos) {
					txtPool.append("\t" + d.toString() + "\n");
					txtCId.setText(String.valueOf(d.getCid()));
					txtCName.setText(d.getcName());
					txtCPoint.setText(String.valueOf(d.getcPoint()));
				}
			} else {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				txtPool.setText(cTel + "은 유효하지 않은 전화번호입니다");
			}
		} else if (e.getSource() == btnCNameSearch) {// 3. 고객명 검색
			String cName = txtCName.getText().trim();
			ArrayList<Super_Dto> dtos = dao.selectcName(cName);
			if (dtos.size() >= 1) {
				txtPool.setText("\tID\t전화\t이름\t포인트\t구매누적액\t 고객레벨\t 레벨업을 위한 남은 액수\n");
				txtPool.append("\t───────────────────────────────\n");
				for (Super_Dto d : dtos) {
					txtPool.append("\t" + d.toString() + "\n");
					txtCId.setText(String.valueOf(d.getCid()));
					txtCTel.setText(d.getcTel());
					txtCName.setText(d.getcName());
					txtCPoint.setText(String.valueOf(d.getcPoint()));
				}
			} else {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				txtPool.setText(cName + "은 없는 이름입니다");
			}
		} else if (e.getSource() == btnBuyWithPoint) {// 4. 포인트로 구매
			int cId = 0, cAmount = 0, cPoint = 0;
			try {
				cId = Integer.parseInt(txtCId.getText().trim());
				cAmount = Integer.parseInt(txtCAmount.getText().trim());
				cPoint = Integer.parseInt(txtCPoint.getText().trim());
				if (cPoint < cAmount) {
					txtPool.setText("포인트가 부족하여 포인트로 구매 불가합니다");
					return;
				}
			} catch (NumberFormatException e1) {
				txtPool.setText("유효한 고객ID와 구매금액을 입력하시고 유효한 포인트로 구매하세요");
				return;
			}
			int result = dao.updatecPoint(cId, cAmount);
			if (result == Super_Dao.SUCCESS) {
				txtPool.setText("포인트로 구매 성공");
				txtCPoint.setText(String.valueOf(cPoint - cAmount));
				txtCAmount.setText("");
			} else {
				txtPool.setText("고객 아이디가 유효하지 않습니다");
			}

		} else if (e.getSource() == btnBuy) { // 5. 물품 구매(포인트 누적, 누걱금액변경, 등급변경)
			int	cId = Integer.parseInt(txtCId.getText().trim());
			int cAmount = Integer.parseInt(txtCAmount.getText().trim());
			int result = dao.buy(cAmount, cId);
			if (result == Super_Dao.SUCCESS) {
				txtPool.setText("구매 완료");
			} else {
				txtPool.setText("고객 아이디가 유효하지 않습니다");
			}

		} else if (e.getSource() == btnLevelNameOutput) {// 6. 등급별 출력
			txtCId.setText("");
			txtCTel.setText("");
			txtCName.setText("");
			txtCPoint.setText("");
			String levelName = comLevelName.getSelectedItem().toString();
			ArrayList<Super_Dto> dtos = dao.levelNameGetCustomers(levelName);
			if (dtos.size() != 0) {
				txtPool.setText("\tID\t전화\t이름\t포인트\t구매누적액\t 고객레벨\t 레벨업을 위한 남은 액수\n");
				txtPool.append("\t───────────────────────────────\n");
				for (Super_Dto d : dtos) {
					txtPool.append("\t" + d.toString() + "\n");
				}
			} else {
				txtPool.setText("해당하는 고객 없음");
			}

		} else if (e.getSource() == btnAllOutput) {// 7. 전체 출력
			ArrayList<Super_Dto> dtos = dao.getCustomers();
			if (dtos.size() != 0) {
				txtPool.setText("\tID\t전화\t이름\t포인트\t구매누적액\t 고객레벨\t 레벨업을 위한 남은 액수\n");
				txtPool.append("\t───────────────────────────────\n");
				for (Super_Dto d : dtos) {
					txtPool.append("\t" + d.toString() + "\n");
				}
			} else {
				System.out.println("해당하는 고객이 없습니다");
			}

		} else if (e.getSource() == btnInsert) {// 8. 회원가입
			String cTel = txtCTel.getText().trim();
			String cName = txtCName.getText().trim();
			if (cTel.equals("")||cName.equals("")) {
				txtPool.setText("번호와 이름 입력해야 가입 가능");
				return;
			}
			txtPool.setText("");
			int result = dao.insertCustomer(cTel,cName);
			if (result == StudentSwingDao.SUCCESS) {
				txtPool.append(cTel + " 가입되었습니다.");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			}
			
			
			
		} else if (e.getSource() == btnCTelUpdate) {// 9, 회원정보 수정(번호수정)
			int cId = 0;
			String cTel;
			try {
				cId = Integer.parseInt(txtCId.getText().trim());
				cTel = txtCTel.getText().trim();
				if (cTel.equals("")) {
					txtPool.setText("변경할 전화번호를 입력하셔야 번호수정이 가능합니다.");
					return;
				}
			} catch (NumberFormatException e1) {
				txtPool.setText("유효한 고객ID를 검색 후 변호변경을 하세요");
				return;
			}
			int result = dao.updateCustomer(cId, cTel);
			if (result == Super_Dao.SUCCESS) {
				txtPool.setText("아이디 : " + cId + "님의 전화번호가 수정되었습니다");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			} else {
				txtPool.setText("유효한 고객ID를 검색 후 변호변경을 하세요");
			}

		} else if (e.getSource() == btnDelete) {// 10 탈퇴
			String cTel = txtCTel.getText().trim();
			if (cTel.equals("")) {
				txtPool.setText("번호 입력해야 탈퇴 가능");
				return;
			}
			txtPool.setText("");
			int result = dao.deleteCustomer(cTel);
			if (result == StudentSwingDao.SUCCESS) {
				txtPool.append(cTel + " 탈퇴되었습니다.");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			}

		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Super_Mng("슈퍼 흉내");
	}
}
