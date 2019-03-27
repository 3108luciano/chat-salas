package Stream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Mensajes.Mensaje;

public class FlujoDeSalida implements Runnable {

	Socket socket;
	ObjectOutputStream salida;
	Mensaje mensaje;

	public FlujoDeSalida(Socket socket) throws IOException {
		this.socket = socket;
		salida = new ObjectOutputStream(socket.getOutputStream());
	}

	public  synchronized void enviarMensaje(Mensaje mensaje) {
		try {
			salida.writeObject(mensaje);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		while (true) {

			enviarMensaje(mensaje);
		}

	}

}
