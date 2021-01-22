package com.lec.studentGUI;

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

public class SwingStudentMng extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtSNo, txtSName, txtScore;
	private Vector<String> mNames; // 콤보박스에 들어갈 전공리스트를 담을 vector
	private JComboBox<String> comMname;
	private JButton btnSNoSearch, btnSNameSearch, btnMNameSearch;
	private JButton btnInput, btnUpdate;
	private JButton btnStudentOut, btnExpelOut, btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private String driver;
	private String url;
	StudentSwingDao dao = StudentSwingDao.getInstance();

	public SwingStudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane(); // 화면구현
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel(new FlowLayout());
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		mNames = dao.getMNamelist();
		comMname = new JComboBox<String>(mNames);
		txtScore = new JTextField(10);
		btnSNoSearch = new JButton("학번검색");
		btnSNameSearch = new JButton("이름검색");
		btnMNameSearch = new JButton("전공검색");
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpelOut = new JButton("제적자출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(600, 400));
		setLocation(200, 150);
		setVisible(true);
		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSNoSearch) { // 1. 학번으로 검색
			String sNo = txtSNo.getText().trim();
			if (sNo.equals("")) {
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("학번을 입력 후 학번 검색을 하세요");
				return;
			} 
			StudentSwingDto dto = dao.selectsNo(sNo);
			if (dto != null) { // 
				txtSName.setText(dto.getsName());
				comMname.setSelectedItem(dto.getmName());
				txtScore.setText(String.valueOf(dto.getScore()));
				txtPool.setText(sNo + " 검색 완료");
			} else { 
				txtSName.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
				txtPool.setText(sNo + "은 유효하지 않는 학번입니다");
			} // if
		} else if (e.getSource() == btnSNameSearch) { //2. 이름으로 검색
			String sName = txtSName.getText().trim();
			if (sName.length() == 0) {
				txtSNo.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("이름은 입력하고 검색해야지");
				return;
			} 
			ArrayList<StudentSwingDto> students = dao.selectsName(sName);
			if (students.size() > 1) {
				txtPool.setText("\t학번\t이름\t\t학과명\t점수\n");
				txtPool.append("\t───────────────────────────────\n");
				for (StudentSwingDto student : students) {
					txtPool.append("\t" + student.toString() + "\n");
					txtSNo.setText(student.getsNo());
					comMname.setSelectedItem(student.getmName());
					// txtScore.setText(""+student.getScore());
					txtScore.setText(String.valueOf(student.getScore()));
				} // for
			} else if (students.size() == 1) {
				txtSNo.setText(students.get(0).getsNo());
				comMname.setSelectedItem(students.get(0).getmName());
				// txtScore.setText(""+students.get(0).getScore());
				txtScore.setText(String.valueOf(students.get(0).getScore()));
			} else {
				txtSNo.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
				txtPool.setText("해당 이름의 학생이 없습니다");
			} // if
		} else if (e.getSource() == btnMNameSearch) {//3. 전공으로 검색
			txtSNo.setText("");
			txtSName.setText("");
			txtScore.setText("");
			String mName = comMname.getSelectedItem().toString();
			if (mName.equals("")) {
				txtPool.setText("전공은 선택하고 검색해야지");
				return;
			}
			ArrayList<StudentSwingDto> students = dao.selectmName(mName);
			if (students.size() != 0) {
				txtPool.setText("\t학번\t이름\t\t학과명\t점수\n");
				txtPool.append("\t───────────────────────────────\n");
				for (StudentSwingDto student : students) {
					txtPool.append("\t" + student.toString() + "\n");
				} // for
			} else {
				txtPool.setText("해당 학과의 학생이 없습니다");
			} // if
		} else if (e.getSource() == btnInput) {// 4. 학생입력
			String sName = txtSName.getText().trim();
			String mName = comMname.getSelectedItem().toString();
			if (sName.equals("") || mName.equals("")) {
				txtPool.setText("학생입력시 학번, 이름, 전공을 입력해야해");
				return;
			}
			txtPool.setText("");
			int score = 0;
			try {
				score = Integer.parseInt(txtScore.getText().trim());
				if (score < 0 || score > 100) {
					txtPool.append("유효한 점수가 아니면 0점 처리\n");
					score = 0;
				}
			} catch (NumberFormatException e1) {
				txtPool.append("점수를 입력 안 하거나 문자로 입력하면 0점 처리\n");
			}
			int result = dao.insertStudent(sName, mName, score);
			if (result == StudentSwingDao.SUCCESS) {
				txtPool.append(sName + " 학생 입력 성공");
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			}
		} else if (e.getSource() == btnUpdate) { // 5. 학생수정
			String sNo = txtSNo.getText().trim();
			String sName = txtSName.getText().trim();
			if (sNo.equals("") || sName.contentEquals("")) {
				txtPool.setText("성적수정시 학번, 이름을 입력해야해");
				return;
			}
			txtPool.setText("");
			int score = 0;
			try {
				score = Integer.parseInt(txtScore.getText().trim());
				if (score < 0 || score > 100) {
					txtPool.append("유효한 점수가 아니면 0점 처리\n");
					score = 0;
				} else {
					int result = dao.updateStudent(sNo, score);
					if (result == StudentSwingDao.SUCCESS) {
						txtPool.append(sName + " 학생 입력 수정");
						txtSNo.setText("");
						txtSName.setText("");
						comMname.setSelectedIndex(0);
						txtScore.setText("");
					}
				}
			} catch (NumberFormatException e1) {
				txtPool.append("점수를 입력 안 하거나 문자로 입력하면 0점 처리\n");
			}
		} else if (e.getSource() == btnStudentOut) { // 6. 학생출력(제적자제외)
			ArrayList<StudentSwingDto> dtos = dao.getStudents();
			if (dtos.size() != 0) {
				txtPool.setText("\t학번\t이름\t\t학과명\t점수\n");
				txtPool.append("\t───────────────────────────────\n");
				for (StudentSwingDto d : dtos) {
					txtPool.append("\t" + d.toString() + "\n");
				}
			} else {
				System.out.println("해당하는 학생이 없습니다");
			}

		} else if (e.getSource() == btnExpelOut) { // 7. 제적자만 출력
			ArrayList<StudentSwingDto> dtos = dao.getStudentsExpel();
			if (dtos.size() != 0) {
				txtPool.setText("\t학번\t이름\t\t학과명\t점수\n");
				txtPool.append("\t───────────────────────────────\n");
				for (StudentSwingDto d : dtos) {
					txtPool.append("\t" + d.toString() + "\n");
				}
			} else {
				System.out.println("해당하는 학생이 없습니다");
			}

		} else if (e.getSource() == btnExpel) { // 8. 제적처리
			String sNo = txtSNo.getText().trim();
			if (sNo.equals("")) {
				txtPool.setText("학번 입력해야 제적");
				return;
			}
			txtPool.setText("");
			int result = dao.sNoExpel(sNo);
			if (result == StudentSwingDao.SUCCESS) {
				txtPool.append(sNo + " 학생 제적처리");
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			}
		} else if (e.getSource() == btnExit) { // 종료버튼
			setVisible(false);
			dispose();
			System.exit(0);
		} // if - e.getSource()
	}// actionPerformed

	public static void main(String[] args) {
		new SwingStudentMng("학사관리");
	}// main
}// class