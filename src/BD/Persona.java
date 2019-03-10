package BD;

public class Persona {

	private String email;
	private String contraseña;
	private String nick;
	private int idPersona;

	public Persona(int idPersona, String email, String contraseña, String nick) {
		this.idPersona = idPersona;
		this.email = email;
		this.contraseña = contraseña;
		this.nick = nick;
	}
}
