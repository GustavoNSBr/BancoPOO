package model;

import java.util.Date;

public class Aluno extends Usuario {
    private int matricula;
    private String filiacao;
    private Date dataNascimento;

    public Aluno(int matricula, int id_usuario, String filiacao, Date dataNascimento, String nome, String endereco, String telefone, String senha) {
    	super (id_usuario, nome, endereco, telefone, senha);
        this.matricula = matricula;
        this.filiacao = filiacao;
        this.dataNascimento = dataNascimento;
    }

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
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