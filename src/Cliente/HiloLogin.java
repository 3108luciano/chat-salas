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

public class HiloLogin implements Runnable {

	private Socket socket;
	private Gui_Login panel;
	private boolean corriendo = true;
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private Mensaje resultado;
	private Persona persona;

	public HiloLogin(Socket socket, Gui_Login panel) {
		this.socket = socket;
		this.panel = panel;

		try {
			salida = new ObjectOutputStream(this.socket.getOutputStream());
			entrada = new ObjectInputStream(this.socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		while (corriendo) {

			if (panel.isFlagBotonLogin()) {

				panel.setFlagBotonLogin(false);
				try {

					salida.writeObject(new Mensaje(Comandos.LOGIN, panel.getPersona()));

					resultado = (Mensaje) entrada.readObject();
					persona = (Persona) resultado.getDatos();

					if (resultado != null) {
						System.out.println("el usuario: " + persona.getNick() + " ha iniciado sesion.");
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
