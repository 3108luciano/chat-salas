package Operacion;

import java.io.Serializable;

import Mensajes.Mensaje;

public interface InterfazPeticion  extends Serializable{

	public void tratarPeticion(Mensaje mensaje);
}
