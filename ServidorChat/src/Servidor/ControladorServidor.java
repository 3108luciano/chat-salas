package Servidor;

import java.io.Serializable;
import java.util.ArrayList;

import Cliente.Cliente;
import Mensajes.Comandos;
import Mensajes.Mensaje;
import Operacion.CrearSala;
import Operacion.InterfazPeticion;
import Operacion.UnirseSala;
import Sala.Sala;

public class ControladorServidor implements Serializable {

	private ArrayList<Sala> salas;
	private ArrayList<Cliente> clientesLobby;
	private InterfazPeticion peticion;
	private static ControladorServidor instancia = null;
	private ArrayList<String>nombreClientes;
	
	// singleton  lo uso para tener los mismos arraylist de clientes y salas para todas las instancias de hiloservidor
	private ControladorServidor() {
		salas = new ArrayList<Sala>();
		clientesLobby = new ArrayList<Cliente>();
		nombreClientes= new ArrayList<String>();
		salas.add(new Sala("Lobby"));

	}

	public synchronized static ControladorServidor getInstancia() {
		if (instancia == null)
			instancia = new ControladorServidor();
		return instancia;
	}

	//singleton
	public synchronized void manejarMensaje(Mensaje mensaje) {
		peticion = (InterfazPeticion) mensaje.getCodigo();
		peticion.tratarPeticion(mensaje);
	}

	public synchronized ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}

	public synchronized ArrayList<Cliente> getClientesLobby() {
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

		System.out.println("CLIENTES EN LOBBY");
		for (Cliente c : clientesLobby)
			System.out.println(c.getNick());

		
		for(Cliente c : clientesLobby)
			nombreClientes.add(c.getNick());
			
		for(Cliente c : clientesLobby)
			c.getSalida().enviarMensaje(new Mensaje(Comandos.ACTUALIZARLOBBY,nombreClientes));
	}
}
