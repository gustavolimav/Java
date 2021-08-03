package generics;

public class CaixaNumberteste {
	
	public static void main(String[] args) {
		
		CaixaNumber<Double> caixaA = new CaixaNumber<>();
		caixaA.guardar(2.3);
		System.out.println(caixaA.abrir());
		
		CaixaNumber<Integer> caixaB = new CaixaNumber<>();
		caixaB.guardar(2);
		System.out.println(caixaB.abrir());
	}
}
