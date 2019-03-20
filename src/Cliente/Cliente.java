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

import java.awt.*;

public class Cliente extends JFrame {

	private JTextField textfieldEmail, textfieldContraseña;
	private JLabel label1, label2;
	private JButton boton1;
	private Persona persona;
	private Socket socket;
	private Gui_Login panel;
	private HiloReconexion cliente;
	private Thread hilo;

	public Cliente() {

		try {
			socket = new Socket(Comandos.IP, Comandos.PUERTO);// va la ip del servidor
		//	panel = new Gui_Login(socket);

			//cliente = new HiloReconexion(socket, panel); // me pongo a la escucha de lo que viene por el servidor
			//hilo = new Thread(cliente);
			//hilo.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //

	}

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
	}

}
