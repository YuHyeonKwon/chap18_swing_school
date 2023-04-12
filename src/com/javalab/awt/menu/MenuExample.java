package com.javalab.awt.menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuExample {
    private CardLayout cardLayout;
    private JPanel cards;

    public MenuExample() {
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        cards.add(new StudentForm(), "Student");
        cards.add(new ProfessorForm(), "Professor");
//        cards.add(new DepartmentForm(), "Department");
//        cards.add(new TakesForm(), "Takes");

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        JMenuItem studentItem = new JMenuItem("Student Register");
        studentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Student");
            }
        });
        menu.add(studentItem);

        JMenuItem professorItem = new JMenuItem("Professor Register");
        professorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Professor");
            }
        });
        menu.add(professorItem);

        JMenuItem departmentItem = new JMenuItem("Department Register");
        departmentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Department");
            }
        });
        menu.add(departmentItem);

        JMenuItem takesItem = new JMenuItem("Takes Register");
        takesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Takes");
            }
        });
        menu.add(takesItem);

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        frame.setContentPane(cards);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuExample();
    }
}
