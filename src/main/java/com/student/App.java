package com.student;

import java.sql.*;  
class App{  
	public static void main(String args[]){  
		selectData();
	}  

	public static void selectData(){
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://192.100.0.000:3306/DBname", "root", "root");  
			String category = System.getenv("ITEM_CATEGORY");
			Statement statement = con.createStatement();
			String query1 = "SELECT ITEM,PRICE FROM PRODUCT WHERE ITEM_CATEGORY='"
				+ category + "' ORDER BY PRICE";
			    ResultSet results = statement.executeQuery(query1); 
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}
}  
