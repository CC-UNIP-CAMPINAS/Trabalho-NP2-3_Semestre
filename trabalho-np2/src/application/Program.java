package application;
import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Rendimento;
import services.Cadastro;
import services.Carregar;
import services.Menu;
import services.Salvar;

public class Program {

	public static void main(String[] args) {
		
        // inicio do Scanner
        Scanner leia = new Scanner(System.in);
 
        // Vari�veis diversas do sistema
        String menu1;
        
        //Carrega o programa na primeira vez
        Carregar.carregar();
        
		// Inicio do menu
        do {
        	Menu.mostraMenu();
                             
//            try {
            	menu1 = leia.next();
                 
                        switch (Integer.parseInt(menu1)) {
                        case 1:
                        	System.out.println(Cadastro.listaCursos());
                            break;
                            
                        case 2:
                        	System.out.println(Cadastro.listaAlunos());
                            break;
                            
                        case 3:
                        	String id;
                        	
                        	System.out.println("Insira um ID: \n");
                            id = leia.next();
                            
                            for(Rendimento rendimento : Cadastro.rendimentos) {
                            	if(rendimento.getAluno().getId().equals(id)) {
                            		System.out.println(rendimento.getAluno());
                            		System.out.println(rendimento.getCurso());
                            		System.out.println(rendimento);
                            	}
                            }
                            break;
                             
                        case 4:
                        	String nome;
                        	int aAno;
                        	boolean nivel;
                        	
                        	System.out.println("Insira o nome do curso: \n");
                            nome = leia.next();
                            System.out.println("Insira o ano: ");
                            aAno = leia.nextInt();
                            System.out.println("Gradua��o (true ou false): ");
                            nivel = leia.nextBoolean();
                            
                            Curso cursoTemp = new Curso(nome, nivel, aAno);
                            
                            for(Rendimento rendimento : Cadastro.rendimentos) {
                            	if(rendimento.getCurso().equals(cursoTemp) ) {
                            		System.out.println(rendimento.getCurso());
                            		System.out.println(rendimento.getAluno());
                            		System.out.println(rendimento);
                            	}
                            }
                        	
                            break;
                            
                        case 5:
                        	id = "";
                            String nomeAluno;
                            	
                            System.out.println("Insira um ID: \n");
                            id = leia.next();
                            	
                            System.out.println("Insira um nome: \n");
                            nomeAluno = leia.next();
                            
                            Aluno novoAluno = new Aluno(id, nomeAluno);
                            
                            if(Cadastro.alunos.contains(novoAluno)) {
                            	System.out.println("ID j� existente");
                            }
                            else {
                                Cadastro.adicionaAluno(novoAluno);                            	
                            }

                            break;

                           
                            
                            
                        case 6:
                        	String nomeCurso;
                        	boolean graduacao;
                        	int ano;
                        	
                        	System.out.println("Insira um nome: \n");
                        	nomeCurso = leia.next();
                        	
                        	System.out.println("Gradua��o (true ou false): \n");
                        	graduacao = leia.nextBoolean();
                        	
                        	System.out.println("Insira um ano: \n");
                        	ano = leia.nextInt();
                        	
                        	Curso novoCurso = new Curso(nomeCurso, graduacao, ano);
                        	
                        	for (Curso curso : Cadastro.cursos) {
								if(curso.equals(novoCurso)) {
									System.out.println("Curso j� existente");
									break;
								}
							}
                        	Cadastro.adicionaCurso(novoCurso);
                        	
                            break;
                            
                        case 7:
                        	System.out.println("Entre com o ID do usu�rio: \n");
                        	String idReposicao = leia.next();
                        	
                        	System.out.println("Entre com o nome do curso: \n");
                        	String nomeReposicao = leia.next();
                        	
                        	System.out.println("Graduacao? true ou false: \n");
                        	boolean nivelReposicao = leia.nextBoolean();
                        	
                        	System.out.println("Entre com o ano do curso: \n");
                        	int anoReposicao = leia.nextInt();
                        	
                        	Aluno alunoBusca = new Aluno(idReposicao, nomeReposicao);
                        	Curso cursoBusca = new Curso(nomeReposicao, nivelReposicao, anoReposicao);
                        	
                        	for(Aluno aluno : Cadastro.alunos) {
                        		if(aluno.equals(alunoBusca))
                        			alunoBusca = aluno;
                        	}
                        	
                        	for(Curso curso : Cadastro.cursos) {
                        		if(curso.equals(cursoBusca))
                        			cursoBusca = curso;
                        	}
                        	
                        	System.out.println("Entre com a nota da NP1: \n");
                        	double np1 = leia.nextDouble();

                        	System.out.println("Entre com a nota da NP2: \n");
                        	double np2 = leia.nextDouble();
                        	
                        	System.out.println("Entre com a nota da reposi��o: \n");
                        	double rep = leia.nextDouble();
                        	
                        	System.out.println("Entre com a nota do exame: \n");
                        	double exame = leia.nextDouble();
                        	
                        	Rendimento novoRendimento = new Rendimento(alunoBusca, cursoBusca, np1, np2, rep, exame);
                        	
                        	Cadastro.adicionaRendimento(novoRendimento);

                        	break;

                            
                        case 8:
                            Salvar.salvar();
                            break;
                        case 0:
                        	break;
                        default: {
                        	System.out.println("Digite um valor v�lido");
                        }
                     }                 
    } while (Integer.parseInt(menu1) != 0 );
        
        leia.close();
	}
}
