package model;

public class Professor extends Usuario {
    private int codigo;
    private String formacao;

    public Professor(int id_usuario, String telefone, String cpf_usuario, String formacao, String nome, String endereco, int codigo, String senha) {
    	super (id_usuario, nome, cpf_usuario, endereco, telefone, senha);
        this.codigo = codigo;
        this.formacao = formacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
}