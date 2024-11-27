package model;

public class Usuario {
	
	protected String nome;
    protected String endereco;
    protected String telefone;
    protected String senha;

    public Usuario(String nome, String endereco, String telefone, String senha) {
    	this.nome = nome;
    	this.endereco = endereco;
    	this.telefone = telefone;
    	this.senha = senha;
    }

	public String getNome() {
		return nome;
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

}
