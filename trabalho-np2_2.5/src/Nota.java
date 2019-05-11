
public class Nota {
	
	private double notaNP1;
	private double notaNP2;
	private double reposicao;
	private double exame;
	private double media;
	
	public double getNotaNP1() {
		return notaNP1;
	}

	public void setNotaNP1(double notaNP1) {
		this.notaNP1 = notaNP1;
	}

	public double getNotaNP2() {
		return notaNP2;
	}

	public void setNotaNP2(double notaNP2) {
		this.notaNP2 = notaNP2;
	}

	public double getReposicao() {
		return reposicao;
	}

	public void setReposicao(double reposicao) {
		this.reposicao = reposicao;
	}

	public double getExame() {
		return exame;
	}

	public void setExame(double exame) {
		this.exame = exame;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
	
	@Override
	public String toString() {
		System.out.println(getNotaNP1());
		System.out.println(getNotaNP2());
		System.out.println(getExame());
		System.out.println(getReposicao());
		
		
		return null;
	}
}
