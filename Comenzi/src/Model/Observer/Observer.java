package Model.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Model.IComandaModel;

public class Observer implements Subject, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3632453056565494440L;
	private List<IObserver> observeri;

	public Observer() {

		super();
		this.observeri = new ArrayList<IObserver>();
	}

	@Override
	public void adaugaObserver(IObserver observer) {
		observeri.add(observer);

	}

	@Override
	public void trimiteNotificare(String mesaj, IComandaModel c) {
		Observer observer = new Observer();
		observer.adaugaObserver(c.getClient());
		for (IObserver observer1 : observeri) {
			observer1.receptionareMesaj(mesaj, c);
		}
	}

}
