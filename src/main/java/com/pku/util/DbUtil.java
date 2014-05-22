package com.pku.util;

import java.sql.*;
import java.util.*;
import java.io.*;


public class DbUtil {
	static InputStream inputStream = null; 
	static String driver;
	static String url;
	static String dbUser;
	static String dbPassword;
	

	public static void init() {
		try{
			
		//	File file = new File("db.properties");
//			FileInputStream fis
//				= new FileInputStream(file);
			
			inputStream = DbUtil.class.getResourceAsStream("/db.properties");
			Properties props 
				= new Properties();
			props.load(inputStream);

			driver = props.getProperty("master.jdbc.driverClassName");
			url = props.getProperty("master.jdbc.url");
			dbUser = props.getProperty("master.jdbc.username");
			dbPassword = props.getProperty("master.jdbc.password");

		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.
				getConnection(url, dbUser, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn){
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
