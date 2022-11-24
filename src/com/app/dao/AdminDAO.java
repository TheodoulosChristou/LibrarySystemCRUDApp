package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.app.dbConnection.DBConnection;
import com.app.model.Admin;

public class AdminDAO {
	
	public Admin getAdmin(String username, String password) {
		
		Admin admin = null;
		try {
			Connection con = null;
			DBConnection connection = new DBConnection();
			con = connection.getConnection();
			String sql = "SELECT * FROM admin WHERE username=? AND password=?;";
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String u = rs.getString(2);
				String p = rs.getString(3);
				String firstName = rs.getString(4);
				String lastName = rs.getString(5);
				
				admin = new Admin(id,u,p,firstName,lastName);
				System.out.println(admin.getId());
				System.out.println(admin.getUsername());
				System.out.println(admin.getPassword());
				System.out.println(admin.getFirstName());
				System.out.println(admin.getLastName());
			}
			
		} catch(Exception e) {
			System.out.println("Something went wrong in connection with MYSQLDATABASE");
			e.printStackTrace();
		}
		return admin;
	}
	
	public int getRegisteredAdmin(String username, String password, String firstName, String lastName) {
		int result = 0;
		Connection con = null;
		try {
			
			PreparedStatement ps = null;
			DBConnection connector = new DBConnection();
			con = connector.getConnection();
			String sql = "INSERT INTO admin(username,password,firstName,lastName)VALUES(?,?,?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
