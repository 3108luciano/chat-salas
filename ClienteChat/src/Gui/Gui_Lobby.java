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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Cliente.Cliente;
import Cliente.ControladorCliente;
import Cliente.Persona;
import Mensajes.Comandos;
import Mensajes.Mensaje;
import Operacion.CrearSala;
import Stream.FlujoDeSalida;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui_Lobby extends JFrame {

	private JPanel contentPane;
	private JTable tabla;
	private String[] columnas = { "N� SALA", "NOMBRE" };
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	private JButton botonCrear, botonUnirse;
	private Object [] listaEtiquetasSalas;
	private ControladorCliente controlador;
	private JList<String> listaClientesConectados;
	private DefaultListModel<String>modeloClientes;
	
	public Gui_Lobby(FlujoDeSalida salida, Persona persona) {

		setTitle("Salas");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		String[] etiquetas = { "N� Sala", "Nombre de sala", "N� Jugadores" };

		modelo = new DefaultTableModel(new Object[][] {}, etiquetas);

		tabla = new JTable(modelo);

		tabla.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(30);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(30);

		scroll = new JScrollPane(tabla);
		scroll.setBounds(10, 45, 414, 205);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);

		modelo = (DefaultTableModel) tabla.getModel();

		botonCrear = new JButton("Crear");
		botonCrear.setBounds(92, 11, 89, 23);
		contentPane.add(botonCrear);

		botonCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nombreSala = JOptionPane.showInputDialog(null,"Ingrese el nombre de la sala");
				salida.enviarMensaje(new Mensaje(Comandos.CREARSALA,nombreSala,persona));
			}
		});
		
		
		
		botonUnirse = new JButton("Unirse");
		botonUnirse.setBounds(216, 11, 89, 23);
		contentPane.add(botonUnirse);

		botonUnirse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nombreSala = JOptionPane.showInputDialog(null,"Ingrese el nombre de la sala");
				salida.enviarMensaje(new Mensaje(Comandos.UNIRSESALA,nombreSala,persona));

				
			}
		});
		
		modeloClientes = new DefaultListModel<String>();
		listaClientesConectados = new JList<>(modeloClientes);
		
		contentPane.add(listaClientesConectados);
		
		setVisible(true);

	}

	public  synchronized JTable getTabla() {
		return tabla;
	}

	public synchronized void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public  synchronized JList<String> getListaClientesConectados() {
		return listaClientesConectados;
	}

	
}
