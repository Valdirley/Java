
public class CalculadoraMelhorada extends Calculadora{

	private String memoria;
	
	public CalculadoraMelhorada() {
		super();
		memoria = " ";
	}
	
	public float calcular(char operador, float op1, float op2) {
		float resultado;
		switch(operador) {
			case '+': memoria = "Soma"; 
				break;
			case '-': memoria = "Subtração";
				break;
			case '*': memoria = "Multiplicação";
				break;
			case '/': memoria = "Divisão";
				break;
		}
		resultado = super.calcular(operador, op1, op2); 
		return resultado;
	}
	
	public float calcular(float base, float expoente) {
		memoria = "Potência";
		setOperando1(base);
		setOperando2(expoente);
		return potencia();
	}
	
	private float potencia() {
		//herdou operando1 (base) e operando2 (expoente)
		float resultado = 1;
		int i;
		for(i=1; i<=getOperando2(); i++) {
			resultado = resultado*getOperando1();
		}
		return resultado;
	}
	
	public String verUltimaOperacao() {
		return memoria;
	}
}
