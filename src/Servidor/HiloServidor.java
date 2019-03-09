package Servidor;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class HiloServidor implements Runnable {

	private Socket socket;
	private PanelServidor panel;
	private DataInputStream entrada;
	private DataOutputStream salida;
	private int idCliente;
	private Socket socketReenvio;
	private LinkedList<HiloServidor> Clientes;

	public HiloServidor(Socket socket, PanelServidor panel, int idCliente, LinkedList<HiloServidor> Clientes) {
		this.socket = socket;
		this.panel = panel;
		this.idCliente = idCliente;
		this.Clientes = Clientes;
		try {
			salida = new DataOutputStream(this.socket.getOutputStream());
			entrada = new DataInputStream(this.socket.getInputStream());

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		while (true) {
			try {
				String texto = entrada.readUTF();

				panel.getTextArea().append("cliente " + idCliente + ": " + texto);
				panel.getTextArea().append("\n");

				for (HiloServidor c : Clientes) { //renvioo los mensajes a todos los clientes
					c.salida.writeUTF(texto);
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}