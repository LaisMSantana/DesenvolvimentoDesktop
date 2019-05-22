package ex6.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ExcluirProduto extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirProduto frame = new ExcluirProduto();
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
	public ExcluirProduto() {
		setBounds(100, 100, 200, 150);
		getContentPane().setLayout(null);
		
		JLabel lblExcluirProduto = new JLabel("Excluir Produto");
		lblExcluirProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExcluirProduto.setBounds(23, 11, 139, 25);
		getContentPane().add(lblExcluirProduto);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(30, 36, 46, 14);
		getContentPane().add(lblId);
		
		textField = new JTextField();
		textField.setBounds(45, 36, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(42, 67, 89, 23);
		getContentPane().add(btnExcluir);

	}
}
