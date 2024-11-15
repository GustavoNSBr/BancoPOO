package model;

public class Professor {
    private int codigo;
    private String nome;
    private String formacao;
    private String endereco;
    private String telefone;

    public Professor(int codigo, String nome, String formacao, String endereco, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.formacao = formacao;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
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
