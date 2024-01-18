package mvp.presenter;

import java.util.List;

import mvp.model.command.Command;
import mvp.model.command.ManagerComenzi;
import mvp.model.state.Interventie;
import mvp.view.View;

public class Presenter {
	
	private View view;
	private ManagerComenzi managerComenzi;
	
	public Presenter(View view, ManagerComenzi managerComenzi) {
		this.view = view;
		this.managerComenzi = managerComenzi;
	}
	
	public void getInterventii() {
		List<Interventie> comenzi = Interventie.getInterventii();
		view.showInterventii(comenzi);
	}
	
	public void addInterventie(Interventie order) {
		order.addInterventie();
		view.addInterventie(order);
	}
	
	public void getInterventie(int id) {
		view.showInterventie(Interventie.getInterventie(id));
	}
	
	public void preiaInterventie(Command interventie) {
		managerComenzi.preia(interventie);
		view.preiaSolicitare(interventie.getInterventie());
	}
	
	public void executaInterventie(Interventie interventie) {
		managerComenzi.executaComanda();
		view.preiaSolicitare(interventie);
	}

}
