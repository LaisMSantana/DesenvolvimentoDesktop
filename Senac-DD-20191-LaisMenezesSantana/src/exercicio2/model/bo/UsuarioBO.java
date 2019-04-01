package exercicio2.model.bo;

import javax.swing.JOptionPane;

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

	public String excluirUsuario(UsuarioVO usuario) {
		String mensagem = "";
		
		
		return mensagem;
	}

	public String listarUsuarioNivel(NivelVO nivel) {
		String mensagem = "";
		
		
		return mensagem;
		
	}

	public String listarUsuarioNome(UsuarioVO usuario) {
		String mensagem = "";
		
		
		return mensagem;
	}

	public UsuarioVO listarTodosUsuarios(UsuarioVO usuarios) {
		
		return null;
		
	}
	

	



}
