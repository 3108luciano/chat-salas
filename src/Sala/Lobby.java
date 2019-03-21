package Sala;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lobby extends JFrame {

	private JPanel contentPane;
	private JTable tabla;
	private String[] columnas = { "N° SALA", "NOMBRE" };
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	private JButton botonCrear, botonUnirse;

	public Lobby() {

		setTitle("Salas");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		String[] etiquetas = { "N° Sala", "Nombre de sala", "N° Jugadores" };

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

		botonUnirse = new JButton("Unirse");
		botonUnirse.setBounds(216, 11, 89, 23);
		contentPane.add(botonUnirse);

	}

	public static void main(String[] args) {

		Lobby frame = new Lobby();
		frame.setVisible(true);
	}
}
