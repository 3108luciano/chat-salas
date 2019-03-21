package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import org.hibernate.result.Output;

import BD.Consulta;
import BD.Persona;
import Cliente.Cliente;
import Gui.Gui_Login;
import Gui.Gui_Registro;
import Mensajes.Mensaje;
import Stream.FlujoDeEntrada;
import Stream.FlujoDeSalida;

public class HiloServidor implements Runnable {

	private Socket socket;

	private FlujoDeEntrada entrada;
	private FlujoDeSalida salida;
	private List<Object[]> lista_de_cosas;
	private Persona persona;
	private Mensaje mensaje;
	private boolean corriendo = true;
	private boolean resultado;

	public HiloServidor(Socket socket) {

		this.socket = socket;

		try {
			salida = new FlujoDeSalida(this.socket);
			entrada = new FlujoDeEntrada(this.socket);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public boolean validarUsuario(Persona persona) {

		String consulta = "select p.email,p.contrase�a,p.nick from Persona p ";
		consulta += "where p.email=" + "'" + persona.getEmail() + "'" + " and p.contrase�a=" + "'"
				+ persona.getContrase�a() + "'";

		lista_de_cosas = Consulta.consultar(consulta);

		if (lista_de_cosas.isEmpty()) {
			return false;
		}

		return true;
	}

	@Override
	public void run() {

		while (corriendo) {

			try {
				corriendo = false;
				mensaje = (Mensaje) entrada.recibirMensaje();
				persona = (Persona) mensaje.getDatos();

				if (Gui_Registro.verificarEmail(persona.getEmail()) == true) {

					if (resultado = validarUsuario(persona) == true) {

						persona.setNick(lista_de_cosas.get(0)[2].toString());
						salida.enviarMensaje(new Mensaje(persona));

						Cliente clienteNuevo = new Cliente(persona.getNick(), entrada, salida);
						
					} else
						salida.enviarMensaje(null);
				}

			} catch (ClassNotFoundException | IOException e) {

				e.printStackTrace();

			}

		}
	}

}