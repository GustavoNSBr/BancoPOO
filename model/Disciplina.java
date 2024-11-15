package model;

public class Disciplina {
    private int codigo;
    private String denominacao;
    private String sigla;
    private String ementa;

    public Disciplina(int codigo, String denominacao, String sigla, String ementa) {
        this.codigo = codigo;
        this.denominacao = denominacao;
        this.sigla = sigla;
        this.ementa = ementa;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

}