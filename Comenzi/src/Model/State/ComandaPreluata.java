package Model.State;

import java.io.Serializable;
import Model.IComandaModel;
import Model.Observer.Observer;

public class ComandaPreluata implements IState, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5133386528230117579L;
	
	Observer observer = new Observer();

	@Override
	public void schimbaStare(IComandaModel comanda) {
		observer.adaugaObserver(comanda.getClient());
		System.out.println("Comanda este trecuta in starea preluata...");
		comanda.setStare(this);
		//Trimitem notificare clientului ca starea comenzii s-a schimbat
		observer.trimiteNotificare("Comanda a fost preluata...", comanda);
	}

	public String toString() {
		return "Comanda este preluata";
	}
}
