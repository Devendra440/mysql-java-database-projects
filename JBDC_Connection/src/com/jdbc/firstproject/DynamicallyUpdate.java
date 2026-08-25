package com.jdbc.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicallyUpdate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final String url = "jdbc:mysql://localhost:3306/demo";
		final String um = "root";
		final String pw = "root";
		final String update = "UPDATE Students SET marks = ? WHERE id = ?";
		
		try {
			Connection con =DriverManager.getConnection(url,um,pw);
			PreparedStatement pstmt = con.prepareStatement(update);

			System.out.println("Enter the Updated  marks that you want to update...");
			int marks = sc.nextInt();
			System.out.println("Enter the id that you want to update the marks...");
			int id = sc.nextInt();
			
			
			pstmt.setInt(1,marks);
			pstmt.setInt(2,id);
			int rows = pstmt.executeUpdate();
			
			if(rows>0) {
				System.out.println("Data updated succesfully.....");
			}else {
			    System.out.println("Student ID not found");
			}
			
			pstmt.close();
			con.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
