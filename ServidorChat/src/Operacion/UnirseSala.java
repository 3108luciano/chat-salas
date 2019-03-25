package Operacion;

import Mensajes.Mensaje;
import Servidor.ControladorServidor;

public class UnirseSala implements InterfazPeticion {

	private static final long serialVersionUID = 2948832563874494113L;
	
	@Override
	public void tratarPeticion(Mensaje mensaje) {
		System.out.println("soy unirse a sala");
		
	}

}
