package exercicio2.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import exercicio2.model.bo.UsuarioBO;
import exercicio2.model.vo.NivelVO;
import exercicio2.model.vo.UsuarioVO;

public class Controller {
	
	public String salvar (String nome, String email, String senha, String senhaConfirmar, NivelVO nivel) {
		String mensagem = "";
		
		if(nome == null || nome.trim().isEmpty()) {
			mensagem = "Digite o nome!";
		}else if(email == null || email.trim().isEmpty()) {
			mensagem = "Digite o email!";
		}else if(nivel == null) {
			mensagem = "Escolha o nivel!";
		}else if(senha == null || senha.trim().isEmpty()) {
			mensagem = "Digite a senha!";
		}else if(senhaConfirmar == null || senhaConfirmar.trim().isEmpty()) {
			mensagem = "Digite a senha de confirma��o!";
		}else if(!senha.equals(senhaConfirmar)) {
			mensagem = "Senha incorreta, digite novamente!";
		}else if(mensagem.isEmpty()) {
			UsuarioBO usuarioBO = new UsuarioBO();
			mensagem = usuarioBO.salvarUsuario(nome, email, senha, nivel);
		}
		return mensagem;
	}
	
	public String excluir(UsuarioVO usuario, String email, String senha) {
		String mensagem = "";
		
		if(usuario == null) {
			mensagem = "Informe o usuario";
		}
		if(email == null || email.trim().isEmpty()) {
			mensagem = "Digite o email!";
		}
		if(senha == null || senha.trim().isEmpty()) {
			mensagem = "Digite a senha!";
		}
		if(mensagem.isEmpty()) {
			UsuarioVO usuarioEX = new UsuarioVO();
			usuarioEX.setId(usuario.getId());
			UsuarioVO usuarioADM = new UsuarioVO();
			usuarioADM.setEmail(email);
			usuarioADM.setSenha(senha);		
			
			UsuarioBO usuarioBO = new UsuarioBO();
			mensagem = usuarioBO.excluirUsuario(usuarioEX , usuarioADM );
		}
		
		return mensagem;
	}
	
	public ArrayList<UsuarioVO> listarTodos() {
			UsuarioBO usuarioBO = new UsuarioBO();
			return usuarioBO.listarTodosUsuarios();
	}
	
	public ArrayList<UsuarioVO> listarPorNivel(NivelVO nivel){
		if(nivel == null) {
			JOptionPane.showMessageDialog(null,"Escolha o nivel");
		} 
			UsuarioBO usuarioBO = new UsuarioBO();
			return usuarioBO.listarUsuarioNivel(nivel);
	}
	
	public UsuarioVO listarPorNome(String nome){
		
		if(nome == null|| nome.isEmpty() || nome.trim().length() < 3) {
			JOptionPane.showMessageDialog(null,"Nome deve possuir no minimo 3 caracteres");
		} 
			UsuarioBO usuarioBO = new UsuarioBO();
			return usuarioBO.listarUsuarioNome(nome);
	}
}
