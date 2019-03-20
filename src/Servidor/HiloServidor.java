package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
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
	private PanelServidor panel;
	// private FlujoDeEntrada entrada;
	// private FlujoDeSalida salida;
	private int idCliente;
	private Socket socketReenvio;
	private LinkedList<HiloServidor> Clientes;
	private List<Object[]> lista_de_cosas;
	private Persona persona;
	private ObjectInputStream input;
	private Mensaje mensaje;
	private boolean corriendo = true;

	public HiloServidor(Socket socket) {

		this.socket = socket;

		try {
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
			JOptionPane.showMessageDialog(null,
					"el usuario o contraseña ingresado es erroneo. vuelva a ingresarlo correctamente", "datos erroneos",
					JOptionPane.ERROR_MESSAGE);
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
					if (validarUsuario(persona) == true) {
						persona.setNick(lista_de_cosas.get(0)[2].toString());
						System.out.println("inicio de sesion exitoso. " + persona.getNick() + " ha iniciado sesion.");
						
					}
				}

			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
	}

}