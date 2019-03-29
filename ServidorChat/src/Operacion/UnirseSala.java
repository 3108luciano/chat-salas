package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Cliente.Persona;
import Mensajes.Mensaje;
import Sala.Sala;
import Servidor.ControladorServidor;
import Servidor.HiloServidor;

public class UnirseSala implements InterfazPeticion {

	private static final long serialVersionUID = 2948832563874494113L;
	private ArrayList<Sala> salas;
	private ArrayList<Cliente> clientes;
	private Cliente cliente;
	private Sala sala;
	public UnirseSala() {
	}

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		salas = HiloServidor.getControlador().getSalas();
		clientes = HiloServidor.getControlador().getClientesLobby();

		Persona persona = (Persona) mensaje.getDatos();

		for (Cliente c : clientes) // busco el cliente en el lobby
			if (c.getNick().equals(persona.getNick()))
				cliente = c;

		for (Sala s : salas)
			if (s.getNroSala() == mensaje.getNroSala())
				if (!buscarClienteEnSala(cliente, s)) {
					s.meterClienteEnSala(cliente);
					sala=s;
				}
					
				else
					System.out.println("El cliente ya se encuentra en la sala");
		
		sala.enviarMensaje(new Mensaje(mensaje.getCodigo(),sala.getNroSala(),sala.getNombre(),cliente.getNick()));

	}

	public boolean buscarClienteEnSala(Cliente cliente, Sala sala) {

		if (sala.getClientesEnSala().contains(cliente))
			return false;

		return true;
	}

}
