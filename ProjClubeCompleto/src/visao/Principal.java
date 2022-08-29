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
 * O PROJETO DEVER� SER ALTERADO - CONCLU�DO - PARA QUE SEJAM PERMITIDAS
 * ALTERA��ES DAS CHAVES PRIM�RIAS E ESTRANGEIRAS
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
            System.out.println("1 - Buscar S�cio");
            System.out.println("2 - Incluir S�cio");
            System.out.println("3 - Alterar S�cio");
            System.out.println("4 - Excluir S�cio");
            System.out.println("5 - Relat�rio de S�cios");
            System.out.println("6 - Relat�rio de S�cios por Nome");
            System.out.println("7 - Sair do Sistema");
            System.out.println("Qual a op��o desejada? ");
            op1 = ler.nextInt();
            switch(op1){
                case 1:
                    System.out.println("Buscando s�cio...");
                    System.out.println("Digite o CPF do s�cio desejado: ");
                    cpfAux = ler.nextInt();
                    // buscar o socio no bd
                    s = sDAO.buscar(cpfAux);
                    if(s==null)
                        System.out.println("S�cio n�o cadastrado!");
                    else{
                        System.out.println("S�cio localizado!");
                        System.out.println("Nome: "+s.getNome_s());
                        System.out.println("Data de admiss�o: "+s.getData_adm());
                        s.setListaDependentes(dDAO.buscarDependentesPorSocio(s.getCpf_s()));
                        do{
                            d = null;
                            System.out.println();
                            System.out.println("        Menu Secund�rio");
                            System.out.println("--------------------------------");
                            System.out.println("1 - Buscar Dependente");
                            System.out.println("2 - Incluir Dependente");
                            System.out.println("3 - Alterar Dependente");
                            System.out.println("4 - Excluir Dependente");
                            System.out.println("5 - Relat�rio de Dependentes");
                            System.out.println("6 - Voltar para o menu principal");
                            System.out.println("Qual a op��o desejada? ");
                            op2 = ler.nextInt();
                            switch(op2){
                                case 1:
                                    System.out.println("Buscando dependente...");
                                    System.out.println("Qual o id do dependente procurado? ");
                                    idAux = ler.nextInt();
                                    d = s.consultarDependente(idAux);
                                    if(d==null)
                                        System.out.println("O dependente n�o foi encontrado!");
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
                                        System.out.println("Dependente inclu�do com sucesso!");
                                    }else
                                        System.out.println("Dependente j� cadastrado!");
                                    break;
                                case 3:
                                    System.out.println("Alterando dependente...");
                                    System.out.println("Qual o id do dependente procurado? ");
                                    idAux = ler.nextInt();
                                    ler.nextLine();
                                    d = s.consultarDependente(idAux);
                                    if(d==null)
                                        System.out.println("Dependente n�o cadastrado!");
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
                                        System.out.println("Dependente n�o cadastrado!");
                                    else{
                                        dDAO.exclusao(d);
                                        s.setListaDependentes(dDAO.buscarDependentesPorSocio(s.getCpf_s()));
                                        System.out.println("Dependente exclu�do com sucesso!");
                                    }
                                    break;
                                case 5:
                                    System.out.println("Relat�rio de dependentes...");
                                    for(i=0; i<s.getTamanhoLista(); i++){
                                        System.out.println("-----------------------------");
                                        System.out.println("Id: "+s.getDependente(i).getId());
                                        System.out.println("Nome: "+s.getDependente(i).getNome_d());
                                        System.out.println("Idade: "+s.getDependente(i).getIdade());
                                    }
                                    System.out.println("Fim de relat�rio...\n");
                                    break;
                                case 6:
                                    System.out.println("Voltando ao menu Principal...");
                                    break;
                                default:
                                    System.out.println("Op��o Inv�lida!");
                            }
                            ler.nextLine();
                        }while(op2!=6);
                    }
                    break;
                case 2:
                    System.out.println("Incluindo s�cio...");
                    System.out.println("Digite o CPF do novo s�cio: ");
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
                        System.out.println("Digite o nome do s�cio: ");
                        s.setNome_s(ler.nextLine());
                        System.out.println("Digite a data de admiss�o: ");
                        s.setData_adm(ler.nextLine());
                        sDAO.inclusao(s);
                        //listaSocios.add(s); //lista simulando a tabela
                    }else
                        System.out.println("S�cio j� cadastrado!");
                    break;
                case 3:
                    System.out.println("Alterando s�cio..."); 
                    System.out.println("Digite o CPF do s�cio desejado: ");
                    cpfAux = ler.nextInt();
                    // buscar no bd 
                    s = sDAO.buscar(cpfAux);
                    if(s==null)
                        System.out.println("S�cio n�o cadastrado!");
                    else{
                        System.out.println("S�cio localizado!");
                        ler.nextLine();
                        System.out.println("Nome: "+s.getNome_s());
                        System.out.println("Data de admiss�o: "+s.getData_adm());
                        System.out.println("Digite o novo nome: ");
                        s.setNome_s(ler.nextLine());
                        System.out.println("Digite a nova data de admiss�o: ");
                        s.setData_adm(ler.nextLine());
                        sDAO.alteracao(s, cpfAux);
                    }
                    break;
                case 4:
                    System.out.println("Excluindo s�cio...");
                    System.out.println("Digite o CPF do s�cio desejado: ");
                    cpfAux = ler.nextInt();
                    // buscar no bd 
                    s = sDAO.buscar(cpfAux);
                    if(s==null)
                        System.out.println("S�cio n�o cadastrado!");
                    else{
                        System.out.println("S�cio localizado!");
                        System.out.println("Nome: "+s.getNome_s());
                        System.out.println("Data de admiss�o: "+s.getData_adm());
                        // verificar se tem dependentes cadastrados para esse s�cio
                        s.setListaDependentes(dDAO.buscarDependentesPorSocio(s.getCpf_s()));
                        // informar e remover dependentes em cascata (todos)
                        if(s.getListaDependentes().size()!=0) {
                        	System.out.println("Este s�cio possui dependentes cadastrados.");
                        	System.out.println("A exclus�o do s�cio acarretar� a exclus�o de todos os seus dependentes.");
                        }
                    	System.out.println("Confirma a exclus�o (1-sim, 2-n�o)? ");
                    	if(ler.nextInt()==1) {
                    		if(s.getListaDependentes()!=null){
                    			// remo��o em cascata
                    			dDAO.exclusaoEmCascata(s.getCpf_s());
                    			s.setListaDependentes(null);
                    		}
	                        // remover s�cio
	                        sDAO.exclusao(s.getCpf_s());
	                        s = null;
	                        System.out.println("Exclus�o efetuada com sucesso!");
                    	} else {
                            System.out.println("Exclus�o cancelada!");
                    	}
                    }
                    break;
                case 5:
                    System.out.println("Relat�rio de s�cios...");
                    listaSocios = sDAO.relatorio();
                    for(i=0; i<listaSocios.size(); i++){
                        System.out.println("-------------------------------");
                        System.out.println("CPF: "+listaSocios.get(i).getCpf_s());
                        System.out.println("Nome: "+listaSocios.get(i).getNome_s());
                        System.out.println("Data de admiss�o: "+listaSocios.get(i).getData_adm());
                    }
                    System.out.println("Fim de relat�rio...\n");
                    break;
                case 6:
                    ler.nextLine();
                    System.out.println("Relat�rio de S�cios por Nome");
                    listaNomesSocios = sDAO.relatorioPorNome();
                    for(i=0; i<listaNomesSocios.size(); i++){
                        System.out.println((i+1)+") "+listaNomesSocios.get(i));
                    }
                    System.out.println("Fim de relat�rio...\n");
                    break;
                case 7:
                    System.out.println("Fim de Programa");
                    break;
                default:
                    System.out.println("Op��o Inv�lida!");
            }
            ler.nextLine();
        }while(op1!=7);
        ler.close();
    }
    
}