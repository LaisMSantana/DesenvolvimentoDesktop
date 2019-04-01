package exercicio2.model.dao;

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

}
