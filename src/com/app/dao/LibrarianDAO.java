package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.app.dbConnection.DBConnection;
import com.app.model.Librarian;

public class LibrarianDAO {
	
	public JSONArray getLibrarians() {
		Librarian librarian = null;
		JSONArray jArray = new JSONArray();
		try {
			Connection con = null;
			DBConnection connector = new DBConnection();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			con = connector.getConnection();
			String sql = "SELECT * FROM librarian;";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				JSONObject obj = new JSONObject();
				
				int id = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String email = rs.getString(4);
				String country = rs.getString(5);
				
				librarian = new Librarian(id,firstname,lastname,email,country);
				obj.put("id", librarian.getId());
				obj.put("firstname", librarian.getFirstName());
				obj.put("lastname", librarian.getLastName());
				obj.put("email", librarian.getEmail());
				obj.put("country", librarian.getCountry());
				
				jArray.add(obj);
				
			}
		}catch(Exception e) {
			System.out.print("Something went wrong check it");
			e.printStackTrace();
		}
		System.out.println(jArray.toJSONString());
		return jArray;
	}
	
	public JSONArray addLibrarians(String firstname, String lastname, String email, String country) {
		int result  = 0;
		JSONArray jArray = new JSONArray();
		
		try {
			JSONObject obj = new JSONObject();
			Connection con = null;
			DBConnection connector = new DBConnection();
			con = connector.getConnection();
			PreparedStatement ps = null;
			String sql = "INSERT INTO librarian(firstname,lastname,email,country) VALUES(?,?,?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, country);
			
			result = ps.executeUpdate();
			obj.put("result", result);
			jArray.add(obj);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(jArray.toJSONString());
		return jArray;
	}
	
	public JSONArray getDeleteLibrarian(String id) {
		
		JSONArray jArray = new JSONArray();
		JSONObject obj = new JSONObject();
		
		int result = 0;
		
		try {
			Connection con = null;
			DBConnection connector = new DBConnection();
			
			con = connector.getConnection();
			
			PreparedStatement ps = null;
			String query = "DELETE FROM librarian WHERE id = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, id);
			
			result = ps.executeUpdate(); 
			
			obj.put("result", result);
			jArray.add(obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jArray.toJSONString());
		return jArray;
	}
	
	
	public JSONArray getLibrarianDetails(String id) {
		
		JSONArray jArray = new JSONArray();
		JSONObject obj = new JSONObject();
		Librarian lib = null;
		
		try {
			Connection con = null;
			DBConnection connection  = new DBConnection();
			con = connection.getConnection();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = "SELECT id,firstname,lastname,email,country FROM librarian WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int i = rs.getInt(1);
				String f = rs.getString(2);
				String l = rs.getString(3);
				String e = rs.getString(4);
				String c = rs.getString(5);
				
				lib = new Librarian(i,f,l,e,c);
				
				obj.put("id", lib.getId());
				obj.put("firstname", lib.getFirstName());
				obj.put("lastname", lib.getLastName());
				obj.put("email", lib.getEmail());
				obj.put("country", lib.getCountry());
				
				jArray.add(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jArray.toJSONString());
		return jArray;
	}
	
	
	public JSONArray getEditLibrarian(String firstname, String lastname, String email, String country, String id) {
		
		JSONArray jArray = new JSONArray();
		int result =0;
		
		try {
			Connection con = null;
			DBConnection connection = new DBConnection();
			con = connection.getConnection();
			
			PreparedStatement ps = null;
			String sql = "UPDATE librarian SET firstname = ?, lastname = ?, email = ?, country = ? WHERE id = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, country);
			ps.setString(5, id);
			
			JSONObject obj = new JSONObject();
			result = ps.executeUpdate();
			obj.put("result", result);
			jArray.add(obj);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(jArray.toJSONString());
		return jArray;
	}
}
