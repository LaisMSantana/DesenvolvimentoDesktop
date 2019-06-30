package ex6.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Ajuda extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajuda frame = new Ajuda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ajuda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Ajuda");
		setBounds(0, 0, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblAjuda = new JLabel("Ajuda");
		lblAjuda.setBounds(182, 11, 61, 19);
		lblAjuda.setFont(new Font("Dialog", Font.BOLD, 20));
		getContentPane().add(lblAjuda);
		
		JLabel lblDigiteAquiSua = new JLabel("Digite aqui sua Duvida :");
		lblDigiteAquiSua.setBounds(141, 41, 158, 19);
		lblDigiteAquiSua.setFont(new Font("Dialog", Font.BOLD, 13));
		getContentPane().add(lblDigiteAquiSua, "2, 6, 2, 1, left, top");
		

		JButton button = new JButton("Pesquisar");
		button.setBounds(123, 101, 189, 19);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					URI uri = new URI("https://www.google.com/search?q=" + URLEncoder.encode(textField.getText(), "UTF-8"));
					Desktop.getDesktop().browse(uri);
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		});
		getContentPane().add(button, "2, 10");
		
		JButton btnGoogle = new JButton("Google");
		btnGoogle.setBounds(317, 231, 107, 19);
		btnGoogle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					URI uri = new URI("https://www.google.com");
					Desktop.getDesktop().browse(uri);
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		});
		getContentPane().add(btnGoogle, "2, 14");
		
		textField = new JTextField();
		textField.setBounds(30, 71, 373, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

	}
}
