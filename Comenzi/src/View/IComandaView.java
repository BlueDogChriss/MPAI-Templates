package View;

import java.util.List;

import Model.Client;
import Model.IComandaModel;
import Model.Produs;
import Model.State.IState;

public interface IComandaView {

	public void afiseazaComanda(int idComanda, List<Produs> produse, Client client, IState stare);
	public void afiseazaToateComenzile();
	public void afiseazaComanda(int cod);
	public void actualizeazaComanda(IComandaModel c);
	public void stergeComanda(int cod);
	public void salveazaComanda(IComandaModel c);
}
