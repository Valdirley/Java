
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		CalculadoraMelhorada minhaCalc = new CalculadoraMelhorada();
		
		System.out.println(minhaCalc.calcular('+',2,1));
		System.out.println("Última operação: " + minhaCalc.verUltimaOperacao());

		System.out.println(minhaCalc.calcular(2, 1));
		System.out.println("Última operação: " + minhaCalc.verUltimaOperacao());

		Calculadora c1 = new Calculadora();
		
		System.out.println(c1.calcular('*', 3, 4));
		
	}

}
