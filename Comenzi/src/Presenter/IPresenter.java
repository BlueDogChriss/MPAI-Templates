package Presenter;

import java.util.List;

import Model.Client;
import Model.IComandaModel;
import Model.Produs;
import Model.State.IState;
import View.IComandaView;

public interface IPresenter {

	IComandaModel getModel();

	void setIComandaModel(IComandaModel model);

	IComandaView getView();

	void setIComandaView(IComandaView view);

	public int getIdComanda();

	public void setIdComanda(int idComanda);

	public List<Produs> getProduse();

	public void setProduse(List<Produs> produse);

	public Client getClient();

	public void setClient(Client client);

	public IState getStare();

	public void setStare(IState stare);

	public void adaugaProdus(Produs p);

	public void updateView();

	public void afiseazaToateComenzile();

	public void afiseazaComanda(int cod);

	public void actualizeazaComanda(IComandaModel c);

	public void stergeComanda(int cod);

	public void salveazaComanda(IComandaModel c);

}
