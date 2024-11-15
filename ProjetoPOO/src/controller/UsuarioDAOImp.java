package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import config.ConnectionBD;
import model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAOImp implements UsuarioDAO{
	
	private Connection conn;
	
	public UsuarioDAOImp() throws SQLException
	{
		conn = ConnectionBD.getConnection();
		System.out.println("Conexão Aberta!");
		
	}

	@Override
	public List<Usuario> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getUser(String userLogin) {
		
		Usuario user = new Usuario();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM aluno WHERE matrucula_aluno=?");
			ps.setString(1, userLogin);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) 
			{
				user.setUser(rs.getString("userLogin"));
				user.setSenha(rs.getString("senhaLogin"));
				user.setPerfil(rs.getString("perfilUser"));
				user.setLembrar(rs.getBoolean("lembrarUser"));
				user.setCurso(rs.getString("cursoUser"));
				
			}
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}

	@Override
	public void updateUser(Usuario user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Usuario user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean adicionaUser(Usuario user) {
		
		try {
			PreparedStatement ps = 
					conn.prepareStatement("INSERT INTO LOGIN (userLogin,senhaLogin,perfilUser,lembrarUser,cursoUser) "+
											"VALUES (?,?,?,?,?)");
			ps.setString(1, user.getUser());
			ps.setString(2, user.getSenha());
			ps.setString(3, user.getPerfil());
			ps.setBoolean(4, user.isLembrar());
			ps.setString(5, user.getCurso());
			
			ps.executeUpdate();
			ps.close();
			return true;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	

}
