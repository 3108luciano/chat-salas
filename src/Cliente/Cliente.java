package Cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.Login;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Cliente extends JFrame {

	private Socket socket;
	private PanelCliente panel;

	public Cliente(int puerto) {
		
		
		
		

		try {
			//panel = new PanelCliente(); 
			
			socket = new Socket("192.168.0.219", puerto);// va la ip del servidor
			Login inicioSesion  = new Login(socket);
			//HiloCliente cliente = new HiloCliente(socket, inicioSesion); // me pongo a la escucha de lo que viene por el servidor
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {

		Cliente frame = new Cliente(10000);

	}
}
