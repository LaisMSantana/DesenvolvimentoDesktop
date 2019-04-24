package exercicio2.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import exercicio2.controller.Controller;
import exercicio2.model.bo.NivelBO;
import exercicio2.model.vo.NivelVO;
import exercicio2.model.vo.UsuarioVO;

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
		frmCadastroDeUsuarios.setBounds(100, 100, 600, 405);
		frmCadastroDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNome = new JLabel("Nome:");

		JLabel lblNivel = new JLabel("Nivel:");

		txtNome = new JTextField();
		txtNome.setColumns(10);

		// Novo componente: Combobox
		cbNivel = new JComboBox();
		cbNivel.setModel(new DefaultComboBoxModel(niveis.toArray()));

		// Inicia sem nada selecionado no combo
		cbNivel.setSelectedIndex(-1);

		JButton btnConsultarPorNivel = new JButton("Consultar por nivel");
		btnConsultarPorNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller controller = new Controller();
				NivelVO nivel = (NivelVO) cbNivel.getModel().getSelectedItem();
				ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
				usuarios = controller.listarPorNivel(nivel);
				atualizarTabelaUsuarios(usuarios);
			}
		});

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

		JButton btnConsultarTodos = new JButton("Consultar todos");
		btnConsultarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller controller = new Controller();
				ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
				usuarios = controller.listarTodos();
				atualizarTabelaUsuarios(usuarios);
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				cbNivel.setSelectedIndex(-1);
				DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();
				model.setRowCount(1);
			}
		});

		// Novo componente: tabela
		tblUsuarios = new JTable();
		tblUsuarios.setVisible(true);

		// Cria a tabela vazia apenas com as colunas
		tblUsuarios
				.setModel(new DefaultTableModel(new Object[][] { { "id", "Nome" }, }, new String[] { "id", "Nome" }));
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeUsuarios.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(20)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(50).addComponent(txtNome,
										GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnConsultarPorNome, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(20)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(50).addComponent(cbNivel,
										GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNivel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnConsultarPorNivel, GroupLayout.PREFERRED_SIZE, 160,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(70)
						.addComponent(btnConsultarTodos, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(70).addComponent(tblUsuarios,
						GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(14)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(1)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(5).addComponent(lblNome,
										GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnConsultarPorNome, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(5)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(1)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cbNivel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(5).addComponent(lblNivel,
										GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))))
						.addComponent(btnConsultarPorNivel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnConsultarTodos, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(5).addComponent(tblUsuarios, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)));
		frmCadastroDeUsuarios.getContentPane().setLayout(groupLayout);
	}

	/**
	 * Atualiza o JTable de usu�rios.
	 * 
	 * @param usuarios
	 */
	protected void atualizarTabelaUsuarios(ArrayList<UsuarioVO> usuarios) {
		DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();

		Object novaLinha[] = new Object[2];
		for (UsuarioVO usuario : usuarios) {
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
