package exercicio1.executavel;

import java.util.Scanner;

import exercicio1.model.vo.ClienteVO;
import exercicio1.model.vo.EnderecoVO;
import exercicio1.model.vo.TelefoneVO;
import exercicio1.view.Menu;

public class Executavel {
	
	public static void main (String[] args) {
		
		
		TelefoneVO t1 = new TelefoneVO(48 , 999999999);
		TelefoneVO t2 = new TelefoneVO(48 , 999999998);
		TelefoneVO t3 = new TelefoneVO(48 , 999999997);
		TelefoneVO t4 = new TelefoneVO(48 , 999999996);
		TelefoneVO t5 = new TelefoneVO(48 , 999999995);
		TelefoneVO[] tCliente1 = {t1, t2};
		TelefoneVO[] tCliente2 = {t3, t4, t5};
		
		EnderecoVO e1 = new EnderecoVO("Rua Bocaiúva", 88888888, "SC", "FLorianópolis");
		EnderecoVO e2 = new EnderecoVO("Av. Hercílio Luz", 88888887, "SC", "FLorianópolis");
		
		
		
		ClienteVO cliente1 = new ClienteVO("nome1", 1111111111, tCliente1 , e1, 001);
		ClienteVO cliente2 = new ClienteVO("nome2", 1111111112, tCliente2 , e2, 002);
		ClienteVO[] clientes = {cliente1, cliente2};
		
		Menu menu = new Menu();
		menu.apresentarMenu(clientes);
				
	}
	

}
