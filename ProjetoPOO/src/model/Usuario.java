package model;

public class Usuario {
	
	
	private String user;
	private String senha;
	private String perfil;
	private boolean lembrar;
	private String curso;
	
	public Usuario(String user, String senha, String perfil, boolean lembrar, String curso)
	{
			this.curso=curso;
			this.user = user;
			this.senha = senha;
			this.perfil = perfil;
			this.lembrar = lembrar;
	}
	
	public Usuario()
	{
		this(null, null, null, false, null);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public boolean isLembrar() {
		return lembrar;
	}

	public void setLembrar(boolean lembrar) {
		this.lembrar = lembrar;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}
