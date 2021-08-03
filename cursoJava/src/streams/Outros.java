package streams;

import java.util.Arrays;
import java.util.List;

public class Outros {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana", 8);
		Aluno a2 = new Aluno("Bia", 9);
		Aluno a3 = new Aluno("Caio", 7);
		Aluno a4 = new Aluno("Duda", 10);
		Aluno a5 = new Aluno("Ana", 9.9);
		Aluno a6 = new Aluno("Bia", 9.2);
		Aluno a7 = new Aluno("Caio", 4);
		Aluno a8 = new Aluno("Duda", 4);
		
		List<Aluno> alunos = 
				Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8);
		
		System.out.println("Distinct...");
		alunos.stream().distinct().forEach(System.out::println);
		
		System.out.println("\nSkip/Limit");
		alunos.stream()
		.distinct()
		.skip(2)
		.limit(2)
		.forEach(System.out::println);
		
		System.out.println("\nTakeWhile");
		alunos.stream()
		.distinct()
		.takeWhile(a -> a.nota >= 7)
		.forEach(System.out::println);
		
	}
}
