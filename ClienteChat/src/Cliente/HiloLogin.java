package Cliente;

import java.io.IOException;

import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Gui.Gui_Lobby;
import Gui.Gui_Login;
import Mensajes.Comandos;
import Mensajes.Mensaje;
import Sala.Sala;
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
	private Cliente cliente;
	private Gui_Lobby gui_lobby;
	private ControladorCliente controlador;
	private ArrayList<Sala> salas;

	public HiloLogin(Socket socket, Gui_Login panel) {
		this.socket = socket;
		this.panel = panel;

		try {
			salida = new FlujoDeSalida(this.socket);
			entrada = new FlujoDeEntrada(this.socket);
			salas = new ArrayList<Sala>();
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
					corriendo = false;

					if (resultado != null) {

						cliente = new Cliente(persona.getNick());
						System.out.println("el usuario: " + persona.getNick() + " ha iniciado sesion.");
						panel.setVisible(false);

						gui_lobby = new Gui_Lobby(salida, persona);
						controlador = new ControladorCliente(gui_lobby, entrada);
						salas = ControladorCliente.getBackupSalas();

						Thread hiloe = new Thread(controlador); // recibe y envia peticiones sobre salas en el lobby
						hiloe.start();

					} else {
						corriendo = true;
						panel.setFlagBotonLogin(true);
						JOptionPane.showMessageDialog(null,
								"el usuario o contraseña ingresado es erroneo. vuelva a ingresarlo correctamente",
								"datos erroneos", JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException | ClassNotFoundException e) {

					e.printStackTrace();
				}

			}

		}

	}

}
