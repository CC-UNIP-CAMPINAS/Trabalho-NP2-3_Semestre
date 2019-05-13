
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
		StringBuilder storage = new StringBuilder();

		for(Curso curso : cursos) {
			storage.append("\n"+curso);
		}
		
		return storage.toString();
	}
	
	public static String listaAlunos() {
		StringBuilder storage = new StringBuilder();

		for(Aluno aluno : alunos) {
			storage.append("\n"+aluno);

		}
		
		return storage.toString();
	}
	
	public static String listaRendimentos() {
		StringBuilder storage = new StringBuilder();
		
		for(Curso curso : cursos) {
			storage.append(curso.toString());
			
			for(Rendimento rendimento : rendimentos) {
				
				if(curso.getNome().equals(rendimento.getCurso().getNome()) ) {
					storage.append(rendimento.toString());
				}
			}
		}
		
		return storage.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder storage = new StringBuilder();
		
		storage.append("\nAlunos");
		storage.append(listaAlunos());
		
		storage.append("\nCursos");
		storage.append(listaCursos());
		
		storage.append("\nRendimentos");
		storage.append(listaRendimentos());
		
		return storage.toString();
	}
}