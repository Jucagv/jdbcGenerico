package model;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	private String url;
	
	private String databaseName;
	
	private String username;
	
	private String password;

	private void initData() {
		try (Reader r = new FileReader("data.txt");
				BufferedReader br = new BufferedReader(r)) {
			
			url = br.readLine();
			databaseName = br.readLine();
			username = br.readLine();
			password = br.readLine();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		initData();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url + "/" + databaseName, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public String getDatabaseName() {
		return databaseName;
	}
	
}
