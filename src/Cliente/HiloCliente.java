package Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JPanel;

public class HiloCliente implements Runnable {

	private DataInputStream entrada;
	private DataOutputStream salida;
	private PanelCliente panel;
	private Socket socket;
	
	public HiloCliente(Socket socket, PanelCliente panel) {
		this.socket= socket;
		this.panel = panel;
		try {
			entrada = new DataInputStream(this.socket.getInputStream());
			salida = new DataOutputStream(this.socket.getOutputStream());
	

			this.panel.getBtnEnviar().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						salida.writeUTF(panel.getTexto());
						HiloCliente.this.panel.setTextField("");
					} catch (IOException e) {
						
						e.printStackTrace();
					}

				}
			});
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		while (true) {
			try {

				String texto = entrada.readUTF();
				panel.agregarTexto(texto);
				panel.agregarTexto("\n");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
