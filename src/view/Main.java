package view;
import dao.*;

import model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import config.ConnectionBD;
import controller.*;


public class Main {
    public static void main(String[] args) throws SQLException
    {
    	Connection conn = ConnectionBD.getConnection();
		System.out.println("Conexão Aberta!");
		
		conn.close();
		System.out.println("Conexão encerrada");
    }
}