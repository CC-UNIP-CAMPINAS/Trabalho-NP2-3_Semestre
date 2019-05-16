package model;

public class Notas {
	
	private double nota;
	
	public Notas(double aNota) {
		this.nota = aNota;
	}
	
	public double getNota() {
		return this.nota;
	}
	
	@Override
	public String toString() {
		String a = Double.toString(getNota());
		return a;
	}
}
