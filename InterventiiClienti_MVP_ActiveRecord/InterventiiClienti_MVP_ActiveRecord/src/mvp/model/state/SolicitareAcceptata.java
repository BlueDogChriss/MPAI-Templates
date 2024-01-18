package mvp.model.state;

public class SolicitareAcceptata implements Stare {

	@Override
	public void schimbaStare(Interventie interventie) {
		interventie.setStare(this);
	}

	@Override
	public String toString() {
		return "SolicitareAcceptata";
	}

}
