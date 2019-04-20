package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import BD.Consulta;
import Cliente.Cliente;
import Cliente.Persona;
import Mensajes.Comandos;
import Mensajes.Mensaje;
import Sala.Sala;
import Stream.FlujoDeEntrada;
import Stream.FlujoDeSalida;

public class HiloServidor implements Runnable {

	private Socket socket;
	private FlujoDeEntrada entrada;
	private FlujoDeSalida salida;
	private List<Object[]> lista_de_cosas;
	private Persona persona;
	private Mensaje mensaje;
	private ControladorServidor controlador;
	private ArrayList<Sala> salas;

	public HiloServidor(Socket socket) {

		this.socket = socket;

		try {
			salida = new FlujoDeSalida(this.socket);
			entrada = new FlujoDeEntrada(this.socket);
			controlador = ControladorServidor.getInstancia();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		boolean validacionUsuario = false;
		Cliente clientenuevo = null;

		do {

			try {
				mensaje = entrada.recibirMensaje();
				controlador.manejarMensaje(new Mensaje(mensaje.getCodigo(), mensaje.getDatos(), entrada, salida));
				persona = (Persona) mensaje.getDatos();

				salas = controlador.getSalas();

				if (salas.size() > 0) {
					for (Sala s : salas)
						clientenuevo.getSalida().enviarMensaje(new Mensaje(Comandos.ACTUALIZARSALASLOBBY,
								s.getNroSala(), s.getNombre(), s.getClientes()));
				}

				else
					salida.enviarMensaje(null);

			} catch (ClassNotFoundException | IOException e) {

				e.printStackTrace();

			}

		} while (validacionUsuario == false);

	}

}
