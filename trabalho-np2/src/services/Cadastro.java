package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import model.Aluno;
import model.Curso;
import model.Rendimento;

public class Cadastro {
	
	public static List<Aluno> alunos = new ArrayList<Aluno>();
	public static List<Curso> cursos = new ArrayList<Curso>();
	public static List<Rendimento> rendimentos = new ArrayList<Rendimento>();
	public static Map<String, Aluno> idParaAluno = new HashMap<>();
	
	public static void adicionaAluno(Aluno novoAluno) {
		alunos.add(novoAluno);
		idParaAluno.put(novoAluno.getId(), novoAluno);
	}
	
	public static void adicionaCurso(Curso novoCurso) {
		cursos.add(novoCurso);
	}
	
	public static void adicionaRendimento(Rendimento novoRendimento) {
		rendimentos.add(novoRendimento);
	}
	
	public static Aluno buscaAluno(String id) {
		if(!idParaAluno.containsKey(id))
			throw new NoSuchElementException();
		return idParaAluno.get(id);
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
}