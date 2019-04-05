package Mensajes;

import Operacion.ActualizarClientesLobby;
import Operacion.ActualizarSalasLobby;
import Operacion.CrearSala;
import Operacion.EnviarMensajeSala;
import Operacion.UnirseSala;
import OperacionUsuario.Login;
import OperacionUsuario.Registro;
import Servidor.ControladorServidor;

public class Comandos {

	
	public static final int PUERTO = 10000;
	public static final String IP = "192.168.0.219";
	public static final Login LOGIN = new Login();
	public static final CrearSala CREARSALA =  new CrearSala();
	public static final UnirseSala UNIRSESALA = new UnirseSala();
	public static final ActualizarClientesLobby ACTUALIZARCLIENTESLOBBY = new ActualizarClientesLobby();
	public static final ActualizarSalasLobby ACTUALIZARSALASLOBBY  = new ActualizarSalasLobby();
	public static final EnviarMensajeSala MENSAJESALA = new EnviarMensajeSala();
	public static final Registro REGISTRO = new Registro();
}
