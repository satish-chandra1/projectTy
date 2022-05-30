package com.crm.autodesk.SeleniumFramworktest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class practicesql_test {

	public static void main(String[] args) throws Throwable {
		//Connection conn= null;
		
			//step1- load/register the database
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			
			//step2-connect to database
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
			System.out.println("connection is done");
			
			//step 3-create query statement
			Statement state=conn.createStatement();
			
			//Step4-execute query
			String query="select* from students_info";
			ResultSet result= state.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			}
			
			//Step5-close the connection
			conn.close();
		
			
		
	
	}

}
