package Cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import BD.Persona;
import Gui.Gui_Login;
import Mensajes.Comandos;
import Mensajes.Mensaje;
import Sala.Lobby;
import Stream.FlujoDeEntrada;
import Stream.FlujoDeSalida;

public class HiloLogin implements Runnable {

	private Socket socket;
	private Gui_Login panel;
	private boolean corriendo = true;
	private Mensaje resultado;
	private Persona persona;
	private FlujoDeEntrada entrada;
	private FlujoDeSalida salida;

	public HiloLogin(Socket socket, Gui_Login panel) {
		this.socket = socket;
		this.panel = panel;

		try {
			salida = new FlujoDeSalida(this.socket);
			entrada = new FlujoDeEntrada(this.socket);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		while (corriendo) {

			if (panel.isFlagBotonLogin()) {

				panel.setFlagBotonLogin(false);
				try {

					salida.enviarMensaje(new Mensaje(Comandos.LOGIN, panel.getPersona()));
					resultado = (Mensaje) entrada.recibirMensaje();

					persona = (Persona) resultado.getDatos();

					if (resultado != null) {
						System.out.println("el usuario: " + persona.getNick() + " ha iniciado sesion.");
						panel.setVisible(false);
						
						Lobby lobby = new Lobby(salida,persona);
						
					} else {
						corriendo = false;
						panel.setFlagBotonLogin(true);
						JOptionPane.showMessageDialog(null,
								"el usuario o contrase�a ingresado es erroneo. vuelva a ingresarlo correctamente",
								"datos erroneos", JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException | ClassNotFoundException e) {

					e.printStackTrace();
				}

			}

		}

	}

}
