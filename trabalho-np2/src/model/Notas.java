package model;

public class Notas {
	
	private double nota;
	
	public Notas(double aNota) {
		this.nota = aNota;
		if(aNota >= 10) {
			this.nota = 10;
		}
		if(aNota <= 0) {
			this.nota = 0;
		}
		
	}
	
	public double getNota() {
		return this.nota;
	}
	
	@Override
	public String toString() {
		return Double.toString(getNota());
	}
}
