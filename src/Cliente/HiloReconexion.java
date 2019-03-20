package Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JPanel;

import BD.Persona;
import Gui.Gui_Login;
import Mensajes.Comandos;
import Mensajes.Mensaje;

public class HiloReconexion implements Runnable {

	// private FlujoDeEntrada entrada;
	// private FlujoDeSalida salida;
	private Socket socket;
	private Persona persona;
	private Gui_Login panel;
	private ObjectOutputStream output;
	private boolean activado = true;

	public HiloReconexion(Gui_Login panel) {
		super();
		this.panel = panel;

	}

	@Override
	public void run() {

		Socket socketNuevo = null;

		while (activado) {

			try {
				socketNuevo = new Socket(Comandos.IP, Comandos.PUERTO);

				if (socketNuevo != null && socketNuevo.isConnected()) {
					activado = false; // lo pongo en falso para que no siga intentando establecer una conexion
					this.socket=socketNuevo;
					HiloLogin login = new HiloLogin(socket,panel);
					
					Thread hilo = new Thread(login);
					hilo.start();
				} else {
					Thread.sleep(2000);// cada 2 segundos intento conectarme nuevamente
				}
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
