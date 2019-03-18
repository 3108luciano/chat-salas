package BD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

	private JTextField textField1, textField2;
	private JLabel label1, label2;
	private JButton boton1;
	private Persona persona;
	private List<Object[]> lista_de_cosas;

	public Login() {

		this.setTitle("Login");

		setLayout(null);

		textField1 = new JTextField();
		textField2 = new JPasswordField();

		label1 = new JLabel("Correo electronico");
		label2 = new JLabel("Contraseña");

		label1.setBounds(50, 50, 120, 30);
		label2.setBounds(210, 50, 120, 30);

		textField1.setBounds(50, 80, 120, 25);
		textField2.setBounds(200, 80, 120, 25);

		boton1 = new JButton("Iniciar sesion");
		boton1.setBounds(350, 75, 120, 30);

		/*boton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				persona = new Persona(textField1.getText(), textField2.getText());

				String consulta = "select p.email,p.contraseña,p.nick from Persona p ";
				consulta += "where p.email=" + "'" + persona.getEmail() + "'" + " and p.contraseña=" + "'"
						+ persona.getContraseña() + "'";	

				lista_de_cosas = Consulta.consultar(consulta);

				if (Registro.verificarEmail(persona.getEmail()) == true) {

					if (!lista_de_cosas.get(0)[0].equals(persona.getEmail())
							&& !lista_de_cosas.get(0)[1].equals(persona.getContraseña()))
						JOptionPane.showMessageDialog(null,
								"el usuario o contraseña ingresado es erroneo. vuelva a ingresarlo correctamente",
								"datos erroneos", JOptionPane.ERROR_MESSAGE);
					else {
						if (persona.getEmail().equals("") || persona.getContraseña().equals(""))
							JOptionPane.showMessageDialog(null, "llene todo los campos", "campos vacios",
									JOptionPane.WARNING_MESSAGE);
						else
							System.out.println("logueo exitoso");
					}
				}

			}
		});
*/
		setBounds(0, 0, 500, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		add(label1);
		add(label2);
		add(textField1);
		add(textField2);
		add(boton1);
		setVisible(true);
	}

	public JButton getBoton1() {
		return boton1;
	}

	public Persona getPersona() {
		return persona;
	}

}
