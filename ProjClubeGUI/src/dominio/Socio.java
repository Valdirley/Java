package dominio;

public class Socio {
	
	private int id;
	private String nome;
	private String celular;
	
	public Socio() {
		
	}
	public Socio(int id, String nome, String celular) {
		this.id = id;
		this.nome = nome;
		this.celular = celular;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
}
