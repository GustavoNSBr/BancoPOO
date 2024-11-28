package view;
import dao.*;

import model.*;

import java.sql.Date;

import javax.swing.*;

import controller.*;


public class Main {
    public static void main(String[] args)
    {
    	Curso curso = new Curso(1, "Ensino Medio", "EM");
    	
		Aluno aluno = new Aluno(1, "245278910", 1, Date.valueOf("2020-08-23"), Date.valueOf("2014-07-03"), "Joao", "rua 1", "62889732112", "1231", curso);
		
		AlunoController alunoCont = new AlunoController();
		
		alunoCont.cadastrarAluno(aluno);
		System.out.println(alunoCont.buscarAluno(aluno).getMensagem());
		
//		Usuario usuario = new Usuario("Gustavo", "Taguatinga", "u25u238", "nijngre");
//		
//		UsuarioController userCont = new UsuarioController();
//		
//		userCont.cadastrarEndereco(usuario);
		
    }
}