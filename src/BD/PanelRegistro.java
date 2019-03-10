package BD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class PanelRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3;
	private JButton btnNewButton;

	public PanelRegistro() {
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

		btnNewButton = new JButton("Registrarse");
		btnNewButton.setBounds(319, 214, 89, 23);
		contentPane.add(btnNewButton);
	}

	public static void main(String[] args) {

		PanelRegistro frame = new PanelRegistro();

	}
}
