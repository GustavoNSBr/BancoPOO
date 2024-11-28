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
			String sql = "INSERT INTO usuario (nome_usuario, endereco_usuario, telefone_usuario, senha)";
			sql = sql.concat("VALUES (?, ?, ?, ?)");
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEndereco());
			ps.setString(4, usuario.getTelefone());
			ps.setString(6, usuario.getSenha());
			
			int linhasAfetadas = ps.executeUpdate();
			
			return linhasAfetadas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao inserir usuario: " + e.getMessage());
			
			return false;
		}
	}

	@Override
	public boolean deletar(Usuario tipo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buscar(Usuario tipo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(int id, Usuario novoTipo) {
		// TODO Auto-generated method stub
		return false;
	}
	
//	@Override
//	public boolean deletar(Usuario usuario)
//	{
//		try
//		{
//			conexao = ConexaoBanco.conectar();
//			
//			if (conexao == null)
//				return false;
//			
//			String sql = "DELETE FROM usuario WHERE id_usuario = ?";
//			
//			PreparedStatement ps = conexao.prepareStatement(sql);
//			ps.setInt(1, usuario.getIdUsuario());
//			
//			int linhasAfetadas = ps.executeUpdate();
//			
//			if (!ConexaoBanco.desconectar(conexao))
//			{
//				System.out.println("FALHA: Conex�o n�o fechada em UsuarioDao (deletar)");
//			}
//			
//			return linhasAfetadas > 0;
//		}
//		catch (SQLException e)
//		{
//			System.out.println("Erro ao deletar usuario: " + e.getMessage());
//			
//			if (!ConexaoBanco.desconectar(conexao))
//			{
//				System.out.println("FALHA: Conex�o n�o fechada em UsuarioDao (deletar)");
//			}
//			
//			return false;
//		}
//	}
//	
//	@Override
//	public boolean buscar(Usuario usuario)
//	{
//		try
//		{
//			conexao = ConexaoBanco.conectar();
//			
//			if (conexao == null)
//				return false;
//			
//			String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
//			
//			PreparedStatement ps = conexao.prepareStatement(sql);
//			ps.setInt(1, usuario.getIdUsuario());
//			
//			ResultSet result = ps.executeQuery();
//			
//			boolean res = result.next();
//			
//			if (!ConexaoBanco.desconectar(conexao))
//			{
//				System.out.println("FALHA: Conex�o n�o fechada em UsuarioDao (buscar)");
//			}
//			
//			return res;
//		}
//		catch (SQLException e)
//		{
//			System.out.println("Erro ao buscar usuario: " + e.getMessage());
//			
//			if (!ConexaoBanco.desconectar(conexao))
//			{
//				System.out.println("FALHA: Conex�o n�o fechada em UsuarioDao (buscar)");
//			}
//			
//			return false;
//		}
//	}
//	
//	@Override
//	public boolean alterar(int id, Usuario novoUsuario)
//	{
//		try
//		{
//			conexao = ConexaoBanco.conectar();
//			
//			if (conexao == null)
//				return false;
//			
//			String sql = "UPDATE usuario SET nome_usuario = ?, cpf_usuario = ?, data_nascimento_usuario = ?, telefone_usuario = ?, tipo_usuario = ?, senha_usuario = ? WHERE id_usuario = ?";
//			
//			PreparedStatement ps = conexao.prepareStatement(sql);
//			ps.setString(1, novoUsuario.getNome());
//			ps.setString(2, novoUsuario.getCpf());
//			ps.setDate(3, novoUsuario.getDataNascimento());
//			ps.setString(4, novoUsuario.getTelefone());
//			ps.setString(5, novoUsuario.getTipoUsuario().name());
//			ps.setString(6,  novoUsuario.getSenha());
//			ps.setInt(7, id);
//			
//			int linhasAlteradas = ps.executeUpdate();
//			
//			if (!ConexaoBanco.desconectar(conexao))
//			{
//				System.out.println("FALHA: Conex�o n�o fechada em UsuarioDao (alterar)");
//			}
//			
//			return linhasAlteradas > 0;
//		}
//		catch (SQLException e)
//		{
//			System.out.println("Erro ao alterar usuario: " + e.getMessage());
//			
//			if (!ConexaoBanco.desconectar(conexao))
//			{
//				System.out.println("FALHA: Conex�o n�o fechada em UsuarioDao (alterar)");
//			}
//			
//			return false;
//		}
//	}
//	
//	public int buscarIdUsuario(Usuario usuario)
//	{
//		try
//		{
//			conexao = ConexaoBanco.conectar();
//			
//			if (conexao == null)
//				return -1;
//			
//			String sql = "SELECT id_usuario FROM usuario WHERE cpf_usuario = ?";
//			
//			PreparedStatement ps = conexao.prepareStatement(sql);
//			ps.setString(1, usuario.getCpf());
//			
//			ResultSet result = ps.executeQuery();
//			
//			boolean houveResposta = result.next();
//			
//			int res = -1;
//			
//			if (houveResposta)
//				res = result.getInt(1);
//			
//			if (!ConexaoBanco.desconectar(conexao))
//				System.out.println("FALHA: Conex�o n�o fechada em UsuarioDao (buscarIdUsuario)");
//			
//			return res;
//		}
//		catch (SQLException e)
//		{
//			System.out.println("Erro: n�o foi poss�vel buscar o id do usu�rio (UsuarioDAo - buscarIdUsuario)");
//			System.out.println(e.getMessage());
//			
//			if (!ConexaoBanco.desconectar(conexao))
//				System.out.println("FALHA: Conex�o n�o fechada em UsuarioDao (buscarIdUsuario)");
//			
//			return -1;
//		}
//	}
//	
//	
//	public boolean logarUsuario(Usuario usuario, String senhaLogin)
//	{
//		try
//		{
//			conexao = ConexaoBanco.conectar();
//			
//			if (conexao == null)
//				return false;
//			
//			String sql = "select senha_usuario from usuario where cpf_usuario = ?";
//			
//			PreparedStatement ps = conexao.prepareStatement(sql);
//			ps.setString(1, usuario.getCpf());
//			
//			ResultSet linha = ps.executeQuery();
//			
//			if (linha.next())
//			{
//				String senhaBanco = linha.getString("senha_usuario");
//				
//				System.out.println(senhaBanco);
//				
//				if (!ConexaoBanco.desconectar(conexao))
//				{
//					System.out.println("FALHA: Conex�o n�o fechada em UsuarioDao (criar)");
//				}
//				
//				return senhaBanco.equals(senhaLogin);
//			}
//
//			if (!ConexaoBanco.desconectar(conexao))
//			{
//				System.out.println("FALHA: Conex�o n�o fechada em UsuarioDao (criar)");
//			}
//			
//			return false;
//		}
//		catch (SQLException e)
//		{
//			System.out.println("Erro ao inserir usuario: " + e.getMessage());
//			
//			if (!ConexaoBanco.desconectar(conexao))
//			{
//				System.out.println("FALHA: Conex�o n�o fechada em UsuarioDao (criar)");
//			}
//			
//			return false;
//		}
//	}
}