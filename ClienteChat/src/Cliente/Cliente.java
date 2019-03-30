package Cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;

import javax.swing.*;

import Gui.Gui_Login;
import Mensajes.Comandos;
import Mensajes.Mensaje;

import java.awt.*;

public class Cliente extends JFrame implements Serializable {

	private static final long serialVersionUID = 7799656478674716638L;
	private  String nick;

	public Cliente(String nick) {
		this.nick = nick;
	}

	public  String getNick() {
		return nick;
	}
	
	

}
