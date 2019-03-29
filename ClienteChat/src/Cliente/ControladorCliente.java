package Cliente;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import Gui.Gui_Lobby;
import Mensajes.Mensaje;
import Operacion.InterfazPeticion;
import Sala.Sala;
import Stream.FlujoDeEntrada;

public class ControladorCliente implements Serializable, Runnable {

	private static ArrayList<Sala> backupSalas;
	private static ArrayList<String> backupClientesLobby;
	private Gui_Lobby guiLobby;
	private FlujoDeEntrada entrada;
	private boolean corriendo = true;
	private InterfazPeticion peticion;

	public ControladorCliente(Gui_Lobby guiLobby, FlujoDeEntrada entrada) {

		this.guiLobby = guiLobby;
		this.entrada = entrada;
		backupSalas = new ArrayList<Sala>();
		backupClientesLobby = new ArrayList<String>();
	}

	public static synchronized ArrayList<Sala> getBackupSalas() {
		return backupSalas;
	}
	

	public static synchronized ArrayList<String> getBackupClientesLobby() {
		return backupClientesLobby;
	}

	public synchronized void manejarMensaje(Mensaje mensaje) {
		peticion = (InterfazPeticion) mensaje.getCodigo();
		peticion.tratarPeticion(mensaje);
	}

	@Override
	public void run() {

		while (corriendo) {

			try {
				Mensaje mensaje = (Mensaje) entrada.recibirMensaje();

				if (mensaje != null) {
					System.out.println("peticion recibida");
					manejarMensaje(mensaje);
				} 
			} catch (ClassNotFoundException | IOException e) {
				corriendo = false;
				e.printStackTrace();
			}
		}

	}

}
