package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.ConnectionBD;

import java.sql.Connection;

import model.Aluno;
import model.Curso;

public class CursoDao implements IDao<Curso>
{
	private static Connection conexao;
	
	public boolean criar(Curso curso)
	{
		try
		{	
			String sql = "INSERT INTO curso (nome_curso, sigla_curso, fk_id_curso)";
			sql = sql.concat("VALUES (?, ?, ?)");
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, curso.getNome());
			ps.setString(2, curso.getSigla());
			ps.setInt(3, curso.getCodigo());
			
			
			int linhasAfetadas = ps.executeUpdate();
			
			return linhasAfetadas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao inserir curso: " + e.getMessage());
			
			return false;
		}
	}
	
	@Override
	public boolean buscar(Curso curso)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "SELECT * FROM curso WHERE fk_id_curso = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, curso.getCodigo());
			
			ResultSet result = ps.executeQuery();
			
			boolean res = result.next();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em Curso (buscar)");
			}
			
			return res;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao buscar curso: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em CursoDao (buscar)");
			}
			
			return false;
		}
	}
	
	@Override
	public boolean deletar(Curso curso)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "DELETE FROM curso WHERE fk_id_curso = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, curso.getCodigo());
			
			int linhasAfetadas = ps.executeUpdate();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em CursoDao (deletar)");
			}
			
			return linhasAfetadas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao deletar curso: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em CursoDao (deletar)");
			}
			
			return false;
		}
	}
	
	@Override 
	public boolean alterar(int id, Curso novoCurso)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "UPDATE curso SET nome_curso = ?, sigla_curso = ? WHERE fk_id_curso = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, novoCurso.getNome());
			ps.setString(2, novoCurso.getSigla());
			ps.setInt(3, id);
			
			
			int linhasAlteradas = ps.executeUpdate();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em CursoDao (criar)");
			}
			
			return linhasAlteradas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao alterar curso: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em CursoDao (criar)");
			}
			
			return false;
		}
	}

}