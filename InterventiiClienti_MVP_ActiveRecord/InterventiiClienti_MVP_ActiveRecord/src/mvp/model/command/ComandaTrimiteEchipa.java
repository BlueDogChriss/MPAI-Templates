package mvp.model.command;

import mvp.model.state.Interventie;

public class ComandaTrimiteEchipa extends Command {

	public ComandaTrimiteEchipa(Interventie interventie) {
		super(interventie);
	}

	@Override
	public void execute() {
		interventie.trimiteEchipaSpreClient();
	}

}
