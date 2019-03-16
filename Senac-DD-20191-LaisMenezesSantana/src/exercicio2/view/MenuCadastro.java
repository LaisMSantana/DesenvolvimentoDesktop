package exercicio2.view;

import java.util.Scanner;

import javax.swing.JOptionPane;

import exercicio2.model.vo.UsuarioVO;

public class MenuCadastro {

	public void apresentarMenuCadastro() {
		UsuarioVO usuario = new UsuarioVO();
		usuario.setNome(JOptionPane.showInputDialog("Informe o nome:"));
		usuario.setEmail(obterEmail());
		usuario.setSenha(obterSenha());
		usuario.setNivel(obterNivel());
		
	
		JOptionPane.showMessageDialog(null, "Lista de usuarios!\n "
				+ usuario.toString());
	}

	private int obterNivel() {
		String nivelInformado = JOptionPane.showInputDialog("Informe o nivel usando apenas as op��es 1/2:");
		int nivel = 0;
		try {
			nivel = Integer.parseInt(nivelInformado);
			if ((nivel != 1) && (nivel != 2)) {
				JOptionPane.showMessageDialog(null, "Informe o nivel usando apenas as op��es 1/2:");
				 nivel = obterNivel();	
			}
		}catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Informe o nivel usando apenas as op��es 1/2:");
			 nivel = obterNivel();	
		}
		return nivel;
	}


	private String obterSenha() {
		String senhaInformada = JOptionPane.showInputDialog("Informe a senha(Minimo 6 caracteres):");
		
		if(!senhaCorreta(senhaInformada) || senhaInformada.length() < 6) {
			JOptionPane.showMessageDialog(null, "Informe a senha com somente numeros, letras e caracteres especiais!(Minimo 6 caracteres)");
			senhaInformada = obterSenha();
		}
		return senhaInformada;
	}

	private boolean senhaCorreta(String senhaInformada) {
		boolean senhaCorreta = false;
		String[] partes = senhaInformada.split(" ");
		if(partes.length == 1) {
			senhaCorreta = true;
		}
		return senhaCorreta;
	}

	private String obterEmail() {
		String emailInformado = JOptionPane.showInputDialog("Informe o email:");
		
		if(!emailCorreto(emailInformado)) {
			JOptionPane.showMessageDialog(null, "Informe o email corretamente!");
			emailInformado = obterEmail();
		}
		
		return emailInformado;
	}

	private boolean emailCorreto(String emailInformado) {
		boolean emailCorreto = false;
		String[] partes = emailInformado.split("@");
		if(partes.length == 2) {
			emailCorreto = true;
		}
		return emailCorreto;
	}

}
