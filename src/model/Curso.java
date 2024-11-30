package model;

public class Curso {
	
    private int codigo;
	private String[] curso = {"Ensino Fundamental", "Ensino Medio"};
	private NomeCurso nomeCurso;
	private SiglaCurso sigla;
    public enum NomeCurso{
    	EnsinoMedio,
    	EnsinoFundamental;
    }
    public enum SiglaCurso{
    	EM,
    	EF
    }

    public Curso(int codigo, String[] curso, SiglaCurso sigla) {
        this.codigo = codigo;
        this.curso = curso;
        this.sigla = sigla;
    }
    
    public Curso() {
    	
    }

    public int getCodigo() {
    	if(nomeCurso == NomeCurso.EnsinoFundamental)
    		this.codigo = 1;
    	else if(nomeCurso == NomeCurso.EnsinoMedio)
    		this.codigo = 2;
    	else 
    		this.codigo = 0;
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

	public String[] getCurso() {
		return curso;
	}

	public void setCurso(String[] curso) {
		this.curso = curso;
	}

	public SiglaCurso getSigla() {
		return sigla;
	}

	public void setSigla(SiglaCurso sigla) {
		this.sigla = sigla;
	}

	public NomeCurso getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(NomeCurso nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	
}