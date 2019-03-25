package Servidor;

import java.io.Serializable;
import java.util.ArrayList;

import Cliente.Cliente;
import Mensajes.Mensaje;
import Operacion.InterfazPeticion;
import Sala.Sala;

public  class ControladorServidor implements Serializable {

	private ArrayList<Sala> salas;
	private ArrayList<Cliente> clientesLobby;
	private InterfazPeticion peticion;

	public ControladorServidor() {
		salas = new ArrayList<Sala>();
		clientesLobby = new ArrayList<Cliente>();
		salas.add(new Sala(-1, "lobby", 10));
	}

	public synchronized void manejarMensaje(Mensaje mensaje) {
		peticion = (InterfazPeticion) mensaje.getCodigo();
		peticion.tratarPeticion(mensaje);
	}

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}

}
