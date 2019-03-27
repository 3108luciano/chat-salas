package Operacion;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Cliente.Cliente;
import Cliente.ControladorCliente;
import Cliente.HiloLogin;
import Cliente.HiloOutputSala;
import Gui.Gui_Lobby;
import Gui.Gui_Sala;
import Mensajes.Mensaje;
import Sala.Sala;

public class CrearSala implements InterfazPeticion {

	private static final long serialVersionUID = 2938832563874494113L;
	private ArrayList<String> clientesEnLobby;
	private ArrayList<Sala> backupsalas;
	private ControladorCliente controlador;
	private Gui_Lobby gui_lobby;

	public CrearSala() {
	}

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		Sala salaNueva;
		gui_lobby = HiloLogin.getGui_lobby();

		if (mensaje.getCadena2().equals(Cliente.getNick())) {

			DefaultListModel<String> modeloClientes = (DefaultListModel<String>) gui_lobby.getListaClientesConectados()
					.getModel();

			Gui_Sala gui_sala = new Gui_Sala(modeloClientes);
			gui_sala.setNombreSala(mensaje.getCadena());
			gui_sala.setNroSala(mensaje.getCodigoSala());

			salaNueva = new Sala(mensaje.getCodigoSala(), mensaje.getCadena(), gui_sala);
			salaNueva.meterClienteEnSala(mensaje.getCadena2());

			HiloOutputSala hilosalida = new HiloOutputSala(gui_sala, salaNueva);

			Thread hilo = new Thread(hilosalida);
			hilo.start();
			
			backupsalas.add(salaNueva);

		}

	}

}
