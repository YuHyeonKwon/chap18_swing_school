package com.javalab.awt.menu;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TakesForm extends JFrame {
    private List<Takes> takesList = new ArrayList<>();

    public TakesForm() {
        setTitle("Takes Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create table model and table
        String[] columnNames = {"ID", "Subject", "Score"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // Create scroll pane and add table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Create add button and action listener
        JButton addButton = new JButton("Add Takes");
        addButton.addActionListener(e -> {
            // Add row to table model
            Object[] rowData = {"", "", ""};
            tableModel.addRow(rowData);

            // Add empty Takes object to takesList
            takesList.add(new Takes());
        });

        // Create panel and add components
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.SOUTH);

        // Set preferred size of panel
        panel.setPreferredSize(new Dimension(400, 300));

        // Set content pane of frame
        setContentPane(panel);

        // Pack and show frame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TakesForm();
    }
}
