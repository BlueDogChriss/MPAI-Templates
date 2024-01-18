package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Model.State.IState;

public class Comanda implements Serializable, IComandaModel {

	private static final long serialVersionUID = 6744767450839086550L;
	private int idComanda;
	private List<Produs> produse = new ArrayList<Produs>();
	private Client client;
	private IState stareComanda;

	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public List<Produs> getProduse() {
		return produse;
	}

	public void setProduse(List<Produs> produse) {
		this.produse = produse;
	}

	@Override
	public Client getClient() {
		return client;
	}

	@Override
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public IState getStare() {
		return stareComanda;
	}

	@Override
	public void setStare(IState stare) {
		this.stareComanda = stare;
	}

	public void adaugaProdus(Produs p) {
		this.produse.add(p);
	}

	@Override
	public String toString() {
		return "Comanda [idComanda=" + idComanda + ", produse=" + getProduse() + ", client=" + client + "]";
	}

}
