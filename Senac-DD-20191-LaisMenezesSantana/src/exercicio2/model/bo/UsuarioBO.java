package exercicio2.model.bo;


import java.util.ArrayList;

import exercicio2.model.dao.UsuarioDAO;
import exercicio2.model.vo.NivelVO;
import exercicio2.model.vo.UsuarioVO;

public class UsuarioBO {

	public String salvarUsuario(UsuarioVO usuario) {
		String mensagem = "";
		UsuarioDAO uDAO = new UsuarioDAO();
		
		if(usuario.getNome().length() < 3) {
			mensagem = "Nome incorreto! Mínimo 3 caracteres";
		}
		if(!emailCorreto(usuario.getEmail())) {
			mensagem = "Email incorreto! Somente com um '@'";
		}	
		if(usuario.getSenha().length() < 6) {
			mensagem = "Senha incorreta! Mínimo 6 caracteres";
		}
		if(usuario.getNivel() == null) {
			mensagem = "Nivel incorreto! Obrigatório";
		}
		if(mensagem.isEmpty()) {
			int statusPersistencia = uDAO.cadastrarUsuarioDAO(usuario);
						
			if(statusPersistencia == 1) {
				mensagem = "Usuario salvo com sucesso";
			}else if(statusPersistencia == 0) {
				mensagem = "Erro ao salvar usuario";
			}
		}
		return mensagem;
	}
	
	private boolean emailCorreto(String emailInformado) {
		boolean emailCorreto = false;
		String[] partes = emailInformado.split("@");
		if(partes.length == 2) {
			emailCorreto = true;
		}
		return emailCorreto;
	}

	public String excluirUsuario(UsuarioVO usuarioEX, UsuarioVO usuarioADM) {
		UsuarioDAO dao = new UsuarioDAO();
		String mensagem = "";
		if(dao.existeRegistroADM(usuarioADM) == false) {
			mensagem = "Não existe usuario Admin com esse email e senha.";
		} else {
			int statusPersistencia = dao.excluirUsuario(usuarioEX);
			
			if(statusPersistencia == 1) {
				mensagem = "Usuario foi excluido com sucesso";
			}else if(statusPersistencia == 0) {
				mensagem = "Erro ao exccluir usuario";
				}
			}
		return mensagem;
	}

	public ArrayList<UsuarioVO> listarUsuarioNivel(NivelVO nivel) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.consultarUsuarioNivel(nivel);
	}

	public UsuarioVO listarUsuarioNome(String nome) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.consultarUsuarioNome(nome);
	}

	public ArrayList<UsuarioVO> listarTodosUsuarios() {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.consultarTodas();
	}
	

	



}
