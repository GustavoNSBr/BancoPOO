package model;

public class Resposta {
	
	private boolean ok;
	private String mensagem;
	
	public Resposta()
	{
		ok = false;
		mensagem = "";
	}
	
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}