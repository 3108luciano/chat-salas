package Mensajes;

import java.io.Serializable;
import java.util.ArrayList;

import Cliente.Cliente;

public class Mensaje implements Serializable {

	private static final long serialVersionUID = 2928832563874494113L;
	private Object codigo;
	private Object datos;
	private String cadena,cadena2;
	private int nroSala;
	private ArrayList<String> vdatos;
	
	public Mensaje(Object codigo, String cadena, Object datos) {
		this.codigo = codigo;
		this.cadena = cadena;
		this.datos = datos;
	}
	
	public Mensaje(Object codigo,int nroSala,String cadena,String cadena2) {
		this.codigo=codigo;
		this.nroSala=nroSala;
		this.cadena=cadena;
		this.cadena2=cadena2;
	}

	
	public Mensaje(Object datos) {
		this.datos=datos;
	}
	public Mensaje(Object codigo, ArrayList<String> vdatos) {
		this.codigo=codigo;
		this.vdatos=vdatos;
	}

	public Object getCodigo() {
		return codigo;
	}

	public Object getDatos() {
		return datos;
	}

	public String getCadena() {
		return cadena;
	}

	public int getNroSala() {
		return nroSala;
	}
	

}
