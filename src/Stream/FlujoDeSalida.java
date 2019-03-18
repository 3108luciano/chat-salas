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

	public  void enviarMensaje(Mensaje mensaje) throws IOException {
		salida.writeObject(mensaje);
	}

	@Override
	public void run() {

		while (true) {

			try {
				enviarMensaje(mensaje);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
