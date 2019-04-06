package exercicio2.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import exercicio2.controller.Controller;
import exercicio2.model.bo.NivelBO;
import exercicio2.model.bo.UsuarioBO;
import exercicio2.model.vo.NivelVO;
import exercicio2.model.vo.UsuarioVO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TelaListagem {

	private JFrame frmCadastroDeUsuarios;
	private JTextField txtNome;
	private JComboBox cbNivel;
	private List<NivelVO> niveis;
	private JTable tblUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagem window = new TelaListagem();
					window.frmCadastroDeUsuarios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListagem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
				consultarNiveis(); 
				

				frmCadastroDeUsuarios = new JFrame();
				frmCadastroDeUsuarios.setTitle("Consulta de usu�rios");
				frmCadastroDeUsuarios.setBounds(100, 100, 585, 405);
				frmCadastroDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmCadastroDeUsuarios.getContentPane().setLayout(null);

				JLabel lblNome = new JLabel("Nome:");
				lblNome.setBounds(20, 20, 55, 15);
				frmCadastroDeUsuarios.getContentPane().add(lblNome);

				JLabel lblNivel = new JLabel("N�vel:");
				lblNivel.setBounds(20, 55, 55, 15);
				frmCadastroDeUsuarios.getContentPane().add(lblNivel);

				txtNome = new JTextField();
				txtNome.setBounds(70, 15, 320, 28);
				frmCadastroDeUsuarios.getContentPane().add(txtNome);
				txtNome.setColumns(10);

				//Novo componente: Combobox
				cbNivel = new JComboBox();
				cbNivel.setModel(new DefaultComboBoxModel(niveis.toArray()));

				//Inicia sem nada selecionado no combo
				cbNivel.setSelectedIndex(-1);

				cbNivel.setBounds(70, 50, 320, 28);
				frmCadastroDeUsuarios.getContentPane().add(cbNivel);
				

				JButton btnConsultarPorNivel = new JButton("Consultar por n�vel");
				btnConsultarPorNivel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Controller controller = new Controller();
						NivelVO nivel = (NivelVO) cbNivel.getModel().getSelectedItem();
						ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
						usuarios = controller.listarPorNivel(nivel);
						atualizarTabelaUsuarios(usuarios);
					}
				});
				btnConsultarPorNivel.setBounds(390, 49, 160, 30);
				frmCadastroDeUsuarios.getContentPane().add(btnConsultarPorNivel);

				JButton btnConsultarPorNome = new JButton("Consultar por nome");
				btnConsultarPorNome.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Controller controller = new Controller();
						UsuarioVO usuario = new UsuarioVO();
						usuario = controller.listarPorNome(txtNome.getText());
						ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
						usuarios.add(usuario);
						atualizarTabelaUsuarios(usuarios);
					}
				});
				btnConsultarPorNome.setBounds(390, 14, 160, 30);
				frmCadastroDeUsuarios.getContentPane().add(btnConsultarPorNome);

				JButton btnConsultarTodos = new JButton("Consultar todos");
				btnConsultarTodos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Controller controller = new Controller();
						ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
						usuarios = controller.listarTodos();
						atualizarTabelaUsuarios(usuarios);
					}
				});
				btnConsultarTodos.setBounds(70, 85, 240, 30);
				frmCadastroDeUsuarios.getContentPane().add(btnConsultarTodos);

				JButton btnLimpar = new JButton("Limpar");
				btnLimpar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtNome.setText("");
						cbNivel.setSelectedIndex(-1);
						DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();
						model.setRowCount(1);
					}
				});
				btnLimpar.setBounds(310, 85, 240, 30);
				frmCadastroDeUsuarios.getContentPane().add(btnLimpar);
				

				//Novo componente: tabela
				tblUsuarios = new JTable();
				tblUsuarios.setVisible(true);

				//Cria a tabela vazia apenas com as colunas
				tblUsuarios.setModel(new DefaultTableModel(
					new Object[][] {
						{"id", "Nome"},
					},
					new String[] {
						"id", "Nome"
					}
				));

				tblUsuarios.setBounds(70, 120, 480, 230);
				frmCadastroDeUsuarios.getContentPane().add(tblUsuarios);
			}

			/**
			 * Atualiza o JTable de usu�rios.
			 * @param usuarios
			 */
			protected void atualizarTabelaUsuarios(ArrayList<UsuarioVO> usuarios) {
				DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();
				
				Object novaLinha[] = new Object[2];
				for(UsuarioVO usuario: usuarios){
					novaLinha[0] = usuario.getId();
					novaLinha[1] = usuario.getNome();
					model.addRow(novaLinha);
				}
			}
			

			private void consultarNiveis() {
				NivelBO nivel = new NivelBO();
				niveis = nivel.consultarNivel();
			}

}
