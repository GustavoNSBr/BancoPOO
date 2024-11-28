package model;

import java.sql.Date;

public class Aluno extends Usuario {
    private int matricula;
    private Date filiacao;
    private Date dataNascimento;
    private Curso curso;

    public Aluno(int matricula, String cpf_usuario, int id_usuario, Date filiacao, Date dataNascimento, String nome, String endereco, String telefone, String senha, Curso curso) {
    	super (id_usuario, nome, cpf_usuario, endereco, telefone, senha);
        this.matricula = matricula;
        this.filiacao = filiacao;
        this.dataNascimento = dataNascimento;
        this.curso = curso;
    }
    
    public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}



	public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Date getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(Date filiacao) {
        this.filiacao = filiacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}