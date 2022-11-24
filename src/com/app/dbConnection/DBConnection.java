package com.app.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public Connection getConnection() {
		
		Connection con = null;
		final String PARAM_DRIVER ="com.mysql.jdbc.Driver";
		final String PARAM_URL ="jdbc:mysql://localhost:3306/sql_library_system";
		final String PARAM_USERNAME ="root";
		final String PARAM_PASSWORD ="Aloma_23u";
		
		try {
			Class.forName(PARAM_DRIVER);
			con = DriverManager.getConnection(PARAM_URL,PARAM_USERNAME,PARAM_PASSWORD);
			System.out.println("You have successfully connected to the database");
		}catch(Exception e) {
			System.out.println("Cant connect to the database");
			e.printStackTrace();
		}
		return con;
	}

}
