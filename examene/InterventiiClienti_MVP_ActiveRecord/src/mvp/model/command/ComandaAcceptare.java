package mvp.model.command;

import mvp.model.state.Interventie;

public class ComandaAcceptare extends Command {

	public ComandaAcceptare(Interventie interventie) {
		super(interventie);
	}

	@Override
	public void execute() {
		interventie.acceptaSolicitare();
	}

}
