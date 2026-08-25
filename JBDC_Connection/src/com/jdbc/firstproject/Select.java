package com.jdbc.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/demo";
		final String us = "root";
		final String pw = "root";
		final String read ="Select* from Students";
				
		try {
			Connection con = DriverManager.getConnection(url,us,pw);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(read);
			System.out.println("= = = = = = = = = = ");
			while(rs.next()){
				
				System.out.println(rs.getInt("Id")+" "+"|"+" "+rs.getString("Student_Name")+" "+"|"+" "+rs.getInt("marks")+" "+"|"+" "+rs.getString("City")+" "+"|"+" ");
			}
			System.out.print("= = = = = = = = = = = =");
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
