package Cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.swing.*;

import BD.Persona;
import Gui.Gui_Login;
import Mensajes.Comandos;
import Mensajes.Mensaje;
import Stream.FlujoDeEntrada;
import Stream.FlujoDeSalida;

import java.awt.*;

public class Cliente extends JFrame {

	private String nick;
	private FlujoDeEntrada entrada;
	private FlujoDeSalida salida;

	public Cliente(String nick, FlujoDeEntrada entrada, FlujoDeSalida salida) {
		this.nick = nick;
		this.salida = salida;
		this.entrada = entrada;
	}
	
	public void iniciarEscuchar() {
		Thread hilo = new Thread(entrada);
		hilo.start();
	}
	
	public void iniciarRespuesta() {
		Thread hilo = new Thread(salida);
		hilo.start();
	}

}
