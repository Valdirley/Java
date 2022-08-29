import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//criar um objeto capaz de fazer a leitura de dados do teclado
		Scanner teclado = new Scanner(System.in); 
		//declara��o de vari�veis
		int opcao;
		//cria��o do objeto l1 da classe Lampada
		Lampada l1 = new Lampada();
		
		do {
			System.out.println("Menu Principal");
			System.out.println("1 - Ligar");
			System.out.println("2 - Desligar");
			System.out.println("3 - Est� ligada?");
			System.out.println("4 - Verificar Pot�ncia");
			System.out.println("5 - Alterar Pot�ncia");
			System.out.println("6 - Sair");
			System.out.println("Digite a op��o desejada: ");
			opcao = teclado.nextInt();
			
			switch(opcao) {
			case 1: l1.ligar();
				break;
			case 2: l1.desligar();
				break;
			case 3: //verificar se a l�mpada est� ou n�o ligada 
				if(l1.estaLigada()) //if(l1.estaLigada()==true)
					System.out.println("A l�mpada est� ligada");
				else
					System.out.println("A l�mpada est� desligada");
				break;
			case 4: System.out.println("Pot�ncia da l�mpada: "+l1.verificarPotencia());
				break;
			case 5: System.out.println("Qual a nova pot�ncia da l�mpada? ");
				l1.alterarPotencia(teclado.nextInt());
				break;
			case 6: System.out.println("Fim de programa");
				break;
			}
		}while(opcao!=6);
		
	}
}
