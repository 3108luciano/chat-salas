package Stream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import Mensajes.Mensaje;
import Operacion.CrearSala;
import Operacion.InterfazPeticion;
import Servidor.ControladorServidor;

public class FlujoDeEntrada implements Runnable {

	Socket socket;
	Mensaje mensaje;
	ObjectInputStream entrada;

	public FlujoDeEntrada(Socket socket) throws IOException {
		this.socket = socket;
		entrada = new ObjectInputStream(this.socket.getInputStream());
	}

	public Mensaje recibirMensaje() throws ClassNotFoundException, IOException {
		return (Mensaje) entrada.readObject();
	}

	@Override
	public void run() {

		ControladorServidor controlador = new ControladorServidor();

		while (true) {

			try {
				mensaje = recibirMensaje();
				controlador.manejarMensaje(mensaje);

			} catch (ClassNotFoundException | IOException e) {

				e.printStackTrace();
			}
		}

	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	

}
