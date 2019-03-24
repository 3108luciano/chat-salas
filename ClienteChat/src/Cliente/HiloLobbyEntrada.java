package Cliente;

import java.io.IOException;
import java.util.ArrayList;

import Gui.Gui_Lobby;
import Mensajes.Mensaje;

import Sala.Sala;
import Stream.FlujoDeEntrada;

public class HiloLobbyEntrada implements Runnable {

	private Gui_Lobby guiLobby;
	private FlujoDeEntrada entrada;
	private ArrayList<String> backupClientesLobby;
	private ArrayList<Sala> backupSalasLobby;
	private boolean corriendo = true;

	public HiloLobbyEntrada(Gui_Lobby guiLobby, FlujoDeEntrada entrada) {
		this.guiLobby = guiLobby;
		this.entrada = entrada;

		backupClientesLobby = new ArrayList<>();
		backupSalasLobby = new ArrayList<>();
	}

	@Override
	public void run() {

		while (corriendo) {

			try {
				Mensaje mensaje = (Mensaje) entrada.recibirMensaje();

				if (mensaje != null) {
					System.out.println("peticion recibida");
				} else {
					corriendo = false;
				}
			} catch (ClassNotFoundException | IOException e) {
				corriendo=false;
				e.printStackTrace();
			}
		}

	}

}
