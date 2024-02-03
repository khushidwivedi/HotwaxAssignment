package com.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Party {
	public static void main(String...s) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/khushi","root","root");
			if(conn!=null) {
//				System.out.println("Connection created successfully");
				String query = "SELECT * FROM khushi.party";
				if(query!=null) {
//					System.out.println("Data retrieved successfully");
				}
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				
				System.out.println("---------------Party Table--------------");
				
				System.out.println("party_id\t\tparty_enum_type_id");
				
				while (rs.next()) {
					 
	                String party_id = rs.getString("party_id");
	                String party_enum_type_id = rs.getString("party_enum_type_id");
	                System.out.println( party_id+ "\t\t\t" + party_enum_type_id);
	            }
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
