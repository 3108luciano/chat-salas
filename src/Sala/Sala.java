package Sala;

import java.util.ArrayList;

import Servidor.HiloServidor;

public class Sala {

	private ArrayList<HiloServidor> Clientes;
	private String nombre;
	private int idSala;

	public Sala(String nombre) {
		this.nombre = nombre;
		
	}
	
	public void meterClienteEnSala(HiloServidor cliente) {
		
		if(Clientes.contains(cliente)) 
			return ;// el usuario ya esta en la sala
		Clientes.add(cliente);//agrego el cliente a la sala
	}
	
	public void sacarClienteEnSala(HiloServidor cliente) {
		
		if(!Clientes.contains(cliente)) 
			return ;// el usuario ya esta en la sala
		Clientes.remove(cliente);//agrego el cliente a la sala
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
