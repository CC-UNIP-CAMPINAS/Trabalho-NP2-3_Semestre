
public class Curso {

	private String nome;
	private boolean graduacao;
	int ano;
	
	public Curso (String aNome, boolean aGraduacao, int aAno) {
		nome = aNome;
		graduacao = aGraduacao;
		ano = aAno;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	public boolean getNivel() {
		return graduacao;
	}
	
	public String getGraduacao() {
		if(graduacao) {
			return "graduacao";
		}
		else {
			return "pos_graduacao";
		}
	}
	
	public String toNomeArquivo() {
		return this.nome + "_" + ((graduacao)?"GRADUACAO":"POS_GRADUACAO") + "_" + String.valueOf(ano)  + ".csv";
	}
	
	@Override
	public String toString() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("Nivel: " + this.getGraduacao());
		System.out.println("Ano: " + this.getAno());
		System.out.println();
		return "";
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o == this) return true;
		
		if(!(o instanceof Curso)) return false;
		
		Curso c = (Curso) o;
		
		return nome.equals(c.nome) 
				&& Boolean.compare(graduacao, c.graduacao) == 0
				&& Integer.compare(ano, c.ano) == 0;
	}
}
