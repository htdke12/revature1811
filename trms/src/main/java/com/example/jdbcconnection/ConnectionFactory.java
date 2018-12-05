package com.example.jdbcconnection;





import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.util.Properties;



public class ConnectionFactory {

	

	private static ConnectionFactory cf = null;

	

	private static final String filename = "C:\\Users\\claus\\Documents\\workspace-spring-tool-suite-4-4.0.1.RELEASE\\trms\\src\\main\\resources/datasource.properties";



	private static String url="";



	private static String user="";



	private static String password="";



	private ConnectionFactory()  {

		
	
		

		try {

			Properties prop = new Properties();

			FileInputStream fis = new FileInputStream(filename);

			prop.load(fis);
			
			 

			url = prop.getProperty("url");

			user = prop.getProperty("username");

			password = prop.getProperty("password");

		} catch (FileNotFoundException e) {

			 

			e.printStackTrace();

		} catch (IOException e) {

			

			e.printStackTrace();

		}



	}



	public synchronized static ConnectionFactory getConnectionFactory() {

		if (cf == null) {

			cf = new ConnectionFactory();

		}

		return cf;

	}



	public Connection createConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection conn = null;
	
		

		try {
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("connected");

		} catch (SQLException e) {

			System.out.println("Unable to make connection to DataBase");

			e.printStackTrace();

		}

		return conn;

	}



}