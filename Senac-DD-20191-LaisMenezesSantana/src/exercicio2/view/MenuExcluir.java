package exercicio2.view;

import javax.swing.JOptionPane;

public class MenuExcluir {

	public void apresentarMenuExcluirGrafico() {
		String idInformado = JOptionPane.showInputDialog("Informe o id:");
		int opcaoSelecionada = JOptionPane.showConfirmDialog(null, 
				"Tem certeza que deseja excluir o usuario " + idInformado + "?");
		switch (opcaoSelecionada) {
			case JOptionPane.YES_OPTION:
				JOptionPane.showMessageDialog(null, "Usuario " + idInformado + " excluido");
				break;
			case JOptionPane.NO_OPTION:
				apresentarMenuExcluirGrafico();
				break;
			case JOptionPane.CANCEL_OPTION:
				apresentarMenuExcluirGrafico();
				break;	
		}
	}


}
