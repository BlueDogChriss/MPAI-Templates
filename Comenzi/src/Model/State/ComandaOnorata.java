package Model.State;

import java.io.Serializable;

import Model.IComandaModel;
import Model.Observer.Observer;

public class ComandaOnorata implements IState, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9109457125247677385L;
	
	Observer observer = new Observer();

	@Override
	public void schimbaStare(IComandaModel comanda) {
		observer.adaugaObserver(comanda.getClient());
		System.out.println("Comanda este trecuta in starea onorata...");
		comanda.setStare(this);
		//Trimitem notificare clientului ca starea comenzii s-a schimbat
		observer.trimiteNotificare("Comanda a fost onorata...", comanda);
	}

	public String toString() {
		return "Comanda este onorata";
	}
}
