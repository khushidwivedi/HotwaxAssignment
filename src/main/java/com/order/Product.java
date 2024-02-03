package com.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Product {
	public static void main(String...s) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/khushi","root","root");
			if(conn!=null) {
//				System.out.println("Connection created successfully");
				String query = "SELECT * FROM khushi.product";
				if(query!=null) {
//					System.out.println("Data retrieved successfully");
				}
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				
				System.out.println("---------------Product Table--------------");
				
				System.out.printf("%-12s%-12s%-20s%-45s%-30s%-10s%n","product_id","party_id","product_name","description","charge_shipping","returnable");
				
				while (rs.next()) {
					 
	                String product_id = rs.getString("product_id");
	                String party_id = rs.getString("party_id");
	                String product_name = rs.getString("product_name");
	                String description = rs.getString("description");
	                String charge_shipping = rs.getString("charge_shipping");
	                String returnable = rs.getString("returnable");
	                
	                System.out.printf("%-12s%-12s%-20s%-45s%-30s%-10s%n",
	                        product_id, party_id, product_name, description, charge_shipping, returnable);
	            }
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}


}
