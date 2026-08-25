package com.jdbc.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertionMultipleData {
	public static void main(String[] args) {
		final String url ="jdbc:mysql://localhost:3306/demo";
		final String us = "root";
		final String pw ="root";
		
		try {
			Connection con = DriverManager.getConnection(url,us,pw);
			Statement stmt = con.createStatement();
			stmt.addBatch("insert into Students Values(2,'Bunty',410,'HYD')");
			stmt.addBatch("insert into Students Values(3,'Bonnie',409,'SRYPT')");
			stmt.addBatch("insert into Students Values(4,'Loki',644,'DRKL')");
			stmt.addBatch("insert into Students Values(5,'Ghatkeshar',644,'DRKL')");
			
			int[] result = stmt.executeBatch();
			
			System.out.println("Successfully inserted multiple data at a single terms using addBatch && executeBatch");
			
			stmt.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
