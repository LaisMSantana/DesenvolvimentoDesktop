package exercicio2.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exercicio2.model.vo.NivelVO;

public class NivelDAO {

	public ArrayList<NivelVO> consultarNivel() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<NivelVO> niveis = new ArrayList<NivelVO>();
		String query = "SELECT * FROM  NIVEL";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				NivelVO nivel = new NivelVO();
				nivel.setId(Integer.parseInt(resultado.getString(1)));
				nivel.setDescricao(resultado.getString(2));
				niveis.add(nivel);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Niveis.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return niveis;
	}

}
