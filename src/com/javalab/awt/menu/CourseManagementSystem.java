package com.javalab.awt.menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CourseManagementSystem extends JFrame {
    public CourseManagementSystem() {
        super("Course Management System");

        // Create the buttons
        JButton studentRegisterButton = new JButton("학생 등록");
        JButton professorRegisterButton = new JButton("교수 등록");
        JButton departmentRegisterButton = new JButton("학과 등록");
        JButton takesRegisterButton = new JButton("수강 등록");
        JButton studentListButton = new JButton("학생 목록");
        JButton professorListButton = new JButton("교수 목록");
        JButton departmentListButton = new JButton("학과 목록");
        JButton takesListButton = new JButton("수강 목록");
        JButton exitButton = new JButton("종료");

        // Add the button listeners
        studentRegisterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Do something when the button is clicked
                System.out.println("학생 등록 button clicked");
            }
        });
        professorRegisterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Do something when the button is clicked
                System.out.println("교수 등록 button clicked");
            }
        });
        departmentRegisterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Do something when the button is clicked
                System.out.println("학과 등록 button clicked");
            }
        });
        takesRegisterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Do something when the button is clicked
                System.out.println("수강 등록 button clicked");
            }
        });
        studentListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Do something when the button is clicked
                System.out.println("학생 목록 button clicked");
            }
        });
        professorListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Do something when the button is clicked
                System.out.println("교수 목록 button clicked");
            }
        });
        departmentListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Do something when the button is clicked
                System.out.println("학과 목록 button clicked");
            }
        });
        takesListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Do something when the button is clicked
                System.out.println("수강 목록 button clicked");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exit the program when the button is clicked
                System.exit(0);
            }
        });

        // Create the button panel
        JPanel buttonPanel = new JPanel(new GridLayout(9, 1));
        buttonPanel.add(studentRegisterButton);
        buttonPanel.add(professorRegisterButton);
    }
}
