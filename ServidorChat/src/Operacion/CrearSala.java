package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Cliente.Persona;
import Mensajes.Mensaje;
import Sala.Sala;
import Servidor.ControladorServidor;

public class CrearSala implements InterfazPeticion {

	private static final long serialVersionUID = 2938832563874494113L;
	private ArrayList<Sala> salas;
	private ArrayList<Cliente> clienteslobby;
	private ControladorServidor controlador;

	public CrearSala() {

	}

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		this.salas = ControladorServidor.getSalas();
		this.clienteslobby = this.controlador.getClientesLobby();

		Persona persona = (Persona) mensaje.getDatos();
		Cliente cliente = buscarClienteCreador(persona.getNick());

		Sala sala = new Sala(mensaje.getCadena(), true);

		sala.meterClienteEnSala(cliente);
		salas.add(sala);

		for (Cliente c : clienteslobby)
			c.getSalida().enviarMensaje(new Mensaje(sala.getNroSala(), sala.getNombre(), persona.getNick()));

		System.out.println("sala creada exitosamente");

	}

	private Cliente buscarClienteCreador(String nombre) {

		for (Cliente c : clienteslobby)
			if (c.getNick().equals(nombre))
				return c;

		return null;

	}
}
