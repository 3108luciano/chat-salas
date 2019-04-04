package Mensajes;

import java.io.Serializable;
import java.util.ArrayList;

import Cliente.Cliente;
import Operacion.ActualizarSalasLobby;
import Operacion.UnirseSala;
import Sala.Sala;

public class Mensaje implements Serializable {

	private static final long serialVersionUID = 2928832563874494113L;
	private Object codigo;
	private Object datos;
	private String cadena, cadena2;
	private int nroSala;
	private ArrayList<Sala> salas;
	private ArrayList<String> nicks;
	private Sala sala;

	public Mensaje(Object codigo, String cadena, Object datos) {
		this.codigo = codigo;
		this.cadena = cadena;
		this.datos = datos;
	}

	public Mensaje(Object codigo, int nroSala, String cadena, String cadena2) {
		this.codigo = codigo;
		this.nroSala = nroSala;
		this.cadena = cadena;
		this.cadena2 = cadena2;
	}

	public Mensaje(Object datos) {
		this.datos = datos;
	}

	public Mensaje(Object codigo, String cadena) {
		this.codigo = codigo;
		this.cadena = cadena;

	}

	public Mensaje(Object codigo, int nroSala, String cadena, ArrayList<String> nicks) {
		this.codigo = codigo;
		this.nroSala = nroSala;
		this.cadena = cadena;
		this.nicks = nicks;
	}

	public Mensaje(Object codigo, Sala sala) {
		this.codigo = codigo;
		this.sala = sala;
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

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public synchronized ArrayList<String> getNicks() {
		return nicks;
	}

	public String getCadena2() {
		return cadena2;
	}

}
