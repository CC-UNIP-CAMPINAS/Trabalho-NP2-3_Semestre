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
		return "\nNome aluno: " + this.nome + "\nID aluno: " + this.id;
	}
}
