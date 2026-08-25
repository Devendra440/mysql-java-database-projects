package com.jdbc.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Insertion {

	public static void main(String[] args) {
		final String url ="jdbc:mysql://localhost:3306/demo";
		final String um = "root";
		final String ps ="root";
		final String insert ="insert into Students Values(1,'Deva',440,'KMM')";
		
		try {
			Connection con = DriverManager.getConnection(url,um,ps);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(insert);
//			syso
			System.out.println("Sucessfully inserted data.....");
			stmt.close();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
