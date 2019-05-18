package services;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Rendimento;

public class Carregar {
	
	public static void carregaCurso() {
		String caminho = System.getProperty("user.dir");
		caminho += File.separator + "src";
		caminho += File.separator + "dao";
		caminho += File.separator + "cursos.csv";
		
		try(Scanner scanner = new Scanner(new File(caminho))) {
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				Scanner linhaScanner = new Scanner(linha);
				
				linhaScanner.useDelimiter(";");
				Curso curso = new Curso(linhaScanner.next(), 
										linhaScanner.next().equalsIgnoreCase("graduacao"), 
										linhaScanner.nextInt());
				Cadastro.adicionaCurso(curso);
				
				linhaScanner.close();
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao carregar os cursos: " + e.getMessage()); 
		}
	}
	
	public static void carregaAluno() {
		String caminho = System.getProperty("user.dir");
		caminho += File.separator + "src";
		caminho += File.separator + "dao";
		caminho += File.separator + "alunos.csv";
		try(Scanner scanner = new Scanner(new File(caminho))) {
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				Scanner linhaScanner = new Scanner(linha);
				
				linhaScanner.useDelimiter(";");
				Aluno aluno = new Aluno(linhaScanner.next(), linhaScanner.next());
				Cadastro.adicionaAluno(aluno);
				
				linhaScanner.close();
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao carregar os alunos: " + e.getMessage()); 
		}
	}
	
public static void carregaRendimento() {
		
		String linha = "";
		
		for(Curso curso : Cadastro.cursos) {
			String caminho = System.getProperty("user.dir");
			caminho += File.separator + "src";
			caminho += File.separator + "dao";
			caminho += File.separator + curso.toNomeArquivo();
			
			try(BufferedReader brRendimento = new BufferedReader(new FileReader(caminho));) {
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
					Cadastro.adicionaRendimento(rendimento);
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
