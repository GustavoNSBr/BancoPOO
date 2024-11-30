package model;

public class Usuario {
	
	protected int id_usuario;
	protected String nome;
	protected String cpf_usuario;
    protected String endereco;
    protected String telefone;
    protected String senha;
    protected TipoUsuario tipoUsuario;

    public Usuario(int id_usuario, String nome, String cpf_usuario, String endereco, String telefone, String senha) {
    	this.id_usuario = id_usuario;
    	this.nome = nome;
    	this.cpf_usuario = cpf_usuario;
    	this.endereco = endereco;
    	this.telefone = telefone;
    	this.senha = senha;
    }
    
    public Usuario(String cpf_usuario, String senha) {
    	this.cpf_usuario = cpf_usuario;
    	this.senha = senha;
    }

	public Usuario() {
		
	}

	public String getCpf_usuario() {
		return cpf_usuario;
	}

	public void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}


	public String getNome() {
		return nome;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_Usuario) {
		this.id_usuario = id_Usuario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	

}
