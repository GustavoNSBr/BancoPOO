package controller;

import dao.UsuarioDAO;
import model.Resposta;
import model.Usuario;

public class UsuarioController {

	
	public Resposta cadastrarEndereco(Usuario usuario) {
		
		UsuarioDAO userDAO = new UsuarioDAO();
		Resposta res = new Resposta();
		
	if (userDAO.criar(usuario) != true)
    {
    	System.out.println("Não foi possível criar um usuario");
    	res.setMensagem("Não foi possível criar usuario");
    	return res;
    }
    res.setOk(true);
    System.out.println("Usuario cadastrado com sucesso");
    return res;
}
}
