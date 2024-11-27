package model;

import java.util.Date;

public class Aluno {
    private int matricula;
    private String nome;
    private String endereco;
    private String telefone;
    private String filiacao;
    private Date dataNascimento;

    public Aluno(int matricula, String nome, String endereco, String telefone, String filiacao, Date dataNascimento) {
        this.matricula = matricula;
        this.endereco = endereco;
        this.telefone = telefone;
        this.filiacao = filiacao;
        this.dataNascimento = dataNascimento;
    }

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}