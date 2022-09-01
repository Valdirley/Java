package Dominio;

/*1. Implementar a classe Cachorro, em Java, 
de acordo com o modelo abaixo retirado 
de um Diagrama de Classes*/

public class Cachorro {
	
	private String nome;
	private String raca;
	private int idade;
	
	/*b) Implemente ainda um construtor que 
		receba os valores dos atributos como 
		parâmetros e os inicialize.*/

	public Cachorro() {
			}
	
	public Cachorro(String nome, String raca, int idade) {
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
	}
	
	public Cachorro (Cachorro x){
		this.cloneCachorro(x);
	}
		
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}


	public String getNome() {
		return nome;
	}

	public String getRaca() {
		return raca;
	}

	public int getIdade() {
		return idade;
	}

	public void cloneCachorro(Cachorro x) {
		this.setNome(x.getNome());
		this.setRaca(x.getRaca());
		this.setIdade(x.getIdade());
	}
	
	
}
