package execao;

public class basico {
	
	public static void main(String[] args) {
		
		try {
			imprimirAluno(null);
		}
		catch(Exception execao) {
			System.out.println("Errou meu filho");
		}
		
		try {
			System.out.println(7 / 0);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim :)");
		
		
	}
	
	public static void imprimirAluno(Aluno aluno) {
		System.out.println(aluno.nome);
	}
}
