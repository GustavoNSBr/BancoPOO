package model;

public class Departamento {
    private int codigo;
    private String denominacao;
    private NomeDep nomeDep;
    public enum NomeDep{
    	Matematica,
    	LinguaPortuguesa,
    	Ciencias,
    	Historia;
    }

    public Departamento(int codigo, String denominacao) {
        this.codigo = codigo;
        this.denominacao = denominacao;
    }
    
    public Departamento() {
    	
    }

    public int getCodigo() {
    	if(nomeDep == NomeDep.Matematica)
    		this.codigo = 1;
    	else if(nomeDep == NomeDep.Ciencias)
    		this.codigo = 2;
    	else if(nomeDep == NomeDep.LinguaPortuguesa)
    		this.codigo = 3;
    	else if(nomeDep == NomeDep.Historia)
    		this.codigo = 4;
    	else 
    		this.codigo = 0;
        return codigo;
    }

    public NomeDep getNomeDep() {
		return nomeDep;
	}

	public void setNomeDep(NomeDep nomeDep) {
		this.nomeDep = nomeDep;
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