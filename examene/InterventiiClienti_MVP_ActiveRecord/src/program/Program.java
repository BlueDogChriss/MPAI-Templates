package program;

import mvp.model.command.ComandaAcceptare;
import mvp.model.command.ComandaTransmitere;
import mvp.model.command.ManagerComenzi;
import mvp.model.state.Interventie;
import mvp.presenter.Presenter;
import mvp.view.View;

public class Program {

	public static void main(String[] args) {
		Interventie interventie = new Interventie(1);
		Interventie interventie2 = new Interventie(2);
		
		View view = new View();
		ManagerComenzi managerComenzi = new ManagerComenzi();
		Presenter presenter = new Presenter(view, managerComenzi);
		
//		presenter.addInterventie(interventie);
		presenter.getInterventie(1);
		presenter.preiaInterventie(new ComandaAcceptare(interventie2));
		presenter.executaInterventie(interventie2);
		presenter.preiaInterventie(new ComandaTransmitere(interventie));
		presenter.executaInterventie(interventie);
		presenter.getInterventii();
	}

}
