package exercicio2.model.dao;

import exercicio2.model.vo.NivelVO;
import exercicio2.model.vo.UsuarioVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {

	public int cadastrarUsuarioDAO(UsuarioVO usuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, IDNIVEL) VALUES ('" + usuario.getNome() + "', "
				+ usuario.getEmail() + "'," + usuario.getSenha() + usuario.getNivel().getId() + ")";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro do Sobremesa. Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<UsuarioVO> consultarTodas() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		String query = "SELECT USUARIO.IDUSUARIO, USUARIO.NOME, USUARIO.EMAIL, NIVEL.IDNIVEL, NIVEL.DESCRICAO"
				+ " FROM USUARIO INNER JOIN NIVEL ON USUARIO.IDNIVEL = NIVEL.IDNIVEL";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setId(Integer.parseInt(resultado.getString(1)));
				usuarioVO.setNome(resultado.getString(2));
				usuarioVO.setEmail(resultado.getString(3));
				NivelVO nivel = new NivelVO();
				nivel.setId(Integer.parseInt(resultado.getString(4)));
				nivel.setDescricao(resultado.getString(5));
				usuarioVO.setNivel(nivel);
				usuarios.add(usuarioVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Usuarios.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuarios;
	}

	public UsuarioVO consultarUsuarioNome(String nome) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		UsuarioVO usuario = null;
		
		String query = "SELECT USUARIO.IDUSUARIO, USUARIO.NOME, USUARIO.EMAIL, NIVEL.IDNIVEL, NIVEL.DESCRICAO"
				+ " FROM USUARIO INNER JOIN NIVEL ON USUARIO.IDNIVEL = NIVEL.IDNIVEL WHERE UPPER(USUARIO.NOME) = '" + nome.toUpperCase() + "'";
		
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				usuario = new UsuarioVO();
				usuario.setId(Integer.parseInt(resultado.getString(1)));
				usuario.setNome(resultado.getString(2));
				usuario.setEmail(resultado.getString(3));
				NivelVO nivel = new NivelVO();
				nivel.setId(Integer.parseInt(resultado.getString(4)));
				nivel.setDescricao(resultado.getString(5));
				usuario.setNivel(nivel);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Usuario por nome. Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}

	public ArrayList<UsuarioVO> consultarUsuarioNivel(NivelVO nivel) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		
		String query = "SELECT USUARIO.IDUSUARIO, USUARIO.NOME, USUARIO.EMAIL, NIVEL.IDNIVEL, NIVEL.DESCRICAO"
				+ " FROM USUARIO INNER JOIN NIVEL ON USUARIO.IDNIVEL = NIVEL.IDNIVEL WHERE NIVEL.IDNIVEL = " + nivel.getId() + "";
		
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setId(Integer.parseInt(resultado.getString(1)));
				usuarioVO.setNome(resultado.getString(2));
				usuarioVO.setEmail(resultado.getString(3));
				NivelVO nivelVO = new NivelVO();
				nivelVO.setId(Integer.parseInt(resultado.getString(4)));
				nivelVO.setDescricao(resultado.getString(5));
				usuarioVO.setNivel(nivelVO);
				usuarios.add(usuarioVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Usuarios por Nivel.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuarios;
	}

	public int excluirUsuario(UsuarioVO usuarioEX) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM USUARIO WHERE IDUSUARIO = " + usuarioEX.getId();
		try{
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Exclusão do Usuario. Causa: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public boolean existeRegistroADM(UsuarioVO usuarioADM) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT USUARIO.EMAIL, USUARIO.SENHA, NIVEL.DESCRICAO "
				+ "FROM USUARIO INNER JOIN NIVEL ON USUARIO.IDNIVEL = NIVEL.IDNIVEL WHERE USUARIO.EMAIL = '" + usuarioADM.getEmail() +"' "
						+ "AND USUARIO.SENHA = '" + usuarioADM.getSenha() + "' AND NIVEL.DESCRICAO = ADMIN";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Registro por Admin. Causa: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}


}
