package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import model.Connect;
import model.DAO;
import view.MyFrame;

public class UseComboBox implements ActionListener{

	private MyFrame view;
	
	public UseComboBox(MyFrame view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String table = (String) view.getTableNames().getSelectedItem();
		
		try {
			Connect conn = new Connect();
			DAO dao = new DAO(conn.getConnection());
			
			view.getModel().update(dao.getColumnNames(conn.getDatabaseName(), table),
					dao.getAllData(table));
			
			view.getModel().fireTableStructureChanged();
			
			conn.getConnection().close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
