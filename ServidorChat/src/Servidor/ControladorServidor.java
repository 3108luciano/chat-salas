package Servidor;

import java.io.Serializable;

import Mensajes.Mensaje;

public abstract class ControladorServidor  implements Serializable{

	public abstract void tratarPeticion(Mensaje mensaje);
}
