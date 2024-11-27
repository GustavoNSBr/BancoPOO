package model;

public class Departamento {
    private int codigo;
    private String denominacao;

    public Departamento(int codigo, String denominacao) {
        this.codigo = codigo;
        this.denominacao = denominacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }
}