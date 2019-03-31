package Operacion;

import java.util.ArrayList;

import Cliente.ControladorCliente;
import Mensajes.Mensaje;
import Sala.Sala;

public class ActualizarSalasLobby implements InterfazPeticion {

	private static final long serialVersionUID = 5938832563874494113L;
	private ArrayList<Sala>salas;
	
	@Override
	public void tratarPeticion(Mensaje mensaje) {
		salas=mensaje.getSalas();
		
		
		for(int i =1;i<salas.size();i++)
		ControladorCliente.getGuiLobby().agregarSala(salas.get(i).getNombre());
	}

}
