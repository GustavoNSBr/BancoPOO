package controller;

import dao.*;

import model.*;

public class ProfessorController  {

    private ProfessorDAO profDao;

    public ProfessorController() {
        this.profDao = new ProfessorDAO();
    }

    private static Resposta validarProfessor(Professor professor)
	{
		Resposta res = new Resposta();
		
		// Validação de inputs
		
		if (professor == null)
		{
			res.setMensagem("Server error: objeto professor não pode ser nulo");
			return res;
		}
		
		int tamanhoNome = professor.getNome().length();
		if (tamanhoNome < 3 || tamanhoNome > 100 )
		{
			res.setMensagem("Nome é inválido");
			return res;
		}
		
		if(professor.getCpf_usuario().length() < 11 || professor.getCpf_usuario().length() > 15)
		{
			res.setMensagem("Cpf é menor que 11 caracteres ou maior que 15 caracteres");
			return res;
		}
		
		if (professor.getSenha().length() > 20 || professor.getSenha().length() < 4)
		{
			res.setMensagem("Senha é menor que 4 caracteres ou maior que 50 caracteres");
			return res;
		}
		
		if (professor.getTelefone().length() < 10 || professor.getTelefone().length() > 20)
		{
			res.setMensagem("Telefone inválido");
			return res;
		}
		
		if (professor.getEndereco().length() == 0)
		{
			res.setMensagem("Endereço inválido, verifique os campos preenchidos ou não");
			return res;
		}
		
		if (professor.getFormacao().length() == 0)
		{
			res.setMensagem("Formacao invalida");
			return res;
		}
		
		res.setOk(true);
		return res;
	}
	
    public Resposta cadastrarProfessor(Professor professor) {
    	
        Resposta validacao = validarProfessor(professor);
        
        if (!validacao.isOk())
        	return validacao;
        
        Resposta res = new Resposta();
        
        Usuario usuario = professor;
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
        
        	professor.setId_usuario(id);
        }
        
        if (!profDao.criar(professor))
		{
        	if (!usuarioDao.deletar(usuario))
        	{
        		System.out.println("Não foi possível apagar usuário após falha de criação de professor");
        	}
        	
        	res.setMensagem("Não foi possível criar professor");
        	return res;
		} else {
        
			System.out.println("Professor criado com sucesso");
			professor.setId_usuario(usuarioDao.buscarIdUsuario(usuario));
			res.setOk(true);
        	return res;
		}
    }

    public Resposta buscarProfessor(Professor professor) {
    	
    	Resposta validacao = validarProfessor(professor);
	        
        if (!validacao.isOk())
        	return validacao;
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        int id = usuarioDao.buscarIdUsuario(professor);
        
        Resposta res = new Resposta();
        
        if (id == -1)
        {
        	res.setMensagem("Não foi possível encontrar o usuário");
        	return res;
        }
        
        professor.setId_usuario(id);
        
        if (!profDao.buscar(professor))
		{
        	
        	res.setMensagem("Não foi possível encontrar o professor");
        	return res;
		}
        
        res.setOk(true);
        return res;
    }

    public Resposta deletarProfessor(Professor professor) {
    	Resposta validacao = validarProfessor(professor);
        
        if (!validacao.isOk())
        	return validacao;
        
        Resposta res = new Resposta();
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        int id = usuarioDao.buscarIdUsuario(professor);
        
        if (id == -1)
        {
        	res.setMensagem("Não foi possível encontrar o usuário");
        	return res;
        }
        
        professor.setId_usuario(id);
       
        if(!profDao.deletar(professor))
        {
        	res.setMensagem("Não foi possível deletar o professor");
        	return res;
        }
        
        usuarioDao.deletar(professor);
        System.out.println("Professor deletado com sucesso");
        res.setOk(true);
        return res;
    }

    public Resposta alterarProfessor(int id, Professor novoProfessor) {
        Resposta validacao = validarProfessor(novoProfessor);
        
        if (!validacao.isOk())
        	return validacao;
        
        Resposta res = new Resposta();
        
        ProfessorDAO professorDao = new ProfessorDAO();

       
        if(!professorDao.alterar(id, novoProfessor))
        {
        	res.setMensagem("Não foi possível alterar o professor");
        	return res;
        }
        
        System.out.println("Professor alterado com sucesso");
        res.setOk(true);
        return res;
    }
}