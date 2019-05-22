package ex6.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
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
	public CadastroCliente() {
		setBounds(100, 100, 329, 270);
		getContentPane().setLayout(null);
		
		JLabel lblCadastroDeCliente = new JLabel("Cadastro de cliente");
		lblCadastroDeCliente.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCadastroDeCliente.setBounds(12, 12, 272, 15);
		getContentPane().add(lblCadastroDeCliente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 39, 66, 15);
		getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(12, 59, 295, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(12, 90, 66, 15);
		getContentPane().add(lblCep);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 109, 295, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setBounds(12, 140, 131, 15);
		getContentPane().add(lblDataNascimento);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(12, 160, 295, 19);
		getContentPane().add(textField_2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(97, 190, 114, 25);
		getContentPane().add(btnSalvar);

	}
}
