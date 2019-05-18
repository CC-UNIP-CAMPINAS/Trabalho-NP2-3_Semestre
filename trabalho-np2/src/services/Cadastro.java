package services;

import java.util.ArrayList;

import model.Aluno;
import model.Curso;
import model.Rendimento;

public class Cadastro {
	
	public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	public static ArrayList<Curso> cursos = new ArrayList<Curso>();
	public static ArrayList<Rendimento> rendimentos = new ArrayList<Rendimento>();
	
	public static void adicionaAluno(Aluno novoAluno) {
		alunos.add(novoAluno);
	}
	
	public static void adicionaCurso(Curso novoCurso) {
		cursos.add(novoCurso);
	}
	
	public static void adicionaRendimento(Rendimento novoRendimento) {
		rendimentos.add(novoRendimento);
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