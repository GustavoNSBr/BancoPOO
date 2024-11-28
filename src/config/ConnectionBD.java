package config;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionBD {
	
	protected static String url = "jdbc:mysql://banco-poo-projeto-poo.f.aivencloud.com:10487/mydb";
	protected static String user = "avnadmin";
	protected static String password = "AVNS_zu6ktRkOyym6pZD12E4";
    protected static Connection conn = null;
	
	public static Connection conectar()
	{
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("Conectado com sucesso");
			
		}
		catch(SQLException e)
		{
			System.out.println("Erro no mysql");
			System.out.println(e.getMessage());
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("Classe não encontrada, instale o driver nas dependencias do projeto");
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
	
	public static boolean desconectar(Connection conn)
	{
		if (conn != null)
		{
			try 
			{
				conn.close();
				System.out.println("Conexão encerrada");
				
				return true;
			} 
			catch(SQLException  e)
			{
				System.out.println("Não foi possível fechar a conexão");
				System.out.println(e.getMessage());
				return false;
			} 
		}
		
		return false;
	}
}