package com.jdbc.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



public class CRUDOperations {
	public static void main(String[] args) {
		final String URL ="jdbc:mysql://localhost:3306/10kcoders";
		final String um = "root";
		final String pw="root";
		
//		final String insert = "insert into Students values(4,'Lokesh',644,'KPHB')";
//		
//		final String Update = "Update Students set id = 2 where city='KMM' ";
//		
//		final String Delete = "Delete from Students where id = 4";
		
		final String Read = "Select * from Students";
		
		String query = "insert into Students Values(?,?,?,?)";
		Scanner sc = new Scanner(System.in);
		
		
		try {
			//stage_1
			Connection con = DriverManager.getConnection(URL,um,pw);
			//Stage_2
			
			PreparedStatement ps = con.prepareStatement(query); 
			
			int id = Integer.parseInt(sc.nextLine());
			String name = sc.nextLine();
			int marks = Integer.parseInt(sc.nextLine());
			String loc = sc.nextLine();
			
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setInt(3, marks);
			ps.setString(4,loc);
			
			//Stage-3
			
			int rows=ps.executeUpdate();
			System.out.println(rows+"inserted....");
			
			//Stage-4
			
			
			
			Statement stmt = con.createStatement();
			
//			stmt.executeUpdate(insert);
//			stmt.executeUpdate(Update);
//			stmt.executeUpdate(Delete);
			ResultSet  rs = stmt.executeQuery(Read);
			
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("Student_Name")+" "+rs.getInt("marks")+" "+rs.getString("city"));
			}
//			System.out.println("inseerted data sucessfullly");
//			System.out.println("Updated  data sucessfullly");
			
//			System.out.println("Deleted  data sucessfullly");
//			

		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
}




//package com.jdbc.firstproject;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.Scanner;
//
//public class Demo1 {
//
//    public static void main(String[] args) {
//
//        // Database details
//        final String URL = "jdbc:mysql://localhost:3306/demo";
//        final String USERNAME = "root";
//        final String PASSWORD = "root";
//
//        // SQL queries
//        String insertQuery = "INSERT INTO Students VALUES (?, ?, ?, ?)";
//        String readQuery = "SELECT * FROM Students";
//
//        // Scanner object
//        Scanner sc = new Scanner(System.in);
//
//        try {
//
//            // Stage 1: Create connection
//            Connection con = DriverManager.getConnection(
//                    URL, USERNAME, PASSWORD
//            );
//
//            System.out.println("Database connected...");
//
//            // Stage 2: Create PreparedStatement
//            PreparedStatement ps = con.prepareStatement(insertQuery);
//
//            // Taking values from user
//            System.out.print("Enter ID: ");
//            int id = Integer.parseInt(sc.nextLine());
//
//            System.out.print("Enter Name: ");
//            String name = sc.nextLine();
//
//            System.out.print("Enter Marks: ");
//            int marks = Integer.parseInt(sc.nextLine());
//
//            System.out.print("Enter City: ");
//            String city = sc.nextLine();
//
//            // Setting values
//            ps.setInt(1, id);
//            ps.setString(2, name);
//            ps.setInt(3, marks);
//            ps.setString(4, city);
//
//            // Stage 3: Execute INSERT
//            int rows = ps.executeUpdate();
//
//            System.out.println(rows + " row inserted successfully.");
//
//            // Stage 4: Read data
//            Statement stmt = con.createStatement();
//
//            ResultSet rs = stmt.executeQuery(readQuery);
//
//            System.out.println("\nStudent Details:");
//
//            while (rs.next()) {
//
//                System.out.println(
//                    rs.getInt("id") + " " +
//                    rs.getString("Student_Name") + " " +
//                    rs.getInt("marks") + " " +
//                    rs.getString("city")
//                );
//            }
//
//            // Close resources
//            rs.close();
//            stmt.close();
//            ps.close();
//            con.close();
//            sc.close();
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//    }
//}
