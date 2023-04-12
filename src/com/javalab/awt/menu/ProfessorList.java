package com.javalab.awt.menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ProfessorList extends JFrame implements ActionListener {

	public DatabaseClass db;
	
	// 교수 목록이 보여질 테이블
	private JTable table;
	// 테이블을 다양한 기능을 사용할 수 있도록 해주는 클래스
	private DefaultTableModel tableModel;
	
	// 기본생성자
	public ProfessorList() {
	    /**
	     * 생성자
	     *  - 메인 메뉴에서 불려질 때 데이터베이스 클래스의 주소를 전달 받는다.
	     *  - 전달 받은 데이터베이스 클래스에는 학생 ArrayList가 있다.
	     */
	}
	
	public ProfessorList(DatabaseClass db) {
		this.db = db;
		
		// 테이블 셋팅
		String[] columnNames = { "ID", "주민번호", "이름", "학과", "직급", "입사일자" };
		List<Professor> professorsList = db.getProfessorList();	// ArrayList<Professor의 갯수 만큼 행을 생성
		Object[][] data = new Object[professorsList.size()][6];
		
		for (int i = 0; i < professorsList.size(); i++) {
			Professor professor = professorsList.get(i);
			data[i][0] = professor.getId();
			data[i][1] = professor.getJumin();
			data[i][2] = professor.getName();
			data[i][3] = professor.getDepartment();
			data[i][4] = professor.getGrade();
			data[i][5] = professor.getHiredate();
		}
		
		tableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tableModel);
		
		// set up the button to add a new student
		JButton closeButton = new JButton("닫기");
		
		// 액션 리스너 부착
		closeButton.addActionListener(this);
		
		// 메인 패널 생성
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		// 입력 필드들이 놓일 input 패널 생성
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(6,2));
		
		// input 패널을 메인 패널에 다시 부착
		mainPanel.add(inputPanel, BorderLayout.SOUTH);
		// 닫기 버튼도 메인 패널에 부탁
		mainPanel.add(closeButton, BorderLayout.SOUTH);
		
		// 프레임(윈도우 창)설정
		setTitle("교수 정보 입력");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 현재 열려있는 학생 조회 화면을 닫음
		this.dispose();
		
		MainMenu mainMenu = new MainMenu(db);
		mainMenu.setVisible(true);
	}

	public static void main(String[] args) { // main s
		new ProfessorList();
	} // main e
}
