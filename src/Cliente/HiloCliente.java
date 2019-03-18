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
import Mensajes.Mensaje;
import Stream.FlujoDeEntrada;
import Stream.FlujoDeSalida;

public class HiloCliente implements Runnable {

	private FlujoDeEntrada entrada;
	private FlujoDeSalida salida;
	private Login inicioSesion;
	private Socket socket;

	public HiloCliente(Socket socket, Login inicioSesion) {
		this.socket = socket;
		this.inicioSesion = inicioSesion;
		try {
			entrada = new FlujoDeEntrada(socket);
			salida = new FlujoDeSalida(socket);

			this.inicioSesion.getBoton1().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					try {
						salida.enviarMensaje(new Mensaje(inicioSesion.getPersona()));
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
			});
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
