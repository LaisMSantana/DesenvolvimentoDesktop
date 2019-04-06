package exercicio2.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import exercicio2.controller.Controller;
import exercicio2.model.vo.UsuarioVO;

public class TelaExcluir {

	private JFrame frame;
	private JTextField txtEmail;
	private JPasswordField pfSenha;
	private ArrayList<UsuarioVO> usuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExcluir window = new TelaExcluir();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaExcluir() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		consultarUsuarios();
		
		frame = new JFrame();
		frame.setTitle("Excluir Usuário");
		frame.setBounds(100, 100, 405, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(20, 50, 55, 15);
		frame.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(80, 50, 300, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(20, 85, 55, 15);
		frame.getContentPane().add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(80, 80, 300, 20);
		frame.getContentPane().add(pfSenha);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setBounds(20, 20, 60, 15);
		frame.getContentPane().add(lblUsuario);
		
		JComboBox cbUsuarios = new JComboBox();
		
		cbUsuarios.setBounds(80, 20, 300, 20);
		frame.getContentPane().add(cbUsuarios);
		cbUsuarios.setModel(new DefaultComboBoxModel(usuarios.toArray()));
		cbUsuarios.setSelectedIndex(-1);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = new String(pfSenha.getPassword());
				UsuarioVO usuario = (UsuarioVO) cbUsuarios.getModel().getSelectedItem();
				
				
				Controller controller = new Controller();
				JOptionPane.showMessageDialog(frame, controller.excluir(usuario , txtEmail.getText(), senha));
			}
		});
		btnExcluir.setBounds(20, 120, 160, 30);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEmail.setText("");
				pfSenha.setText("");
				cbUsuarios.setSelectedIndex(-1);
			}
		});
		btnLimpar.setBounds(215, 120, 160, 30);
		frame.getContentPane().add(btnLimpar);
	}

	private void consultarUsuarios() {
		Controller controller = new Controller();
		usuarios = controller.listarTodos();
	}
	}

