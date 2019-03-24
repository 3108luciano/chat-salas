package Cliente;

import java.io.Serializable;

import Mensajes.Mensaje;

public abstract class ControladorCliente implements Serializable {

	
	public abstract void tratarPeticion(Mensaje mensaje);
}
