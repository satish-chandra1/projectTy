package com.crm.practice_test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.DataBaseUtility;

public class DatabaseGenric_test extends DataBaseUtility {
	@Test
	public void database() throws SQLException {
		DataBaseUtility dlib =new DataBaseUtility();
		dlib.connectionToDB();
		ResultSet result = dlib.getAllData("select * from students_info");
		while(result.next()) {
			System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
		}
		dlib.closeDB();
	}

}
