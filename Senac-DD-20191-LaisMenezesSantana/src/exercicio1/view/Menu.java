package exercicio1.view;

import java.util.Scanner;

import exercicio1.model.vo.ClienteVO;

public class Menu {

	Scanner teclado = new Scanner(System.in);
	
	public void apresentarMenu(ClienteVO[] clientes) {
		System.out.println("Relatórios CLiente");
		System.out.println("1- Todos os Dados");
		System.out.println("2- Sair");
		System.out.print("\nDigite a opção: ");
		int opcao = Integer.parseInt(teclado.nextLine());
		
		while(opcao !=2) {
		if(opcao == 1) {
				System.out.println("Digite o CPF do Cliente:");
				int cpf = Integer.parseInt(teclado.nextLine());
				for(int i = 0; i < clientes.length; i ++ ) {
					if(cpf == clientes[i].getCpf()) {
						System.out.println("\nNome: " + clientes[i].getNome());
						System.out.println("CPF: " + clientes[i].getCpf());
						for(int j = 0; j < clientes[i].getTelefone().length; j++) {
						System.out.println("Telefones: " + clientes[i].getTelefone()[j].getDdd() + clientes[i].getTelefone()[j].getNumero());
						}
						System.out.println("Endereço: " + clientes[i].getEndereco().getRua());
						System.out.println("CEP: " + clientes[i].getEndereco().getCep());
						System.out.println("Estado: " + clientes[i].getEndereco().getEstado());
						System.out.println("Cidade: " + clientes[i].getEndereco().getCidade());
					}
				}
		} 
		System.out.println("\nRelatórios CLiente");
		System.out.println("1- Todos os Dados");
		System.out.println("2- Sair");
		System.out.print("\nDigite a opção: ");
		opcao = Integer.parseInt(teclado.nextLine());
		}
		}
}
	
