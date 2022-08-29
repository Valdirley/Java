
public class Lampada {
	private boolean ligada;
	private int potencia;
	
	public void ligar() {
		ligada = true;
	}
	public void desligar() {
		ligada = false;
	}
	public boolean estaLigada() {
		return ligada;
	}
	public int verificarPotencia() {
		return potencia;
	}
	public void alterarPotencia(int novaPotencia) {
		potencia = novaPotencia;
	}
	
}
