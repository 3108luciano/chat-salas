package Cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;

import javax.swing.*;

import Mensajes.Comandos;
import Mensajes.Mensaje;
import Stream.FlujoDeEntrada;
import Stream.FlujoDeSalida;

import java.awt.*;

public class Cliente extends JFrame implements Serializable {

	private static final long serialVersionUID = 7799656478674716638L;
	private String nick;
	private FlujoDeEntrada entrada;
	private FlujoDeSalida salida;

	public Cliente(String nick, FlujoDeEntrada entrada, FlujoDeSalida salida) {
		this.nick = nick;
		this.salida = salida;
		this.entrada = entrada;
	}

	public void iniciarEscuchar() {
		Thread hilo = new Thread(entrada);
		hilo.start();
	}

	public void iniciarRespuesta() {
		Thread hilo = new Thread(salida);
		hilo.start();
	}

	public synchronized FlujoDeSalida getSalida() {
		return salida;
	}
	

	public synchronized FlujoDeEntrada getEntrada() {
		return entrada;
	}

	public  synchronized String getNick() {
		return nick;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		result = prime * result + ((salida == null) ? 0 : salida.hashCode());
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
		Cliente other = (Cliente) obj;
		if (entrada == null) {
			if (other.entrada != null)
				return false;
		} else if (!entrada.equals(other.entrada))
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		if (salida == null) {
			if (other.salida != null)
				return false;
		} else if (!salida.equals(other.salida))
			return false;
		return true;
	}

	
}
