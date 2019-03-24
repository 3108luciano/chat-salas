package Sala;

import java.util.ArrayList;

import Cliente.Cliente;
import Servidor.HiloServidor;

public class Sala {

	private ArrayList<Cliente> clientes;
	private String nombre;
	private int nroSala;
	private int cantJugadores;

	public Sala(int nroSala, String nombre, int cantJugadores) {
		this.nroSala = nroSala;
		this.nombre = nombre;
		this.cantJugadores = cantJugadores;
		clientes = new ArrayList<Cliente>();

	}

	public void meterClienteEnSala(Cliente cliente) {

		if (clientes.contains(cliente))
			return;// el usuario ya esta en la sala
		clientes.add(cliente);// agrego el cliente a la sala
	}

	public void sacarClienteEnSala(Cliente cliente) {

		if (!clientes.contains(cliente))
			return;// el usuario no esta en la sala
		clientes.remove(cliente);// saco el cliente de la sala
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
