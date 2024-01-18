package Model.State;

import java.io.Serializable;

import Model.IComandaModel;
import Model.Observer.Observer;

public class ComandaPregatita implements IState, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4395118709555665508L;

	Observer observer = new Observer();

	@Override
	public void schimbaStare(IComandaModel comanda) {
		observer.adaugaObserver(comanda.getClient());
		System.out.println("Comanda este trecuta in starea pregatita...");
		comanda.setStare(this);
		//Trimitem notificare clientului ca starea comenzii s-a schimbat
		observer.trimiteNotificare("Comanda a fost pregatita...", comanda);
	}

	public String toString() {
		return "Comanda este pregatita";
	}

}
