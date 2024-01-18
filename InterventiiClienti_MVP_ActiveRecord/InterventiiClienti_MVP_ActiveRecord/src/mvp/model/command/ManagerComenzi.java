package mvp.model.command;

import java.util.ArrayList;
import java.util.List;

public class ManagerComenzi {

	private List<Command> comenzi;

	public ManagerComenzi() {
		super();
		this.comenzi = new ArrayList<>();
	}
	
	public void preia(Command comanda) {
		comenzi.add(comanda);
	}
	
	public void executaComanda() {
		if(!comenzi.isEmpty()) {
			comenzi.get(0).execute();
			comenzi.remove(0);
		}
	}
}
