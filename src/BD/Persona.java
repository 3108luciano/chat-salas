package BD;

public class Persona {

	private String email;
	private String contrase�a;
	private String nick;
	private int idPersona;

	public Persona(int idPersona, String email, String contrase�a, String nick) {
		this.idPersona = idPersona;
		this.email = email;
		this.contrase�a = contrase�a;
		this.nick = nick;
	}
}
