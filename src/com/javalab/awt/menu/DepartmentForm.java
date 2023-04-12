package com.javalab.awt.menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DepartmentForm extends JPanel implements ActionListener {

	// JLabels for the input fields
	private JLabel idLabel, nameLabel, officeLabel;

	// Text fields for input
	private JTextField idField, nameField, officeField;

	// Button to submit the form
	private JButton submitButton;

	public DepartmentForm() {
		// Initialize input fields and labels
		idLabel = new JLabel("학과번호:");
		idField = new JTextField(10);

		nameLabel = new JLabel("학과명:");
		nameField = new JTextField(10);

		officeLabel = new JLabel("교실:");
		officeField = new JTextField(10);

		// Initialize submit button and add action listener
		submitButton = new JButton("등록");
		submitButton.addActionListener(this);

		// Create a JPanel to hold the input fields and button
		JPanel inputPanel = new JPanel(new GridLayout(4, 2));
		inputPanel.add(idLabel);
		inputPanel.add(idField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(officeLabel);
		inputPanel.add(officeField);
		inputPanel.add(new JLabel());
		inputPanel.add(submitButton);

		// Add the input panel to the content pane
		add(inputPanel);
	}

	// 버튼 클릭시 행할 내용을 적은 메소드(이벤트 핸들러, 이벤트 처리기)
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			// 입력 필드 값을 사용하여 새 학과 개체 만들기
			Department department = new Department();
			department.setId(Integer.parseInt(idField.getText()));
			department.setName(nameField.getText());
			department.setOffice(officeField.getText());

			// 학과 객체를 ArrayList 또는 데이터베이스 또는 파일에 추가
			// TODO: Add code to save the department object to a database or file

			// 학과 객체 성공적으로 등록 완료 메시지
			JOptionPane.showMessageDialog(this, "학과 등록 완료.");

			// 입력 텍스트 필드 클리어
			idField.setText("");
			nameField.setText("");
			officeField.setText("");
		}
	}
}