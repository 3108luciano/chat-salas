package Cliente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Gui.Gui_Login;
import Mensajes.Comandos;
import Mensajes.Mensaje;

public class HiloLogin implements Runnable {

	private Socket socket;
	private Gui_Login panel;
	private boolean corriendo = true;
	private ObjectOutputStream salida;

	public HiloLogin(Socket socket, Gui_Login panel) {
		this.socket = socket;
		this.panel = panel;

		try {
			salida = new ObjectOutputStream(this.socket.getOutputStream());
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
					corriendo = false;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

}
