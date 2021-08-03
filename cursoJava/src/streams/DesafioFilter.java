package streams;

import java.util.Arrays;
import java.util.List;

public class DesafioFilter {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("Ana", 7.8);
		Aluno a2 = new Aluno("Bia", 5.8);
		Aluno a3 = new Aluno("Carol", 6.8);
		Aluno a4 = new Aluno("Daniel", 3.8);
		Aluno a5 = new Aluno("Elen", 9.8);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5);
		
		alunos.stream()
			.filter(a -> a.nome.contains("Da"))
			.map(a -> a.nome)
			.forEach(System.out::println);
	}
}
