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

import BD.Consulta;
import Cliente.Cliente;
import Cliente.Persona;
import Mensajes.Comandos;
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

		String consulta = "select p.email,p.contraseña,p.nick from Persona p ";
		consulta += "where p.email=" + "'" + persona.getEmail() + "'" + " and p.contraseña=" + "'"
				+ persona.getContraseña() + "'";

		lista_de_cosas = Consulta.consultar(consulta);

		if (lista_de_cosas.isEmpty()) {
			return false;
		}

		return true;
	}

	@Override
	public void run() {

		while (corriendo) {

			corriendo = false;
			try {
				mensaje = entrada.recibirMensaje();
				persona = (Persona) mensaje.getDatos();

				if (Consulta.verificarEmail(persona.getEmail()) == true) {

					if (resultado = validarUsuario(persona) == true) {

						persona.setNick(lista_de_cosas.get(0)[2].toString());
						salida.enviarMensaje(new Mensaje(persona));

					
						
					} else
						salida.enviarMensaje(null);

				}
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Cliente clientenuevo = new Cliente(persona.getNick(), entrada, salida);
			clientenuevo.iniciarEscuchar();
			clientenuevo.iniciarRespuesta();
		}

	}
}
