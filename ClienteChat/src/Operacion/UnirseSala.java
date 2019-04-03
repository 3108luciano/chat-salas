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
	private String nick;

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		backupSalas = ControladorCliente.getBackupSalas();
		nick = mensaje.getCadena2();

		System.out.println(nick);
		
		Gui_Sala gui_sala = ControladorCliente.getBackupSalas().get(mensaje.getNroSala()).getGui_sala();
		for (Sala s : backupSalas) {
			if (s.getNroSala() == mensaje.getNroSala()) {

				s.meterClienteEnSala(nick);
				ControladorCliente.getBackupSalas().get(s.getNroSala()).meterClienteEnSala(nick);

				if (!Cliente.getNick().equals(s.getClienteCreador()) && gui_sala  == null) {
					gui_sala = new Gui_Sala();
					gui_sala.setSala(s);
					gui_sala.setNroSala(s.getNroSala());
					gui_sala.setNombreSala(s.getNombre());
					gui_sala.agregarClienteSala(nick);

					ControladorCliente.getBackupSalas().get(mensaje.getNroSala()).setGui_sala(gui_sala);
					HiloOutputSala hilosala = new HiloOutputSala(gui_sala, s);
					Thread hilo = new Thread(hilosala);
					hilo.start();

					s.setHilosala(hilosala);

				} else {
					System.out.println(nick);
					ControladorCliente.getBackupSalas().get(mensaje.getNroSala()).getGui_sala().agregarClienteSala(nick);
				}
			}

		}
	}

}
