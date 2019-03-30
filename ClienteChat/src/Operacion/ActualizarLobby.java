package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Cliente.ControladorCliente;
import Cliente.HiloLogin;
import Gui.Gui_Lobby;
import Mensajes.Mensaje;

public class ActualizarLobby implements InterfazPeticion {

	private static final long serialVersionUID = 2958832563874494113L;
	private ArrayList<String> clientes ;

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		if(clientes==null) {
			clientes= new ArrayList<String>();
		}
		String nickCliente = mensaje.getCadena();
		clientes.add(nickCliente);
		Gui_Lobby.agregarCliente(nickCliente);

	}

}	
