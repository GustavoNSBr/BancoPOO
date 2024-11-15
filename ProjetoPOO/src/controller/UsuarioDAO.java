package controller;

import java.util.List;
import model.Usuario;

public interface UsuarioDAO {
	
	public List<Usuario> getAllUsers();
	public Usuario getUser(String userLogin);
	public void updateUser(Usuario user);
	public void deleteUser(Usuario user);
	public boolean adicionaUser(Usuario user);

}
