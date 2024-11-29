package view;
import dao.*;

import model.*;
import model.Curso.NomeCurso;
import model.Curso.SiglaCurso;

import java.sql.Date;

import javax.swing.*;

import controller.*;


public class Main {
    public static void main(String[] args)
    {
    	Janela login = new Janela("Login");
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setSize(310,600);
		login.setVisible(true);
    
    	
//    	Curso curso = new Curso(1, NomeCurso.EnsinoFundamental, SiglaCurso.EF);
//    	
//		Aluno aluno = new Aluno(1, "24527891053", 1, Date.valueOf("2020-08-23"), Date.valueOf("2014-07-03"), "Joao", "rua 1", "62889732112", "1231", curso);
//		
//		Aluno aluno2 = new Aluno(1, "24527891053", 1, Date.valueOf("2000-08-23"), Date.valueOf("2001-07-03"), "Joao", "rua 1", "62889732112", "1231", curso);
//		
//		AlunoController alunoCont = new AlunoController();
//		
//		Professor professor = new Professor(1, "12153681391", "923.654.781-92", "Matematica", "Adam", "Brasilia", 1, "78910");
//		
//		Professor novoProf = new Professor(1, "12153681391", "923.654.781-92", "historia", "Milton", "Brasilia", 1, "78910");
//		
//		Usuario usuario = new Usuario(1, "Milton", "923.654.781-92", "Brasilia", "12153681391", "14115");
//		
//		UsuarioDAO userDAO = new UsuarioDAO();
//		
//		userDAO.alterar(15, usuario);
//		
//		ProfessorController profCont = new ProfessorController();
//		
//		profCont.cadastrarProfessor(professor);
//		profCont.alterarProfessor(15, novoProf);
//		profCont.deletarProfessor(professor);
//		
//		System.out.println(profCont.buscarProfessor(professor).getMensagem());
//		
//		alunoCont.cadastrarAluno(aluno);
//		alunoCont.alterarAluno(17, aluno2);
//		
//		alunoCont.deletarAluno(aluno);
//		
//		System.out.println(alunoCont.buscarAluno(aluno).getMensagem());
		

    }
}