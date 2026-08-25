package com.jdbc.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicallySelection {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		final String url ="jdbc:mysql://localhost:3306/demo";
		final String um = "root";
		final String pw ="root";
		final String read="Select * from Students where id = ?";
		
		
		Connection con =DriverManager.getConnection(url,um,pw);
		
		PreparedStatement pstmts = con.prepareStatement(read);
		
		System.out.println("Enter the id that you print the data");
		int id = sc.nextInt();
		
		pstmts.setInt(1, id);
		
		ResultSet rs = pstmts.executeQuery();
		if(rs.next()) {
			System.out.println("Data of "+id+" is retrieved Sucessfully....");
			System.out.println("Id:"+rs.getInt("id"));
			System.out.println("Name:"+rs.getString("Student_Name"));
			System.out.println("Marks:"+rs.getInt("marks"));
			System.out.println("City:"+rs.getString("city"));
			
			rs.close();
			pstmts.close();
			con.close();
			
		}else {
			System.out.println("Data of "+id+" is not found....");
		}
		
	}

}
