package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cliente.Cliente;
import Cliente.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Gui_Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3;
	private JButton registrarse;
	private Persona persona;
	private List<Object[]> lista_de_cosas;

	public Gui_Registro() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		lblNewLabel = new JLabel("email");
		lblNewLabel.setBounds(41, 55, 46, 14);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("contrase\u00F1a");
		lblNewLabel_1.setBounds(41, 113, 69, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("nick");
		lblNewLabel_2.setBounds(41, 170, 46, 14);
		contentPane.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(144, 52, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(144, 110, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(144, 167, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		lblNewLabel_3 = new JLabel("Registro");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(144, 11, 69, 30);
		contentPane.add(lblNewLabel_3);

		registrarse = new JButton("Registrarse");
		registrarse.setBounds(301, 207, 105, 30);
		contentPane.add(registrarse);

		

		/*registrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				persona = new Persona(textField.getText().trim(), textField_1.getText().trim(),
						textField_2.getText().trim());

				String consulta = "select p.email,p.nick from Persona p ";
				consulta += "where p.email=" + "'" + persona.getEmail() + "'" + "and p.nick=" + "'" + persona.getNick()
						+ "'";

			//	lista_de_cosas = Consulta.consultar(consulta);

				if (verificarEmail(persona.getEmail()) == true) {

					if (persona.getEmail().equals("") || persona.getContraseña().equals("")
							|| persona.getNick().equals(""))
						JOptionPane.showMessageDialog(null, "llene todo los campos", "campos vacios",
								JOptionPane.WARNING_MESSAGE);
					if (lista_de_cosas.size() != 0) {
						JOptionPane.showMessageDialog(null, "usuario ya existente", "usuario existente",
									JOptionPane.ERROR_MESSAGE);
					} else {
						if (Consulta.insertar(persona) == true) {
							//Login login = new Login();
							setVisible(false);
						} else
							JOptionPane.showMessageDialog(null, "este email ya se ha registrado",
									"usuario ya registrado", JOptionPane.ERROR_MESSAGE);

					}
				} else
					JOptionPane.showMessageDialog(null, "el email ingresado no es valido. ingrese su email nuevamente",
							"email erroneo", JOptionPane.ERROR_MESSAGE);

			}
		});
*/
		setVisible(true);
	}

	

	public static void main(String[] args) {

		Gui_Registro frame = new Gui_Registro();

	}
}
