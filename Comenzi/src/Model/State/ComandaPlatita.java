package Model.State;

import java.io.Serializable;

import Model.IComandaModel;
import Model.Observer.Observer;

public class ComandaPlatita implements IState, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3672710446342712051L;
	
	Observer observer = new Observer();

	@Override
	public void schimbaStare(IComandaModel comanda) {
		observer.adaugaObserver(comanda.getClient());
		System.out.println("Comanda este trecuta in starea platita");
		comanda.setStare(this);
		//Trimitem notificare clientului ca starea comenzii s-a schimbat
		observer.trimiteNotificare("Comanda a fost platita...", comanda);
	}

	public String toString() {
		return "Comanda este platita";
	}

}
