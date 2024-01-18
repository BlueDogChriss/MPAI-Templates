package clase.abstractfactory;

import clase.strategy.InterfataStrategie;
import clase.visitor.Persoana;

public abstract class Elev extends Persoana {

	private String clasa;
	private int totalTemeRezolvate;
	private int notaTemeRezolvate;
	private InterfataStrategie strategie = null;

	public Elev(String nume, String prenume, String clasa) {
		super(nume, prenume);
		this.clasa = clasa;
	}

	public Elev(String nume, String prenume, String clasa, int totalTemeRezolvate, int notaTemeRezolvate) {
		super(nume, prenume);
		this.clasa = clasa;
		this.totalTemeRezolvate = totalTemeRezolvate;
		this.setNotaTemeRezolvate(notaTemeRezolvate);
	}

	public Elev() {

	}

	public String getClasa() {
		return clasa;
	}

	public void setClasa(String clasa) {
		this.clasa = clasa;
	}

	public int getTotalTemeRezolvate() {
		return totalTemeRezolvate;
	}

	public void setTotalTemeRezolvate(int totalTemeRezolvate) {
		this.totalTemeRezolvate = totalTemeRezolvate;
	}

	public int getNotaTemeRezolvate() {
		return notaTemeRezolvate;
	}

	public void setNotaTemeRezolvate(int notaTemeRezolvate) {
		this.notaTemeRezolvate = notaTemeRezolvate;
	}

	public void setStrategie(InterfataStrategie strategie) {
		this.strategie = strategie;
	}

	public void primesteNotaTemeRezolvate() {
		if (this.strategie != null) {
			this.strategie.aplicaStrategie( this);
		} else {
			throw new UnsupportedOperationException();
		}
	}

}
