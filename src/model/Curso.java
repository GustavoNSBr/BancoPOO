package model;

public class Curso {
	
    private int codigo;
	private NomeCurso curso;
	private SiglaCurso sigla;
    public enum NomeCurso{
    	EnsinoMedio,
    	EnsinoFundamental
    }
    public enum SiglaCurso{
    	EM,
    	EF
    }

    public Curso(int codigo, NomeCurso curso, SiglaCurso sigla) {
        this.codigo = codigo;
        this.curso = curso;
        this.sigla = sigla;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

	public NomeCurso getCurso() {
		return curso;
	}

	public void setCurso(NomeCurso curso) {
		this.curso = curso;
	}

	public SiglaCurso getSigla() {
		return sigla;
	}

	public void setSigla(SiglaCurso sigla) {
		this.sigla = sigla;
	}

    
}