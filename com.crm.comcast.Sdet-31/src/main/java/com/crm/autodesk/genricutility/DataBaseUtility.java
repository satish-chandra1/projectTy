package com.crm.autodesk.genricutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * this method establish the connection between jdbc and database
 * @author SATISH
 *
 */
public class DataBaseUtility {
	Connection conn=null;
	public void connectionToDB()  {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
            conn=DriverManager.getConnection(IPathConstants.DATABASE_URL,IPathConstants.DB_USERNAME,IPathConstants.DB_PASSWORD);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
	}
	/**
	 * this method is used to close the database connection.
	 */
	public void closeDB() {
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to get all the data from the database
	 * @param query
	 * @return
	 */
	
	public ResultSet getAllData(String query) {
		 ResultSet result = null;
		try {
			result = conn.createStatement().executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	/**
	 * this method is  used to insert the data from the database.
	 * @param query
	 * @return
	 */
	public boolean insertData(String query)  {
		int result=0;
		try {
			result = conn.createStatement().executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag=false;
		if(result==1) {
			System.out.println("data is added");
			flag=true;
			return flag;
		}
		else {
			System.out.println("data is not added");
		}
	return flag;
}	

}
