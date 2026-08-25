package com.jdbc.firstproject;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class DynamicDataInsertion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final String url ="jdbc:mysql://localhost:3306/demo";
		final String um ="root";
		final String pw="root";
		final String insert = "INSERT INTO Students (id, Student_Name, marks, city) VALUES (?, ?, ?, ?)";
		
		try {
			Connection con = DriverManager.getConnection(url,um,pw);
			PreparedStatement pstmt = con.prepareStatement(insert);
			
			System.out.println("Enter the id:");
			int id = sc.nextInt();
			System.out.println("Enter the Student_Name:");
			String name = sc.next();
			System.out.println("Enter the Marks:");
			int marks = sc.nextInt();
			System.out.println("Enter the City:");
			String city = sc.next();
			
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setInt(3, marks);
			pstmt.setString(4,city);
			
			pstmt.executeUpdate();
			System.out.println("Data inserted successfully Dynamically!");
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
