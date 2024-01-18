package clase.common;

import clase.abstractfactory.Elev;

public class Meditatie {
	
	private Profesor profesor;
	private Elev elev;
	private String zi;
	private String ora;
	
	public Meditatie(Profesor profesor, Elev elev, String zi, String ora) {
		this.profesor = profesor;
		this.elev = elev;
		this.zi = zi;
		this.ora = ora;
	}
	
	public Meditatie() {
		
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Elev getElev() {
		return elev;
	}

	public void setElev(Elev elev) {
		this.elev = elev;
	}

	public String getZi() {
		return zi;
	}

	public void setZi(String zi) {
		this.zi = zi;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}
	
}
