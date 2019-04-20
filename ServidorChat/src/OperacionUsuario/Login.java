package OperacionUsuario;

import java.util.List;

import BD.Consulta;
import Cliente.Cliente;
import Cliente.Persona;
import Mensajes.Mensaje;
import Operacion.InterfazPeticion;
import Servidor.ControladorServidor;

public class Login implements InterfazPeticion {

	private static final long serialVersionUID = 1905513113745901842L;
	private List<Object[]> lista_de_cosas;

	@Override
	public void tratarPeticion(Mensaje mensaje) {

		new PersonaAdapter() {
			@Override
			public void consultar(String consulta) {
				Persona persona = (Persona) mensaje.getDatos();

				consulta = "select p.email,p.contraseña,p.nick from Persona p ";
				consulta += "where p.email=" + "'" + persona.getEmail() + "'" + " and p.contraseña=" + "'"
						+ persona.getContraseña() + "'";

				lista_de_cosas = Consulta.consultar(consulta);
				if (!lista_de_cosas.isEmpty()) {

					if (Consulta.verificarEmail(persona.getEmail()) == true) {
						persona.setNick(lista_de_cosas.get(0)[2].toString());
						Cliente clienteNuevo = new Cliente(persona.getNick(), mensaje.getEntrada(),
								mensaje.getSalida());
						clienteNuevo.iniciarEscuchar();
						clienteNuevo.iniciarRespuesta();

						ControladorServidor.getInstancia().meterEnLobby(clienteNuevo);
						clienteNuevo.getSalida().enviarMensaje(new Mensaje(persona));
					}

				}

				
			}
		};

	}

}
