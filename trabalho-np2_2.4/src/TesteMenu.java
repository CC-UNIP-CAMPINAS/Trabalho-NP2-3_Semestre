import java.util.Scanner;

public class TesteMenu {
	
	class Menu1{
		public static final int LISTAR_CURSOS = 1;
		public static final int LISTAR_ALUNOS = 2;
	}
	
	
	
	
    static enum Menu{LISTAR_CURSOS, LISTAR_ALUNOS};
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Cadastro cadastro1 = new Cadastro();
		
        // inicio do Scanner
        Scanner leia = new Scanner(System.in);
 
        // Variáveis diversas do sistema
        String menu1;
        
		// Inicio do menu
        do {
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
            System.out.println("9 - Carregar");
            System.out.println("Ou digite 0 para encerrar o programa");
                             
//            try {
            	menu1 = leia.next();
                 
                        switch (Integer.parseInt(menu1)) {
                        case 1:
                        	cadastro1.getHistorico().listaCursos();
                            break;
                        case 2:
                        	cadastro1.getHistorico().listaAlunos();
                            break;
                            
                        case 3:
                        	String id;
                        	
                        	System.out.println("Insira um ID: \n");
                            id = leia.next();
                            
                            for(Rendimento rendimento : cadastro1.getHistorico().rendimentos) {
                            	if(rendimento.aluno.getId().equals(id)) {
                            		rendimento.aluno.toString();
                            		rendimento.curso.toString();
                            		rendimento.toString();
                            	}
                            }
                            break;
                             
                        case 4:
                        	String nome;
                        	
                        	System.out.println("Insira o nome do curso: \n");
                            nome = leia.next();
                       
                            for(Rendimento rendimento : cadastro1.getHistorico().rendimentos) {
                            	if(rendimento.curso.getNome().equals(nome)) {
                            		rendimento.curso.toString();
                            		rendimento.aluno.toString();
                            		rendimento.toString();
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
                            	
                            cadastro1.cadastraAluno(new Aluno(id, nomeAluno));
                            break;
                            
                        case 6:
                        	String nomeCurso;
                        	boolean graduacao;
                        	int ano;
                        	
                        	System.out.println("Insira um nome: \n");
                        	nomeCurso = leia.next();
                        	
                        	System.out.println("Graduação (true ou false): \n");
                        	graduacao = leia.nextBoolean();
                        	
                        	System.out.println("Insira um ano: \n");
                        	ano = leia.nextInt();
                        	
                        	cadastro1.cadastraCurso(new Curso(nomeCurso, graduacao, ano));
                        	
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
                        	
                        	
                        	System.out.println("Entre com o ID do usuário: \n");
                        	idReposicao = leia.next();
                        	
                        	System.out.println("Entre com o nome do curso: \n");
                        	nomeReposicao = leia.next();
                        	
                        	System.out.println("Graduacao? true ou false: \n");
                        	nivelReposicao = leia.nextBoolean();
                        	
                        	System.out.println("Entre com o ano do curso: \n");
                        	anoReposicao = leia.nextInt();
                        	
                        	Curso cursoBusca = new Curso(nomeReposicao, nivelReposicao, anoReposicao);
                        	
                        	for(Aluno aluno : cadastro1.getHistorico().alunos) {
                        		if(aluno.getId().equals(String.valueOf(idReposicao))) {
                        			alunoBusca = aluno;
                        		}
                        	}
                        	
                        	for(Curso curso : cadastro1.getHistorico().cursos) {
                        		if(curso.equals(cursoBusca)) {
                        			cursoBusca = curso;
                        		}
                        	}
                        	
                        	System.out.println("Entre com a nota da NP1: \n");
                        	np1 = leia.nextDouble();

                        	System.out.println("Entre com a nota da NP2: \n");
                        	np2 = leia.nextDouble();
                        	
                        	System.out.println("Entre com a nota da reposição: \n");
                        	rep = leia.nextDouble();
                        	
                        	System.out.println("Entre com a nota do exame: \n");
                        	exame = leia.nextDouble();
                        	
                        	cadastro1.getHistorico().rendimentos.add(new Rendimento(alunoBusca, cursoBusca, np1, np2, rep, exame));
                        	break;

                            
                        case 8:
                            Salvar.salvar();
                            break;
                            
                        case 9:
                        	Carregar.carregar();
                            break;
 
                    }                 
         
    } while (Integer.parseInt(menu1) != 0 );
        
        leia.close();
	}
}
