package Gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BD.Persona;
import Cliente.HiloReconexion;
import Mensajes.Comandos;
import Mensajes.Mensaje;
import Servidor.HiloServidor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_Login extends JFrame implements Serializable {

	private JTextField textfieldEmail, textfieldContrase�a;
	private JLabel label1, label2;
	private JButton boton1;
	private String email;
	private String contrase�a;
	private ObjectOutputStream salida;
	private Persona persona;
	private  boolean flagBotonLogin;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Login panelLoguin = new Gui_Login();
					panelLoguin.setVisible(true);
					crearHiloReconexion(panelLoguin);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

	}

	private static void crearHiloReconexion(Gui_Login panelLoguin) {
		HiloReconexion hr = new HiloReconexion(panelLoguin);
		Thread hilo = new Thread(hr);
		hilo.start();

	}

	public Gui_Login() {

		this.setTitle("Login");

		setLayout(null);

		flagBotonLogin = new Boolean(false);

		textfieldEmail = new JTextField();
		textfieldContrase�a = new JPasswordField();

		label1 = new JLabel("Correo electronico");
		label2 = new JLabel("Contrase�a");

		label1.setBounds(50, 50, 120, 30);
		label2.setBounds(210, 50, 120, 30);

		textfieldEmail.setBounds(50, 80, 120, 25);
		textfieldContrase�a.setBounds(200, 80, 120, 25);

		boton1 = new JButton("Iniciar sesion");
		boton1.setBounds(350, 75, 120, 30);

		boton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (getTextfieldEmail().equals("") || getTextfieldContrase�a().equals("")) {
					JOptionPane.showMessageDialog(null, "llene todo los campos", "campos vacios",
							JOptionPane.WARNING_MESSAGE);
				} else {
					persona = new Persona(getTextfieldEmail(), getTextfieldContrase�a());
					flagBotonLogin=true;

				}

			}
		});

		setBounds(0, 0, 500, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		add(label1);
		add(label2);
		add(textfieldEmail);
		add(textfieldContrase�a);
		add(boton1);

	}

	public JButton getBoton1() {
		return boton1;
	}

	public String getTextfieldEmail() {
		return textfieldEmail.getText();
	}

	public String getTextfieldContrase�a() {
		return textfieldContrase�a.getText();
	}

	public String getEmail() {
		return email;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public  boolean isFlagBotonLogin() {
		return flagBotonLogin;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setFlagBotonLogin(boolean flagBotonLogin) {
		this.flagBotonLogin = flagBotonLogin;
	}

}