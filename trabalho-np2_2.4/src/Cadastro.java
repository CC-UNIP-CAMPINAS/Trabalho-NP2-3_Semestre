
public class Cadastro {
	
	private Historico historico = new Historico();
	
	@SuppressWarnings("static-access")
	public void cadastraAluno(Aluno aluno) {
		this.historico.alunos.add(aluno);
	}
	
	@SuppressWarnings("static-access")
	public void cadastraCurso(Curso curso) {
		this.historico.cursos.add(curso);
	}
	
	@SuppressWarnings("static-access")
	public void adicionaCurso(Aluno aluno, Curso curso) {
		this.historico.rendimentos.add(new Rendimento(aluno, curso));
	}
	
	public Historico getHistorico() {
		return historico;
		
	}
	
	/*
	private Aluno aluno;
	private Historico historico;
	
	public Cadastro(String aId, String aNome) {
		aluno = new Aluno(aId, aNome);
		historico = new Historico();
		
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	
	
	public void add(Curso curso, double np1, double np2, double reposicao, double exame) {
		this.historico.cursos.add(curso);
		adicionaCursoDados(curso);
		this.historico.rendimentos.add(new Rendimento(this.aluno, curso, np1, np2, reposicao, exame));
	}
	
	public void add(Curso curso) {
		this.historico.cursos.add(curso);
		adicionaCursoDados(curso);
		this.historico.rendimentos.add(new Rendimento(this.aluno, curso));
	}
	
	public void adicionaCursoDados(Curso curso) {
		if(!(this.historico.cursosDados.contains(curso))) {
			this.historico.cursosDados.add(curso);
		}
	}
	
	@Override
	public String toString() {
		this.aluno.toString();
		this.historico.toString();
		System.out.print("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");//Adicionei para diferenciar cada teste
		return "";
	}
	*/
}
