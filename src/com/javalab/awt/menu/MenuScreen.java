package com.javalab.awt.menu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MenuScreen extends JFrame implements ActionListener {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JButton studentBtn, professorBtn, departmentBtn, takesBtn;

    public MenuScreen() {
        setTitle("Menu Screen");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create card layout and panel
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // add student form
        StudentForm studentForm = new StudentForm();
        cardPanel.add(studentForm, "Student");

        // add professor form
        ProfessorForm professorForm = new ProfessorForm();
        cardPanel.add(professorForm, "Professor");

        // add department form
        DepartmentForm departmentForm = new DepartmentForm();
        cardPanel.add(departmentForm, "Department");

        // add takes form
        TakesForm takesForm = new TakesForm();
        cardPanel.add(takesForm, "Takes");

        // create buttons to switch between forms
        studentBtn = new JButton("Student");
        studentBtn.addActionListener(this);

        professorBtn = new JButton("Professor");
        professorBtn.addActionListener(this);

        departmentBtn = new JButton("Department");
        departmentBtn.addActionListener(this);

        takesBtn = new JButton("Takes");
        takesBtn.addActionListener(this);

        // add buttons to a panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(studentBtn);
        buttonPanel.add(professorBtn);
        buttonPanel.add(departmentBtn);
        buttonPanel.add(takesBtn);

        // add card panel and button panel to content pane
        Container contentPane = getContentPane();
        contentPane.add(cardPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        cardLayout.show(cardPanel, e.getActionCommand());
    }

    public static void main(String[] args) {
        MenuScreen menuScreen = new MenuScreen();
        menuScreen.setVisible(true);
    }
}
