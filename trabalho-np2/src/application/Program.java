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
                            	
                            Cadastro.alunos.add(new Aluno(id, nomeAluno));
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
                        	
                        	Cadastro.cursos.add(new Curso(nomeCurso, graduacao, ano));
                        	
                            break;
                            
                        case 7:
                        	
                        	String idReposicao;
                        	String nomeReposicao;
                        	boolean nivelReposicao;
                        	int anoReposicao;
                        	
                        	Aluno alunoBusca = null;
                        	
                        	double np1;
                        	double np2;
                        	double rep;
                        	double exame;
                        	
                        	
                        	System.out.println("Entre com o ID do usu�rio: \n");
                        	idReposicao = leia.next();
                        	
                        	System.out.println("Entre com o nome do curso: \n");
                        	nomeReposicao = leia.next();
                        	
                        	System.out.println("Graduacao? true ou false: \n");
                        	nivelReposicao = leia.nextBoolean();
                        	
                        	System.out.println("Entre com o ano do curso: \n");
                        	anoReposicao = leia.nextInt();
                        	
                        	Curso cursoBusca = new Curso(nomeReposicao, nivelReposicao, anoReposicao);
                        	
                        	for(Aluno aluno : Cadastro.alunos) {
                        		if(aluno.getId().equals(String.valueOf(idReposicao))) {
                        			alunoBusca = aluno;
                        		}
                        	}
                        	
                        	for(Curso curso : Cadastro.cursos) {
                        		if(curso.equals(cursoBusca)) {
                        			cursoBusca = curso;
                        		}
                        	}
                        	
                        	System.out.println("Entre com a nota da NP1: \n");
                        	np1 = leia.nextDouble();

                        	System.out.println("Entre com a nota da NP2: \n");
                        	np2 = leia.nextDouble();
                        	
                        	System.out.println("Entre com a nota da reposi��o: \n");
                        	rep = leia.nextDouble();
                        	
                        	System.out.println("Entre com a nota do exame: \n");
                        	exame = leia.nextDouble();
                        	
                        	Cadastro.rendimentos.add(new Rendimento(alunoBusca, cursoBusca, np1, np2, rep, exame));
                        	break;

                            
                        case 8:
                            Salvar.salvar();
                            break;
                            
                        default: {
                        	System.out.println("Digite um valor v�lido");
                        }
                     }                 
    } while (Integer.parseInt(menu1) != 0 );
        
        leia.close();
	}
}
