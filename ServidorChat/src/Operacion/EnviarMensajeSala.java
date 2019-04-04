package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Mensajes.Comandos;
import Mensajes.Mensaje;
import Sala.Sala;
import Servidor.ControladorServidor;

public class EnviarMensajeSala implements InterfazPeticion {

	private static final long serialVersionUID = 1256084117719956973L;
	private String texto;
	private String nick;
	private int nroSala;
	private ArrayList<Sala> salas;
	private ArrayList<Cliente> clientes;

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		nroSala = mensaje.getNroSala();
		texto = mensaje.getCadena();
		nick = mensaje.getCadena2();

		salas = ControladorServidor.getInstancia().getSalas();

		for (Sala s : salas)
			if (s.getNroSala() == nroSala)
				clientes = s.getClientesEnSala();
		
		for(Cliente c : clientes) {
			c.getSalida().enviarMensaje(new Mensaje(Comandos.MENSAJESALA,nroSala,texto,nick));
		}
	}

}
