package Mensajes;

import java.io.Serializable;

import BD.Persona;

public class Mensaje implements Serializable {

	private int codigo;
	private Object datos;

	public Mensaje(Object datos) {
		this.datos=datos;
	}



	
}
