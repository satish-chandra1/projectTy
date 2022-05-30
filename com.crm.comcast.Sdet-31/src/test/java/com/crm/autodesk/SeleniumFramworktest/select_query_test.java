package com.crm.autodesk.SeleniumFramworktest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class select_query_test {

	public static void main(String[] args) throws Throwable {
		Connection conn= null;
		
		 try {
			 
			 Driver driverref=new Driver();
			 DriverManager.registerDriver(driverref);
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
			  Statement state=conn.createStatement();
			  String query="select* from students_info";
			  ResultSet res=state.executeQuery(query);
			  while(res.next()) {
				  System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getString(3)+"\t"+res.getString(4));
				  
			  }
			  
		 }catch(Exception e) {
			 
		 }
		 finally {
			 conn.close();
		 }
}
}