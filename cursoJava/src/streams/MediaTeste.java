package streams;

public class MediaTeste {
	public static void main(String[] args) {
		
		Media m1 = new Media().adicionar(9).adicionar(3);
		
		Media m2 = new Media().adicionar(9).adicionar(8);

		
		System.out.println(m1.getValor());
		System.out.println(m2.getValor());
		
		System.out.println(Media.combinar(m1, m2).getValor());

	}
}
