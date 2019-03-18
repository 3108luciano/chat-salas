package Servidor;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import org.hibernate.result.Output;

import BD.Consulta;
import BD.Persona;
import BD.Registro;
import Cliente.Cliente;
import Mensajes.Mensaje;
import Stream.FlujoDeEntrada;
import Stream.FlujoDeSalida;

public class HiloServidor implements Runnable {

	private Socket socket;
	private PanelServidor panel;
	private FlujoDeEntrada entrada;
	private FlujoDeSalida salida;
	private int idCliente;
	private Socket socketReenvio;
	private LinkedList<HiloServidor> Clientes;
	private List<Object[]> lista_de_cosas;
	private Persona persona;

	public HiloServidor(Socket socket, PanelServidor panel, int idCliente, LinkedList<HiloServidor> Clientes)
			throws IOException {

		this.socket = socket;
		this.panel = panel;
		this.idCliente = idCliente;
		this.Clientes = Clientes;

		FlujoDeEntrada entrada = new FlujoDeEntrada(socket);
		FlujoDeSalida salida = new FlujoDeSalida(socket);

	}

	public boolean validarUsuario(Persona persona) {
		
		String consulta = "select p.email,p.contraseña,p.nick from Persona p ";
		consulta += "where p.email=" + "'" + persona.getEmail() + "'" + " and p.contraseña=" + "'"
				+ persona.getContraseña() + "'";	

		lista_de_cosas = Consulta.consultar(consulta);
		
		if (!lista_de_cosas.get(0)[0].equals(persona.getEmail())
				&& !lista_de_cosas.get(0)[1].equals(persona.getContraseña()))
			JOptionPane.showMessageDialog(null,
					"el usuario o contraseña ingresado es erroneo. vuelva a ingresarlo correctamente",
					"datos erroneos", JOptionPane.ERROR_MESSAGE);
			
		else {
			if (persona.getEmail().equals("") || persona.getContraseña().equals("")) {
				JOptionPane.showMessageDialog(null, "llene todo los campos", "campos vacios",
						JOptionPane.WARNING_MESSAGE);
			}
			else
				return true;
		}
		return true;
	}
	
	

	@Override
	public void run() {

		while (true) {
			try {
				persona =  (Persona) entrada.recibirMensaje();

				if (Registro.verificarEmail(persona.getEmail()) == true) {
					if(validarUsuario(persona)==true) {
						persona.setNick(lista_de_cosas.get(0)[2].toString());
						System.out.println("inicio de sesion exitoso. "+persona.getNick()+" ha iniciado sesion.");
					}
				}

				Thread hiloEntrada = new Thread(entrada);
				Thread hiloSalida = new Thread(salida);

				hiloEntrada.start();
				hiloSalida.start();
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}
}