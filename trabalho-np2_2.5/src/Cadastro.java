
import java.util.ArrayList;
import java.util.Iterator;

public class Cadastro implements Iterable<Curso> {
	
	static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	static ArrayList<Curso> cursos = new ArrayList<Curso>();
	static ArrayList<Rendimento> rendimentos = new ArrayList<Rendimento>();
	
	public void add(Rendimento rendimento) {
		rendimentos.add(rendimento);
	}
	
	@Override
	public Iterator<Curso> iterator() {
		return  cursos.iterator();
	}
	
	public static String listaCursos() {
		for(Curso curso : cursos) {
			System.out.println(curso);
		}
		
		return null;
	}
	
	public static String listaAlunos() {
		for(Aluno aluno : alunos) {
			System.out.println(aluno);

		}
		
		return null;
	}
	
	public static String listaRendimentos() {
		for(Curso curso : cursos) {
			System.out.println(curso);
			
			for(Rendimento rendimento : rendimentos) {
				
				if(curso.getNome().equals(rendimento.curso.getNome()) ) {
					System.out.println(rendimento);
				}
			}
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		
		listaRendimentos();
		
		System.out.println("CURSOS DADOS: ");
		for(Curso cursos : cursos) {
			System.out.println(cursos.getNome());
		}
		
		
		return ""; 
	}
}