package model;
public class Rendimento {
	private Aluno aluno;
	private Curso curso;
	private Notas np1;
	private Notas np2;
	private Notas exame;
	private Notas reposicao;
	private Notas media;
	private boolean aprovado;
	
	public Rendimento(Aluno aluno, Curso curso, double np1, double np2, double rep, double aExame) {

		this.aluno = aluno;
		this.curso = curso;
		this.np1 = new Notas(np1);
		this.np2 = new Notas(np2);
		exame = new Notas(aExame);
		reposicao = new Notas(rep);
		media = new Notas(calculaMedia());
	}
	
	public Rendimento(Aluno aluno, Curso curso, double np1, double np2, double rep, double aExame, double med, boolean aprov) {
		
		this.aluno = aluno;
		this.curso = curso;
		this.np1 = new Notas(np1);
		this.np2 = new Notas(np2);
		exame = new Notas(aExame);
		reposicao = new Notas(rep);
		media = new Notas(med);
		isAprovado(aprov);
	}
	
	public double getNP1() {
		return np1.getNota();
	}

	public double getNP2() {
		return np2.getNota();
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
	
	public double calculaMedia() {
		double media = (np1.getNota() + np2.getNota())/2;
		if(reposicao.getNota() >= np1.getNota() || reposicao.getNota() >= np2.getNota()) {
			if(np1.getNota() >= np2.getNota()) {
				media = (np1.getNota() + reposicao.getNota())/2.0;
				if(curso.getNivel()) {
					if(media >= 7.0) {
						this.aprovado = true;
						return media;
					}
					else {
						media = (exame.getNota() + media)/2;
						if(media >= 5.0) {
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
					if(media >= 5.0) {
						this.aprovado = true;
						return media;
					}
					else {
						media = (media + exame.getNota())/2.0;
						if(media >= 5.0) {
							this.aprovado = true;
							return 5.0;
						}
						else {
							this.aprovado = false;
							return media;
						}
					}
				}
			}
			else {
				media = (np2.getNota() + reposicao.getNota())/2.0;
				if(curso.getNivel()) {
					if(media >= 7.0) {
						this.aprovado = true;
						return media;
					}
					else {
						media = (exame.getNota() + media)/2.0;
						if(media >= 5.0) {
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
					if(media >= 5.0) {
						this.aprovado = true;
						return media;
					}
					else {
						media = (media + exame.getNota())/2.0;
						if(media >= 5.0) {
							this.aprovado = true;
							return 5.0;
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
				if(media >= 7.0) {
					this.aprovado = true;
					return media;
				}
				else {
					media = (exame.getNota() + media)/2.0;
					if(media >= 5.0) {
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
				if(media >= 5.0) {
					this.aprovado = true;
					return media;
				}
				else {
					media = (media + exame.getNota())/2.0;
					if(media >= 5.0) {
						this.aprovado = true;
						return 5.0;
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
		
		return "NP1: " + this.np1 +
			   "\nNP2: " + this.np2 +
			   "\nExame: "+ this.exame +  	
			   "\nReposição: " + this.reposicao + 
			   "\nMédia: " + this.media +
			   "\n" + ((this.aprovado) ? "Aprovado: SIM\n" : "Aprovado: NÃO\n");
	}
}

