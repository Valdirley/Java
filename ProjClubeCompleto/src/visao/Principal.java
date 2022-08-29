package visao;
import java.util.Scanner;
import java.util.ArrayList;
import dominio.Socio;
import dominio.Dependente;
import persistencia.DependenteDAO;
import persistencia.SocioDAO;

/**
 *
 * @author Alessandra Mendes
 * O PROJETO DEVERÁ SER ALTERADO - CONCLUÍDO - PARA QUE SEJAM PERMITIDAS
 * ALTERAÇÕES DAS CHAVES PRIMÁRIAS E ESTRANGEIRAS
 */
public class Principal {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ler = new Scanner(System.in);
        int op1, op2, cpfAux, i, idAux;
        
        ArrayList<Socio> listaSocios = new ArrayList<>();
//        ArrayList<Dependente> listaDependentes = new ArrayList<>();
        ArrayList<String> listaNomesSocios = new ArrayList<>();
        
        Socio s;
        Dependente d;
        SocioDAO sDAO = new SocioDAO();
        DependenteDAO dDAO = new DependenteDAO();
        
        do{
            s = null;
            System.out.println();
            System.out.println("    Menu Principal");
            System.out.println("------------------------");
            System.out.println("1 - Buscar Sócio");
            System.out.println("2 - Incluir Sócio");
            System.out.println("3 - Alterar Sócio");
            System.out.println("4 - Excluir Sócio");
            System.out.println("5 - Relatório de Sócios");
            System.out.println("6 - Relatório de Sócios por Nome");
            System.out.println("7 - Sair do Sistema");
            System.out.println("Qual a opção desejada? ");
            op1 = ler.nextInt();
            switch(op1){
                case 1:
                    System.out.println("Buscando sócio...");
                    System.out.println("Digite o CPF do sócio desejado: ");
                    cpfAux = ler.nextInt();
                    // buscar o socio no bd
                    s = sDAO.buscar(cpfAux);
                    if(s==null)
                        System.out.println("Sócio não cadastrado!");
                    else{
                        System.out.println("Sócio localizado!");
                        System.out.println("Nome: "+s.getNome_s());
                        System.out.println("Data de admissão: "+s.getData_adm());
                        s.setListaDependentes(dDAO.buscarDependentesPorSocio(s.getCpf_s()));
                        do{
                            d = null;
                            System.out.println();
                            System.out.println("        Menu Secundário");
                            System.out.println("--------------------------------");
                            System.out.println("1 - Buscar Dependente");
                            System.out.println("2 - Incluir Dependente");
                            System.out.println("3 - Alterar Dependente");
                            System.out.println("4 - Excluir Dependente");
                            System.out.println("5 - Relatório de Dependentes");
                            System.out.println("6 - Voltar para o menu principal");
                            System.out.println("Qual a opção desejada? ");
                            op2 = ler.nextInt();
                            switch(op2){
                                case 1:
                                    System.out.println("Buscando dependente...");
                                    System.out.println("Qual o id do dependente procurado? ");
                                    idAux = ler.nextInt();
                                    d = s.consultarDependente(idAux);
                                    if(d==null)
                                        System.out.println("O dependente não foi encontrado!");
                                    else{
                                        System.out.println("Dependente localizado!");
                                        System.out.println("Nome: "+d.getNome_d());
                                        System.out.println("Idade: "+d.getIdade());
                                    }
                                    break;
                                case 2:
                                    System.out.println("Incluindo dependente...");
                                    System.out.println("Qual o id do dependente procurado? ");
                                    idAux = ler.nextInt();
                                    ler.nextLine();
                                    d = s.consultarDependente(idAux);
                                    if(d==null){
                                        d = new Dependente();
                                        d.setId(idAux);
                                        System.out.println("Digite o nome do dependente: ");
                                        d.setNome_d(ler.nextLine());
                                        System.out.println("Digite a idade: ");
                                        d.setIdade(ler.nextInt());
                                        dDAO.inclusao(d, s.getCpf_s());
                                        s.setListaDependentes(dDAO.buscarDependentesPorSocio(s.getCpf_s()));
                                        System.out.println("Dependente incluído com sucesso!");
                                    }else
                                        System.out.println("Dependente já cadastrado!");
                                    break;
                                case 3:
                                    System.out.println("Alterando dependente...");
                                    System.out.println("Qual o id do dependente procurado? ");
                                    idAux = ler.nextInt();
                                    ler.nextLine();
                                    d = s.consultarDependente(idAux);
                                    if(d==null)
                                        System.out.println("Dependente não cadastrado!");
                                    else{
                                        System.out.println("Dependente localizado!");
                                        System.out.println("Nome: "+d.getNome_d());
                                        System.out.println("Idade: "+d.getIdade());
                                        System.out.println("Digite o novo nome: ");
                                        d.setNome_d(ler.nextLine());
                                        System.out.println("Digite a nova idade: ");
                                        d.setIdade(ler.nextInt());
                                        dDAO.alteracao(d, s.getCpf_s());
                                        s.setListaDependentes(dDAO.buscarDependentesPorSocio(s.getCpf_s()));
                                        System.out.println("Dependente alterado com sucesso!");
                                    }
                                    break;
                                case 4:
                                    System.out.println("Excluindo dependente...");
                                    System.out.println("Qual o id do dependente procurado? ");
                                    idAux = ler.nextInt();
                                    ler.nextLine();
                                    d = s.consultarDependente(idAux);
                                    if(d==null)
                                        System.out.println("Dependente não cadastrado!");
                                    else{
                                        dDAO.exclusao(d);
                                        s.setListaDependentes(dDAO.buscarDependentesPorSocio(s.getCpf_s()));
                                        System.out.println("Dependente excluído com sucesso!");
                                    }
                                    break;
                                case 5:
                                    System.out.println("Relatório de dependentes...");
                                    for(i=0; i<s.getTamanhoLista(); i++){
                                        System.out.println("-----------------------------");
                                        System.out.println("Id: "+s.getDependente(i).getId());
                                        System.out.println("Nome: "+s.getDependente(i).getNome_d());
                                        System.out.println("Idade: "+s.getDependente(i).getIdade());
                                    }
                                    System.out.println("Fim de relatório...\n");
                                    break;
                                case 6:
                                    System.out.println("Voltando ao menu Principal...");
                                    break;
                                default:
                                    System.out.println("Opção Inválida!");
                            }
                            ler.nextLine();
                        }while(op2!=6);
                    }
                    break;
                case 2:
                    System.out.println("Incluindo sócio...");
                    System.out.println("Digite o CPF do novo sócio: ");
                    cpfAux = ler.nextInt();
                    ler.nextLine();
                    // buscar no bd (por enquanto a listaSocio simula a tabela Socio do BD)
                    for(i=0; i<listaSocios.size(); i++){
                        if(listaSocios.get(i).getCpf_s()==cpfAux){
                            s = listaSocios.get(i);
                        }
                    }

                    if(s==null){
                        s = new Socio();
                        s.setCpf_s(cpfAux);
                        System.out.println("Digite o nome do sócio: ");
                        s.setNome_s(ler.nextLine());
                        System.out.println("Digite a data de admissão: ");
                        s.setData_adm(ler.nextLine());
                        sDAO.inclusao(s);
                        //listaSocios.add(s); //lista simulando a tabela
                    }else
                        System.out.println("Sócio já cadastrado!");
                    break;
                case 3:
                    System.out.println("Alterando sócio..."); 
                    System.out.println("Digite o CPF do sócio desejado: ");
                    cpfAux = ler.nextInt();
                    // buscar no bd 
                    s = sDAO.buscar(cpfAux);
                    if(s==null)
                        System.out.println("Sócio não cadastrado!");
                    else{
                        System.out.println("Sócio localizado!");
                        ler.nextLine();
                        System.out.println("Nome: "+s.getNome_s());
                        System.out.println("Data de admissão: "+s.getData_adm());
                        System.out.println("Digite o novo nome: ");
                        s.setNome_s(ler.nextLine());
                        System.out.println("Digite a nova data de admissão: ");
                        s.setData_adm(ler.nextLine());
                        sDAO.alteracao(s, cpfAux);
                    }
                    break;
                case 4:
                    System.out.println("Excluindo sócio...");
                    System.out.println("Digite o CPF do sócio desejado: ");
                    cpfAux = ler.nextInt();
                    // buscar no bd 
                    s = sDAO.buscar(cpfAux);
                    if(s==null)
                        System.out.println("Sócio não cadastrado!");
                    else{
                        System.out.println("Sócio localizado!");
                        System.out.println("Nome: "+s.getNome_s());
                        System.out.println("Data de admissão: "+s.getData_adm());
                        // verificar se tem dependentes cadastrados para esse sócio
                        s.setListaDependentes(dDAO.buscarDependentesPorSocio(s.getCpf_s()));
                        // informar e remover dependentes em cascata (todos)
                        if(s.getListaDependentes().size()!=0) {
                        	System.out.println("Este sócio possui dependentes cadastrados.");
                        	System.out.println("A exclusão do sócio acarretará a exclusão de todos os seus dependentes.");
                        }
                    	System.out.println("Confirma a exclusão (1-sim, 2-não)? ");
                    	if(ler.nextInt()==1) {
                    		if(s.getListaDependentes()!=null){
                    			// remoção em cascata
                    			dDAO.exclusaoEmCascata(s.getCpf_s());
                    			s.setListaDependentes(null);
                    		}
	                        // remover sócio
	                        sDAO.exclusao(s.getCpf_s());
	                        s = null;
	                        System.out.println("Exclusão efetuada com sucesso!");
                    	} else {
                            System.out.println("Exclusão cancelada!");
                    	}
                    }
                    break;
                case 5:
                    System.out.println("Relatório de sócios...");
                    listaSocios = sDAO.relatorio();
                    for(i=0; i<listaSocios.size(); i++){
                        System.out.println("-------------------------------");
                        System.out.println("CPF: "+listaSocios.get(i).getCpf_s());
                        System.out.println("Nome: "+listaSocios.get(i).getNome_s());
                        System.out.println("Data de admissão: "+listaSocios.get(i).getData_adm());
                    }
                    System.out.println("Fim de relatório...\n");
                    break;
                case 6:
                    ler.nextLine();
                    System.out.println("Relatório de Sócios por Nome");
                    listaNomesSocios = sDAO.relatorioPorNome();
                    for(i=0; i<listaNomesSocios.size(); i++){
                        System.out.println((i+1)+") "+listaNomesSocios.get(i));
                    }
                    System.out.println("Fim de relatório...\n");
                    break;
                case 7:
                    System.out.println("Fim de Programa");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
            ler.nextLine();
        }while(op1!=7);
        ler.close();
    }
    
}