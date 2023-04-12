package com.javalab.awt.menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentList extends JFrame implements ActionListener{
	
	/*
	 * 데이터베이스 역할을 하는 DatabaseClass 변수 선언
	 * 생성자에서 전달 받음. 가장 중요함.
	 */
	public DatabaseClass db;

	// 학생 목록이 보여질 테이블
    private JTable table;	
    // 테이블을 다양한 기능을 사용할 수 있도록 해주는 클래스
    private DefaultTableModel tableModel;	

    // 기본 생성자
    public StudentList() {    	
    }
    
    /**
     * 생성자
     *  - 메인 메뉴에서 불려질 때 데이터베이스 클래스의 주소를 전달 받는다.
     *  - 전달 받은 데이터베이스 클래스에는 학생 ArrayList가 있다. 
     * @param db
     */
    public StudentList(DatabaseClass db) {
    	// 데이터베이스 전담 클래스의 객체를 전달받아서 내가 선언한 변수에 저장함
    	this.db = db;
    	
        // 테이블 세팅
        String[] columnNames = {"ID", "주민등록번호", "이름", "학년", "주소", "학과"};
        List<Student> studentList = db.getStudentList(); // ArrayList<Student>의 갯수 만큼 행을 생성
        Object[][] data = new Object[studentList.size()][6];
        
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            data[i][0] = student.getId();
            data[i][1] = student.getJumin();
            data[i][2] = student.getName();
            data[i][3] = student.getYear();
            data[i][4] = student.getAddress();
            data[i][5] = student.getDepartment();
        }

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        
        
        // Set up the button to add a new student
       JButton closeButton = new JButton("닫기");
       
        // 액션 리스너 부착
        closeButton.addActionListener(this);	// 액션 리스터 부착

        // 메인 패널 생성
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // 입력 필드들이 놓일 input 패널 생성
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        
        // input 패널을 메인 패널에 다시 부착
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        // 닫기 버튼도 메인 패널에 부착
        mainPanel.add(closeButton, BorderLayout.SOUTH);

        // 프레임(윈도우 창) 설정
        setTitle("학생 정보 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 액션 리스너 
	public void actionPerformed(ActionEvent e) {
        // 현재 열려있는 학생 조회 화면을 닫음                
        this.dispose();
        
        MainMenu mainMenu = new MainMenu(db);
        mainMenu.setVisible(true);
	}
	
    /**
     * 학생 등록폼을 직접 실행할 경우에 사용하는 메소드
     *  - 프로그램 전체를 실행할 때는 사용되지 않음
     *  - 학생 등록폼을 만들면서 테스트 할 때 이 프로그램을 실행시킬때 사용됨
     */
    public static void main(String[] args) {
    	new StudentList(new DatabaseClass());
    }	
}
