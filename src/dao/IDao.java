package dao;

public interface IDao<T> {
	public boolean criar(T tipo);
	public boolean deletar(T tipo);
	public boolean buscar(T tipo);
	public boolean alterar(int  id, T novoTipo);
}