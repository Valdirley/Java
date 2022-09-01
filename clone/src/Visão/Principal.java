package Vis�o;

import Dominio.Cachorro;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*	a) Instancie o objeto C1 da classe Cachorro
				inicializando os atributos conforme 
				descri��o abaixo:
				Nome: cachorro sem nome
				Ra�a: nehuma ra�a definida
				Idade: 0*/
		
		Cachorro c1 = new Cachorro();
		
		/*b) Informe os valores dos atributos ap�s 
			inicializados utilizando os m�todos 
			acessores;*/

		c1.setNome("Dino");
		c1.setRaca("Pitbull");
		c1.setIdade(6);
		
		/*c) Utilizando os seus m�todos 
			modificadores, altere os valores dos seus 
			atributos;*/
		System.out.println();
		System.out.println(c1.getNome());
		System.out.println(c1.getRaca());
		System.out.println(c1.getIdade());

		c1.setNome("Thor");
		c1.setRaca("Dogue alem�o");
		c1.setIdade(10);

		/*d) Informe os valores dos atributos ap�s 
		altera��o utilizando o m�todo que 
		retorna o estado do objeto;*/
		System.out.println();
		System.out.println(c1.getNome());
		System.out.println(c1.getRaca());
		System.out.println(c1.getIdade());
		System.out.println();

		/*e) Clone o objeto C1 e verifique se os 
		estados dos dois objetos s�o iguiais de 
		fato;*/
		
		Cachorro c2 = new Cachorro(c1);
		
		/*f) Informe o estado do clone.*/

		System.out.println("Endere�o na memoria Cachorro Original "+c1);
		System.out.println("Endere�o na memoria Cachorro Clone "+c2);
		System.out.println();
		System.out.println("Cachorro original");
		System.out.println(c1.getNome());
		System.out.println(c1.getRaca());
		System.out.println(c1.getIdade());
		System.out.println();
		System.out.println("Cachorro Clone");
		System.out.println(c2.getNome());
		System.out.println(c2.getRaca());
		System.out.println(c2.getIdade());

	}

}
