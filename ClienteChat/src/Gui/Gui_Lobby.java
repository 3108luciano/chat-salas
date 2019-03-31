package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Cliente.Cliente;
import Cliente.ControladorCliente;
import Cliente.Persona;
import Mensajes.Comandos;
import Mensajes.Mensaje;
import Operacion.CrearSala;
import Sala.Sala;
import Stream.FlujoDeSalida;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Gui_Lobby extends JFrame {

	private JPanel contentPane;
	private static DefaultListModel<String> modeloSalas;
	private static DefaultListModel<String> modeloClientes;
	private JScrollPane scroll, scrollclientes;
	private JButton botonCrear, botonUnirse;
	private ControladorCliente controlador;
	private JList<String> listaClientesConectados;
	private JList<String> listaSalasDisponibles;

	public Gui_Lobby(FlujoDeSalida salida, Persona persona, DefaultListModel<String> modeloSalas,
			DefaultListModel<String> modeloClientes) {

		setTitle("Salas");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		if (this.modeloClientes == null && this.modeloSalas == null) {

			this.modeloClientes = new DefaultListModel<String>();
			this.modeloSalas = new DefaultListModel<String>();
		} else {
			this.modeloClientes = modeloClientes;
			this.modeloSalas = modeloSalas;
		}

		listaClientesConectados = new JList<>(this.modeloClientes);

		scrollclientes = new JScrollPane(listaClientesConectados);
		scrollclientes.setBounds(278, 45, 146, 187);
		contentPane.add(scrollclientes);

		listaSalasDisponibles = new JList<>(this.modeloSalas);
		listaSalasDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scroll = new JScrollPane(listaSalasDisponibles);
		scroll.setBounds(10, 45, 258, 205);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);

		botonCrear = new JButton("Crear");
		botonCrear.setBounds(98, 11, 89, 23);
		contentPane.add(botonCrear);

		botonCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String nombreSala = JOptionPane.showInputDialog(null, "Ingrese el nombre de la sala");
				salida.enviarMensaje(new Mensaje(Comandos.CREARSALA, nombreSala, persona));
			}
		});

		listaSalasDisponibles.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					int nroSala = listaSalasDisponibles.getSelectedIndex();

					salida.enviarMensaje(new Mensaje(Comandos.UNIRSESALA, nroSala, persona));

				}
			}
		});

		JLabel lblLobby = new JLabel("Lobby");
		lblLobby.setBounds(325, 15, 52, 14);
		contentPane.add(lblLobby);

		setVisible(true);

	}

	public static void agregarCliente(String nick) {
		modeloClientes.addElement(nick);

	}

	public static void agregarSala(String nombreSala) {
		if(!modeloSalas.contains(nombreSala))
		modeloSalas.addElement(nombreSala);
	}

	public synchronized JList<String> getListaClientesConectados() {
		return listaClientesConectados;
	}

	public synchronized static DefaultListModel<String> getModeloSalas() {
		return modeloSalas;
	}

	public static void setModeloSalas(DefaultListModel<String> modeloSalas) {
		Gui_Lobby.modeloSalas = modeloSalas;
	}

	public static DefaultListModel<String> getModeloClientes() {
		return modeloClientes;
	}

}
