package Operacion;

import Mensajes.Mensaje;
import Servidor.ControladorServidor;

public class UnirseSala extends ControladorServidor {

	@Override
	public void tratarPeticion(Mensaje mensaje) {
		System.out.println("soy unirse a sala");
		
	}

}
