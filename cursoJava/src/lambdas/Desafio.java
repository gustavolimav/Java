package lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {
	
	public static void main(String[] args) {
		Produto p = new Produto("iPad", 3235.89, 0.13);
		
		Function<Produto, Double> valorComDesconto = produto -> produto.preco * (1 - produto.desconto);
		
		Function<Double, Double> imposto = a -> a > 2500 ? a : a * 1.085;
		
		Function<Double, Double> frete = a -> a > 3000 ? a + 50 : a + 100;
		
		Function<Double, String> arredondar = a -> String.format("%.2f", a);
		
		UnaryOperator<String> formatar = a -> String.format("R$ %f", a);
		
		
		String preco = valorComDesconto
				.andThen(imposto)
				.andThen(frete)
				.andThen(arredondar)
				.andThen(formatar)
				.apply(p);
		
		System.out.println(preco);
		

		
		
	}
}
