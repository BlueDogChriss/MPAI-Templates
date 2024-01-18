package clase.common;

import clase.abstractfactory.Elev;
import clase.visitor.Visitor;

public class ElevScoala extends Elev {

	public ElevScoala(String nume, String prenume, String clasa) {
		super(nume, prenume, clasa);
	}
	
	public ElevScoala() {
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitElevScoala();
	}

}
