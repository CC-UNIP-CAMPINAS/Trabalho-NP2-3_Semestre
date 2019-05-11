import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Salvar {
	public static void salvaCurso() {
		File arquivoCurso = new File("cursos.csv");
		
		try(BufferedWriter bwCurso = new BufferedWriter(new FileWriter(arquivoCurso))) {
	
			if(arquivoCurso.exists()) arquivoCurso.delete();
			
			for(Curso curso : Cadastro.cursos) {
				bwCurso.write(curso.getNome() + ";" + curso.getGraduacao() + ";" + curso.getAno() + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void salvaAluno() {
		File arquivoAluno = new File("alunos.csv");
		
		try(BufferedWriter brAluno = new BufferedWriter(new FileWriter(arquivoAluno))) {
			
			if(arquivoAluno.exists()) {
				arquivoAluno.delete();
			}

			for(Aluno aluno : Cadastro.alunos) {
				brAluno.write(aluno.getId() + ";" + aluno.getNome() + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void salvaRendimento() {
		for (Curso curso : Cadastro.cursos) {
			File arquivoRendimento = new File(curso.toNomeArquivo());
			
			try(BufferedWriter bwRendimento = new BufferedWriter(new FileWriter(curso.toNomeArquivo()))) {
				if(arquivoRendimento.exists()) {
					arquivoRendimento.delete();
				}

				for (Rendimento rendimento : Cadastro.rendimentos) {
					if(curso.equals(rendimento.curso)) {
							bwRendimento.write(rendimento.aluno.getId() + ";" + 
								String.valueOf(rendimento.notas.getNotaNP1()) + ";" + 
								String.valueOf(rendimento.notas.getNotaNP2()) + ";" + 
								String.valueOf(rendimento.notas.getReposicao()) + ";" + 
								String.valueOf(rendimento.notas.getExame()) + ";" +
								String.valueOf(rendimento.notas.getMedia()) + ";" +
								String.valueOf(rendimento.getAprovado() + "\n"));
					}
				}			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void salvar() {
		salvaAluno();
		salvaCurso();
		salvaRendimento();
	}
}
