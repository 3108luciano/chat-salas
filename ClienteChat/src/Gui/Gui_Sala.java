package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Gui_Sala extends JFrame {

	private JPanel contentPane;
	private JButton botonEnviar;
	private JTextArea conversacion;
	private JLabel nombreSala;
	private JList listaClientes;
	private JScrollPane scrollPane;
	private JTextField textMensaje;

	public Gui_Sala() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		botonEnviar = new JButton("Enviar");
		botonEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonEnviar.setBounds(277, 212, 89, 23);
		contentPane.add(botonEnviar);

		conversacion = new JTextArea();
		

		nombreSala = new JLabel("");
		nombreSala.setBounds(151, 11, 46, 14);
		contentPane.add(nombreSala);

		listaClientes = new JList();
		listaClientes.setBounds(347, 111, 57, -29);
		contentPane.add(listaClientes);

		scrollPane = new JScrollPane(conversacion);
		scrollPane.setBounds(42, 46, 282, 138);
		contentPane.add(scrollPane);
		
		textMensaje = new JTextField();
		textMensaje.setBounds(42, 213, 199, 37);
		contentPane.add(textMensaje);
		textMensaje.setColumns(10);
	}

	public static void main(String[] args) {

		Gui_Sala frame = new Gui_Sala();
		frame.setVisible(true);

	}
}
