package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConnectionBD;

import java.sql.Connection;

import model.Usuario;

public class UsuarioDAO implements IDao<Usuario>
{
	private static Connection conexao;
	
	@Override
	public boolean criar(Usuario usuario)
	{
		try
		{	
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			String sql = "INSERT INTO usuario (nome_usuario, endereco_usuario, telefone_usuario, senha, cpf_usuario)";
			sql = sql.concat("VALUES (?, ?, ?, ?, ?)");
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEndereco());
			ps.setString(3, usuario.getTelefone());
			ps.setString(4, usuario.getSenha());
			ps.setString(5, usuario.getCpf_usuario());
			
			int linhasAfetadas = ps.executeUpdate();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em UsuarioDAO (criar)");
			}
			
			return linhasAfetadas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao inserir usuario: " + e.getMessage());
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em UsuarioDAO");
			}
			
			return false;
		}
	}
	
	@Override
	public boolean deletar(Usuario usuario)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "DELETE FROM usuario WHERE id_usuario = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, usuario.getId_usuario());
			
			int linhasAfetadas = ps.executeUpdate();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexao nao fechada em UsuarioDao (deletar)");
			}
			
			return linhasAfetadas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao deletar usuario: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexao nao fechada em UsuarioDao (deletar)");
			}
			
			return false;
		}
	}
	
	@Override
	public boolean buscar(Usuario usuario)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, usuario.getId_usuario());
			
			ResultSet result = ps.executeQuery();
			
			boolean res = result.next();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexao nao fechada em UsuarioDao (buscar)");
			}
			
			return res;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao buscar usuario: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexao nao fechada em UsuarioDao (buscar)");
			}
			
			return false;
		}
	}
	
	@Override
	public boolean alterar(int id, Usuario novoUsuario)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "UPDATE usuario SET nome_usuario = ?, endereco_usuario = ?, telefone_usuario = ?, senha = ? WHERE id_usuario = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, novoUsuario.getNome());
			ps.setString(2, novoUsuario.getEndereco());
			ps.setString(3, novoUsuario.getTelefone());
			ps.setString(4, novoUsuario.getSenha());
			ps.setInt(5, id);
			
			int linhasAlteradas = ps.executeUpdate();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexao nao fechada em UsuarioDao (alterar)");
			}
			
			return linhasAlteradas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao alterar usuario: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexao nao fechada em UsuarioDao (alterar)");
			}
			
			return false;
		}
	}
	
	
	public boolean logarUsuario(Usuario usuario, String senhaLogin)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "select senha from usuario where nome_usuario = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			
			ResultSet linha = ps.executeQuery();
			
			if (linha.next())
			{
				String senhaBanco = linha.getString("senha");
				
				System.out.println(senhaBanco);
				
				if (!ConnectionBD.desconectar(conexao))
				{
					System.out.println("FALHA: Conexao nao fechada em UsuarioDao (logar)");
				}
				
				return senhaBanco.equals(senhaLogin);
			}

			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexao nao fechada em UsuarioDao (logar)");
			}
			
			return false;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao logar usuario: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexao nao fechada em UsuarioDao (logar)");
			}
			
			return false;
		}
	}
	
	public int buscarIdUsuario(Usuario usuario)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return -1;
			
			String sql = "SELECT id_usuario FROM usuario WHERE cpf_usuario = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getCpf_usuario());
			
			ResultSet result = ps.executeQuery();
			
			boolean houveResposta = result.next();
			
			int res = -1;
			
			if (houveResposta)
				res = result.getInt(1);
			
			if (!ConnectionBD.desconectar(conexao))
				System.out.println("FALHA: Conexão não fechada em UsuarioDao (buscarIdUsuario)");
			
			return res;
		}
		catch (SQLException e)
		{
			System.out.println("Erro: não foi possível buscar o id do usuário (UsuarioDAo - buscarIdUsuario)");
			System.out.println(e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
				System.out.println("FALHA: Conexão não fechada em UsuarioDao (buscarIdUsuario)");
			
			return -1;
		}
	}
}