package dominio;

public class Dependente {
	private int id;
	private String nome_d;
	private int idade;
	
	public Dependente() {
		
	}
	public Dependente(int id, String nome_d, int idade) {
		this.id = id;
		this.nome_d = nome_d;
		this.idade = idade;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome_d() {
		return nome_d;
	}
	public void setNome_d(String nome_d) {
		this.nome_d = nome_d;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
