package exercicio2.model.bo;

import java.util.ArrayList;

import exercicio2.model.dao.NivelDAO;
import exercicio2.model.vo.NivelVO;

public class NivelBO {

	public ArrayList<NivelVO> consultarNivel() {
		NivelDAO dao = new NivelDAO();
		return dao.consultarNivel();
	}

}
