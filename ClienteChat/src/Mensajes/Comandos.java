package Mensajes;

import Cliente.ControladorCliente;
import Operacion.CrearSala;
import Operacion.EnviarMensajeSala;
import Operacion.UnirseSala;
import OperacionUsuario.Login;
import OperacionUsuario.Registro;

public class Comandos {

	ControladorCliente controlador;
	
	public static final int PUERTO = 10000;
	public static final String IP = "192.168.0.219";
	public static final Login LOGIN = new Login();
	public static final CrearSala CREARSALA =  new CrearSala();
	public static final UnirseSala UNIRSESALA = new UnirseSala();
	public static final EnviarMensajeSala MENSAJESALA = new EnviarMensajeSala();
	public static final Registro REGISTRO = new Registro();
	
}
