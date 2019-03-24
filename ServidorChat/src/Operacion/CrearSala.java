package Operacion;

import java.util.ArrayList;

import Cliente.Cliente;
import Mensajes.Mensaje;
import Sala.Sala;
import Servidor.ControladorServidor;

public class CrearSala extends ControladorServidor {

	private ArrayList<Sala> salas;
	private ArrayList<Cliente> clienteslobby;

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		System.out.println("soy crear sala");

		Sala sala = new Sala(1, mensaje.getCadena(), 1);

		salas.add(sala);
	}
}
