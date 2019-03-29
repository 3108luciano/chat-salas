package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import Cliente.Cliente;
import Mensajes.Comandos;
import Sala.Sala;

public class Servidor implements Runnable {

	private ServerSocket serversocket;
	private PanelServidor panel;
	private static int idCliente;
	private boolean corriendo = true;
	private int nrocliente;
	private int puerto;
	private HiloServidor hiloServidor;

	public Servidor(int puerto) {
		this.puerto = puerto;
		try {
			serversocket = new ServerSocket(this.puerto);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		Socket socketNuevo = null;

		while (corriendo) {

			try {
				socketNuevo = serversocket.accept();
				hiloServidor = new HiloServidor(socketNuevo);
				Thread hilo = new Thread(hiloServidor);
				hilo.start();
			} catch (IOException e) {
				e.printStackTrace();
				corriendo = false;

			}
		}

		try {
			serversocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
