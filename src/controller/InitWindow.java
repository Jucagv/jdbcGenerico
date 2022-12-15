package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import model.Connect;
import model.DAO;
import view.MyFrame;

public class InitWindow extends WindowAdapter {

	private MyFrame view;
	
	public InitWindow(MyFrame view) {
		this.view = view;
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		try {
			Connect conn = new Connect();
			DAO dao = new DAO(conn.getConnection());
			
			for (String myTable : dao.getTableNames(conn.getDatabaseName())) {
				view.getTableNames().addItem(myTable);
			}
			
			conn.getConnection().close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
