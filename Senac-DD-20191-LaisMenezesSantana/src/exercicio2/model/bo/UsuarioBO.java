package exercicio2.model.bo;


import java.util.ArrayList;

import exercicio2.model.dao.UsuarioDAO;
import exercicio2.model.vo.NivelVO;
import exercicio2.model.vo.UsuarioVO;

public class UsuarioBO {

	public String salvarUsuario(String nome, String email, String senha,NivelVO nivel) {
		String mensagem = "";
		
		if(nome.length() < 3) {
			mensagem = "Nome incorreto! M�nimo 3 caracteres";
		} else if(!emailCorreto(email)) {
			mensagem = "Email incorreto! Somente com um '@'";
		}else if(senha.length() < 6) {
			mensagem = "Senha incorreta! M�nimo 6 caracteres";
		}else if(nivel == null) {
			mensagem = "Nivel incorreto! Obrigat�rio";
		}else if(mensagem.isEmpty()) {
			UsuarioVO usuario = new UsuarioVO();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setNivel(nivel);
			
			UsuarioDAO uDAO = new UsuarioDAO();
			int statusPersistencia = uDAO.cadastrarUsuarioDAO(usuario);
						
			if(statusPersistencia >= 1) {
				mensagem = "Usuario salvo com sucesso";
			}else {
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
			mensagem = "N�o existe usuario Admin com esse email e senha.";
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
