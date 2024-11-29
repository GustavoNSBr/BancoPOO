package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import dao.*;

import model.*;

public class AlunoController  {

    private AlunoDao alunoDao;

    public AlunoController() throws SQLException{
        this.alunoDao = new AlunoDao();
    }

    private static Resposta validarAluno(Aluno aluno)
	{
		Resposta res = new Resposta();
		
		// Validação de inputs
		
		if (aluno == null)
		{
			res.setMensagem("Server error: objeto aluno não pode ser nulo");
			return res;
		}
		
		int tamanhoNome = aluno.getNome().length();
		if (tamanhoNome > 100 )
		{
			res.setMensagem("Nome é inválido");
			return res;
		}
		
		if(aluno.getCpf_usuario().length() < 11 || aluno.getCpf_usuario().length() > 15)
		{
			res.setMensagem("Cpf é menor que 11 caracteres ou maior que 15 caracteres");
			return res;
		}
		
		if (aluno.getSenha().length() > 20 || aluno.getSenha().length() < 4)
		{
			res.setMensagem("Senha é menor que 4 caracteres ou maior que 50 caracteres");
			return res;
		}
		
		if (aluno.getTelefone().length() < 10 || aluno.getTelefone().length() > 20)
		{
			res.setMensagem("Telefone inválido");
			return res;
		}
		
		LocalDate dtm = LocalDate.now();
		Date dataAtual = Date.valueOf(dtm);

		if (dataAtual.getYear() - aluno.getDataNascimento().getYear() > 100)
		{
			res.setMensagem("Data de nascimento invalida");
			return res;
		}
		
		if (aluno.getEndereco().length() == 0)
		{
			res.setMensagem("Endereço inválido, verifique os campos preenchidos ou não");
			return res;
		}
		
		if (dataAtual.getYear() - aluno.getFiliacao().getYear() > 100)
		{
			res.setMensagem("Data de filiacao invalida");
			return res;
		}
		
		res.setOk(true);
		return res;
	}
	
    public Resposta cadastrarAluno(Aluno aluno) {
    	
        Resposta validacao = validarAluno(aluno);
        
        if (!validacao.isOk())
        	return validacao;
        
        Resposta res = new Resposta();
        
        Usuario usuario = aluno;
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        if (!usuarioDao.criar(usuario))
        {
        	System.out.println("Não foi possível criar um usuário");
        	res.setMensagem("Não foi possível criar usuário");
        	return res;
        } else {
        
        	System.out.println("Usuario criado com sucesso");
        
        	int id = usuarioDao.buscarIdUsuario(usuario);
        
        	if (id == -1)
        	{
        		res.setMensagem("Não foi possível encontrar o id do usuário criado");
        		return res;
        	}
        
        	aluno.setId_usuario(id);
        }
        
        if (!alunoDao.criar(aluno))
		{
        	if (!usuarioDao.deletar(usuario))
        	{
        		System.out.println("Não foi possível apagar usuário após falha de criação de aluno");
        	}
        	
        	res.setMensagem("Não foi possível criar aluno");
        	return res;
		} else {
        
        System.out.println("Aluno criado com sucesso");
        
        aluno.setId_usuario(usuarioDao.buscarIdUsuario(usuario));
        res.setOk(true);
        return res;
		}
    }

    public Resposta buscarAluno(Aluno aluno) {
    	
    	Resposta validacao = validarAluno(aluno);
	        
        if (!validacao.isOk())
        	return validacao;
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        int id = usuarioDao.buscarIdUsuario(aluno);
        
        Resposta res = new Resposta();
        
        if (id == -1)
        {
        	res.setMensagem("Não foi possível encontrar o usuário");
        	return res;
        }
        
        aluno.setId_usuario(id);
        
        if (!alunoDao.buscar(aluno))
		{
        	
        	res.setMensagem("Não foi possível encontrar aluno");
        	return res;
		}
    
        res.setOk(true);
        return res;
    }

    public Resposta deletarAluno(Aluno aluno) {
    	Resposta validacao = validarAluno(aluno);
        
        if (!validacao.isOk())
        	return validacao;
        
        Resposta res = new Resposta();
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        int id = usuarioDao.buscarIdUsuario(aluno);
        
        if (id == -1)
        {
        	res.setMensagem("Não foi possível encontrar o usuário");
        	return res;
        }
        
        aluno.setId_usuario(id);
       
        if(!alunoDao.deletar(aluno))
        {
        	res.setMensagem("Não foi possível deletar o aluno");
        	return res;
        }
        
        usuarioDao.deletar(aluno);
        System.out.println("Aluno deletado com sucesso");
        res.setOk(true);
        return res;
    }

    public Resposta alterarAluno(int id, Aluno novoAluno) {
    	Resposta validacao = validarAluno(novoAluno);
        
        if (!validacao.isOk())
        	return validacao;
        
        Resposta res = new Resposta();
        
        AlunoDao alunoDao = new AlunoDao();

       
        if(!alunoDao.alterar(id, novoAluno))
        {
        	res.setMensagem("Não foi possível alterar o aluno");
        	return res;
        }
        
        System.out.println("Aluno alterado com sucesso");
        res.setOk(true);
        return res;
    }
}