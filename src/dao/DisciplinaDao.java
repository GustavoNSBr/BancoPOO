package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.ConnectionBD;

import java.sql.Connection;

import model.Disciplina;

public class DisciplinaDao implements IDao<Disciplina>
{
	private static Connection conexao;
	
	public boolean criar(Disciplina disciplina)
	{
		try
		{	
			String sql = "INSERT INTO usuario (denominacao_disciplina, sigla_disciplina, ementa_disciplina, fk_id_departamento)";
			sql = sql.concat("VALUES (?, ?, ?, ?)");
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, disciplina.getDenominacao());
			ps.setString(2, disciplina.getSigla());
			ps.setString(3, disciplina.getEmenta());
			ps.setInt(4, disciplina.getCodigo());
			
			
			int linhasAfetadas = ps.executeUpdate();
			
			return linhasAfetadas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao inserir disciplina: " + e.getMessage());
			
			return false;
		}
	}

	@Override
	public boolean buscar(Disciplina disciplina)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "SELECT * FROM disciplina WHERE fk_id_departamento = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, disciplina.getCodigo());
			
			ResultSet result = ps.executeQuery();
			
			boolean res = result.next();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em DisciplinaDao (buscar)");
			}
			
			return res;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao buscar disciplina: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em DisciplinaDao (buscar)");
			}
			
			return false;
		}
	}
	
	@Override
	public boolean deletar(Disciplina disciplina)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "DELETE FROM disciplina WHERE fk_id_departamento = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, disciplina.getCodigo());
			
			int linhasAfetadas = ps.executeUpdate();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em DisciplinaDao (deletar)");
			}
			
			return linhasAfetadas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao deletar disciplina: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em DisciplinaDao (deletar)");
			}
			
			return false;
		}
	}
	
	@Override 
	public boolean alterar(int id, Disciplina novaDisciplina)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "UPDATE disciplina SET denominacao_disciplina = ?, sigla_disciplina = ?, ementa_disciplina WHERE fk_id_departamento = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, novaDisciplina.getDenominacao());
			ps.setString(2, novaDisciplina.getSigla());
			ps.setString(3, novaDisciplina.getEmenta());
			ps.setInt(4, id);
			
			
			int linhasAlteradas = ps.executeUpdate();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em DisciplinaDao (criar)");
			}
			
			return linhasAlteradas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao alterar disciplina: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em DisciplinaDao (criar)");
			}
			
			return false;
		}
	}
}