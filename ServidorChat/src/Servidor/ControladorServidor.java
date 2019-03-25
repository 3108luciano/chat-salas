package Servidor;

import java.io.Serializable;
import java.util.ArrayList;

import Cliente.Cliente;
import Mensajes.Mensaje;
import Sala.Sala;

public abstract class ControladorServidor  implements Serializable{

	private ArrayList<Sala> salas;
	private ArrayList<Cliente>clientesLobby;
	
	public ControladorServidor() {
		salas = new ArrayList<Sala>();
		clientesLobby = new ArrayList<Cliente>();
		salas.add(new Sala(-1,"lobby",10));
	}
	
	public abstract void tratarPeticion(Mensaje mensaje);

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}
	
	
}
