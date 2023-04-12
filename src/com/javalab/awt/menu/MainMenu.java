package com.javalab.awt.menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 초기화면 - 메인 메뉴
 *  - 프로그램 구동후 가장 먼저 보여지는 화면
 *  - 여기에서 다른 화면으로 이동함.
 */
public class MainMenu extends JFrame implements ActionListener {
	/*
	 * 데이터베이스 역할을 하는 DatabaseClass 변수 선언
	 * 생성자에서 전달 받음. 가장 중요함.
	 */
	public DatabaseClass db;
	
    // 화면에서 사용할 입력필드, 버튼, 레이블 변수 선언(GUI components)
    private JLabel titleLabel;
    private JButton studentButton;
    private JButton professorButton;
    private JButton departmentButton;
    private JButton takesButton;
    private JButton studentListButton;
    private JButton professorListButton;
    private JButton departmentListButton;
    private JButton takesListButton;
    private JButton exitButton;
    
    // 본 클래스에는 기본 생성자 생성 금지 //
    
    /**
     * 생성자
     *  - 메인 메뉴에서 불려질 때 데이터베이스 클래스의 주소를 전달 받는다.
     *  - 전달 받은 데이터베이스 클래스에는 학생 ArrayList 등이 있다. 
     * @param db
     */
    public MainMenu(DatabaseClass db) {
    	// 데이터베이스 전담 클래스의 객체를 전달받아서 내가 선언한 변수에 저장함
    	this.db = db;
    			
        // 프레임 설정
        setTitle("Registration Form");
        setLayout(new GridLayout(10, 1));
        setSize(300, 400);
        
        // 프레임 타이틀 설정
        titleLabel = new JLabel("Select an option:");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel);
        
        // 각 화면을 버튼으로 만들어서 프레임에 부착 - 학생등록
        studentButton = new JButton("Student Register");
        studentButton.addActionListener(this);	// 버튼에 액션 리스너 부착
        add(studentButton); // 버튼을 프레임에 부착(별도의 패널 안쓰고 바로 부착)
        
        // Professor Register button
        professorButton = new JButton("Professor Register");
        professorButton.addActionListener(this);
        add(professorButton);
        
        // Department Register button
        departmentButton = new JButton("Department Register");
        departmentButton.addActionListener(this);
        add(departmentButton);
        
        // Takes Register button
        takesButton = new JButton("Takes Register");
        takesButton.addActionListener(this);
        add(takesButton);
        
        // Student List button
        studentListButton = new JButton("Student List");
        studentListButton.addActionListener(this);
        add(studentListButton);
        
        // Professor List button
        professorListButton = new JButton("Professor List");
        professorListButton.addActionListener(this);
        add(professorListButton);
        
        // Department List button
        departmentListButton = new JButton("Department List");
        departmentListButton.addActionListener(this);
        add(departmentListButton);
        
        // Takes List button
        takesListButton = new JButton("Takes List");
        takesListButton.addActionListener(this);
        add(takesListButton);
        
        // Exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        add(exitButton);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    // 각 메뉴 버튼 클릭시 할일 정의
    public void actionPerformed(ActionEvent e) {
        // 학생 등록폼이 눌렸냐?
        if (e.getSource() == studentButton) {
            System.out.println("Student Register");
            
            // 현재의 메인 메뉴 화면 닫기                
            this.dispose();
            
            // 이동해갈 화면 객체 생성(학생등록폼)
            StudentForm studentForm = new StudentForm(db);
            
            // 이동해갈 화면 보이기
            studentForm.setVisible(true);
            
        } else if (e.getSource() == professorButton) {
            System.out.println("Professor Register");
            ProfessorForm professorForm = new ProfessorForm();
            professorForm.setVisible(true);            
        } else if (e.getSource() == departmentButton) {
            System.out.println("Department Register");
            DepartmentForm departmentForm = new DepartmentForm();
            departmentForm.setVisible(true);              
        } else if (e.getSource() == takesButton) {
            System.out.println("Takes Register");
            TakesForm takesForm = new TakesForm();
            takesForm.setVisible(true);             
        } else if (e.getSource() == studentListButton) {
            System.out.println("Student List");            
            // 현재 화면 닫기                
            this.dispose();            
            // 이동해갈 화면 객체 생성
            StudentList studentList = new StudentList(db);            
            // 이동해갈 화면 보이기
            studentList.setVisible(true);            
        } else if (e.getSource() == professorListButton) {
            System.out.println("Professor List");
            /////////// JTable로 구현 //////////            
        } else if (e.getSource() == departmentListButton) {
            System.out.println("Department List");
            /////////// JTable로 구현 //////////            
        } else if (e.getSource() == takesListButton) {
            System.out.println("Takes List");
            /////////// JTable로 구현 //////////            
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new MainMenu(new DatabaseClass());
    }
}

