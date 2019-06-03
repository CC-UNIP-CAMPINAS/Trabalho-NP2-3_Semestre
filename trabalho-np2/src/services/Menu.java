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
		System.out.println("\n=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=\n");
		System.out.println("Escolha uma opção a seguir:");
		System.out.println("1 - Listar todos os cursos dados");
		System.out.println("2 - Listar todos os alunos inscritos");
		System.out.println("3 - Listar o histórico de um determinado aluno");
		System.out.println("4 - Listar o relatório de rendimento de cada curso");
		System.out.println("5 - Incluir um novo aluno");
		System.out.println("6 - Incluir um novo curso");
		System.out.println("7 - Incluir um novo rendimento");
		System.out.println("8 - Salvar");
		System.out.println("Ou digite 0 para encerrar o programa");
		System.out.print("\nOpção: ");
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
				while(escolha<0 || escolha>9) {
					System.out.println("\n"+escolha +" não é uma opção válida!!\n");
					mostraMenu();
					escolha = leia.nextInt();
				}
				Escolha opcoes = Escolha.values()[escolha];
				switch (opcoes) {
					case LISTA_CURSO:
						System.out.println(Cadastro.listaCursos());
						System.out.print("\nDeseja voltar ao menu? 1=Sim 0=Não: ");
						escolha = leia.nextInt();
						break;
	
					case LISTA_ALUNOS:
						System.out.println(Cadastro.listaAlunos());
						System.out.print("\nDeseja voltar ao menu? 1=Sim 0=Não: ");
						escolha = leia.nextInt();
						break;
	
					case LISTA_HISTORICO:
						String id;
	
						System.out.print("Insira um ID: ");
						id = leia.next();
	
						Aluno alunoBuscado = Cadastro.buscaAluno(id);
						System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
						System.out.println(alunoBuscado+"\n");
						System.out.println("Cursos feitos: \n");
						
						Cadastro.rendimentos.forEach(rendimento -> {
							if (rendimento.getAluno().equals(alunoBuscado)) {
								System.out.println(rendimento.getCurso()+"\n");
								System.out.println(rendimento);
							}
						});
						System.out.print("Deseja voltar ao menu? 1=Sim 0=Não: ");
						escolha = leia.nextInt();
						break;
	
					case LISTA_RELATORIO:
						String nome;
						int aAno;
						boolean nivel;
	
						System.out.print("Insira o nome do curso: " + leia.nextLine());
						nome = leia.nextLine
								();
						
						System.out.print("Insira o ano: ");
						if(!leia.hasNextInt()) {
							String input = leia.next();
							throw new NoSuchElementException(input + " não é um numero válido\n");
						}
						aAno = leia.nextInt();
						
						System.out.print("Graduação (true ou false): ");									
						if(!leia.hasNextBoolean()) {
							String input = leia.next();
							throw new NoSuchElementException(input + " não é um boolean válido\n");
						}
						nivel = leia.nextBoolean();
	
						Curso cursoTemp = new Curso(nome, nivel, aAno);
						
						System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
						System.out.println(cursoTemp + "\n");
						System.out.println("Alunos que fizeram o curso: \n");
						
						for (Rendimento rendimento : Cadastro.rendimentos) {
							if (rendimento.getCurso().equals(cursoTemp)) {
								System.out.println(rendimento.getAluno()+"\n");
								System.out.println(rendimento);
							}
						}
						System.out.print("Deseja voltar ao menu? 1=Sim 0=Não: ");
						escolha = leia.nextInt();
						break;
	
					case INCLUIR_ALUNO:
						id = "";
						String nomeAluno = "";
						
						System.out.print("Insira um ID: ");
						id = leia.next();
						System.out.print("Insira um nome: " +leia.nextLine());
						nomeAluno = leia.nextLine();
						
						
	
						Aluno novoAluno = new Aluno(id, nomeAluno);
	
						if (Cadastro.alunos.contains(novoAluno)) {
							System.out.println("\nID já existente");
						} else {
							Cadastro.adicionaAluno(novoAluno);
							System.out.println("\nAluno criado com sucesso!!\n");
						}
						System.out.print("\nDeseja voltar ao menu? 1=Sim 0=Não: ");
						escolha = leia.nextInt();
						break;
	
					case INCLUIR_CURSO:
						String nomeCurso = "";
						boolean graduacao;
						int ano;
	
						System.out.print("Insira um nome: " + leia.nextLine());
						nomeCurso = leia.nextLine();
	
						System.out.print("Graduação (true ou false): ");
						if(!leia.hasNextBoolean()) {
							String input = leia.next();
							throw new NoSuchElementException(input + " não é um boolean válido\n");
						}
						graduacao = leia.nextBoolean();
	
						System.out.print("Insira um ano: ");
						if(!leia.hasNextInt()) {
							String input = leia.next();
							throw new NoSuchElementException(input + " não é um numero válido\n");
						}
						ano = leia.nextInt();
	
						Curso novoCurso = new Curso(nomeCurso, graduacao, ano);
	
						for (Curso curso : Cadastro.cursos) {
							if (curso.equals(novoCurso)) {
								System.out.println("\nCurso já existente");
								break;
							}
						}
						Cadastro.adicionaCurso(novoCurso);
						
						System.out.print("\nDeseja voltar ao menu? 1=Sim 0=Não: ");
						escolha = leia.nextInt();
						break;
	
					case INCLUIR_RENDIMENTO:
						
						System.out.print("Entre com o ID do usuário: ");
						String idReposicao = leia.next();
	
						Cadastro.buscaAluno(idReposicao);
						
						System.out.print("Entre com o nome do curso: " + leia.nextLine());
						String nomeReposicao = leia.nextLine();						
						
						
						System.out.print("Graduacao? true ou false: ");
					
						boolean nivelReposicao;		
						
						while(!leia.hasNextBoolean()) {
							String input = leia.next();
							System.out.printf("%s não é um boolean válido\n", input);
						}
						nivelReposicao = leia.nextBoolean();
	
						System.out.print("Entre com o ano do curso: ");
						int anoReposicao = leia.nextInt();
	
						
						Curso cursoBusca = new Curso(nomeReposicao, nivelReposicao, anoReposicao);
						
						
	
	
						System.out.print("Entre com a nota da NP1: ");
						double np1 = leia.nextDouble();
	
						System.out.print("Entre com a nota da NP2: ");
						double np2 = leia.nextDouble();
	
						System.out.print("Entre com a nota da reposição: ");
						double rep = leia.nextDouble();
	
						System.out.print("Entre com a nota do exame: ");
						double exame = leia.nextDouble();
						
						Rendimento novoRendimento = new Rendimento(Cadastro.buscaAluno(idReposicao), cursoBusca, np1, np2, rep, exame);
						if (Cadastro.rendimentos.contains(novoRendimento) || !(Cadastro.cursos.contains(cursoBusca))) {
							System.out.println("\nRendimento já existente ou o curso não existe!!");
						} else {
							Cadastro.adicionaRendimento(novoRendimento);
							System.out.println("\nRendimento criado com sucesso!!\n");
						}
						
						System.out.print("\nDeseja voltar ao menu? 1=Sim 0=Não: ");
						escolha = leia.nextInt();
						break;
	
					case SALVAR:
						Salvar.salvar();
						System.out.println("\nArquivos salvos com sucesso!!\n");
						break;
					case SAIR:
						System.out.println("\nPrograma encerrado!!");
						break;
					default:
						System.out.println("Número errado");
						break;
				
				}
			}catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
				
		}  while (escolha != 0);
			leia.close();
	}
}
