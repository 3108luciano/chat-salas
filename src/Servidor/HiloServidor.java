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
import Gui.Gui_Login;
import Gui.Gui_Registro;
import Mensajes.Mensaje;

public class HiloServidor implements Runnable {

	private Socket socket;

	// private FlujoDeEntrada entrada;
	// private FlujoDeSalida salida;
	private List<Object[]> lista_de_cosas;
	private Persona persona;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private Mensaje mensaje;
	private boolean corriendo = true;
	private boolean resultado;

	public HiloServidor(Socket socket) {

		this.socket = socket;

		try {
			output = new ObjectOutputStream(this.socket.getOutputStream());
			input = new ObjectInputStream(this.socket.getInputStream());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// salida = new FlujoDeSalida(this.socket);
		// entrada = new FlujoDeEntrada(this.socket);

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

			try {
				corriendo = false;
				mensaje = (Mensaje) input.readObject();
				persona = (Persona) mensaje.getDatos();

				if (Gui_Registro.verificarEmail(persona.getEmail()) == true) {
					if (resultado = validarUsuario(persona) == true) {
						persona.setNick(lista_de_cosas.get(0)[2].toString());
						output.writeObject(new Mensaje(persona));
					} else
						output.writeObject(null);
				}

			} catch (ClassNotFoundException | IOException e) {

				e.printStackTrace();

			}

		}
	}

}