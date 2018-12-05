package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.jdbcconnection.ConnectionFactory;
import com.example.obj.Grade;

public class GradeDao {
	
	private String statement;
	private static Connection conn;
	
	
	
	public static Grade getData(String data) {
		try {
			Grade temp = new Grade();
			conn = ConnectionFactory.getConnectionFactory().createConnection();

			Statement stmt = conn.createStatement();

			String sqlQuery = "select * from grading where course_type ='"+data+"'";

			

			ResultSet rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				
					temp.setType(rs.getString(1));
					temp.setGrades(rs.getString(2));
					temp.setPass_fail(rs.getInt(3));
					

			}

			return temp;

		} catch (SQLException e) {

			System.out.println("APPLICATION UNSUCCESSFUL TRY AGAIN");

			e.printStackTrace();

		}

		return null;

	}

}
