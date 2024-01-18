package mvp.view;

import java.util.List;

import mvp.model.command.Command;
import mvp.model.state.Interventie;

public class View {

	public void showInterventii(List<Interventie> comenzi) {
		for (Interventie comanda : comenzi) {
			System.out.println(comanda);
		}
	}

	public void addInterventie(Interventie order) {
		System.out.println("Comanda a fost adaugata");
	}
	
	public void showInterventie(Interventie comanda) {
		if(comanda != null) {
			System.out.println(comanda);
		} else {
			System.out.println("Interventia nu a fost gasita");
		}
	}
	
	public void preiaSolicitare(Interventie interventie) {
		System.out.println("Interventia " + interventie + " a fost preluata");
	}
	
	public void executaSolicitare(Interventie interventie) {
		System.out.println("Interventia " + interventie + " a fost executata");
	}

}
