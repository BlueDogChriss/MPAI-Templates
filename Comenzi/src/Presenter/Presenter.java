package Presenter;

import java.util.List;

import Model.Client;
import Model.IComandaModel;
import Model.Produs;
import Model.State.IState;
import View.IComandaView;

public class Presenter implements IPresenter {

	IComandaModel model;
	IComandaView view;

	@Override
	public IComandaModel getModel() {
		return model;
	}

	@Override
	public void setIComandaModel(IComandaModel model) {
		this.model = model;
	}

	@Override
	public IComandaView getView() {
		return view;
	}

	@Override
	public void setIComandaView(IComandaView view) {
		this.view = view;
	}

	@Override
	public int getIdComanda() {
		return model.getIdComanda();
	}

	@Override
	public void setIdComanda(int idComanda) {
		model.setIdComanda(idComanda);
	}

	@Override
	public List<Produs> getProduse() {
		return model.getProduse();
	}

	@Override
	public void setProduse(List<Produs> produse) {
		model.setProduse(produse);
	}

	@Override
	public Client getClient() {
		return model.getClient();
	}

	@Override
	public void setClient(Client client) {
		model.setClient(client);
	}

	@Override
	public IState getStare() {
		return model.getStare();
	}

	@Override
	public void setStare(IState stare) {
		model.setStare(stare);
	}

	@Override
	public void adaugaProdus(Produs p) {
		model.getProduse().add(p);
	}

	@Override
	public void updateView() {
		view.afiseazaComanda(model.getIdComanda(), model.getProduse(), model.getClient(), model.getStare());
	}

	@Override
	public void afiseazaToateComenzile() {
		view.afiseazaToateComenzile();
	}

	@Override
	public void afiseazaComanda(int cod) {
		view.afiseazaComanda(cod);
	}

	@Override
	public void actualizeazaComanda(IComandaModel c) {
		view.actualizeazaComanda(c);
	}

	@Override
	public void stergeComanda(int cod) {
		view.stergeComanda(cod);
	}

	@Override
	public void salveazaComanda(IComandaModel c) {
		view.salveazaComanda(c);
	}

}
