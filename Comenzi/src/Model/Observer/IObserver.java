package Model.Observer;

import Model.IComandaModel;

public interface IObserver {

	public void receptionareMesaj(String mesaj, IComandaModel c);
}
