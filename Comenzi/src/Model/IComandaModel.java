package Model;

import java.util.List;

import Model.State.IState;

public interface IComandaModel {

	public int getIdComanda();

	public void setIdComanda(int idComanda);

	public List<Produs> getProduse();

	public void setProduse(List<Produs> produse);

	public Client getClient();

	public void setClient(Client client);

	public IState getStare();

	public void setStare(IState stare);

	public void adaugaProdus(Produs p);

}
