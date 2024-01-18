import Model.Client;
import Model.Comanda;
import Model.IComandaModel;
import Model.Produs;
import Model.State.ComandaOnorata;
import Model.State.ComandaPlatita;
import Model.State.ComandaPregatita;
import Model.State.ComandaPreluata;
import Presenter.IPresenter;
import Presenter.Presenter;
import View.ComandaView;
import View.IComandaView;

public class Main {

	public static void main(String[] args) {
		IComandaModel model = new Comanda();
		IComandaView view = new ComandaView();
		IPresenter presenter = new Presenter();

		presenter.setIComandaModel(model);
		presenter.setIComandaView(view);

		// Setam un nou client
		Client client = new Client();
		client.setId(1);
		client.setNume("Victor");
		client.setVarsta(22);
		client.setLocalitate("Pitesti");

		// Setam un nou produs care sa fie adaugat in comanda
		Produs produsPapetarie = new Produs();
		produsPapetarie.setId(1);
		produsPapetarie.setDenumireProdus("Creion albastru");
		
		//Adaugam produsul in lista produselor comenzii
		presenter.getModel().adaugaProdus(produsPapetarie);

		presenter.setIdComanda(1);
		presenter.setClient(client);
		presenter.setProduse(presenter.getModel().getProduse());
		presenter.setStare(null);

		// salveaza comanda
//		presenter.salveazaComanda((Comanda) presenter.getModel());

		// afiseaza comanda
//		presenter.afiseazaComanda(1);

		// sterge comanda
//		presenter.stergeComanda(1);

		// afiseaza toate comenzile
		presenter.afiseazaToateComenzile();

		// Schimbam starea comenzii in onorata
		ComandaPreluata comandaPreluata = new ComandaPreluata();
		comandaPreluata.schimbaStare(presenter.getModel());

		//Schimbam starea comenzii in pregatita
		ComandaPregatita comandaPregatita = new ComandaPregatita();
		comandaPregatita.schimbaStare(presenter.getModel());
		
		//Schimbam starea comenzii in platita
		ComandaPlatita comandaPlatita = new ComandaPlatita();
		comandaPlatita.schimbaStare(presenter.getModel());

		//Schimbam starea comenzii in onorata
		ComandaOnorata comandaOnorata = new ComandaOnorata();
		comandaOnorata.schimbaStare(presenter.getModel());
		
		// actualizeaza interfata utilizatorului cu noile date
		presenter.updateView();
	}
}
