package com.DB;

import java.sql.*;

public class DBConnect {
	private static Connection con;
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes", "root", "root");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	

}