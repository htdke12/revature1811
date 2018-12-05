package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.example.jdbcconnection.ConnectionFactory;
import com.example.obj.Employee;
import com.example.obj.TrForm;

public class TrFormDao {
	
	
	
		
	private String statement;
	private static Connection conn;

	public  boolean insertData(TrForm f) /*insert values into the trf table*/
	 {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		conn = ConnectionFactory.getConnectionFactory().createConnection();
		String sql = "insert into trf values( "+f.getFid()+",'"+f.getCourseType()+"','"+f.getDate()+"','"+f.getTime()+"','"+f.getLocation()+"','"+f.getDescription()+"'"
				+ ","+f.getCost()+",'"+f.getWorkRelate()+"' ,'"+f.getGrade()+"',"+f.getEid()+")";
		
		System.out.println(sql);
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

	public  boolean deleteData(String data)  /*delete data from employee by eid*/{

		conn = ConnectionFactory.getConnectionFactory().createConnection();
		String sql = "delete from trf where fid="+data+"";
																							

		

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

	public  boolean updateData(String setColumnName,String setColumnData,int fid ) {

		conn = ConnectionFactory.getConnectionFactory().createConnection();
		String sql = "update trf set "+setColumnName+" =? where fid= ?";// + " set " + data[1] + "= ?";

		
		try {
			
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);

			preparedStmt.setString(1, setColumnData);
			preparedStmt.setInt(2, fid);
			
			
			

			preparedStmt.executeUpdate();
			
			
			
			
			
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	
	
	

}
