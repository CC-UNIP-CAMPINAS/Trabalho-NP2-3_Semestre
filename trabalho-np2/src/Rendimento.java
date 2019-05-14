
public class Rendimento {
	private Aluno aluno;
	private Curso curso;
	public Notas NP1;
	private Notas NP2;
	private Notas exame;
	private Notas reposicao;
	private Notas media;
	private boolean aprovado;
	
	public Rendimento(Aluno aluno, Curso curso, double np1, double np2, double rep, double aExame) {

		this.aluno = aluno;
		this.curso = curso;
		NP1 = new Notas(np1);
		NP2 = new Notas(np2);
		exame = new Notas(aExame);
		reposicao = new Notas(rep);
		media = new Notas(media_cal());
	}
	
	public Rendimento(Aluno aluno, Curso curso, double np1, double np2, double rep, double aExame, double med, boolean aprov) {
		
		this.aluno = aluno;
		this.curso = curso;
		NP1 = new Notas(np1);
		NP2 = new Notas(np2);
		exame = new Notas(aExame);
		reposicao = new Notas(rep);
		media = new Notas(med);
		isAprovado(aprov);
	}
	
	public double getNP1() {
		return NP1.getNota();
	}

	public double getNP2() {
		return NP2.getNota();
	}

	public double getExame() {
		return exame.getNota();
	}

	public double getReposicao() {
		return reposicao.getNota();
	}

	public double getMedia() {
		return media.getNota();
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aAluno) {
		this.aluno = aAluno;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public boolean getAprovado() {
		return this.aprovado;
	}
	
	public void isAprovado(boolean aprov) {
		this.aprovado = aprov;
	}
	
	public double media_cal() {
		double media = (NP1.getNota() + NP2.getNota())/2;
		if(reposicao.getNota() >= NP1.getNota() || reposicao.getNota() >= NP2.getNota()) {
			if(NP1.getNota() >= NP2.getNota()) {
				media = (NP1.getNota() + reposicao.getNota())/2;
				if(curso.getNivel()) {
					if(media >= 7) {
						this.aprovado = true;
						return media;
					}
					else {
						media = (exame.getNota() + media)/2;
						if(media >= 5) {
							this.aprovado = true;
							return media;
						}
						else {
							this.aprovado = false;
							return media;
						}
					}
				}
				else {
					if(media >= 5) {
						this.aprovado = true;
						return media;
					}
					else {
						media = (media + exame.getNota())/2;
						if(media >= 5) {
							this.aprovado = true;
							return 5;
						}
						else {
							this.aprovado = false;
							return media;
						}
					}
				}
			}
			else {
				media = (NP2.getNota() + reposicao.getNota())/2;
				if(curso.getNivel()) {
					if(media >= 7) {
						this.aprovado = true;
						return media;
					}
					else {
						media = (exame.getNota() + media)/2;
						if(media >= 5) {
							this.aprovado = true;
							return media;
						}
						else {
							this.aprovado = false;
							return media;
						}
					}
				}
				else {
					if(media >= 5) {
						this.aprovado = true;
						return media;
					}
					else {
						media = (media + exame.getNota())/2;
						if(media >= 5) {
							this.aprovado = true;
							return 5;
						}
						else {
							this.aprovado = false;
							return media;
						}
					}
				}
			}
		}
		else {
			if(curso.getNivel()) {
				if(media >= 7) {
					this.aprovado = true;
					return media;
				}
				else {
					media = (exame.getNota() + media)/2;
					if(media >= 5) {
						this.aprovado = true;
						return media;
					}
					else {
						this.aprovado = false;
						return media;
					}
				}
			}
			else {
				if(media >= 5) {
					this.aprovado = true;
					return media;
				}
				else {
					media = (media + exame.getNota())/2;
					if(media >= 5) {
						this.aprovado = true;
						return 5;
					}
					else {
						this.aprovado = false;
						return media;
					}
				}
			}
		}
	}
	
	@Override
	public String toString() {
		if(aprovado) { 
			return "NP1: " + NP1.toString() + 
					"\nNP2: " + NP2.toString() + 
					"\nExame: "+ exame.toString() + 
					"\nReposi��o: " + reposicao.toString() + 
					"\nM�dia: " + media.toString() + 
					"\nAprovado: SIM\n";
		}
		else {
			return "NP1: " + NP1.toString() + 
					"\nNP2: " + NP2.toString() + 
					"\nExame: "+ exame.toString() + 
					"\nReposi��o: " + reposicao.toString() + 
					"\nM�dia: " + media.toString() + 
					"\nAprovado: N�O\n";
			}
		}
}
