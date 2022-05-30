package com.crm.practice_test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.DataBaseUtility;

public class MySqlTest  extends DataBaseUtility{
	Connection conn=null;
	@Test
	public void database() throws SQLException {
		
		DataBaseUtility dlib=new DataBaseUtility();
		dlib.connectionToDB();
		
		//dlib.getAllData("select* from students_Info;");
		ResultSet result = dlib.getAllData("select * from students_Info;");
		while(result.next()) {
		System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			
		}
		
		
		
		
		dlib.closeDB();
		
	}

}
