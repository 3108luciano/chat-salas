package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Cliente.ControladorCliente;
import Cliente.HiloLogin;
import Gui.Gui_Lobby;
import Mensajes.Mensaje;

public class ActualizarClientesLobby implements InterfazPeticion {

	private static final long serialVersionUID = 2958832563874494113L;
	private ArrayList<String> clientes;

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		if (clientes == null) {
			clientes = new ArrayList<String>();
		}
		String nickCliente = mensaje.getCadena();
		clientes.add(nickCliente);
		//ControladorCliente.agregarClienteLobby(nickCliente);
		//ControladorCliente.getBackupSalas().get(0).meterClienteEnSala(nickCliente);
		Gui_Lobby.agregarCliente(nickCliente);

	}

}
