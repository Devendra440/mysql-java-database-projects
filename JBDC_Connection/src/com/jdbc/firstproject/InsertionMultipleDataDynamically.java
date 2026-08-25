package com.jdbc.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertionMultipleDataDynamically {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 final String url = "jdbc:mysql://localhost:3306/demo";
		 final String um = "root";
		 final String pw="root";
		 final String insert = "INSERT INTO Students (id, Student_Name, marks, city) VALUES (?, ?, ?, ?)";
		 
		 try {
			Connection con = DriverManager.getConnection(url,um,pw);
			PreparedStatement pstmt = con.prepareStatement(insert);
			
			System.out.println("How many students do you want to insert?");
			int n = sc.nextInt();
			
			for(int i=1;i<=n;i++) {
				System.out.println("\nEnter details of Student " + i);

                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                System.out.print("Enter Student Name: ");
                String name = sc.next();

                System.out.print("Enter Marks: ");
                int marks = sc.nextInt();

                System.out.print("Enter City: ");
                String city = sc.next();
                
                
                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setInt(3, marks);
                pstmt.setString(4, city);
                
                pstmt.addBatch();
                
                
			}
			
			int[] result = pstmt.executeBatch();

            System.out.println("\n" + result.length
                    + " records inserted successfully!");

            pstmt.close();
            con.close();
            sc.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		

	}

}
