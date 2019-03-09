package Servidor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelServidor extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JLabel lblConversacion;

	public PanelServidor() {
		
		setTitle("Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		textArea = new JTextArea();

		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(68, 41, 257, 142);
		contentPane.add(scrollPane);

		lblConversacion = new JLabel("Conversacion");
		lblConversacion.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblConversacion.setBounds(161, 11, 89, 14);
		contentPane.add(lblConversacion);

		setVisible(true);

	}

	public JTextArea getTextArea() {
		return textArea;
	}
}
