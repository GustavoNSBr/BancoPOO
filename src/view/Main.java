package view;
import dao.*;

import model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.*;

import config.ConnectionBD;
import controller.*;


public class Main {
    public static void main(String[] args) throws SQLException
    {
    	Connection conn = ConnectionBD.getConnection();
		System.out.println("Conexão Aberta!");
		
		Usuario usuario = new Usuario("Gustavo", "Taguatinga", "u25u238", "nijngre");
		
		UsuarioController userCont = new UsuarioController();
		
		userCont.cadastrarEndereco(usuario);
		
		conn.close();
		System.out.println("Conexão encerrada");
    }
}