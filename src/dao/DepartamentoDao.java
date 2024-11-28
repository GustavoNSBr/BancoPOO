package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.ConnectionBD;

import java.sql.Connection;

import model.Departamento;

public class DepartamentoDao implements IDao<Departamento>
{
	private static Connection conexao;

	@Override
	public boolean buscar(Departamento departamento)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "SELECT * FROM departamento WHERE fk_id_departamento = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, departamento.getCodigo());
			
			ResultSet result = ps.executeQuery();
			
			boolean res = result.next();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em Departamento (buscar)");
			}
			
			return res;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao buscar departamento: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em DepartamentoDao (buscar)");
			}
			
			return false;
		}
	}
	
	@Override
	public boolean deletar(Departamento departamento)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "DELETE FROM departamento WHERE fk_id_departamento = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, departamento.getCodigo());
			
			int linhasAfetadas = ps.executeUpdate();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em DepartamentoDao (deletar)");
			}
			
			return linhasAfetadas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao deletar departamento: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em DepartamentoDao (deletar)");
			}
			
			return false;
		}
	}
	
	@Override 
	public boolean alterar(int id, Departamento novoDepartamento)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "UPDATE departamento SET denominacao_departamento WHERE fk_id_departamento = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, novoDepartamento.getDenominacao());
			ps.setInt(2, id);
			
			
			int linhasAlteradas = ps.executeUpdate();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em DepartamentoDao (criar)");
			}
			
			return linhasAlteradas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao alterar departamento: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em DepartamentoDao (criar)");
			}
			
			return false;
		}
	}

	@Override
	public boolean criar(Departamento tipo) {
		// TODO Auto-generated method stub
		return false;
	}
}