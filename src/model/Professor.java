package model;

public class Professor extends Usuario {
    private int codigo;
    private String formacao;

    public Professor(int codigo, String formacao, String nome, String endereco, String telefone, String senha) {
    	super (nome, endereco, telefone, senha);
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