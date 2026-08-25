package com.jdbc.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) {
		final String url="jdbc:mysql://localhost:3306/demo";
		final String us = "root";
		final String pw="root";
		
		final  String Update ="Update Students set marks = '569' where  city='SRCL'";
		
		try {
			Connection con = DriverManager.getConnection(url,us,pw);
			Statement stmt = con.createStatement();
			int rows = stmt.executeUpdate(Update);
			System.out.println(rows);
			System.out.println("Updating data sucessfully");
			}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
