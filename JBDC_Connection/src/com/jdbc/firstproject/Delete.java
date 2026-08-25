package com.jdbc.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Delete {
	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/demo";
		final String us="root";
		final String pw = "root";
		final String delete = "Delete from Students where id = 10";
		
		
		try {
			Connection con = DriverManager.getConnection(url,us,pw);
			java.sql.Statement stmt = con.createStatement();
			int rows = stmt.executeUpdate(delete);
			System.out.println("Deleted Successfully  "+rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
