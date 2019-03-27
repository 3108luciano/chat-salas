package Cliente;

import Gui.Gui_Sala;
import Sala.Sala;

public class HiloOutputSala implements Runnable {

	private Gui_Sala gui_sala;
	private Sala salaNueva;

	public HiloOutputSala(Gui_Sala gui_sala, Sala salaNueva) {
		this.gui_sala = gui_sala;
		this.salaNueva = salaNueva;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
