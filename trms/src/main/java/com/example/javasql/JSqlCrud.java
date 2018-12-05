package com.example.javasql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbcconnection.ConnectionFactory;

public class JSqlCrud {

	private String statement;
	private static Connection conn;

	public static boolean insertData(String[] data) {

		conn = ConnectionFactory.getConnectionFactory().createConnection();
		String sql = "insert into " + data[0] + " values(" + data[1] + "";
		for (int i = 2; i < data.length; i++) {
			sql += ",'" + data[i] + "'";

		}
		sql += ");";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public static boolean deleteData(String[] data) {

		conn = ConnectionFactory.getConnectionFactory().createConnection();
		String sql = "delete from " + data[0] + " where " + data[1] + "='" + data[2] + "'";// and
																							// "+data[3]+"='"+data[4]+"'";

		if (data.length > 3) {
			sql += "and " + data[3] + "='" + data[4] + "';";

		}

		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public static boolean updateData(String[] data) {

		conn = ConnectionFactory.getConnectionFactory().createConnection();
		String sql = "update " + data[0] + " set " + data[1] + "= ?";

		if (data.length > 3) {
			sql += "where " + data[3] + "=?";

		}
		if (data.length > 5) {
			sql += "and " + data[5] + "=?";

		}

		try {
			
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);

			preparedStmt.setString(1, data[2]);
			
			if (data.length > 3) {
				preparedStmt.setString(2, data[4]) ;

			}
			
			if (data.length > 5) {
				preparedStmt.setString(3, data[6]) ;

			}
			

			preparedStmt.executeUpdate();
			
			
			
			
			
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public static List getData(String[] data) {
		try {
			List temp = new ArrayList();
			conn = ConnectionFactory.getConnectionFactory().createConnection();

			Statement stmt = conn.createStatement();

			String sqlQuery = "select * from " + data[0] + " where " + data[1] + "='" + data[2] + "'";

			if (data.length > 3) {
				sqlQuery += "and " + data[5] + "='" + data[6] + "'";

			}

			ResultSet rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				for (int i = 0; i < rs.getFetchSize(); i++)
					temp.add(rs.getString(i + 1));

			}

			return temp;

		} catch (SQLException e) {

			System.out.println("APPLICATION UNSUCCESSFUL TRY AGAIN");

			e.printStackTrace();

		}

		return null;

	}

	

}
