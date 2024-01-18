package clase.common;

import clase.builder.Materie;
import clase.visitor.Persoana;

public abstract class Profesor extends Persoana {

	private Materie materie;

	public Profesor(String nume, String prenume, Materie materie) {
		super(nume, prenume);
		this.materie = materie;
	}
	
	public Profesor(String nume, String prenume) {
		super(nume, prenume);
	}

	public Profesor() {

	}

	public Materie getMaterie() {
		return materie;
	}

	public void setMaterie(Materie materie) {
		this.materie = materie;
	}
	
	@Override
	public String toString() {
		return "Nume " + getNume() + ", Prenume "
				+ getPrenume() + ", Materie " + getMaterie();
	}
}
