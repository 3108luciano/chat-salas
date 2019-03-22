package Cliente;

import java.io.IOException;

import java.net.Socket;

import javax.swing.JOptionPane;


import Gui.Gui_Login;
import Mensajes.Comandos;
import Mensajes.Mensaje;
import Sala.GuiLobby;
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
						
						GuiLobby guiLobby = new GuiLobby(salida,persona);
						HiloLobbyEntrada hilolobbyentrada = new HiloLobbyEntrada(guiLobby,entrada);
						
						Sala lobby = new Sala(-1,"Lobby",1);
						
						Thread hiloe = new Thread(hilolobbyentrada); //recibe y envia peticiones sobre salas en el lobby
						hiloe.start();
						
						HiloLobbySalida hilolobbysalida = new HiloLobbySalida();
						Thread hilos= new Thread(hilolobbysalida);
						hilos.start();
						
					} else {
						corriendo = false;
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
