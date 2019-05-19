package services;

import java.util.NoSuchElementException;
import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Rendimento;


public class Menu {
	
	enum Escolha{
		SAIR,
		LISTA_CURSO,
		LISTA_ALUNOS,
		LISTA_HISTORICO,
		LISTA_RELATORIO,
		INCLUIR_ALUNO,
		INCLUIR_CURSO,
		INCLUIR_RENDIMENTO,
		SALVAR;
	}

	public static void mostraMenu() {
		System.out.println();
		System.out.println("\nEscolha uma opção a seguir:");
		System.out.println("1 - Listar todos os cursos dados");
		System.out.println("2 - Listar todos os alunos inscritos");
		System.out.println("3 - Listar o histórico de um determinado aluno");
		System.out.println("4 - Listar o relatório de rendimento de cada curso");
		System.out.println("5 - Incluir um novo aluno");
		System.out.println("6 - Incluir um novo curso");
		System.out.println("7 - Incluir um novo rendimento");
		System.out.println("8 - Salvar");
		System.out.println("Ou digite 0 para encerrar o programa");
	}

	public static void escolheMenu() {
		
		int escolha = 0;
		
		Scanner leia = new Scanner(System.in);
			do {
				try {
				mostraMenu();
				
				while (!leia.hasNextInt()) {
					String input = leia.next();
					System.out.printf("%s não é um número válido.\n", input);
					mostraMenu();
				}
				escolha = leia.nextInt();
				Escolha opcoes = Escolha.values()[escolha];
				switch (opcoes) {
					case LISTA_CURSO:
						System.out.println(Cadastro.listaCursos());
						break;
	
					case LISTA_ALUNOS:
						System.out.println(Cadastro.listaAlunos());
						System.out.println("sad");
						break;
	
					case LISTA_HISTORICO:
						String id;
	
						System.out.println("Insira um ID: \n");
						id = leia.next();
	
						Aluno alunoBuscado = Cadastro.buscaAluno(id);
	
						Cadastro.rendimentos.forEach(rendimento -> {
							if (rendimento.getAluno().equals(alunoBuscado)) {
								System.out.println(rendimento);
							}
						});
						break;
	
					case LISTA_RELATORIO:
						String nome;
						int aAno;
						boolean nivel;
	
						System.out.println("Insira o nome do curso: \n");
						nome = leia.next();
						
						System.out.println("Insira o ano: ");
						if(!leia.hasNextInt()) {
							String input = leia.next();
							throw new NoSuchElementException(input + " não é um numero válido\n");
						}
						aAno = leia.nextInt();
						
						System.out.println("Graduação (true ou false): ");									
						if(!leia.hasNextBoolean()) {
							String input = leia.next();
							throw new NoSuchElementException(input + " não é um boolean válido\n");
						}
						nivel = leia.nextBoolean();
	
						Curso cursoTemp = new Curso(nome, nivel, aAno);
	
						for (Rendimento rendimento : Cadastro.rendimentos) {
							if (rendimento.getCurso().equals(cursoTemp)) {
								System.out.println(rendimento.getCurso());
								System.out.println(rendimento.getAluno());
								System.out.println(rendimento);
							}
						}
	
						break;
	
					case INCLUIR_ALUNO:
						id = "";
						String nomeAluno;
	
						System.out.println("Insira um ID: \n");
						id = leia.next();
	
						System.out.println("Insira um nome: \n");
						nomeAluno = leia.next();
	
						Aluno novoAluno = new Aluno(id, nomeAluno);
	
						if (Cadastro.alunos.contains(novoAluno)) {
							System.out.println("ID já existente");
						} else {
							Cadastro.adicionaAluno(novoAluno);
						}
	
						break;
	
					case INCLUIR_CURSO:
						String nomeCurso;
						boolean graduacao;
						int ano;
	
						System.out.println("Insira um nome: \n");
						nomeCurso = leia.next();
	
						System.out.println("Graduação (true ou false): \n");
						if(!leia.hasNextBoolean()) {
							String input = leia.next();
							throw new NoSuchElementException(input + " não é um boolean válido\n");
						}
						graduacao = leia.nextBoolean();
	
						System.out.println("Insira um ano: \n");
						if(!leia.hasNextInt()) {
							String input = leia.next();
							throw new NoSuchElementException(input + " não é um numero válido\n");
						}
						ano = leia.nextInt();
	
						Curso novoCurso = new Curso(nomeCurso, graduacao, ano);
	
						for (Curso curso : Cadastro.cursos) {
							if (curso.equals(novoCurso)) {
								System.out.println("Curso já existente");
								break;
							}
						}
						Cadastro.adicionaCurso(novoCurso);
	
						break;
	
					case INCLUIR_RENDIMENTO:
						
						System.out.println("Entre com o ID do usuário: \n");
						String idReposicao = leia.next();
	
						Cadastro.buscaAluno(idReposicao);
						
						System.out.println("Entre com o nome do curso: \n");
						String nomeReposicao = leia.next();						
	
						Aluno alunoBusca = new Aluno(idReposicao, nomeReposicao);
						
						
						System.out.println("Graduacao? true ou false: \n");
					
						boolean nivelReposicao;		
						
						while(!leia.hasNextBoolean()) {
							String input = leia.next();
							System.out.printf("%s não é um boolean válido\n", input);
						}
						nivelReposicao = leia.nextBoolean();
	
						System.out.println("Entre com o ano do curso: \n");
						int anoReposicao = leia.nextInt();
	
						
						Curso cursoBusca = new Curso(nomeReposicao, nivelReposicao, anoReposicao);
						
						
	
						for (Curso curso : Cadastro.cursos) {
							if (curso.equals(cursoBusca))
								cursoBusca = curso;
						}
	
						System.out.println("Entre com a nota da NP1: \n");
						double np1 = leia.nextDouble();
	
						System.out.println("Entre com a nota da NP2: \n");
						double np2 = leia.nextDouble();
	
						System.out.println("Entre com a nota da reposição: \n");
						double rep = leia.nextDouble();
	
						System.out.println("Entre com a nota do exame: \n");
						double exame = leia.nextDouble();
	
						Rendimento novoRendimento = new Rendimento(alunoBusca, cursoBusca, np1, np2, rep, exame);
	
						Cadastro.adicionaRendimento(novoRendimento);
						break;
	
					case SALVAR:
						Salvar.salvar();
						break;
					case SAIR:
						break;
					default: {
						System.out.println("Digite um valor válido");
					}
				}
			}catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
				
		}  while (escolha != 0);
			leia.close();
	}
}
