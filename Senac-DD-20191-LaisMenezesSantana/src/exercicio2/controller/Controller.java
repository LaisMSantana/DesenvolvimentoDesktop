package exercicio2.controller;

import java.util.ArrayList;

import exercicio2.model.bo.UsuarioBO;
import exercicio2.model.vo.NivelVO;
import exercicio2.model.vo.UsuarioVO;

public class Controller {
	
	public String salvar (String nome, String email, String senha, String senhaConfirmar, NivelVO nivel) {
		String mensagem = "";
		
		if(nome == null || nome.trim().isEmpty()) {
			mensagem = "Digite o nome!";
		}
		
		if(email == null || email.trim().isEmpty()) {
			mensagem = "Digite o email!";
		}
	
		if(nivel == null) {
			mensagem = "Escolha o nivel!";
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
			usuario.setNivel(nivel);
			
			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioBO.salvarUsuario(usuario);
		}
		return mensagem;
	}
	
	public String excluir(String idInformado, String email, String senha) {
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
		if(mensagem.isEmpty()) {
			UsuarioVO usuarioEX = new UsuarioVO();
			usuarioEX.setId(Integer.parseInt(idInformado));
			UsuarioVO usuarioADM = new UsuarioVO();
			usuarioADM.setEmail(email);
			usuarioADM.setSenha(senha);		
			
			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioBO.excluirUsuario(usuarioEX , usuarioADM );
		}
		
		return mensagem;
	}
	
	public ArrayList<UsuarioVO> listarTodos() {
			UsuarioBO usuarioBO = new UsuarioBO();
			return usuarioBO.listarTodosUsuarios();
	}
	
	public ArrayList<UsuarioVO> listarPorNivel(NivelVO nivel){
		if(nivel == null) {
			System.out.println("Escolha o nivel");
		} 
			UsuarioBO usuarioBO = new UsuarioBO();
			return usuarioBO.listarUsuarioNivel(nivel);
	}
	
	public UsuarioVO listarPorNome(String nome){
		
		if(nome == null|| nome.isEmpty() || nome.trim().length() < 3) {
			System.out.println("Nome deve possuir no mínimo 3 caracteres");
		} 
			UsuarioBO usuarioBO = new UsuarioBO();
			return usuarioBO.listarUsuarioNome(nome);
	}
}
