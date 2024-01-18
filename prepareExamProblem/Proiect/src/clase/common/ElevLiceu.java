package clase.common;

import clase.abstractfactory.Elev;
import clase.visitor.Visitor;

public class ElevLiceu extends Elev {

	public ElevLiceu(String nume, String prenume, String clasa) {
		super(nume, prenume, clasa);
	}

	public  ElevLiceu() {
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitElevLiceu();
	}
	
}
