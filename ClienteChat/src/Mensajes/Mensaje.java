package Mensajes;

import java.io.Serializable;

import Cliente.Persona;
import Operacion.CrearSala;

public class Mensaje implements Serializable {

	private static final long serialVersionUID = 2928832563874494113L;
	private Object codigo;
	private Object datos;
	private String cadena, cadena2;
	private int nroSala;

	public Mensaje(Object codigo, Object datos) {
		this.codigo = codigo;
		this.datos = datos;
	}

	public Mensaje(Object datos) {
		this.datos = datos;
	}

	public Mensaje(Object codigo, String cadena, Object datos) {
		this.codigo = codigo;
		this.cadena = cadena;
		this.datos = datos;
	}

	public Mensaje(Object codigo, int nroSala, Object datos) {
		this.codigo = codigo;
		this.nroSala = nroSala;
		this.datos = datos;
	}

	public Mensaje(Object codigo, int nroSala, String cadena, String cadena2) {
		this.codigo = codigo;
		this.nroSala = nroSala;
		this.cadena = cadena;
		this.cadena2 = cadena2;
	}

	public Object getCodigo() {
		return codigo;
	}

	public Object getDatos() {
		return datos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCadena() {
		return cadena;
	}

	public String getCadena2() {
		return cadena2;
	}

	public int getNroSala() {
		return nroSala;
	}

	public void setNroSala(int nroSala) {
		this.nroSala = nroSala;
	}

}
