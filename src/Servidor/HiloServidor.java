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

import org.hibernate.result.Output;

import Cliente.Cliente;
import Stream.FlujoDeEntrada;
import Stream.FlujoDeSalida;

public class HiloServidor implements Runnable {

	private Socket socket;
	private PanelServidor panel;
	private FlujoDeEntrada entrada;
	private FlujoDeSalida salida;
	private int idCliente;
	private Socket socketReenvio;
	private LinkedList<HiloServidor> Clientes;

	public HiloServidor(Socket socket, PanelServidor panel, int idCliente, LinkedList<HiloServidor> Clientes)
			throws IOException {
		this.socket = socket;
		this.panel = panel;
		this.idCliente = idCliente;
		this.Clientes = Clientes;

		FlujoDeEntrada entrada = new FlujoDeEntrada(socket);
		FlujoDeSalida salida = new FlujoDeSalida(socket);

	}

	@Override
	public void run() {

		while (true) {
			try {

				Thread hiloEntrada = new Thread(entrada);
				Thread hiloSalida = new Thread(salida);

				hiloEntrada.start();
				hiloSalida.start();
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}
}