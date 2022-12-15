package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.InitWindow;
import controller.UseComboBox;

public class MyFrame {
	
	private JComboBox<String> tableNames;
	
	private JTable table;
	
	private JFrame frame;
	
	private GenericTable model;
	
	public MyFrame() {
		init();
	}
	
	private void init() {
		
		frame = new JFrame("Generic App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tableNames = new JComboBox<>();
		tableNames.addActionListener(new UseComboBox(this));
		frame.add(tableNames, BorderLayout.NORTH);
		
		model = new GenericTable();
		
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(600, 400));
		frame.add(sp, BorderLayout.CENTER);
		
		frame.addWindowListener(new InitWindow(this));
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public JComboBox<String> getTableNames() {
		return tableNames;
	}

	public GenericTable getModel() {
		return model;
	}
}
