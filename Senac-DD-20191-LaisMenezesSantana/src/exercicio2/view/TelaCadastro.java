package exercicio2.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exercicio2.controller.Controller;
import exercicio2.model.bo.NivelBO;
import exercicio2.model.vo.NivelVO;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class TelaCadastro {

	private JFrame frmCadastroDeUsuarios;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JComboBox cbNivel;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmacaoSenha;
	private List<NivelVO> niveis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
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
	public TelaCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		consultarNiveis();

		frmCadastroDeUsuarios = new JFrame();
		frmCadastroDeUsuarios.setTitle("Cadastro de usuários");
		frmCadastroDeUsuarios.setBounds(100, 100, 400, 300);
		frmCadastroDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNome = new JLabel("Nome:");

		JLabel lblEmail = new JLabel("Email:");

		JLabel lblSenha = new JLabel("Senha:");

		JLabel lblConfirmaoDeSenha = new JLabel("Confirmação:");
		lblConfirmaoDeSenha.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNivel = new JLabel("Nível:");

		txtNome = new JTextField();
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		pfSenha = new JPasswordField();

		pfConfirmacaoSenha = new JPasswordField();

		// Novo componente: Combobox
		cbNivel = new JComboBox();
		cbNivel.setModel(new DefaultComboBoxModel(niveis.toArray()));

		// Inicia sem nada selecionado no combo
		cbNivel.setSelectedIndex(-1);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtEmail.setText("");
				pfSenha.setText("");
				pfConfirmacaoSenha.setText("");
				cbNivel.setSelectedIndex(-1);
			}
		});

		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String senha = new String(pfSenha.getPassword());
				String confirmacaoSenha = new String(pfConfirmacaoSenha.getPassword());
				NivelVO nivel = (NivelVO) cbNivel.getModel().getSelectedItem();

				Controller controller = new Controller();
				JOptionPane.showMessageDialog(null,
						controller.salvar(txtNome.getText(), txtEmail.getText(), senha, confirmacaoSenha, nivel));

			}
		});
		frmCadastroDeUsuarios.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("20px"),
				ColumnSpec.decode("55px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("90px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("7px"),
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("55px"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("96px"),},
			new RowSpec[] {
				RowSpec.decode("20px"),
				RowSpec.decode("28px"),
				RowSpec.decode("20px"),
				RowSpec.decode("28px"),
				RowSpec.decode("20px"),
				RowSpec.decode("28px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("28px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("35px"),}));
		frmCadastroDeUsuarios.getContentPane().add(lblNome, "2, 2, fill, center");
		frmCadastroDeUsuarios.getContentPane().add(txtNome, "4, 2, 7, 1, fill, fill");
		frmCadastroDeUsuarios.getContentPane().add(lblEmail, "2, 4, fill, center");
		frmCadastroDeUsuarios.getContentPane().add(txtEmail, "4, 4, 7, 1, fill, fill");
		frmCadastroDeUsuarios.getContentPane().add(lblSenha, "2, 6, fill, center");
		frmCadastroDeUsuarios.getContentPane().add(pfSenha, "4, 6, fill, fill");
		frmCadastroDeUsuarios.getContentPane().add(lblConfirmaoDeSenha, "6, 6, 3, 1, fill, center");
		frmCadastroDeUsuarios.getContentPane().add(pfConfirmacaoSenha, "10, 6, fill, fill");
		frmCadastroDeUsuarios.getContentPane().add(lblNivel, "2, 8, fill, center");
		frmCadastroDeUsuarios.getContentPane().add(cbNivel, "4, 8, 7, 1, fill, fill");
		frmCadastroDeUsuarios.getContentPane().add(button, "2, 10, 5, 1, fill, fill");
		frmCadastroDeUsuarios.getContentPane().add(btnLimpar, "8, 10, 3, 1, fill, fill");
	}

	private void consultarNiveis() {
		NivelBO nivel = new NivelBO();
		niveis = nivel.consultarNivel();
	}
}
