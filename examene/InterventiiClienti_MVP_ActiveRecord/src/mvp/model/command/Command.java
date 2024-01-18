package mvp.model.command;

import mvp.model.state.Interventie;

public abstract class Command {
	
	protected Interventie interventie;
	
	public Command(Interventie interventie) {
		super();
		this.interventie = interventie;
	}
	
	public Interventie getInterventie() {
		return interventie;
	}

	public abstract void execute();
}
