package Cliente;

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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCliente extends JFrame implements Serializable {
	
	private JTextField textfieldEmail, textfieldContraseña;
	private JLabel label1, label2;
	private JButton boton1;
	private String email;
	private String contraseña;
	private ObjectOutputStream salida;
	private Socket socket;
	private Persona persona;
	
	public PanelCliente(Socket socket) {

		this.setTitle("Login");

		setLayout(null);	
		
		try {
			salida = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
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

				if (getTextfieldEmail().equals("") || getTextfieldContraseña().equals(""))
					JOptionPane.showMessageDialog(null, "llene todo los campos", "campos vacios",
							JOptionPane.WARNING_MESSAGE);
				
				else {
					persona = new Persona(getTextfieldEmail(), getTextfieldContraseña());
					try {
						salida.writeObject(persona);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					
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

	public String getEmail() {
		return email;
	}

	public String getContraseña() {
		return contraseña;
	}

	

}
