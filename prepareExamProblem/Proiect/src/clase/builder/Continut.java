package clase.builder;

public class Continut implements InterfataContinut {

	String descriere;

	public Continut(String descriere) {
		super();
		this.descriere = descriere;
	}

	@Override
	public void scriereContinut(String Descriere) {
		descriere = Descriere;

	}

	@Override
	public String toString() {
		return "Continut:" + descriere;
	}

}
