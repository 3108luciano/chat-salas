package Cliente;

import java.io.IOException;
import java.util.ArrayList;

import Mensajes.Mensaje;
import Sala.GuiLobby;
import Sala.Sala;
import Stream.FlujoDeEntrada;

public class HiloLobbyEntrada implements Runnable {

	private GuiLobby guiLobby;
	private FlujoDeEntrada entrada;
	private ArrayList<String> backupClientesLobby;
	private ArrayList<Sala> backupSalasLobby;
	private boolean corriendo = true;

	public HiloLobbyEntrada(GuiLobby guiLobby, FlujoDeEntrada entrada) {
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
