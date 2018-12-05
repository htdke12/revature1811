package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbcconnection.ConnectionFactory;
import com.example.obj.Employee;

public class EmployeeDao {
	
	
	private String statement;
	private static Connection conn;

	public  boolean insertData(Employee em)/*insert values into the employee table*/
	 {

		conn = ConnectionFactory.getConnectionFactory().createConnection();
		String sql = "insert into employee1 values( "+em.getEid()+",'"+em.getFname()+"','"+em.getLname()+"',"+em.getPositionType()+") ";//insert query (int,string,string,int)
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

	public  boolean deleteData(int data) /*delete data from employee by eid*/{

		conn = ConnectionFactory.getConnectionFactory().createConnection();
		String sql = "delete from employee1 where eid="+data+"";
																							

		

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

	public  boolean updateData(String setColumnName,String setColumnData,int eid ) {

		conn = ConnectionFactory.getConnectionFactory().createConnection();
		String sql = "update employee1 set "+setColumnName+" =? where eid= ?;";

		
		try {
			
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);

			preparedStmt.setString(1, setColumnData);
			preparedStmt.setInt(2, eid);
			
			
			System.out.println(sql);

			preparedStmt.executeUpdate();
			
			
			
			
			
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public  Employee getData(int data) {
		try {
			Employee temp = new Employee();
			conn = ConnectionFactory.getConnectionFactory().createConnection();

			Statement stmt = conn.createStatement();

			String sqlQuery = "select * from employee1 where eid ="+data+"";

			

			ResultSet rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				
					temp.setEid(rs.getInt(1));
					temp.setFname(rs.getString(2));
					temp.setLname(rs.getString(3));
					temp.setPositionType(rs.getInt(4));

			}

			return temp;

		} catch (SQLException e) {

			System.out.println("APPLICATION UNSUCCESSFUL TRY AGAIN");

			e.printStackTrace();

		}

		return null;

	}
	
	
	
	
}


