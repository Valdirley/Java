
public class Calculadora {
	private char operador;
	private float operando1;
	private float operando2;
	
	public Calculadora() {
		operador = ' ';
		operando1 = 0;
		operando2 = 0;
	}
	
	public float calcular(char operador, float op1, float op2) {
		float resultado;
		operando1 = op1;
		operando2 = op2;
		this.operador = operador;
		switch(this.operador) {
			case '+':  resultado = soma(); break;
			case '-':  resultado = subtracao(); break;
			case '*':  resultado = multiplicacao(); break;
			case '/':  resultado = divisao(); break;
			default: resultado = 0;
		}
		return resultado;
	}
	
	private float soma() {
		return operando1+operando2;
	}
	
	private float subtracao() {
		return operando1-operando2;
	}
	
	private float multiplicacao() {
		return operando1*operando2;
	}
	
	private float divisao() {
		if(operando2!=0)
			return operando1/operando2;
		else
			return 0;
	}

	public float getOperando1() {
		return operando1;
	}

	public void setOperando1(float operando1) {
		this.operando1 = operando1;
	}

	public float getOperando2() {
		return operando2;
	}

	public void setOperando2(float operando2) {
		this.operando2 = operando2;
	}
	
	
}
