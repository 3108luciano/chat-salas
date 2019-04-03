package Sala;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import Cliente.Cliente;
import Mensajes.Mensaje;

public class Sala implements Serializable {

	private static final long serialVersionUID = 5838832563874494113L;
	private ArrayList<Cliente> clientesEnSala;
	private String nombre;
	private int nroSala;
	private static final AtomicInteger nroSalaIncremental = new AtomicInteger(1);
	private ArrayList<String> Clientes;
	private String clienteCreador;

	public Sala(String nombre, boolean banderaLobby) {

		this.nroSala = nroSalaIncremental.getAndIncrement();
		this.nombre = nombre;
		clientesEnSala = new ArrayList<Cliente>();
		Clientes = new ArrayList<String>();

	}

	public Sala(String nombre) {
		this.nroSala = 0;
		this.nombre = nombre;
		clientesEnSala = new ArrayList<Cliente>();
		Clientes = new ArrayList<String>();
	}

	public void meterClienteEnSala(Cliente cliente) {

		if (!clientesEnSala.contains(cliente)) {
			clientesEnSala.add(cliente);// agrego el cliente a la sala
			Clientes.add(cliente.getNick());
		}
	}

	public boolean sacarClienteEnSala(Cliente cliente) {

		if (!clientesEnSala.contains(cliente))
			return false;// el usuario no esta en la sala

		clientesEnSala.remove(cliente);// saco el cliente de la sala
		return true;
	}

	public synchronized void enviarMensaje(Mensaje mensaje) {

		for (Cliente c : clientesEnSala) 
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

	public synchronized String getNombre() {
		return nombre;
	}

	public synchronized int getNroSala() {
		return nroSala;
	}

	public synchronized ArrayList<Cliente> getClientesEnSala() {
		return clientesEnSala;
	}

	

	public synchronized String getClienteCreador() {
		return clienteCreador;
	}

	public synchronized void setClienteCreador(String clienteCreador) {
		this.clienteCreador = clienteCreador;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNroSala(int nroSala) {
		this.nroSala = nroSala;
	}

	

	public void setClientesEnSala(ArrayList<Cliente> clientesEnSala) {
		this.clientesEnSala = clientesEnSala;
	}

	public ArrayList<String> getClientes() {
		return Clientes;
	}

	public void setClientes(ArrayList<String> clientes) {
		Clientes = clientes;
	}

	
}
