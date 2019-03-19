package Mensajes;

import java.io.Serializable;

import BD.Persona;

public class Mensaje implements Serializable {
	
	private static final long serialVersionUID = 2928832563874494113L;
	private int codigo;
	private Object datos;

	public Mensaje(Object datos) {
		this.datos=datos;
	}



	
}
