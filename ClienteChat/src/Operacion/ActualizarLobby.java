package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Cliente.ControladorCliente;
import Cliente.HiloLogin;
import Gui.Gui_Lobby;
import Mensajes.Mensaje;

public class ActualizarLobby implements InterfazPeticion {

	private static final long serialVersionUID = 2958832563874494113L;
	private ArrayList<Cliente> clientes;
	private ArrayList<String> nombres;

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		clientes = new ArrayList<Cliente>();
		nombres = new ArrayList<String>();
		nombres = mensaje.getVdatos();
		

			for(String n : nombres)
			clientes.add(new Cliente(n));
			
		

		for(int i = 0 ;i<clientes.size();i++)
			HiloLogin.getGui_lobby().actualizarTablaClientesLobby(clientes.get(i).getNick());
	}

}
