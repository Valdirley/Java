package visao;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		
		int op, op2, cpfAux;
		
		do {
			System.out.println("\n\nMenu Principal");
			System.out.println("--------------------------");
			System.out.println("1 – Buscar Sócio");
			System.out.println("2 – Incluir Sócio");
			System.out.println("3 – Alterar Sócio");
			System.out.println("4 – Excluir Sócio");
			System.out.println("5 – Relatório de Sócios");
			System.out.println("6 – Sair do Sistema");
			
			op = ler.nextInt();
			
			switch(op) {
				case 1: System.out.println("Buscando sócio");
				System.out.println("Digite o CPF para a busca: ");
				cpfAux = ler.nextInt();
				//buscar cpf
				//se encontrar
				// apresentar menu secundário

				do {
					System.out.println("\n\nMenu Secundário");
					System.out.println("--------------------------");
					System.out.println("1 – Buscar Dependente");
					System.out.println("2 – Incluir Dependente");
					System.out.println("3 – Alterar Dependente");
					System.out.println("4 – Excluir Dependente");
					System.out.println("5 – Relatório de Dependentes");
					System.out.println("6 – Voltar para o Menu Principal");
					
					op2 = ler.nextInt();
					
					switch(op2) {
						case 1: System.out.println("Buscando Dependente");
						break;
						case 2: System.out.println("Incluindo Dependente");
						break;
						case 3: System.out.println("Alterando Dependente");
						break;
						case 4: System.out.println("Excluindo Dependente");
						break;
						case 5: System.out.println("Relatório geral de Dependentes");
						break;
						case 6: System.out.println("Retornando...");
						break;
						default: System.out.println("Opção inválida");
					}
				}while(op2!=6);
					
				//senão encontrar, informar que o sócio não está cadastrado
				break;
				case 2: System.out.println("Incluindo sócio");
				break;
				case 3: System.out.println("Alterando sócio");
				break;
				case 4: System.out.println("Excluindo sócio");
				break;
				case 5: System.out.println("Relatório geral de sócios cadastrados");
				break;
				case 6: System.out.println("Fim de programa");
				break;
				default: System.out.println("Opção inválida");
			}
			
		}while(op!=6);
	}

}
