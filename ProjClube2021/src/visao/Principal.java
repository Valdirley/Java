package visao;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		
		int op, op2, cpfAux;
		
		do {
			System.out.println("\n\nMenu Principal");
			System.out.println("--------------------------");
			System.out.println("1 � Buscar S�cio");
			System.out.println("2 � Incluir S�cio");
			System.out.println("3 � Alterar S�cio");
			System.out.println("4 � Excluir S�cio");
			System.out.println("5 � Relat�rio de S�cios");
			System.out.println("6 � Sair do Sistema");
			
			op = ler.nextInt();
			
			switch(op) {
				case 1: System.out.println("Buscando s�cio");
				System.out.println("Digite o CPF para a busca: ");
				cpfAux = ler.nextInt();
				//buscar cpf
				//se encontrar
				// apresentar menu secund�rio

				do {
					System.out.println("\n\nMenu Secund�rio");
					System.out.println("--------------------------");
					System.out.println("1 � Buscar Dependente");
					System.out.println("2 � Incluir Dependente");
					System.out.println("3 � Alterar Dependente");
					System.out.println("4 � Excluir Dependente");
					System.out.println("5 � Relat�rio de Dependentes");
					System.out.println("6 � Voltar para o Menu Principal");
					
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
						case 5: System.out.println("Relat�rio geral de Dependentes");
						break;
						case 6: System.out.println("Retornando...");
						break;
						default: System.out.println("Op��o inv�lida");
					}
				}while(op2!=6);
					
				//sen�o encontrar, informar que o s�cio n�o est� cadastrado
				break;
				case 2: System.out.println("Incluindo s�cio");
				break;
				case 3: System.out.println("Alterando s�cio");
				break;
				case 4: System.out.println("Excluindo s�cio");
				break;
				case 5: System.out.println("Relat�rio geral de s�cios cadastrados");
				break;
				case 6: System.out.println("Fim de programa");
				break;
				default: System.out.println("Op��o inv�lida");
			}
			
		}while(op!=6);
	}

}
