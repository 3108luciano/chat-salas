package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

public class Servidor {

	private ServerSocket serversocket;
	private int puerto;
	boolean corriendo = true;
	private PanelServidor panel;
	private static int idCliente;
	private LinkedList<HiloServidor> Clientes;

	public Servidor(int puerto) {

		Clientes = new LinkedList<HiloServidor>();
		this.puerto = puerto;
		panel = new PanelServidor();

		Socket conexion = null;

		try {

			serversocket = new ServerSocket(this.puerto);

			while (true) {
				conexion = serversocket.accept();
				HiloServidor cliente = new HiloServidor(conexion, panel, ++idCliente, Clientes);
				Clientes.add(cliente); // guardo los clientes

				Thread hilo = new Thread(cliente);// escucho lo que viene de los clientes
				hilo.start();

			}
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public static void main(String[] args) {

		Servidor server = new Servidor(10000);
	}
}
