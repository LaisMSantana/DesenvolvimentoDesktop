package ex6.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;

public class TelaSobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobre frame = new TelaSobre();
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
	public TelaSobre() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 425, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnNomeLaisCurso = new JTextPane();
		txtpnNomeLaisCurso.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtpnNomeLaisCurso.setText("Nome: Lais "
				+ "\nCurso: ADS "
				+ "\nCidade: Florianópolis");
		txtpnNomeLaisCurso.setBounds(95, 12, 224, 81);
		contentPane.add(txtpnNomeLaisCurso);
	}
}
