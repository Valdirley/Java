/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.Scanner;
import dominio.Musica;
import java.util.ArrayList;
import java.util.Random; // para a geração de números aleatórios

/**
 *
 * @author Alessandra Mendes
 */
public class Principal {
    
    public static void main (String args[]){

        Scanner ler = new Scanner(System.in);

        int op, cont, i, numeroAleatorio;
        String titulo, cantor;
        boolean achou;
        
        Musica m;
        ArrayList<Musica> lista = new ArrayList<>();
        
        do{
            System.out.println("\n\n------------------------------------------------------------");	
            System.out.println("                         PLAYLIST");	
            System.out.println("------------------------------------------------------------");	
            System.out.println("1 - Adicionar uma música");	
            System.out.println("2 - Excluir uma música");	
            System.out.println("3 - Tocar uma música específica (pelo título)");	
            System.out.println("4 - Tocar as músicas de um cantor");	
            System.out.println("5 - Tocar as músicas em sequência");	
            System.out.println("6 - Tocar as músicas embaralhadas (random)");	
            System.out.println("7 - Ver as músicas da Playlist");	
            System.out.println("8 - Sair");	
            System.out.println("------------------------------------------------------------");	
            System.out.println("Escolha sua opção: ");	
            op = ler.nextInt();
            ler.nextLine(); 
            switch(op){
            case 1: System.out.println("\nAdicionando uma música...");
                m = new Musica();
                System.out.println("Entre com os dados da Música");
                System.out.println("Título: ");
                m.setTitulo(ler.nextLine());
                System.out.println("Cantor: ");
                m.setCantor(ler.nextLine());
                System.out.println("Estilo (1-MPB, 2-Samba, 3-Outros): ");
                m.setEstilo(ler.nextInt());
                System.out.println("Duração em minutos: ");
                m.setMin(ler.nextInt());
                System.out.println("Duração em segundos: ");
                m.setSeg(ler.nextInt());
                lista.add(m);
                System.out.println("Inclusão efetuada com sucesso!");
                break;
            case 2: System.out.println("\nExcluindo uma música...");
                System.out.println("Entre com o título da Música: ");
                titulo = ler.nextLine();
                achou = false;
                for(i=0; i<lista.size(); i++){
                    if(lista.get(i).getTitulo().equals(titulo)){
                        achou = true;
                        lista.remove(i);
                    }
                }
                if(achou)
                    System.out.println("Exclusão efetuada com sucesso!");
                else
                    System.out.println("Música não cadastrada!");
                break;
            case 3: System.out.println("\nTocando uma música específica...");
                System.out.println("Entre com o título da Música: ");
                titulo = ler.nextLine();
                achou = false;
                for(i=0; i<lista.size(); i++){
                    if(lista.get(i).getTitulo().equals(titulo)){
                        achou = true;
                        System.out.println("Tocando "+lista.get(i).getTitulo());
                        for(cont=0;cont<lista.get(i).getDuracaoTotal(); cont++)
                        {
                            try{
                                Thread.sleep(1000); // pausa de 1 segundo
                            }catch(InterruptedException e){
                                System.out.println("Erro na execução da música: "+e.getMessage());
                            }  
                            System.out.print("|");
                        }
                        System.out.println("\nFim da execução da música\n");
                    }
                }
                if(!achou)
                    System.out.println("Música não cadastrada!");
                break;
            case 4: System.out.println("\nTocando as músicas de um cantor...");
                System.out.println("Entre com o cantor desejado: ");
                cantor = ler.nextLine();
                achou = false;
                for(i=0; i<lista.size(); i++){
                    if(lista.get(i).getCantor().equals(cantor)){
                        achou = true;
                        System.out.println("Tocando "+lista.get(i).getTitulo());
                        for(cont=0;cont<lista.get(i).getDuracaoTotal(); cont++)
                        {
                            try{
                                Thread.sleep(1000); // pausa de 1 segundo
                            }catch(InterruptedException e){
                                System.out.println("Erro na execução da música: "+e.getMessage());
                            }  
                            System.out.print("|");
                        }
                        System.out.println("\nFim da execução da música\n");
                    }
                }
                if(!achou)
                    System.out.println("Cantor não cadastrado!");
                break;
            case 5: System.out.println("\nTocando as músicas em sequência...");
                for(i=0; i<lista.size(); i++){
                    System.out.println("Tocando "+lista.get(i).getTitulo());
                    for(cont=0;cont<lista.get(i).getDuracaoTotal(); cont++)
                    {
                        try{
                            Thread.sleep(1000); // pausa de 1 segundo
                        }catch(InterruptedException e){
                            System.out.println("Erro na execução da música: "+e.getMessage());
                        }  
                        System.out.print("|");
                    }
                    System.out.println("\nFim da execução da música\n");
                }
                break;
            case 6: System.out.println("\nTocando as músicas embaralhadas...");
                Random gerador = new Random(); //gerando um objeto random para gerar os números aleatórios
                for(i=0; i<lista.size(); i++){
                    numeroAleatorio = gerador.nextInt(lista.size()-1); //gerando um número aleatório entre os números das músicas cadastradas na lista
                    System.out.println("numero aleatorio: "+numeroAleatorio);
                    System.out.println("Tocando "+lista.get(numeroAleatorio).getTitulo());
                    for(cont=0;cont<lista.get(numeroAleatorio).getDuracaoTotal(); cont++)
                    {
                        try{
                            Thread.sleep(1000); // pausa de 1 segundo
                        }catch(InterruptedException e){
                            System.out.println("Erro na execução da música: "+e.getMessage());
                        }  
                        System.out.print("|");
                    }
                    System.out.println("\nFim da execução da música\n");
                }
                break;
            case 7: System.out.println("\nListando as músicas da Playlist...");
                for(i=0;i<lista.size();i++){
                    System.out.println("\n----------- Música "+(i+1)+" -----------");
                    System.out.println("Título: "+lista.get(i).getTitulo());
                    System.out.println("Cantor: "+lista.get(i).getCantor());
                    System.out.println("Estilo: "+lista.get(i).getEstilo());
                    System.out.println("Duração: "+lista.get(i).getMin()+"m e "+lista.get(i).getSeg()+"s");
                }
                break;
            case 8: System.out.println("Fim de Programa!");
                break;		
            default: System.out.println("Opção Inválida!");
            }
        }while(op!=8);

    }
}
