package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Filter {
	
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana", 7.8);
		Aluno a2 = new Aluno("Bia", 5.8);
		Aluno a3 = new Aluno("Carol", 6.8);
		Aluno a4 = new Aluno("Daniel", 3.8);
		Aluno a5 = new Aluno("Elen", 9.8);
	
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5);
		
		Predicate<Aluno> estaAprovado = a -> a.nota >= 7;
		Function<Aluno, String> saudacaoAprovado = a -> "Parabéns " + a.nome + "! você foi aprovado(a)!";
		
		alunos.stream()
			.filter(estaAprovado)
			.map(saudacaoAprovado)
			.forEach(System.out::println);
	}
}
