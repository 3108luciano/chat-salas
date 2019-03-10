package BD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel, lblContrasea;
	private JButton btnIniciarSesion;

	public PanelLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		lblNewLabel = new JLabel("Correo Electronico");
		lblNewLabel.setBounds(32, 42, 101, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(127, 39, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(235, 42, 63, 14);
		contentPane.add(lblContrasea);

		textField_1 = new JTextField();
		textField_1.setBounds(308, 39, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBounds(173, 80, 110, 23);
		contentPane.add(btnIniciarSesion);
	}

	public static void main(String[] args) {

		PanelLogin frame = new PanelLogin();

	}
}
