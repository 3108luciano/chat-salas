package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Cliente.ControladorCliente;
import Cliente.HiloLogin;
import Cliente.HiloOutputSala;
import Gui.Gui_Sala;
import Mensajes.Mensaje;
import Sala.Sala;

public class UnirseSala implements InterfazPeticion {

	private static final long serialVersionUID = 2948832563874494113L;
	private ArrayList<Sala> backupSalas;
	private ArrayList<Cliente> backupClientes;
	private Cliente cliente;
	private Sala sala;

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		backupSalas = ControladorCliente.getBackupSalas();

		for (Sala s : backupSalas) {
			if (s.getNroSala() == mensaje.getNroSala()) {
				s.meterClienteEnSala((String) mensaje.getDatos());
				sala = s;
			}
		}

		Gui_Sala gui_sala = new Gui_Sala();
		gui_sala.actualizarListClientes(mensaje.getCadena2());
		gui_sala.setSala(sala);
		gui_sala.setNroSala(sala.getNroSala());
		gui_sala.setNombreSala(sala.getNombre());

		HiloOutputSala hilosala = new HiloOutputSala(gui_sala, sala);
		Thread hilo = new Thread(hilosala);
		hilo.start();

		sala.setHilosala(hilosala);

	}

}
