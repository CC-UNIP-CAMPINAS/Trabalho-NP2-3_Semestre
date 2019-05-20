package model;

public class Aluno {
	
	private String id;
	private String nome;
	
	public Aluno(String aId, String aNome) {
		this.id = aId;
		this.nome = aNome;
	}
	
	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return "Nome aluno: " + this.nome + 
			   "\nID aluno: " + this.id;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o == this) return true;
		
		if(!(o instanceof Aluno)) return false;
		
		Aluno a = (Aluno) o;
		
		return id.equals(a.id);
	}
}
