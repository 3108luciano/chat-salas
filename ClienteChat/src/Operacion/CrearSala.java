package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Cliente.ControladorCliente;
import Mensajes.Mensaje;
import Sala.Sala;

public class CrearSala implements InterfazPeticion {

	private static final long serialVersionUID = 2938832563874494113L;
	private ArrayList<String> clientesEnLobby;
	private ArrayList<Sala> salas;
	private ControladorCliente controlador;
	
	public CrearSala() {
	}

	@Override
	public void tratarPeticion(Mensaje mensaje) {

	}

}
