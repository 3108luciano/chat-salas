package Mensajes;

import java.io.Serializable;

import BD.Persona;

public class Mensaje implements Serializable {
	
	private static final long serialVersionUID = 2928832563874494113L;
	private int codigo;
	private Object datos;

	public Mensaje(int codigo,Object datos) {
		this.codigo=codigo;
		this.datos=datos;
	}

	public int getCodigo() {
		return codigo;
	}

	public Object getDatos() {
		return datos;
	}



	
}
