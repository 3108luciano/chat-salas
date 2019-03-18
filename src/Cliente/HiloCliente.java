package Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JPanel;

import BD.Login;
import BD.Persona;
import Mensajes.Mensaje;
import Stream.FlujoDeEntrada;
import Stream.FlujoDeSalida;

public class HiloCliente implements Runnable {

	private FlujoDeEntrada entrada;
	private FlujoDeSalida salida;
	private Socket socket;
	private Persona persona;

	public HiloCliente(Socket socket, Persona persona) {
		this.socket = socket;
		this.persona = persona;
		try {
			salida = new FlujoDeSalida(this.socket);
			salida.enviarMensaje(new Mensaje(this.persona));
			entrada = new FlujoDeEntrada(this.socket);
			
		
			
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		/*
		 * while (true) { try {
		 * 
		 * String texto = entrada.readUTF(); panel.agregarTexto(texto);
		 * panel.agregarTexto("\n");
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } }
		 */
	}

}
