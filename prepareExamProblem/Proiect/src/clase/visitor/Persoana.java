package clase.visitor;

public abstract class Persoana {
	
	private String nume;
	private String prenume;
	
	public Persoana() {
		
	}
	
	public Persoana(String nume, String prenume) {
		super();
		this.nume = nume;
		this.prenume = prenume;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public abstract void accept(Visitor visitor);
}
