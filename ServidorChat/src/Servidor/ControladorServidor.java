package Servidor;

import java.io.Serializable;
import java.util.ArrayList;

import Cliente.Cliente;
import Mensajes.Mensaje;
import Operacion.CrearSala;
import Operacion.InterfazPeticion;
import Operacion.UnirseSala;
import Sala.Sala;

public class ControladorServidor implements Serializable {

	private static ArrayList<Sala> salas;
	private static ArrayList<Cliente> clientesLobby;
	private InterfazPeticion peticion;

	public ControladorServidor() {
		salas = new ArrayList<Sala>();
		clientesLobby = new ArrayList<Cliente>();
		salas.add(new Sala("Lobby"));

	}

	public synchronized void manejarMensaje(Mensaje mensaje) {
		peticion = (InterfazPeticion) mensaje.getCodigo();
		peticion.tratarPeticion(mensaje);
	}

	public static synchronized ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}

	public static synchronized ArrayList<Cliente> getClientesLobby() {
		return clientesLobby;
	}

	public synchronized void meterEnLobby(Cliente cliente) {

		if (clientesLobby.contains(cliente)) {
			System.out.println("El cliente ya esta en el lobby");
			return;
		}

		System.out.println("El cliente: " + cliente.getNick() + " ha entrado al lobby");
		clientesLobby.add(cliente);

		int i = 0;
		while (!salas.get(i).getNombre().equals("Lobby"))
			i++;

		salas.get(i).meterClienteEnSala(cliente);

	}
}
