package Sala;

import java.util.ArrayList;

import Cliente.Cliente;

public class Sala {

	private String nombre;
	private int nroSala;
	private int cantJugadores;
	private ArrayList<Cliente> Clientes;

	public Sala(int nroSala, String nombre, int cantJugadores) {
		this.nroSala = nroSala;
		this.nombre = nombre;
		this.cantJugadores = cantJugadores;

	}

	public void meterClienteEnSala(Cliente cliente) {

		if (Clientes.contains(cliente))
			return;// el usuario ya esta en la sala
		Clientes.add(cliente);// agrego el cliente a la sala
	}

	public void sacarClienteEnSala(Cliente cliente) {

		if (!Clientes.contains(cliente))
			return;// el usuario ya esta en la sala
		Clientes.remove(cliente);// agrego el cliente a la sala
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
