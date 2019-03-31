package Sala;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import Cliente.Cliente;
import Mensajes.Mensaje;
import Servidor.HiloServidor;

public class Sala implements Serializable {
	
	private static final long serialVersionUID = 5838832563874494113L;
	private  static ArrayList<Cliente> clientesEnSala;
	private String nombre;
	private int nroSala;
	private static final AtomicInteger nroSalaIncremental = new AtomicInteger(1);


	public Sala(String nombre, boolean banderaLobby) {

		this.nroSala = nroSalaIncremental.getAndIncrement();
		this.nombre = nombre;
		clientesEnSala = new ArrayList<Cliente>();

	}

	public Sala(String nombre) {
		this.nroSala = 0;
		this.nombre = nombre;
		clientesEnSala = new ArrayList<Cliente>();
	}

	public void meterClienteEnSala(Cliente cliente) {

		if (clientesEnSala.contains(cliente))
			return;// el usuario ya esta en la sala
		clientesEnSala.add(cliente);// agrego el cliente a la sala
	}

	public boolean sacarClienteEnSala(Cliente cliente) {

		if (!clientesEnSala.contains(cliente))
			return false;// el usuario no esta en la sala

		clientesEnSala.remove(cliente);// saco el cliente de la sala
		return true;
	}
	
	public void enviarMensaje(Mensaje mensaje) {
		
		for(Cliente c:clientesEnSala)
			c.getSalida().enviarMensaje(mensaje);
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + nroSala;
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
		if (nroSala != other.nroSala)
			return false;
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNroSala() {
		return nroSala;
	}

	public  synchronized static ArrayList<Cliente> getClientesEnSala() {
		return clientesEnSala;
	}

	

	
}
