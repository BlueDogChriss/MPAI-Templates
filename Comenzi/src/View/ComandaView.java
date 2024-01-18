package View;

import java.util.List;

import Model.Client;
import Model.Comanda;
import Model.IComandaModel;
import Model.Produs;
import Model.ComandaActiveRecord.ComandaActiveRecord;
import Model.State.IState;

public class ComandaView implements IComandaView {

	@Override
	public void afiseazaComanda(int idComanda, List<Produs> produse, Client client, IState stare) {
		System.out.println("Comanda cu id-ul " + idComanda);
		System.out.println("Client: " + client.toString());
		System.out.println("Produse: " + produse.toString());
		System.out.println("Stare: " + stare);
	}

	public void afiseazaToateComenzile() {
		ComandaActiveRecord comandaActiveRecord = new ComandaActiveRecord();
		comandaActiveRecord.getAll();
	}

	public void afiseazaComanda(int cod) {
		ComandaActiveRecord comandaActiveRecord = new ComandaActiveRecord();
		comandaActiveRecord.get(cod);
	}

	public void actualizeazaComanda(IComandaModel c) {
		ComandaActiveRecord comandaActiveRecord = new ComandaActiveRecord();
		comandaActiveRecord.update((Comanda) c);
	}

	public void stergeComanda(int cod) {
		ComandaActiveRecord comandaActiveRecord = new ComandaActiveRecord();
		comandaActiveRecord.delete(cod);
	}

	public void salveazaComanda(IComandaModel c) {
		ComandaActiveRecord comandaActiveRecord = new ComandaActiveRecord();
		comandaActiveRecord.save((Comanda) c);
	}

}
