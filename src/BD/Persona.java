package BD;

public class Persona {

	private String email;
	private String contraseņa;
	private String nick;
	private int idPersona;

	public Persona(int idPersona, String email, String contraseņa, String nick) {
		this.idPersona = idPersona;
		this.email = email;
		this.contraseņa = contraseņa;
		this.nick = nick;
	}
}
