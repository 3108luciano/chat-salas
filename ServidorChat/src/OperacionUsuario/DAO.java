package OperacionUsuario;

public interface DAO<T, K> {

	public void insertar(T persona);

	public void consultar(K consulta);

}
