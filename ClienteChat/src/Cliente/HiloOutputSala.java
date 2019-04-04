package Cliente;

import Gui.Gui_Sala;
import Mensajes.Comandos;
import Mensajes.Mensaje;
import Sala.Sala;
import Stream.FlujoDeSalida;

public class HiloOutputSala implements Runnable {

	private Gui_Sala gui_sala;
	private Sala salaNueva;
	private boolean corriendo=true;
	private String texto;
	private FlujoDeSalida salida;

	public HiloOutputSala(Gui_Sala gui_sala, Sala salaNueva) {

		this.gui_sala = gui_sala;
		this.salaNueva = salaNueva;
		salida = ControladorCliente.getSalida();
	}

	@Override
	public void run() {

		while (corriendo) {

			if(gui_sala.isEnviado() && !gui_sala.getTextMensaje().equals("")) {
				texto = gui_sala.getTextMensaje().getText();
				salida.enviarMensaje(new Mensaje(Comandos.MENSAJESALA,salaNueva.getNroSala(),texto,Cliente.getNick()));
				gui_sala.setTextMensaje("");
			}
			
			
		}

	}

}
