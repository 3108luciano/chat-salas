package BD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.swing.*;

import Cliente.HiloCliente;
import Mensajes.Mensaje;

import java.awt.*;

public class Login extends JFrame {

	private JTextField textfieldEmail, textfieldContraseña;
	private JLabel label1, label2;
	private JButton boton1;
	private Persona persona;
	private Socket socket;
	
	public Login(Socket socket) {
		
		this.setTitle("Login");
		
		setLayout(null);

		this.socket=socket;
		
		textfieldEmail = new JTextField();
		textfieldContraseña = new JPasswordField();

		label1 = new JLabel("Correo electronico");
		label2 = new JLabel("Contraseña");

		label1.setBounds(50, 50, 120, 30);
		label2.setBounds(210, 50, 120, 30);

		textfieldEmail.setBounds(50, 80, 120, 25);
		textfieldContraseña.setBounds(200, 80, 120, 25);

		boton1 = new JButton("Iniciar sesion");
		boton1.setBounds(350, 75, 120, 30);
		
		boton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				persona = new Persona(getTextfieldEmail(), getTextfieldContraseña());
				HiloCliente cliente = new HiloCliente(Login.this.socket,persona);
				Thread hilo = new Thread(cliente);
				hilo.start();
			}
		});
		
		setBounds(0, 0, 500, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		
		
		
		add(label1);
		add(label2);
		add(textfieldEmail);
		add(textfieldContraseña);
		add(boton1);
		setVisible(true);
		
	}

	public JButton getBoton1() {
		return boton1;
	}

	public String getTextfieldEmail() {
		return textfieldEmail.getText();
	}

	public String getTextfieldContraseña() {
		return textfieldContraseña.getText();
	}

}
