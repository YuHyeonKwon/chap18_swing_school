package com.javalab.awt.menu;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentForm extends JFrame implements ActionListener{

	/*
	 * 데이터베이스 역할을 하는 DatabaseClass 변수 선언
	 * 생성자에서 전달 받음. 가장 중요함.
	 */
	public DatabaseClass db;

    private JTextField idField;
    private JTextField juminField;
    private JTextField nameField;
    private JTextField yearField;
    private JTextField addressField;
    private JTextField departmentField;
    //private JTable table;

    // 기본 생성자
    public StudentForm() {    	
    }
    
    /**
     * 생성자
     *  - 메인 메뉴에서 불려질 때 데이터베이스 클래스의 주소를 전달 받는다.
     *  - 전달 받은 데이터베이스 클래스에는 학생 ArrayList가 있다. 
     * @param db
     */
    public StudentForm(DatabaseClass db) {
    	// 데이터베이스 전담 클래스의 객체를 전달받아서 내가 선언한 변수에 저장함
    	this.db = db;

        // 텍스트필드(입력칸)와 레이블 설정
        idField = new JTextField(10);
        juminField = new JTextField(10);
        nameField = new JTextField(10);
        yearField = new JTextField(10);
        addressField = new JTextField(10);
        departmentField = new JTextField(10);

        JLabel idLabel = new JLabel("학번:");
        JLabel juminLabel = new JLabel("주민등록번호:");
        JLabel nameLabel = new JLabel("이름:");
        JLabel yearLabel = new JLabel("학년(int):");
        JLabel addressLabel = new JLabel("주소:");
        JLabel departmentLabel = new JLabel("학과(int):");

        // 학생 추가 버튼 생성
        JButton addButton = new JButton("추가");
        
        // 액션 리스너 부착(추가 버튼 클릭시 할일 정의)
        // 버튼 클릭시 actionPerformed()가 호출됨.
        addButton.addActionListener(this);	// 액션 리스터 부착

        // 버튼, 레이블, 텍스트 필드를 배치할 input 패널을 배치할 메인 패널 생성
        // 즉, 메인 패널 위에 inputPanel이 놓이게 됨.
        JPanel mainPanel = new JPanel();

        // 메인 패널을 BoarderLayout으로 만들겠다.
        mainPanel.setLayout(new BorderLayout());

        // 버튼, 레이블, 텍스트 필드를 배치할 input 패널
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));        
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(juminLabel);
        inputPanel.add(juminField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(yearLabel);
        inputPanel.add(yearField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentField);

        // 메인 패널에 input패널 부착
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        // 메인 패널에 "추가"버튼 부착
        mainPanel.add(addButton, BorderLayout.SOUTH);

        // 프레임(윈도우 창) 설정
        setTitle("학생 정보 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 메인 패널을 프레임의 루트 컨텐트에 저장
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
        /**
         * 컴포넌트(버튼, 텍스트필드, 레이블)가 프레임에 쌓이는 순서
         *  - 프레임 > 루트 컨텐트 > 메인 패널 > input패널 > 버튼,텍스트필드,레이블
         */
    }

    /**
     * 액션 리스너
     *  - 학생 추가 버튼 클릭시 실행되는 메소드로 데이터베이스 클래스에 학생을 추가시킨다.
     *    즉, 학생 ArrayList에 학생 한명 추가함.
     */
	public void actionPerformed(ActionEvent e) {
		// 화면에서 입력된 값을 임시 변수에 저장
        String id = idField.getText();
        String jumin = juminField.getText();
        String name = nameField.getText();
        int year = Integer.parseInt(yearField.getText());
        String address = addressField.getText();
        int department = Integer.parseInt(departmentField.getText());

        // 화면에서 입력받은 데이터로 학생 객체 생성
        Student student = new Student(id, jumin, name, year, address, department);
        
        // 생성한 학생 객체를 ArrayList<Student> studentList에 저장
        this.db.addStudent(student);
        
		// 학생 객체 성공적으로 등록 완료 메시지
		JOptionPane.showMessageDialog(this, "등록완료");
		
		// 현재까지 등록된 학생수 확인
        System.out.println("학생 객체 등록 완료 학생수 : " + db.getStudentCount());
		
        // 학생 등록 끝나서 현재의 화면 닫기                
        this.dispose();
        
        // 이동해갈 메인 메뉴 생성
        MainMenu mainMenu = new MainMenu(db);
        
        // 메인 메뉴 보이기
        mainMenu.setVisible(true);
	}
	
    /**
     * 학생 등록폼을 직접 실행할 경우에 사용하는 메소드
     *  - 프로그램 전체를 실행할 때는 사용되지 않음
     *  - 학생 등록폼을 만들면서 테스트 할 때 이 프로그램을 실행시킬때 사용됨
     */
    public static void main(String[] args) {
    	new StudentForm(new DatabaseClass());
    }
	
}
