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

	private static ArrayList<Sala> backupSalas=new ArrayList<Sala>();
	private static ArrayList<String> backupClientesLobby = new ArrayList<String>();
	private static Gui_Lobby guiLobby;
	private FlujoDeEntrada entrada;
	private boolean corriendo = true;
	private InterfazPeticion peticion;

	public ControladorCliente(Gui_Lobby guiLobby, FlujoDeEntrada entrada) {

		this.guiLobby = guiLobby;
		this.entrada = entrada;

	}

	public synchronized static ArrayList<Sala> getBackupSalas() {
		return backupSalas;
	}

	public synchronized static void setBackupSalas(ArrayList<Sala> backupSalas) {
		ControladorCliente.backupSalas = backupSalas;
	}

	public static synchronized void agregarSala(Sala sala) {
		if (!backupSalas.contains(sala))
			backupSalas.add(sala);
	}

	public static synchronized void agregarClienteLobby(String cliente) {
		if (!backupClientesLobby.contains(cliente))
			ControladorCliente.backupClientesLobby.add(cliente);
	}

	public static synchronized ArrayList<String> getBackupClientesLobby() {
		return backupClientesLobby;
	}

	public synchronized void manejarMensaje(Mensaje mensaje) {
		peticion = (InterfazPeticion) mensaje.getCodigo();
		peticion.tratarPeticion(mensaje);
	}

	
	
	public  synchronized static Gui_Lobby getGuiLobby() {
		return guiLobby;
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
