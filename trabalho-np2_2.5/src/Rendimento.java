
public class Rendimento {
	public Aluno aluno;
	public Curso curso;
	
	public Notas notas;
	
	
	
	private boolean aprovado;
	
	public Rendimento() {
		
	}
	
	public Rendimento(Aluno aluno, Curso curso) {
		this.aluno = aluno;
		this.curso = curso;
	}
	
	public Rendimento(Aluno aluno, Curso curso, double np1, double np2, double rep, double exame) {
		notas = new Notas();
		
		this.aluno = aluno;
		this.curso = curso;
		this.notas.setNotaNP1(np1);
		this.notas.setNotaNP2(np2);
		this.notas.setReposicao(rep);
		this.notas.setExame(exame);
		this.notas.setMedia(media_cal());
	}
	
	public Rendimento(Aluno aluno, Curso curso, double np1, double np2, double rep, double exame, double med, boolean aprov) {
		notas = new Notas();
		
		this.aluno = aluno;
		this.curso = curso;
		this.notas.setNotaNP1(np1);
		this.notas.setNotaNP2(np2);
		this.notas.setReposicao(rep);
		this.notas.setExame(exame);
		this.notas.setMedia(med);
		isAprovado(aprov);
	}
	
	public Aluno getAluno() {
		return aluno;
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
		double media = (notas.getNotaNP1() + notas.getNotaNP2())/2;
		if(notas.getReposicao() >= notas.getNotaNP1() || notas.getReposicao() >= notas.getNotaNP2()) {
			if(notas.getNotaNP1() >= notas.getNotaNP2()) {
				media = (notas.getNotaNP1() + notas.getReposicao())/2;
				if(curso.getNivel()) {
					if(media >= 7) {
						this.aprovado = true;
						return media;
					}
					else {
						media = (notas.getExame() + media)/2;
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
						media = (media + notas.getExame())/2;
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
				media = (notas.getNotaNP2() + notas.getReposicao())/2;
				if(curso.getNivel()) {
					if(media >= 7) {
						this.aprovado = true;
						return media;
					}
					else {
						media = (notas.getExame() + media)/2;
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
						media = (media + notas.getExame())/2;
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
					media = (notas.getExame() + media)/2;
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
					media = (media + notas.getExame())/2;
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
		
		notas.toString();
			
		if(aprovado) System.out.println("Aprovado: SIM\n");
		else System.out.println("Aprovado: NÃO\n");
		return "";
	}
}
