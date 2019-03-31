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
		backupsalas = HiloLogin.getControlador().getBackupSalas();

		if (mensaje.getCadena2().equals(Cliente.getNick())) {

			Gui_Sala gui_sala = new Gui_Sala();
			gui_sala.setNombreSala(mensaje.getCadena());
			gui_sala.setNroSala(mensaje.getNroSala());

			salaNueva = new Sala(mensaje.getNroSala(), mensaje.getCadena(), gui_sala);
			gui_sala.setSala(salaNueva);

			HiloOutputSala hilosalida = new HiloOutputSala(gui_sala, salaNueva);
			salaNueva.setHilosala(hilosalida);
			Thread hilo = new Thread(hilosalida);
			hilo.start();

			gui_sala.actualizarListClientes(mensaje.getCadena2());

			System.out.println("N° SALA : " + salaNueva.getNroSala() + " NOMBRE: " + salaNueva.getNombre()
					+ " ha sido creada exitosamente");

		} else {

			salaNueva = new Sala(mensaje.getNroSala(), mensaje.getCadena());

		}
		salaNueva.meterClienteEnSala(mensaje.getCadena2());
		backupsalas.add(salaNueva);
		HiloLogin.getGui_lobby().agregarSala(mensaje.getCadena());
		
		ControladorCliente.setBackupSalas(backupsalas);

	}

}
