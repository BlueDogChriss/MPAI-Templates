package Model;

import java.io.Serializable;

import Model.Observer.IObserver;

public class Client implements IObserver, Serializable, IClientModel {

	private static final long serialVersionUID = 919347473925718274L;
	public int idClient;
	public String nume;
	public int varsta;
	public String localitate;

	@Override
	public int getId() {
		return idClient;
	}

	@Override
	public void setId(int idClient) {
		this.idClient = idClient;
	}

	@Override
	public String getNume() {
		return nume;
	}

	@Override
	public void setNume(String nume) {
		this.nume = nume;
	}

	@Override
	public int getVarsta() {
		return varsta;
	}

	@Override
	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	@Override
	public String getLocalitate() {
		return localitate;
	}

	@Override
	public void setLocalitate(String localitate) {
		this.localitate = localitate;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nume=" + nume + ", varsta=" + varsta + "]";
	}

	@Override
	public void receptionareMesaj(String mesaj, IComandaModel c) {
		if (this.getNume().equalsIgnoreCase(c.getClient().getNume())) {
			System.out.println(this.getNume() + " ai primit urmatorul mesaj cu privire la comanda ta: " + "\n" + mesaj);
		}
	}
}
