package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.ConnectionBD;

import java.sql.Connection;

import model.Aluno;
import model.Curso;

public class AlunoDao implements IDao<Aluno>
{
	private static Connection conexao;
	
	public boolean criar(Aluno aluno)
	{
		try
		{	
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			String sql = "INSERT INTO aluno (filiacao_aluno, data_nascimento_aluno, fk_id_usuario, fk_id_curso)";
			sql = sql.concat("VALUES (?, ?, ?, ?)");
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setDate(1, aluno.getFiliacao());
			ps.setDate(2, aluno.getDataNascimento());
			ps.setInt(3, aluno.getId_usuario());
			ps.setInt(4, aluno.getCurso().getCodigo());
			
			
			int linhasAfetadas = ps.executeUpdate();
			
			return linhasAfetadas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao inserir aluno: " + e.getMessage());
			
			return false;
		}
	}

	@Override
	public boolean buscar(Aluno aluno)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "SELECT * FROM aluno WHERE fk_id_usuario = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, aluno.getId_usuario());
			
			ResultSet result = ps.executeQuery();
			
			boolean res = result.next();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em AlunoDao (buscar)");
			}
			
			return res;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao buscar aluno: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em AlunoDao (buscar)");
			}
			
			return false;
		}
	}
	
	@Override
	public boolean deletar(Aluno aluno)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "DELETE FROM aluno WHERE fk_id_usuario = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, aluno.getId_usuario());
			
			int linhasAfetadas = ps.executeUpdate();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em AlunoDao (deletar)");
			}
			
			return linhasAfetadas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao deletar aluno: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em AlunoDao (deletar)");
			}
			
			return false;
		}
	}
	
	@Override 
	public boolean alterar(int id, Aluno novoAluno)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "UPDATE aluno SET filiacao_aluno = ?, data_nascimento_aluno = ?, fk_id_curso = ? WHERE fk_id_usuario = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setDate(1, novoAluno.getFiliacao());
			ps.setDate(2, novoAluno.getDataNascimento());
			ps.setInt(3, novoAluno.getCurso().getCodigo());
			ps.setInt(4, id);
			
			
			int linhasAlteradas = ps.executeUpdate();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em AlunoDao (alterar)");
			}
			
			return linhasAlteradas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao alterar aluno: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em AlunoDao (alterar)");
			}
			
			return false;
		}
	}
}