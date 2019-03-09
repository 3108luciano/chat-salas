package Cliente;

import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelCliente extends JFrame implements Serializable {
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JButton btnEnviar;
	private JScrollPane scrollPane;
	private JLabel lblChat;

	public PanelCliente() {

		setTitle("Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(301, 225, 89, 23);
		contentPane.add(btnEnviar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 43, 350, 151);
		contentPane.add(scrollPane);

		textField = new JTextField();
		textField.setBounds(40, 219, 251, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		textArea = new JTextArea();
		textArea.setBounds(40, 45, 348, 149);
		contentPane.add(textArea);

		lblChat = new JLabel("Chat");
		lblChat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblChat.setBounds(179, 18, 46, 14);
		contentPane.add(lblChat);

		setVisible(true);
	}

	public void setTextField(String string) {
		this.textField.setText(string);
	}

	public String getTexto() {
		return textField.getText();

	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public void agregarTexto(String texto) {
		textArea.append(texto);
	}

}
