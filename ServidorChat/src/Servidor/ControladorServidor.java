package Servidor;

import Mensajes.Mensaje;

public abstract class ControladorServidor {

	public abstract void tratarPeticion(Mensaje mensaje);
}
