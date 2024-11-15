package config;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionBD {
	
	public static Connection getConnection()
	{
		String url = "jdbc:mysql://banco-poo-projeto-poo.f.aivencloud.com:10487/mydb";
		String user = "avnadmin";
		String password = "AVNS_zu6ktRkOyym6pZD12E4";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url,user,password);
			
		}catch(SQLException | ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		} 
		
	}

}
