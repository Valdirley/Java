package projElevador;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//criar um objeto capaz de fazer a leitura de dados do teclado
		Scanner teclado = new Scanner(System.in); 
		//declaração de variáveis
		int opcao, cap, tot;
		boolean sucesso; // indica se o método foi executado com sucesso (true) ou não (false)
		
		System.out.println("Como o elevador deverá ser criado? Valores 1-fixos ou 2-digitados?");
		opcao = teclado.nextInt();
		Elevador e1;
		
		if(opcao==1) {
			e1 = new Elevador();
		}else {
			System.out.println("Digite a capacidade desejada para o elevador: ");
			cap = teclado.nextInt();
			System.out.println("Digite o total de andares do prédio: ");
			tot = teclado.nextInt();
			e1 = new Elevador(cap, tot);
		}

		do {
			System.out.println("\n\nMenu Principal");
			//System.out.println("1 - Inicializa");
			System.out.println("2 - Entra");
			System.out.println("3 - Sai");
			System.out.println("4 - Sobe");
			System.out.println("5 - Desce");
			System.out.println("6 - Informar estado");
			System.out.println("7 - Sair do Programa");
			System.out.println("Digite a opção desejada: ");
			opcao = teclado.nextInt();
			
			switch(opcao) {
			case 1: /*System.out.println("Digite a capacidade desejada para o elevador: ");
				cap = teclado.nextInt();
				System.out.println("Digite o total de andares do prédio: ");
				tot = teclado.nextInt();
				e1.inicializa(cap, tot); */
				break;
			case 2: sucesso = e1.entra();
				if(sucesso)
					System.out.println("A pessoa entrou no elevador!");
				else
					System.out.println("O elevador está cheio!");
				break;
			case 3: e1.sai();
				break;
			case 4: e1.sobe();
				break;
			case 5: e1.desce();
				break;
			case 6: System.out.println(e1.retornarEstado());
				break;
			case 7: System.out.println("Fim de programa");
				break;
			}
		}while(opcao!=7);
	}

}
