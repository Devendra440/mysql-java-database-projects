package com.jdbc.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicallyDelete {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 final String url = "jdbc:mysql://localhost:3306/demo";
		 final String um = "root";
		 final String pw="root";
		 final String delete = "Delete from Students where id=?";
		 
		 try {
			Connection con = DriverManager.getConnection(url,um,pw);
			PreparedStatement psmt = con.prepareStatement(delete);
			
			System.out.println("Enter the id to remove the data");
			int id = sc.nextInt();
			psmt.setInt(1,id);
			int row = psmt.executeUpdate();
			if (row > 0) {
                System.out.println("Data deleted successfully!");
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }

            psmt.close();
            con.close();
            sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
