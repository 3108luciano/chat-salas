package Operacion;

import java.util.ArrayList;

import Cliente.ControladorCliente;
import Mensajes.Mensaje;
import Sala.Sala;

public class ActualizarSalasLobby implements InterfazPeticion {

	private static final long serialVersionUID = 5938832563874494113L;
	private Sala sala;
	
	@Override
	public void tratarPeticion(Mensaje mensaje) {
		
	sala = new Sala(mensaje.getNicks(), mensaje.getNroSala(), mensaje.getCadena());
	
	ControladorCliente.agregarSala(sala);
	if(!sala.getNombre().equals("Lobby"))
	ControladorCliente.getGuiLobby().agregarSala(sala.getNombre());

}
	
}
