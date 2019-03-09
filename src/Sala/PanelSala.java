package Sala;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class PanelSala extends JFrame {

	private JPanel contentPane;
	private JTable tabla;
	private String[] columnas = { "N° SALA", "NOMBRE" };
	private TableModel modelo;
	private JScrollPane scroll;
	
	public PanelSala() {

		setTitle("Salas");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		modelo = new modelotabla();
		tabla = new JTable(modelo);
	
		
		scroll = new JScrollPane(tabla);
		scroll.setBounds(0, 0, 440, 290);
		contentPane.add(scroll);
		
	}

	class modelotabla extends AbstractTableModel {

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public static void main(String[] args) {

		PanelSala frame = new PanelSala();

	}
}
