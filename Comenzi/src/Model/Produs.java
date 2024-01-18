package Model;

import java.io.Serializable;

public class Produs implements Serializable, IProdusModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5665564791424655200L;
	int id;
	String denumireProdus;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getDenumireProdus() {
		return denumireProdus;
	}

	@Override
	public void setDenumireProdus(String denumireProdus) {
		this.denumireProdus = denumireProdus;
	}

	@Override
	public String toString() {
		return "Produs [id=" + id + ", denumireProdus=" + denumireProdus + "]";
	}

}
