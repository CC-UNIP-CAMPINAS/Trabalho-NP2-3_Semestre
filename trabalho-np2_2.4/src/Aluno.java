
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
		System.out.println("Nome aluno: " + this.nome);
		System.out.println("ID aluno: " + this.id);
		System.out.println();
		return "";
	}
}
