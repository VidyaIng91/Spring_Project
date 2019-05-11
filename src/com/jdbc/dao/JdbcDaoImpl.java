package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.model.Circle;

public class JdbcDaoImpl {
	
	Connection conn =null;
	Circle circle =null;
	
	public Circle getCircle(int circleID) {
		
	String connString = "jdbc:derby://localhost:1527/db"; //connection String
	String driver = "org.apache.derby.jdbc.ClientDriver"; //Drivers
	
	try {
		
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(connString);
		
		PreparedStatement psmt = conn.prepareStatement("select * from circle where id=?");
		psmt.setInt(1, circleID);
		
		ResultSet rs = psmt.executeQuery();
		if(rs.next())
		{
			circle = new Circle(circleID, rs.getString("name"));
		}
		conn.close();
		return circle;
		
	}
	catch(Exception e)
	{
		throw new RuntimeException(e);
	}
	finally {
		try
		{
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}//End of method
}
