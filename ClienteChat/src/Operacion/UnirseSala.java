package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Cliente.ControladorCliente;
import Mensajes.Mensaje;
import Sala.Sala;

public class UnirseSala implements InterfazPeticion {

	private static final long serialVersionUID = 2948832563874494113L;
	private ArrayList<Sala> backupSalas;
	private ArrayList<Cliente> backupClientes;

	@Override
	public void tratarPeticion(Mensaje mensaje) {

	}

}
