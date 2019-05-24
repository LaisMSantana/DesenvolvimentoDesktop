package ex6.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Principal extends JFrame {

	
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JLabel lblSistemDeGerenciamento;
	CadastroCliente cadastroCliente = null;
	ListarProdutos listarProdutos = null;
	ExcluirProduto excluirProduto = null;
	Alterar alterarProduto = null;
	TelaSobre telaSobre = null;
	Ajuda ajuda = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 515);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-fila.png")));
		menuBar.add(mnClientes);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				if(cadastroCliente == null) {
					desktopPane.add(cadastroCliente);
					cadastroCliente.show();
				}else if(cadastroCliente!= null) {
					cadastroCliente.setVisible(true);
				}
				
			}
		});
		
		mntmCadastrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UNDEFINED, 0));
		mntmCadastrar.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-adicionar-usuário-masculino.png")));
		mnClientes.add(mntmCadastrar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-cardápio.png")));
		mnClientes.add(mntmListar);
		
		JMenuItem mntmRelatrio = new JMenuItem("Relatório");
		mntmRelatrio.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-documento-regular.png")));
		mnClientes.add(mntmRelatrio);
		
		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-comprar.png")));
		menuBar.add(mnProdutos);
		
		JMenuItem mntmCadastroDeProdutos = new JMenuItem("Cadastro de Produtos");
		mntmCadastroDeProdutos.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-adicionar-ao-banco-de-dados.png")));
		mnProdutos.add(mntmCadastroDeProdutos);
		
		JMenuItem mntmAlteraoDeProduto = new JMenuItem("Alteração de Produto");
		mntmAlteraoDeProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(alterarProduto == null) {
					alterarProduto = new Alterar();
					desktopPane.add(alterarProduto);
					alterarProduto.show();
				}else if(alterarProduto!= null) {
					alterarProduto.setVisible(true);
				}
				
			}
			
		});
		
		mntmAlteraoDeProduto.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-mensagem-de-avião-de-papel.png")));
		mnProdutos.add(mntmAlteraoDeProduto);
		
		JMenuItem mntmExcluirProduto = new JMenuItem("Excluir Produto");
		mntmExcluirProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(excluirProduto == null) {
					desktopPane.add(excluirProduto);
					excluirProduto.show();
				}else if(excluirProduto!= null) {
					excluirProduto.setVisible(true);
				}
				
			}
		});
		mntmExcluirProduto.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-molho-de-chaves.png")));
		mnProdutos.add(mntmExcluirProduto);
		
		JMenuItem mntmListarProdutos = new JMenuItem("Listar Produtos");
		mntmListarProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listarProdutos == null) {
					desktopPane.add(listarProdutos);
					listarProdutos.show();
				}else if(listarProdutos!= null) {
					listarProdutos.setVisible(true);
				}
			}
		});
		mntmListarProdutos.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-documento-regular.png")));
		mnProdutos.add(mntmListarProdutos);
		
		JMenu mnFuncionrios = new JMenu("Funcionários");
		mnFuncionrios.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-treinamento.png")));
		menuBar.add(mnFuncionrios);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-cartão-de-crédito-sem-contato.png")));
		menuBar.add(mnSobre);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mntmManual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		mntmManual.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-gerente-de-informações-do-cliente.png")));
		mnSobre.add(mntmManual);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ajuda == null) { 
					ajuda = new Ajuda();
					desktopPane.add(ajuda);
					ajuda.setVisible(true);
					} else if(ajuda != null) {
					ajuda.setVisible(true);
					}
			}
		});
		mntmAjuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0));
		mntmAjuda.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-suporte-on-line-filled-50.png")));
		mnSobre.add(mntmAjuda);
		
		JMenuItem mntmAutores = new JMenuItem("Autores");
		mntmAutores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(telaSobre == null) { 
				desktopPane.add(telaSobre);
				telaSobre.setVisible(true);
				} else if(telaSobre != null) {
				telaSobre.setVisible(true);
				}
			}
		});
		mntmAutores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		mntmAutores.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-charlie-chaplin-64.png")));
		mnSobre.add(mntmAutores);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSistemDeGerenciamento = new JLabel("Sistem De Gerenciamento de Vendas");
		lblSistemDeGerenciamento.setBounds(359, 398, 262, 15);
		contentPane.add(lblSistemDeGerenciamento);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(0, 0, 851, 387);
		contentPane.add(desktopPane_1);
	}
	
}
