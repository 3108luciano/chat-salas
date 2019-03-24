package Mensajes;

import java.io.Serializable;



public class Mensaje implements Serializable {
	
	private static final long serialVersionUID = 2928832563874494113L;
	private int codigo;
	private Object datos;
	private String cadena;
	
	public Mensaje(int codigo,Object datos) {
		this.codigo=codigo;
		this.datos=datos;
	}

	public Mensaje(Object datos) {
		this.datos=datos;
	}

	public Mensaje(int codigo, String cadena, Object datos) {
		// TODO Auto-generated constructor stub
	}

	public Object getCodigo() {
		return codigo;
	}

	public Object getDatos() {
		return datos;
	}



	
}
