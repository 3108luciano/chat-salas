package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Mensajes.Mensaje;
import Sala.Sala;
import Servidor.ControladorServidor;

public class CrearSala implements InterfazPeticion {

	private static final long serialVersionUID = 2938832563874494113L;
	private ArrayList<Sala> salas;
	private ArrayList<Cliente> clienteslobby;

	public CrearSala(ArrayList<Sala> salas,ArrayList<Cliente> clienteslobby) {
		this.salas=salas;
		this.clienteslobby=clienteslobby;
	}
	
	@Override
	public void tratarPeticion(Mensaje mensaje) {

		

		Sala sala = new Sala(mensaje.getCadena(),true);
		
		//sala.meterClienteEnSala();
		salas.add(sala);
		
		
		for(Cliente c : clienteslobby)
			c.getSalida().enviarMensaje(mensaje);
		
		System.out.println("sala creada exitosamente");
	}
}
