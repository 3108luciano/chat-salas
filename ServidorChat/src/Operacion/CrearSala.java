package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Cliente.Persona;
import Mensajes.Comandos;
import Mensajes.Mensaje;
import Sala.Sala;
import Servidor.ControladorServidor;
import Servidor.HiloServidor;

public class CrearSala implements InterfazPeticion {

	private static final long serialVersionUID = 2938832563874494113L;
	private ArrayList<Sala> salas;
	private ArrayList<Cliente> clienteslobby;

	public CrearSala() {

	}

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		this.salas = ControladorServidor.getInstancia().getSalas();
		this.clienteslobby = ControladorServidor.getInstancia().getClientesLobby();

		Persona persona = (Persona) mensaje.getDatos();

		Cliente cliente = buscarClienteCreador(persona.getNick());

		Sala sala = new Sala(mensaje.getCadena(), true);

		sala.meterClienteEnSala(cliente);
		salas.add(sala);

		this.clienteslobby = ControladorServidor.getInstancia().getClientesLobby();
		ControladorServidor.getInstancia().setSalas(salas);
		
		for (Cliente c : clienteslobby) {
			c.getSalida().enviarMensaje(new Mensaje(Comandos.CREARSALA, sala.getNroSala(), sala.getNombre(), persona.getNick()));
			System.out.println("N° SALA : " + sala.getNroSala() + " NOMBRE: " + sala.getNombre() + " ha sido creada exitosamente");
		}
		
		ArrayList<Sala>backupsalas = new ArrayList<Sala>();
		backupsalas.add(sala);
		for(Cliente c : clienteslobby) {
			if(!c.equals(persona.getNick()))
			c.getSalida().enviarMensaje(new Mensaje(Comandos.ACTUALIZARSALASLOBBY,backupsalas));
		}

	}

	private Cliente buscarClienteCreador(String nombre) {

		for (Cliente c : clienteslobby)
			if (c.getNick().equals(nombre))
				return c;

		return null;

	}
}
