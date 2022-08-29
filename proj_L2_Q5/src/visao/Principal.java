package visao;

import java.util.Scanner;
import dominio.Pessoa;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		Pessoa p;
		ArrayList<Pessoa> agenda = new ArrayList<Pessoa>();
		
		int op, i, confirma;
		String nomeAux;
		boolean achou;
		
		do {
			System.out.println("Agenda de contatos");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Remover");
			System.out.println("3 - Alterar");
			System.out.println("4 - Informar dados (buscar)");
			System.out.println("5 - Escrever");
			System.out.println("6 - Sair");
			System.out.println("Qual a opção desejada?");
		
			op = teclado.nextInt();
			teclado.nextLine();
			
			switch(op) {
				case 1: System.out.println("Cadastrando uma pessoa...");
					p = new Pessoa();
					System.out.println("Digite o nome: ");
					p.setNome(teclado.nextLine());
					System.out.println("Digite o telefone: ");
					p.setTel(teclado.nextLine());
					System.out.println("Digite o e-mail: ");
					p.setEmail(teclado.nextLine());
					agenda.add(p); //colocar a pessoa p dentro da agenda
					break;
				case 2: System.out.println("Removendo uma pessoa...");
					achou = false;
					System.out.println("Digite o nome procurado: ");
					nomeAux = teclado.nextLine();
					for(i=0; i<agenda.size(); i++) {
						if(nomeAux.equals(agenda.get(i).getNome())){
							System.out.println(agenda.get(i).estado());
							achou = true;
							System.out.println("Confirma a exclusão (1-sim, 2-não)?");
							confirma = teclado.nextInt();
							if(confirma==1) {
								agenda.remove(i);     //excluir
								i--;
								System.out.println("Exclusão efetuada com sucesso");
							}else {
								System.out.println("Exclusão cancelada");
							}
						}
					}
					if(!achou)			//(achou == false)
						System.out.println("Não existe pessoa cadastrada com esse nome");
					break;
				case 3: System.out.println("Alterando uma pessoa...");
				achou = false;
				System.out.println("Digite o nome procurado: ");
				nomeAux = teclado.nextLine();
				for(i=0; i<agenda.size(); i++) {
					if(nomeAux.equals(agenda.get(i).getNome())){
						System.out.println(agenda.get(i).estado());
						achou = true;
						System.out.println("Qual o novo nome?");
						agenda.get(i).setNome(teclado.nextLine());
						System.out.println("Qual o novo telefone?");
						agenda.get(i).setTel(teclado.nextLine());
						System.out.println("Qual o novo e-mail?");
						agenda.get(i).setEmail(teclado.nextLine());
						System.out.println("Dados alterados com sucesso");
					}
				}
				if(!achou)			//(achou == false)
					System.out.println("Não existe pessoa cadastrada com esse nome");
					break;
				case 4: System.out.println("Informando dados de uma pessoa cadastrada (buscar)...");
					achou = false;
					System.out.println("Digite o nome procurado: ");
					nomeAux = teclado.nextLine();
					for(i=0; i<agenda.size(); i++) {
						if(nomeAux.equals(agenda.get(i).getNome())){
							System.out.println(agenda.get(i).estado());
							achou = true;
						}
					}
					if(!achou)			//(achou == false)
						System.out.println("Não existe pessoa cadastrada com esse nome");
					break;
				case 5: System.out.println("Escrevendo os dados da agenda...");
					for(i=0; i<agenda.size(); i++) {
						System.out.println(agenda.get(i).estado());
					}
					break;
				case 6: System.out.println("Fim de programa");
					break;
				default: System.out.println("Opção inválida");
			}
			 
		}while(op!=6);
		
		
	}

}
