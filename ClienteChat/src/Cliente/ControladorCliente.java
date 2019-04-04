package Cliente;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import Gui.Gui_Lobby;
import Gui.Gui_Sala;
import Mensajes.Mensaje;
import Operacion.InterfazPeticion;
import Sala.Sala;
import Stream.FlujoDeEntrada;
import Stream.FlujoDeSalida;

public class ControladorCliente implements Serializable, Runnable {

	private static ArrayList<Sala> backupSalas = new ArrayList<Sala>();
	private static ArrayList<String> backupClientesLobby = new ArrayList<String>();
	private static Gui_Lobby guiLobby;
	private static FlujoDeEntrada entrada;
	private static FlujoDeSalida salida;
	private boolean corriendo = true;
	private InterfazPeticion peticion;

	public ControladorCliente(Gui_Lobby guiLobby, FlujoDeEntrada entrada,FlujoDeSalida salida) {

		this.guiLobby = guiLobby;
		this.entrada = entrada;
		this.salida = salida;

	}

	public synchronized static ArrayList<Sala> getBackupSalas() {
		return backupSalas;
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

	public synchronized static Gui_Lobby getGuiLobby() {
		return guiLobby;
	}
	
	

	public synchronized static FlujoDeEntrada getEntrada() {
		return entrada;
	}

	public synchronized static FlujoDeSalida getSalida() {
		return salida;
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
