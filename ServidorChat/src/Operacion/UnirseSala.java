package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Cliente.Persona;
import Mensajes.Comandos;
import Mensajes.Mensaje;
import Sala.Sala;
import Servidor.ControladorServidor;
import Servidor.HiloServidor;

public class UnirseSala implements InterfazPeticion {

	private static final long serialVersionUID = 2948832563874494113L;
	private ArrayList<Sala> salas;
	private ArrayList<Cliente> clientes;
	private Cliente cliente;
	private ArrayList<String> nicks;

	public UnirseSala() {
	}

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		salas = ControladorServidor.getInstancia().getSalas();
		clientes = ControladorServidor.getInstancia().getClientesLobby();

		Persona persona = (Persona) mensaje.getDatos();

		for (Cliente c : clientes) // busco el cliente en el lobby
			if (c.getNick().equals(persona.getNick()))
				cliente = c;

		for (int i = 0; i < salas.size(); i++) {
			if (salas.get(i).getNroSala() == mensaje.getNroSala()) {
				if (!buscarClienteEnSala(cliente, salas.get(i))) {
					salas.get(i).meterClienteEnSala(cliente);
					for (int j = 0; j < salas.get(i).getClientes().size(); j++) {
						salas.get(i).enviarMensaje(new Mensaje(Comandos.UNIRSESALA, salas.get(i).getNroSala(),
								salas.get(i).getNombre(), salas.get(i).getClientes().get(j)));
					}
				}

				else {
					System.out.println("El cliente ya se encuentra en la sala");
				}
			}

		}

	}

	public boolean buscarClienteEnSala(Cliente cliente, Sala sala) {

		if (sala.getClientesEnSala().contains(cliente))
			return true;

		return false;
	}

}
