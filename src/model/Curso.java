package model;

public class Curso {
	
    private int codigo;
	private NomeCurso nomeCurso;
    public enum NomeCurso{
    	EnsinoMedio,
    	EnsinoFundamental;
    }

    public Curso(int codigo) {
        this.codigo = codigo;
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

	public NomeCurso getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(NomeCurso nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

}