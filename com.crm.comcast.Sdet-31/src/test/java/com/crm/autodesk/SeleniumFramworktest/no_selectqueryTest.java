package com.crm.autodesk.SeleniumFramworktest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class no_selectqueryTest {

	public static void main(String[] args) throws Throwable {
		Connection conn= null;
		int result=0;
		try {
			Driver driverref=new Driver();
			//Step1-register database with mysql
			DriverManager.registerDriver(driverref);
			
			//Step2-connect to database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
			System.out.println("connection is done");
			
			//Step3=create query statement
			Statement state=conn.createStatement();
			String query ="insert into students_info values('19','deepak','sir','t')";
			
			//Step4 execute the query
			result =state.executeUpdate(query);
			
			
		}catch(Exception e) {
			
		}finally {
			if(result==1) {
				System.out.println("inserted successfully");
			}else {
				System.out.println("not inserted");
			}
			//Step 5-step to close the connection
			conn.close();
			System.out.println("connection is closed");
		}
	}

}
