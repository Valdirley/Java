package Visão;

import Dominio.Cachorro;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*	a) Instancie o objeto C1 da classe Cachorro
				inicializando os atributos conforme 
				descrição abaixo:
				Nome: cachorro sem nome
				Raça: nehuma raça definida
				Idade: 0*/
		
		Cachorro c1 = new Cachorro();
		
		/*b) Informe os valores dos atributos após 
			inicializados utilizando os métodos 
			acessores;*/

		c1.setNome("Dino");
		c1.setRaca("Pitbull");
		c1.setIdade(6);
		
		/*c) Utilizando os seus métodos 
			modificadores, altere os valores dos seus 
			atributos;*/
		System.out.println();
		System.out.println(c1.getNome());
		System.out.println(c1.getRaca());
		System.out.println(c1.getIdade());

		c1.setNome("Thor");
		c1.setRaca("Dogue alemão");
		c1.setIdade(10);

		/*d) Informe os valores dos atributos após 
		alteração utilizando o método que 
		retorna o estado do objeto;*/
		System.out.println();
		System.out.println(c1.getNome());
		System.out.println(c1.getRaca());
		System.out.println(c1.getIdade());
		System.out.println();

		/*e) Clone o objeto C1 e verifique se os 
		estados dos dois objetos são iguiais de 
		fato;*/
		
		Cachorro c2 = new Cachorro(c1);
		
		/*f) Informe o estado do clone.*/

		System.out.println("Endereço na memoria Cachorro Original "+c1);
		System.out.println("Endereço na memoria Cachorro Clone "+c2);
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
