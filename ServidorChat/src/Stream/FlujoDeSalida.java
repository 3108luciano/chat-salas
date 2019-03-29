package Stream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Mensajes.Mensaje;

public class FlujoDeSalida implements Runnable {

	Socket socket;
	ObjectOutputStream salida;
	Mensaje mensaje;
	List<Mensaje> lista = new ArrayList<Mensaje>();

	public FlujoDeSalida(Socket socket) throws IOException {
		this.socket = socket;
		salida = new ObjectOutputStream(socket.getOutputStream());
	}

	public synchronized Mensaje siguienteMensaje() throws InterruptedException {
		while (lista.isEmpty())
			wait();

		Mensaje mensaje = lista.get(0);
		lista.remove(0);
		return mensaje;
	}

	public synchronized void enviarMensaje(Mensaje mensaje) {
		lista.add(mensaje);
		notify();
	}

	public synchronized void enviarMensajeCliente(Mensaje mensaje) {
		
		try {
			salida.writeObject(mensaje);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		while (true) {
			Mensaje mensaje;
			try {
				mensaje = siguienteMensaje();
				enviarMensajeCliente(mensaje);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
