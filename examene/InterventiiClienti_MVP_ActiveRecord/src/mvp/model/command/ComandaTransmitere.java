package mvp.model.command;

import mvp.model.state.Interventie;

public class ComandaTransmitere extends Command {

	public ComandaTransmitere(Interventie interventie) {
		super(interventie);
	}

	@Override
	public void execute() {
		interventie.transmiteSolicitare();
	}

}
