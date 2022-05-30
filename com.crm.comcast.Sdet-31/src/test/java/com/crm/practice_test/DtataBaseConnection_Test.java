package com.crm.practice_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.IPathConstants;
import com.mysql.cj.jdbc.Driver;

public class DtataBaseConnection_Test {

	@Test
	public void database() throws Throwable  {
		Connection conn=null;
		try {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection(IPathConstants.DATABASE_URL,IPathConstants.DB_USERNAME,IPathConstants.DB_PASSWORD);
		Statement stat = conn.createStatement();
		String query="select* from students_info";
		ResultSet result = stat.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		}catch(Exception e) {
			
		}finally {
			conn.close();
		}
	}
}
