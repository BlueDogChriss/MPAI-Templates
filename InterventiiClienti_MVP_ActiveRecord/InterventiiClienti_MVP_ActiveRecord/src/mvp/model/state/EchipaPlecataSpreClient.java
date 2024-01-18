package mvp.model.state;

public class EchipaPlecataSpreClient implements Stare {

	@Override
	public void schimbaStare(Interventie interventie) {
		interventie.setStare(this);
	}

	@Override
	public String toString() {
		return "EchipaPlecataSpreClient";
	}

}
