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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import Cliente.Cliente;
import Cliente.HiloReconexion;
import Cliente.Persona;
import Mensajes.Comandos;
import Mensajes.Mensaje;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Gui_Login extends JFrame implements Serializable {

	private JTextField textfieldEmail, textfieldContrase�a;
	private JLabel label1, label2;
	private JButton boton1;
	private String email;
	private String contrase�a;
	private ObjectOutputStream salida;
	private Persona persona;
	private boolean flagBotonLogin;
	private JLabel abrirRegistro;

	public static void main(String[] args) {

		System.setProperty("sun.io.serialization.extendedDebugInfo", "true");
		// toma el aspecto del sistema
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {

			e.printStackTrace();
		}

		Gui_Login panelLoguin = new Gui_Login();
		panelLoguin.setVisible(true);
		crearHiloReconexion(panelLoguin);

	}

	private static void crearHiloReconexion(Gui_Login panelLoguin) {
		HiloReconexion hr = new HiloReconexion(panelLoguin);
		Thread hilo = new Thread(hr);
		hilo.start();

	}

	public Gui_Login() {

		this.setTitle("Login");

		getContentPane().setLayout(null);

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
					flagBotonLogin = true;

				}

			}
		});

		setBounds(0, 0, 500, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		getContentPane().add(label1);
		getContentPane().add(label2);
		getContentPane().add(textfieldEmail);
		getContentPane().add(textfieldContrase�a);
		getContentPane().add(boton1);

		abrirRegistro = new JLabel("Registrarse");
		abrirRegistro.setBounds(350, 132, 70, 25);
		abrirRegistro.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Gui_Registro registro = new Gui_Registro();
					setVisible(false);
					dispose();
				}
			}
		});
		getContentPane().add(abrirRegistro);

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

	public synchronized boolean isFlagBotonLogin() {
		return flagBotonLogin;
	}

	public synchronized Persona getPersona() {
		return persona;
	}

	public void setFlagBotonLogin(boolean flagBotonLogin) {
		this.flagBotonLogin = flagBotonLogin;
	}
}
