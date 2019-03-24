package Operacion;

import Mensajes.Mensaje;
import Servidor.ControladorServidor;

public class CrearSala extends ControladorServidor {

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		System.out.println("soy crear sala");
	}
}
