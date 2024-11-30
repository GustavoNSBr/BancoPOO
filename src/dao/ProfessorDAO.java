package dao;

import model.Professor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.ConnectionBD;

import java.sql.Connection;

public class ProfessorDAO implements IDao<Professor> 
{
	private static Connection conexao;
	
	@Override
	public boolean criar(Professor professor)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sqlProfessor = "INSERT INTO professor (formacao_professor, fk_id_usuario) VALUES (?, ?)";
			String sqlPertence = "INSERT INTO Pertence (fk_id_departamento, fk_id_professor, fk_id_usuario) VALUES (?, ?, ?)";
			
			PreparedStatement psProfessor = conexao.prepareStatement(sqlProfessor, Statement.RETURN_GENERATED_KEYS);
			psProfessor.setString(1, professor.getFormacao());
			psProfessor.setInt(2, professor.getId_usuario());
			
			int linhasAfetadas = psProfessor.executeUpdate();
			
			if(linhasAfetadas > 0) {
				
				ResultSet generatedKeys = psProfessor.getGeneratedKeys();
	            int idProfessor = 0;
	            if (generatedKeys.next()) {
	                idProfessor = generatedKeys.getInt(1); // Obtém o ID gerado
	            }
	            
				PreparedStatement psPertence = conexao.prepareStatement(sqlPertence);
				psPertence.setInt(1, professor.getDep().getCodigo());
				psPertence.setInt(2, idProfessor);
				psPertence.setInt(3, professor.getId_usuario());
				
				int linhasPertenceAfetadas = psPertence.executeUpdate();
	            if (linhasPertenceAfetadas <= 0) {
	                System.out.println("Nenhuma linha inserida na tabela Pertence.");
	            }
			}
			if (!ConnectionBD.desconectar(conexao))
				System.out.println("FALHA: Conexão não fechada em ProfessorDao (criar)");
			
			return linhasAfetadas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao criar professor: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
				System.out.println("FALHA: Conexão não fechada em ProfessorDao (criar)");

			
			return false;
		}
	}
	
	@Override
	public boolean buscar(Professor professor)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "SELECT * FROM professor WHERE fk_id_usuario = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, professor.getId_usuario());
			
			ResultSet result = ps.executeQuery();
			
			boolean res = result.next();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em ProfessorDao (buscar)");
			}
			
			return res;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao buscar professor: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em ProfessorDao (buscar)");
			}
			
			return false;
		}
	}
	
	@Override
	public boolean deletar(Professor professor)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "DELETE FROM professor WHERE fk_id_usuario = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, professor.getId_usuario());
			
			int linhasAfetadas = ps.executeUpdate();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em ProfessorDao (deletar)");
			}
			
			return linhasAfetadas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao deletar professor: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em ProfessorDao (deletar)");
			}
			
			return false;
		}
	}
	
	@Override 
	public boolean alterar(int id, Professor novoProfessor)
	{
		try
		{
			conexao = ConnectionBD.conectar();
			
			if (conexao == null)
				return false;
			
			String sql = "UPDATE professor SET formacao_professor = ? WHERE fk_id_usuario = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, novoProfessor.getFormacao());
			ps.setInt(2, id);
			
			int linhasAlteradas = ps.executeUpdate();
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em ProfessorDao (criar)");
			}
			
			return linhasAlteradas > 0;
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao alterar funcionario: " + e.getMessage());
			
			if (!ConnectionBD.desconectar(conexao))
			{
				System.out.println("FALHA: Conexão não fechada em ProfessorDao (criar)");
			}
			
			return false;
		}
	}
}