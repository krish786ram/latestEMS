package com.flp.ems.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	public Connection getConnection() throws IOException, SQLException{
		
		Properties props=new Properties();
		
		FileInputStream fIn=new FileInputStream("dbDetails.properties");
		
		props.load(fIn);
		
		String url=props.getProperty("jdbc.url");
		
		Connection con = null;
		
		con=DriverManager.getConnection(url);
		
		return con;
	}
}
