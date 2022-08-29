package projElevador;

public class Elevador {
	private int andarAtual;
	private int totalAndares;
	private int capacidade;
	private int qtdPessoas;
	
	public Elevador() { //construtor
		capacidade = 10;
		totalAndares = 4;
	}
	
	public Elevador(int cap, int totAnd) { //construtor
		capacidade = cap;
		totalAndares = totAnd;
	}

	
/*	public void inicializa(int cap, int totAnd) {
		capacidade = cap;
		totalAndares = totAnd;
	}
*/	
	public boolean entra() {
		if(qtdPessoas<capacidade) {
			qtdPessoas++;
			return true;
		}else
			return false; //o elevador estava cheio, a pessoa não conseguiu entrar
	}
	
	public void sai() {
		if(qtdPessoas>0)
			qtdPessoas--;
	}
	
	public void sobe() {
		if(andarAtual<totalAndares)
			andarAtual++;
	}
	
	public void desce() {
		if(andarAtual>0) //o 0 é térreo
			andarAtual--;
	}
	
	public String retornarEstado() {
		return	("Andar atual "+andarAtual+"/"+totalAndares+" e capacidade atual "+qtdPessoas+"/"+capacidade);
	}
}
