package exercicio2.view;

import javax.swing.JOptionPane;

import exercicio2.model.vo.UsuarioVO;

public class MenuListarTodos {
	
	public void apresentarMenuListarTodosGrafico(UsuarioVO[] usuarios) {
		for(int i = 0; i < usuarios.length; i++) {
			JOptionPane.showMessageDialog(null, "Lista de usuarios!\n "
					+ usuarios[i].toString());
		}
	}

}
