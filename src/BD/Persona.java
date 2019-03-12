package BD;

public class Persona {

	private String email;
	private String contraseña;
	private String nick;
	private int idPersona;

	public Persona(String email, String contraseña, String nick) {
		
		this.email = email;
		this.contraseña = contraseña;
		this.nick = nick;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getNick() {
		return nick;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	
}
