package Stream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import Mensajes.Mensaje;
import Servidor.ControladorServidor;

public class FlujoDeEntrada implements Runnable {

	Socket socket;
	Mensaje mensaje;
	ObjectInputStream entrada;
	ControladorServidor controlador;
	
	public FlujoDeEntrada(Socket socket) throws IOException {
		this.socket = socket;
		entrada = new ObjectInputStream(this.socket.getInputStream());
	}

	public  Mensaje recibirMensaje() throws ClassNotFoundException, IOException {
		return (Mensaje) entrada.readObject();
	}

	@Override
	public void run() {
		
		
		
		while (true) {
			try {
				mensaje =  recibirMensaje();
				controlador =  (ControladorServidor) mensaje.getCodigo();
				controlador.tratarPeticion(mensaje);
			} catch (Exception e) {
				
			}
		}

	}

}
