package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

public class DAO {

	private final String SELECT = "SELECT * FROM ";
	
	public Connection conn;
	
	public DAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<String> getTableNames(String database) {
		List<String> tables = new ArrayList<>();
		
		try {
			DatabaseMetaData dbmd = conn.getMetaData();
			
			try (ResultSet rs = dbmd.getTables(database, null, null, null)) {
				while (rs.next()) {
					tables.add(rs.getString("TABLE_NAME"));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tables;
	}
	
	public List<String> getColumnNames(String database, String tabla) {
		List<String> columns = new ArrayList<>();
		
		try {
			DatabaseMetaData dbmd = conn.getMetaData();
			
			try (ResultSet rs = dbmd.getColumns(database, null, tabla, null)) {
				while (rs.next()) {
					columns.add(rs.getString("COLUMN_NAME"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return columns;
	}
	
	public List<String[]> getAllData(String table) {
		List<String[]> list = new ArrayList<>();
		
		try (PreparedStatement ps = conn.prepareStatement(SELECT + table);
			ResultSet rs = ps.executeQuery()) {
			
			int columns = rs.getMetaData().getColumnCount();
			
			while (rs.next() ) {
				String[] row = new String[columns];
				for (int i=0; i<row.length; i++) {
					row[i] = rs.getString(i+1);
				}
				list.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
