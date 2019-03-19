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
import Mensajes.Mensaje;

import java.awt.*;

public class Cliente extends JFrame {

	private JTextField textfieldEmail, textfieldContraseña;
	private JLabel label1, label2;
	private JButton boton1;
	private Persona persona;
	private Socket socket;
	private PanelCliente panel;
	public Cliente(int puerto) {
	

		

			try {
				socket = new Socket("192.168.0.219", puerto);// va la ip del servidor
				panel  = new PanelCliente(socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//
			HiloCliente cliente = new HiloCliente(socket, panel); // me pongo a la escucha de lo que viene por el
																	// servidor
			Thread hilo = new Thread(cliente);
			hilo.start();

		
		

	}

	public static void main(String[] args) {
		Cliente cliente = new Cliente(10000);
	}

}
