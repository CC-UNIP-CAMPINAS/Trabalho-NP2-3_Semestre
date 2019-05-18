package model;

public class Curso {

	private String nome;
	private boolean nivel;
	int ano;
	
	public Curso (String aNome, boolean aGraduacao, int aAno) {
		nome = aNome;
		nivel = aGraduacao;
		ano = aAno;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getAno() {
		return ano;
	}
	
	public boolean getNivel() {
		return nivel;
	}
	
	public String getGraduacao() {
		if(nivel) {
			return "graduacao";
		}
		else {
			return "pos_graduacao";
		}
	}
	public String tipoGraduacao() {
		if(nivel) {
			return "Graduação";
		}
		else {
			return "Pós Graduação";
		}
	}
	
	public boolean verificaNome(String nome) {
		if(this.nome == nome) return true;
		
		return false;
	}
	
	public String toNomeArquivo() {
		return this.nome + "_" + ((nivel)?"GRADUACAO":"POS_GRADUACAO") + "_" + String.valueOf(ano)  + ".csv";
	}
	
	@Override
	public String toString() {
		return "\nNome: " + this.getNome() + 
			   "\nNivel: " + this.tipoGraduacao() + 
			   "\nAno: " + this.getAno();
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o == this) return true;
		
		if(!(o instanceof Curso)) return false;
		
		Curso c = (Curso) o;
		
		return nome.equals(c.nome) 
				&& Boolean.compare(nivel, c.nivel) == 0
				&& Integer.compare(ano, c.ano) == 0;
	}
	
	@Override
	public int hashCode() {
		int ret = 0;
		
		for(int i = 0; i < nome.length(); i++)
		{
			ret += nome.codePointAt(i);
		}
		
		ret += Integer.hashCode(ano);
		
		return ret;
		
	}
}
