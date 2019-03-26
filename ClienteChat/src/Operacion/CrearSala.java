package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Cliente.ControladorCliente;
import Mensajes.Mensaje;
import Sala.Sala;

public class CrearSala implements InterfazPeticion {

	private static final long serialVersionUID = 2938832563874494113L;
	private ArrayList<Cliente> clientesEnLobby;
	private ArrayList<Sala> salas;

	public CrearSala(ArrayList<Sala> salas, ArrayList<String> clientesLobby) {
		this.clientesEnLobby = clientesEnLobby;
		this.salas = salas;
	}

	@Override
	public void tratarPeticion(Mensaje mensaje) {

	}

}
