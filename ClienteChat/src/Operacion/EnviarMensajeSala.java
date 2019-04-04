package Operacion;

import Cliente.ControladorCliente;
import Mensajes.Mensaje;

public class EnviarMensajeSala implements InterfazPeticion {

	private static final long serialVersionUID = 1256084117719956973L;
	
	@Override
	public void tratarPeticion(Mensaje mensaje) {
		
		ControladorCliente.getBackupSalas().get(mensaje.getNroSala()).getGui_sala().getConversacion().append(mensaje.getCadena2()+" : "+mensaje.getCadena());
		ControladorCliente.getBackupSalas().get(mensaje.getNroSala()).getGui_sala().getConversacion().append("\n");
		}

}
