package ex6.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;

public class ListarProdutos extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProdutos frame = new ListarProdutos();
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
	public ListarProdutos() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblTelaListagemProdutos = new JLabel("Tela Listagem Produtos");
		lblTelaListagemProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelaListagemProdutos.setBounds(10, 2, 241, 23);
		getContentPane().add(lblTelaListagemProdutos);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(10, 36, 46, 14);
		getContentPane().add(lblProduto);
		
		textField = new JTextField();
		textField.setBounds(58, 36, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(10, 85, 414, 174);
		getContentPane().add(table);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(335, 32, 89, 23);
		getContentPane().add(btnPesquisar);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(172, 36, 46, 14);
		getContentPane().add(lblId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(197, 36, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

	}
}
