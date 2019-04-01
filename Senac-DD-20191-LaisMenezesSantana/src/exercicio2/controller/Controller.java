package exercicio2.controller;

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
			UsuarioVO usuario = new UsuarioVO();
			
			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioBO.excluirUsuario(usuario);
		}
		
		return mensagem;
	}
	
	public UsuarioVO listarTodos(UsuarioVO usuarios) {
			UsuarioBO usuarioBO = new UsuarioBO();
			return usuarioBO.listarTodosUsuarios(usuarios);

	}
	
	public String listarPorNivel(NivelVO nivel) {
		String mensagem = "";
		if(nivel == null) {
			mensagem = "Escolha o nivel!";
		} 
		if(mensagem.isEmpty()) {
			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioBO.listarUsuarioNivel(nivel);
		}
		return mensagem;
	}
	
	public String listarPorNome(UsuarioVO usuario) {
		String mensagem = "";
		if(usuario == null) {
			mensagem = "Escolha o usuario!";
		} 
		if(mensagem.isEmpty()) {
			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioBO.listarUsuarioNome(usuario);
		}
		return mensagem;
	}
}
