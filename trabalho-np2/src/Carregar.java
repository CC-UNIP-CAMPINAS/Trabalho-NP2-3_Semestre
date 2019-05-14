import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Carregar {
	
	public static void carregaCurso() {
		
		try(Scanner scanner = new Scanner(new File("cursos.csv"))) {
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				Scanner linhaScanner = new Scanner(linha);
				
				linhaScanner.useDelimiter(";");
				Curso curso = new Curso(linhaScanner.next(), 
										linhaScanner.next().equalsIgnoreCase("graduacao"), 
										linhaScanner.nextInt());
				Cadastro.cursos.add(curso);
				
				linhaScanner.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void carregaAluno() {
		try(Scanner scanner = new Scanner(new File("alunos.csv"))) {
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				Scanner linhaScanner = new Scanner(linha);
				
				linhaScanner.useDelimiter(";");
				Aluno aluno = new Aluno(linhaScanner.next(), linhaScanner.next());
				Cadastro.alunos.add(aluno);
				
				linhaScanner.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public static void carregaRendimento() {
		
		String linha = "";
		
		for(Curso curso : Cadastro.cursos) {
			try(BufferedReader brRendimento = new BufferedReader(new FileReader(curso.toNomeArquivo()));) {
				while((linha = brRendimento.readLine()) != null) {	
					String[] linhaRendimento = linha.split(";");				
					Rendimento rendimento = new Rendimento(null, curso, 
							Double.valueOf(linhaRendimento[1]), 
							Double.valueOf(linhaRendimento[2]), 
							Double.valueOf(linhaRendimento[3]), 
							Double.valueOf(linhaRendimento[4]),
							Double.valueOf(linhaRendimento[5]),
							Boolean.parseBoolean(linhaRendimento[6]));

					for (Aluno aluno : Cadastro.alunos) {
						if(aluno.getId().equals(linhaRendimento[0])) {
							rendimento.setAluno(aluno);
						}						
					}
					
					Cadastro.rendimentos.add(rendimento);
				}
				brRendimento.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void carregar() {
		carregaAluno();
		carregaCurso();
		carregaRendimento();
	}
}
