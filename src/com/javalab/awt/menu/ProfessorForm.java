package com.javalab.awt.menu;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProfessorForm extends JFrame implements ActionListener/* JPanel  */ {
	private ArrayList<Professor> professorList;
	
    private JTable table;
    private DefaultTableModel tableModel;	
	
	private JLabel idLabel, juminLabel, nameLabel, departmentLabel, gradeLabel, hiredateLabel;
	private JTextField idField, juminField, nameField, departmentField, gradeField, hiredateField;
	private JButton submitButton;

	// 기본 생성자
	public ProfessorForm() {
		
		professorList = new ArrayList<Professor>();
		
        // 테이블 세팅
        String[] columnNames = {"ID", "주민번호", "이름", "학과", "그레이드", "입사일"};
        Object[][] data = new Object[0][6];
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);		
		
        // 입력 텍스트 필드 세팅(Set up the input fields and labels)
        idField = new JTextField(10);	// id
        juminField = new JTextField(10);	// 주민번호
        nameField = new JTextField(10);		// 이름
        departmentField = new JTextField(10);		// 학과
        gradeField = new JTextField(10);	// 그레이드
        departmentField = new JTextField(10);// 입사일
        
        
		idLabel = new JLabel("ID:");
		idField = new JTextField(10);

		juminLabel = new JLabel("주민번호:");
		juminField = new JTextField(10);

		nameLabel = new JLabel("이름:");
		nameField = new JTextField(10);

		departmentLabel = new JLabel("학과:");
		departmentField = new JTextField(10);

		gradeLabel = new JLabel("직급:");
		gradeField = new JTextField(10);

		hiredateLabel = new JLabel("입사일자:");
		hiredateField = new JTextField(10);

		submitButton = new JButton("등록");
		submitButton.addActionListener(this);	// 액션 리스터 부착

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

//		JPanel inputPanel = new JPanel(new GridLayout(7, 2));
		inputPanel.add(idLabel);
		inputPanel.add(idField);
		inputPanel.add(juminLabel);
		inputPanel.add(juminField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(departmentLabel);
		inputPanel.add(departmentField);
		inputPanel.add(gradeLabel);
		inputPanel.add(gradeField);
		inputPanel.add(hiredateLabel);
		inputPanel.add(hiredateField);
		inputPanel.add(new JLabel());
		inputPanel.add(submitButton);

		//add(inputPanel);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        mainPanel.add(submitButton, BorderLayout.EAST);
		
        // Set up the frame
        setTitle("교수 정보 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("액션 리스너 호출됨");
		if (e.getSource() == submitButton) {
			// 입력 필드 값을 사용하여 새 교수 개체 만들기
			Professor professor = new Professor();
			String id = idField.getText();
			String jumin = juminField.getText();
			String name = nameField.getText();
			int department = Integer.parseInt(departmentField.getText());
			String grade = gradeField.getText();
			String hiredate = hiredateField.getText();
			
			professor.setId(id);
			professor.setJumin(jumin);
			professor.setName(name);
			professor.setDepartment(department);
			professor.setGrade(grade);
			professor.setHiredate(hiredate);

			// 교수 객체를 ArrayList 또는 데이터베이스 또는 파일에 추가
			professorList.add(professor);
			
			// table model 업데이트
            Object[] row = {id, jumin, name, department, grade, hiredate};
            tableModel.addRow(row);

			// 교수 객체 성공적으로 등록 완료 메시지
			JOptionPane.showMessageDialog(this, "교수 등록 완료.");

			// 입력 텍스트 필드 클리어
			idField.setText("");
			juminField.setText("");
			nameField.setText("");
			departmentField.setText("");
			gradeField.setText("");
			hiredateField.setText("");
		}
	}
}
