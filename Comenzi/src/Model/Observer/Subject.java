package Model.Observer;

import Model.IComandaModel;

public interface Subject {

	public void trimiteNotificare(String mesaj, IComandaModel c);
	public void adaugaObserver(IObserver observer);
}
