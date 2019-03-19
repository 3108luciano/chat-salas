package Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JPanel;

import BD.Persona;
import Mensajes.Mensaje;


public class HiloCliente implements Runnable {

	//private FlujoDeEntrada entrada;
	//private FlujoDeSalida salida;
	private Socket socket;
	private Persona persona;
	private PanelCliente panel;
	private ObjectOutputStream output;
	
	public HiloCliente(Socket socket, PanelCliente panel) {
		this.socket = socket;
		this.panel = panel;
		
		
	
	}

	@Override
	public void run() {

		
	}

}
