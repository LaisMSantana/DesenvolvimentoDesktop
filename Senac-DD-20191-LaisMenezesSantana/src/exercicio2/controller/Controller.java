package exercicio2.controller;

import javax.swing.JOptionPane;

import exercicio2.model.bo.UsuarioBO;
import exercicio2.model.vo.UsuarioVO;

public class Controller {
	
	public String salvar (String nome, String email, String senha, String senhaConfirmar, String nivel) {
		String mensagem = "";
		
		if(nome == null || nome.trim().isEmpty()) {
			mensagem = "Digite o nome!";
		}
		
		if(email == null || email.trim().isEmpty()) {
			mensagem = "Digite o email!";
		}
	
		if(nivel == null || nivel.trim().isEmpty()) {
			mensagem = "Digite o nivel!";
		}
		
		if(senha == null || senha.trim().isEmpty()) {
			mensagem = "Digite a senha!";
		}
		
		if(senhaConfirmar == null || senhaConfirmar.trim().isEmpty()) {
			mensagem = "Digite a senha de confirmação!";
		}
		if(senhaConfirmar != senha) {
			mensagem = "Senha incorreta, digite novamente!";
		}
		
		if(mensagem.isEmpty()) {
			UsuarioVO usuario = new UsuarioVO();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			//usuario.setNivel(nivel);
			
			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioBO.salvarUsuario(usuario);
		}
		return mensagem;
	}
	
	public String excluir(String idInformado, String email, String senha, String nivel) {
		String mensagem = "";
		
		if(idInformado == null || idInformado.trim().isEmpty()) {
			mensagem = "Informe o id";
		}
		
		if(email == null || email.trim().isEmpty()) {
			mensagem = "Digite o email!";
		}
		if(senha == null || senha.trim().isEmpty()) {
			mensagem = "Digite a senha!";
		}
	
		if(nivel == null || nivel.trim().isEmpty()) {
			mensagem = "Digite o nivel!";
		} 
		
		if(mensagem.isEmpty()) {
			UsuarioVO usuario = new UsuarioVO();
			usuario.getId();
			
			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioBO.excluirUsuario(usuario);
		}
		
		return mensagem;
	}
	
	public String listarPorNivel(String nivel) {
		String mensagem = "";
		if(nivel == null || nivel.trim().isEmpty()) {
			mensagem = "Digite o nivel!";
		} 
		if(mensagem.isEmpty()) {
			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioBO.listarUsuarioNivel(mensagem);
		}
		return mensagem;
	}
	
	
	

}
